package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

public class DecorGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton wall;
	private PlacementButton floor;
	private PlacementButton goal;
	
	public DecorGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		this.wall = new PlacementButton(c,(b,y,x) -> wallPlacement(b,y,x));
		this.floor = new PlacementButton(c,(b,y,x) -> floorPlacement(b,y,x));
		this.goal = new PlacementButton(c,(b,y,x) -> goalPlacement(b,y,x));
		
		layoutPlacement();
	}
	private void layoutPlacement () {
		TitledBorder title = BorderFactory.createTitledBorder("Décor");
		this.setBorder(title);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.addButton();
	}
	
	private void addButton() {
		this.addWithSeparation(wall);
		this.addWithSeparation(floor);
		this.addWithSeparation(goal);
	}
	
	private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(0,5)));
    }
	
	private static void wallPlacement(Board b,int y,int x) {
		b.setDecor(new Wall(b,x,y),y,x);
	}
	private static void floorPlacement(Board b,int y,int x) {
		b.setDecor(new Floor(b,y,x),y,x);
	}
	private static void goalPlacement (Board b, int y, int x) {
		b.initiateGoal(y,x);
	}
}
