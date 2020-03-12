package src.view.world;

import src.model.world.*;
import src.model.langage.*;
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
	private JPanel languageView;//FIXME : Place the LanguageView Here
	private JButton runButton;
	private JButton restartButton;
	
	public LevelPanel (Level l){
		this.level = l;
		this.levelController = new ControllerLevel (this.level, this);
		
		initialiseWorldView();
		initialiseRunButton();
		initialiseRestartButton();
		
		layoutPlacement();
		this.updateDisplay();
	}
	
	private void initialiseWorldView() {
		this.worldView = new WorldPanel (this.level.getBoard());
	}
	
	private void initialiseRunButton() {
		this.runButton = new JButton ("Run");
		this.runButton.addActionListener((e) -> levelController.run());
	}
	
	private void initialiseRestartButton() {
		this.restartButton = new JButton ("Restart");
		this.restartButton.addActionListener((e) -> levelController.restart());
	}
	
	public WorldPanel getWorldView () {
		return this.worldView;
	}
	
	private void layoutPlacement() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(constructTopPanel());
		this.add(constructBodyPanel());
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
		body.add(constructLeftPanel());
		return body;
	}
	
	private JPanel constructLeftPanel() {
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
		executionPanel.add(this.runButton);
		executionPanel.add(this.restartButton);
		return executionPanel;
	}
	
	public void updateDisplay() {
		
	}
	public void setEnableRunButton(boolean activation) {
		this.runButton.setEnabled(activation);
	}
	public void setEnablerestartButton(boolean activation) {
		this.restartButton.setEnabled(activation);
	}
}
