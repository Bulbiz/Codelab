package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;

public class DecorGeneratorPanel extends JPannel{
	private ControllerEditor controller;
	
	public DecorGeneratorPanel (ControllerEditor c) {
		PlacementButton wall = new PlacementButton(c,(b,y,x) -> wallPlacement(b,y,x));
		PlacementButton floor = new PlacementButton(c,(b,y,x) -> floorPlacement(b,y,x));
		PlacementButton goal = new PlacementButton(c,(b,y,x) -> {});
	}
	
	private static void wallPlacement(Board b,int y,int x) {
		b.setDecor(new Wall(b,x,y),y,x);
	}
	
	private static void floorPlacement(Board b,int y,int x) {
		b.setDecor(null,y,x);
	}
}
