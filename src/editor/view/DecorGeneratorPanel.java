package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;

public class DecorGeneratorPanel extends JPannel{
	private ControllerEditor controller;
	private PlacementButton wall;
	private PlacementButton floor;
	private PlacementButton goal;
	
	public DecorGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		this.wall = new PlacementButton(c,(b,y,x) -> wallPlacement(b,y,x));
		this.floor = new PlacementButton(c,(b,y,x) -> floorPlacement(b,y,x));
		this.goal = new PlacementButton(c,(b,y,x) -> goalPlacement(b,y,x));
		
		
	}
	private void layoutPlacement () {
		
	}
	private static void wallPlacement(Board b,int y,int x) {
		b.setDecor(new Wall(b,x,y),y,x);
	}
	
	private static void floorPlacement(Board b,int y,int x) {
		b.setDecor(null,y,x);
	}
	private static void goalPlacement (Board b, int y, int x) {
		
	}
}
