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
	private JButton runButton;
	private JButton stopButton;
	
	public LevelPanel (Level l){
		this.level = l;
		this.levelController = new ControllerLevel (this.level, this);
		
		this.worldView = new WorldPanel (this.level.getBoard());
		this.runButton = new JButton ("Run");
		this.runButton.addActionListener((e) -> levelController.run());
		
		this.stopButton = new JButton ("Stop");
		this.stopButton.addActionListener((e) -> levelController.stop());
		this.stopButton.setEnabled(false);
		
		layoutPlacement();
		this.updateDisplay();
	}
	
	public WorldPanel getWorldView () {
		return this.worldView;
	}
	//FIXME : Magic Number is not the best
	private void layoutPlacement() {
		this.add(this.worldView);
		this.add(this.runButton);
		this.add(this.stopButton);
		this.runButton.setBounds(400, 510, 100, 75);
		this.stopButton.setBounds(300, 510 , 100, 75);
	}
	
	//FIXME There is no animation it's Sad :(
	public void updateDisplay() {
	}
	
	public void setEnableRunButton(boolean activation) {
		this.runButton.setEnabled(activation);
	}
	public void setEnableStopButton(boolean activation) {
		this.stopButton.setEnabled(activation);
	}
}
