
package src.controller;

import src.editor.view.*;
import src.model.world.*;

public class ControllerEditor {
	private BoardEditorPanel boardEditor;
	private GeneratorsPanel generator;
	private PlacementInterface placementInstruction;
	
	public ControllerEditor (BoardEditorPanel b, GeneratorsPanel g) {
		this.boardEditor = b;
		this.generator = g;
	}
	
	public void setPlacementInstruction(PlacementInterface p) {
		this.placementInstruction = p;
	}
	
	public void clicked (int y, int x) {
		this.placementInstruction.placement(boardEditor.getBoard(), y, x);
	}
}