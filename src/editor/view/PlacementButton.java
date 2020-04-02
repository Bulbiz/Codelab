package src.editor.view;

import javax.swing.*;
import src.controller.ControllerEditor;

public class PlacementButton extends JButton{
	private final PlacementInterface placementInstruction;
	private ControllerEditor controller;
	
	public PlacementButton(ControllerEditor c, PlacementInterface p) {
		this.placementInstruction = p;
		this.controller = c;
		this.addActionListener((e) -> this.controller.setPlacementInstruction(p));
	}
	
}
