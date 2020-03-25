package src.view.world;

import src.model.world.*;
import src.model.langage.*;
import src.model.langage.Action;
import src.controller.*;
import src.view.langage.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/*FIXME : Should add the Language to the View*/
public class LevelPanel extends JPanel{
	private Level level;

	private ControllerLevel levelController;

	private WorldPanel worldView;
	private LanguageView languageView;//FIXME : Place the LanguageView Here
	private JButton runOrStopButton;
	private JButton restartButton;

	public LevelPanel (Level l){
		this.level = l;
		this.levelController = new ControllerLevel (this.level, this);

		ControllerLanguage controllerLanguage = new ControllerLanguage(null);
		languageView = new LanguageView(controllerLanguage, level.getPlayer());
		controllerLanguage.setView(languageView);

		initialiseWorldView();
		initialiseRunOrStopButton(languageView);
		initialiseRestartButton();

		layoutPlacement();
		this.updateDisplay();
	}

	public void restart(){
		this.languageView.setPlayer(level.getPlayer());
		this.worldView.setBoard(level.getBoard());
	}

	private void initialiseWorldView() {
		this.worldView = new WorldPanel (this.level.getBoard());
	}

	private void initialiseRunOrStopButton(LanguageView languageView) {
		this.runOrStopButton = new JButton ("Run Or Stop");
		this.runOrStopButton.addActionListener((e) -> levelController.runOrStop(languageView));
		//PlaceLanguageHere
	}

	private void initialiseRestartButton() {
		this.restartButton = new JButton ("Restart");
		this.restartButton.addActionListener((e) -> levelController.restart());
	}

	public WorldPanel getWorldView () {
		return this.worldView;
	}

	private void layoutPlacement() {
		JPanel worldPane = new JPanel();
		worldPane.setLayout(new BoxLayout(worldPane,BoxLayout.Y_AXIS));
		//worldPane.add(constructTopPanel());
		worldPane.add(constructBodyPanel());
		this.add(worldPane);
		this.add(languageView);
	}
	//FIXME : Place Holder Panel
	private JPanel constructTopPanel() {
		JPanel north = new JPanel ();
		north.setLayout(new FlowLayout());
		north.add(new JButton("Retour"));
		north.add(new JButton("1"));
		north.add(new JButton("2"));
		north.add(new JButton("3"));
		north.add(new JButton("4"));
		north.add(new JButton("5"));
		north.setPreferredSize(new Dimension(1000,30));
		return north;
	}

	private JPanel constructBodyPanel() {
		JPanel body = new JPanel (new GridLayout (1,2));
		body.add(constructRightPanel());
		//body.add(constructLeftPanel());
		return body;
	}

	private JPanel constructLeftPanel() {//Ajouter le Panel du language
		JPanel east = new JPanel ();
		east.setLayout(new BoxLayout(east,BoxLayout.Y_AXIS));
		JTextArea temp = new JTextArea("Code Temporaire");
		temp.setPreferredSize(new Dimension (100,10));
		JTextField messagetemp = new JTextField("Message Temporaire");
		messagetemp.setPreferredSize(new Dimension (100,10));
		east.add(temp);
		east.add(messagetemp);
		return east;
	}
	private void removeRightPanel(){

	}
	private JPanel constructRightPanel() {
		JPanel west = new JPanel ();
		west.setLayout(new BoxLayout(west,BoxLayout.Y_AXIS));
		west.add(this.worldView);
		west.add(Box.createRigidArea(new Dimension(0,20)));
		west.add(constructExecutionButton());
		return west;
	}

	private JPanel constructExecutionButton() {
		JPanel executionPanel = new JPanel (new FlowLayout());
		executionPanel.setAlignmentX(LEFT_ALIGNMENT);
		executionPanel.add(this.runOrStopButton);
		executionPanel.add(this.restartButton);
		return executionPanel;
	}

	public void updateDisplay() {

	}
	public void setEnablerunOrStopButton(boolean activation) {
		this.runOrStopButton.setEnabled(activation);
	}
	public void setEnablerestartButton(boolean activation) {
		this.restartButton.setEnabled(activation);
	}
}
