package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;

public class PersonageGeneratorPanel extends JPannel{
	private ControllerEditor controller;
	private PlacementButton player;
	
	public PersonageGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		this.player = new PlacementButton(c, (b,y,x) -> playerPlacement(b,y,x))
	}
	
	private void static playerPlacement(Board b, int y, int x) {
		
	}
}
