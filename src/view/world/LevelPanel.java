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
	private JButton stopButton;
	
	public LevelPanel (Level l){
		this.level = l;
		this.levelController = new ControllerLevel (this.level, this);
		
		initialiseWorldView();
		initialiseRunButton();
		initialiseStopButton();
		
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
	
	private void initialiseStopButton() {
		this.stopButton = new JButton ("Stop");
		this.stopButton.addActionListener((e) -> levelController.stop());
		this.stopButton.setEnabled(false);
	}
	
	public WorldPanel getWorldView () {
		return this.worldView;
	}
	//FIXME : Magic Number is not the best
	private void layoutPlacement() {
		this.setLayout(new GridLayout(1,2));
		JPanel rightPanel = constructRightPanel();
		this.add(rightPanel);
	}
	
	private JPanel constructRightPanel() {
		JPanel rightPanel = new JPanel ();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(this.worldView,BorderLayout.WEST);
		JPanel buttonPanel = constructButtonPanel();
		rightPanel.add(buttonPanel,BorderLayout.SOUTH);
		return rightPanel;
	}
	
	private JPanel constructButtonPanel() {
		JPanel buttonPanel = new JPanel () ;
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(this.runButton);
		buttonPanel.add(this.stopButton);
		return buttonPanel;
	}
	public void updateDisplay() {
		
	}
	public void setEnableRunButton(boolean activation) {
		this.runButton.setEnabled(activation);
	}
	public void setEnableStopButton(boolean activation) {
		this.stopButton.setEnabled(activation);
	}
}
