package src.view.world;

import src.model.world.*;
import src.controller.*;
import src.view.language.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

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
	private JLabel message;
	private InventoryPanel inventoryPanel;

	public LevelPanel (String name){
		try{
			this.level = new Level(name);
			this.levelController = new ControllerLevel (this.level, this);
			this.levelController.speedReset();

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
		setFastForwardText ();
		this.runOrStopButton.setText("Run");
		this.worldView.setBoard(level.getBoard());
	}

	public void endOfLevel() {
		restart();
	}
	private void initialiseWorldView() {
		this.worldView = new WorldPanel (this.level.getBoard());
	}

	private void initialiseRunOrStopButton(LanguageView languageView) {
		this.runOrStopButton = new JButton ("Run");
		this.runOrStopButton.addActionListener((e) -> {
			levelController.runOrStop(languageView);
			if(this.runOrStopButton.getText() == "Run")
				this.runOrStopButton.setText("Stop");
			else
				this.runOrStopButton.setText("Run");
		});
	}

	private void initialiseFastForwardButton () {
		this.fastForward = new JButton ();
		this.fastForward.setText(levelController.isAccelerated()? "Slower" : "Faster");
		this.fastForward.addActionListener((e) -> {
			levelController.acceleration();
			setFastForwardText ();
		});
	}

	private void setFastForwardText (){
		this.fastForward.setText(levelController.isAccelerated() ? "Slower" : "Faster");
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
		worldPane.add(constructBodyPanel());
		this.add(worldPane);

		JPanel languagePane = new JPanel();
		languagePane.setLayout(new BoxLayout(languagePane,BoxLayout.Y_AXIS));
		languagePane.add(languageView);
		
		message = new JLabel ();
		setMessageText(this.getMessageText());
		message.setFont(new Font("SANS_SERIF", Font.BOLD,10));
		message.setMinimumSize(new Dimension(332,100));
		message.setMaximumSize(new Dimension(332,100));
		message.setPreferredSize(new Dimension(332,100));
		TitledBorder border = BorderFactory.createTitledBorder("Message");
		message.setBorder(border);
		languagePane.add(message);

		this.add(languagePane);
	}

	protected void setMessageText(String s) {
		message.setText("<html>" + s + "</html>");
	}

	protected String getMessageText(){
		return "Bienvenue dans le Codelab de Bronze, bonne chance pour ce niveau ! N'hésitez pas à liker, partager, nous suivre sur les réseaux sociaux et créer vos propres niveaux !";
	}

	private JPanel constructBodyPanel() {
		JPanel body = new JPanel ();
		body.add(constructRightPanel());
		return body;
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
		//executionPanel.setAlignmentX(LEFT_ALIGNMENT);
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
