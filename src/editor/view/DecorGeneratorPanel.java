package src.editor.view;

import javax.swing.*;
import src.controller.ControllerEditor;

public class DecorGeneratorPanel extends JPannel{
	private ControllerEditor controller;
	
	public DecorGeneratorPanel (ControllerEditor c) {
		PlacementButton wall = new PlacementButton(c,(b,y,x) -> {});
		PlacementButton floor = new PlacementButton(c,(b,y,x) -> {});
		PlacementButton goal = new PlacementButton(c,(b,y,x) -> {});
	}
}
