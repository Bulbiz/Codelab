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
	
	private Controller controller;
	
	private BoardPanel worldView;
	private JButton runButton;
	
	public LevelPanel (Level l){
		this.level = l;
		this.controller = new Controller (this.level, this);
		
		this.worldView = new BoardPanel(this.level.getBoard());
		this.runButton = new JButton ("Run");
		this.runButton.addActionListener((e) -> controller.run());
		layoutPlacement();
	}
	
	//FIXME : Magic Number is not the best
	private void layoutPlacement() {
		this.setLayout(null);
		this.add(this.worldView);
		this.add(this.runButton);
		this.worldView.setBounds(0,0,500,500);
		this.runButton.setBounds(400, 510, 100, 100);
	}
	//FIXME : Freeze every thing
	public void updateDisplay() {
		this.worldView.updateDisplay();
		try {
			Thread.sleep(5000);
			System.out.println("Turn Finish");
		}catch(InterruptedException e) {
			System.out.println("Please don't interrupt !");
		}
	}
}
