package src.view.world;

import src.model.world.*;
import src.controller.*;
import src.view.langage.*;
import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel{
	private Level level;

	private JFrame levelFrame;
  	private JButton backToMenu;

	private ControllerLevel levelController;
	ControllerLanguage controllerLanguage;

	private WorldPanel worldView;
	private LanguageView languageView;
	private JButton runOrStopButton;
	private JButton restartButton;
	private JButton fastForward;
	private InventoryPanel inventoryPanel;

	public LevelPanel (String name){
		try{
			this.level = new Level(name);
			this.levelController = new ControllerLevel (this.level, this);

			controllerLanguage = new ControllerLanguage(null);
			languageView = new LanguageView(controllerLanguage, level.getPlayer());
			controllerLanguage.setView(languageView);

			this.backToMenu = new JButton("<--");
    		this.add(backToMenu);

			initialiseWorldView();
			initialiseRunOrStopButton(languageView);
			initialiseRestartButton();
			initialiseInventoryPanel();
			initialiseFastForwardButton();

			layoutPlacement();

			this.backToMenu.addActionListener((e) -> {
        		levelFrame.dispose();
        		MenuPanel.beginMenu();
			});
			this.levelController.speedReset();
		}catch(Exception e){
			e.printStackTrace();
			//Afficher un message d'erreur
		}
	}

	public void setLevelFrame(JFrame levelFrame){
		this.levelFrame = levelFrame;
		controllerLanguage.setFrame(levelFrame);
	}

	public void loadResourcePanel(int idLevel) {
		languageView.loadResourcePanel(idLevel);
	}

	public void restart(){
		this.languageView.setPlayer(level.getPlayer());
		inventoryPanel.setInventory(level.getPlayer().getInventory());
		inventoryPanel.repaint();
		this.levelController.speedReset();
		this.worldView.setBoard(level.getBoard());
	}

	public void endOfLevel() {
		restart();
	}
	private void initialiseWorldView() {
		this.worldView = new WorldPanel (this.level.getBoard());
	}

	private void initialiseRunOrStopButton(LanguageView languageView) {
		this.runOrStopButton = new JButton ("Run Or Stop");
		this.runOrStopButton.addActionListener((e) -> levelController.runOrStop(languageView));
		//PlaceLanguageHere
	}

	private void initialiseFastForwardButton () {
		this.fastForward = new JButton ("Faster/Slower");
		this.fastForward.addActionListener((e) -> levelController.acceleration());
	}

	private void initialiseRestartButton() {
		this.restartButton = new JButton ("Restart");
		this.restartButton.addActionListener((e) -> levelController.restart());
	}

	private void initialiseInventoryPanel() {
		inventoryPanel = new InventoryPanel(level.getPlayer().getInventory(), worldView.getImageLibrary());		
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

	private JPanel constructRightPanel() {
		JPanel west = new JPanel ();
		west.setLayout(new BoxLayout(west,BoxLayout.Y_AXIS));
		west.add(this.worldView);
		west.add(Box.createRigidArea(new Dimension(0,20)));
		west.add(constructExecutionButton());
		west.add(this.inventoryPanel);
		return west;
	}

	private JPanel constructExecutionButton() {
		JPanel executionPanel = new JPanel (new FlowLayout());
		executionPanel.setAlignmentX(LEFT_ALIGNMENT);
		executionPanel.add(this.runOrStopButton);
		executionPanel.add(this.restartButton);	
		executionPanel.add(this.fastForward);		
		return executionPanel;
	}

	public void updateDisplay() {
		repaint();
	}
	public void setEnablerunOrStopButton(boolean activation) {
		this.runOrStopButton.setEnabled(activation);
	}
	public void setEnablerestartButton(boolean activation) {
		this.restartButton.setEnabled(activation);
	}
}
