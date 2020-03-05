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
	
	private ControllerWorld worldController;
	
	private BoardPanel worldView;
	private JButton runButton;
	
	private JButton stopButton;
	
	public LevelPanel (Level l){
		this.level = l;
		this.worldController = new ControllerWorld (this.level, this);
		
		this.worldView = new BoardPanel(this.level.getBoard());
		this.runButton = new JButton ("Run");
		this.stopButton = new JButton ("Stop");
		this.stopButton.addActionListener((e) -> worldController.stop());
		this.stopButton.setEnabled(false);
		this.runButton.addActionListener((e) -> worldController.run());
		
		layoutPlacement();
		this.updateDisplay();
	}
	
	//FIXME : Magic Number is not the best
	private void layoutPlacement() {
		this.setLayout(null);
		this.add(this.worldView);
		this.add(this.runButton);
		this.add(this.stopButton);
		this.worldView.setBounds(0,0,500,500);
		this.runButton.setBounds(400, 510, 100, 75);
		this.stopButton.setBounds(300, 510 , 100, 75);
	}
	
	//FIXME There is no animation it's Sad :(
	public void updateDisplay() {
		this.worldView.updateDisplay();
	}
	
	public void setEnableRunButton(boolean activation) {
		this.runButton.setEnabled(activation);
	}
	public void setEnableStopButton(boolean activation) {
		this.stopButton.setEnabled(activation);
	}
}
