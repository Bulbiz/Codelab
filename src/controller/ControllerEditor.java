
package src.controller;

import java.io.FileReader;

import src.editor.view.*;
import src.model.world.*;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ControllerEditor {
	private BoardEditorPanel boardEditor;
	private GeneratorsPanel generator;
	private PlacementInterface placementInstruction;
	
	public ControllerEditor (BoardEditorPanel b, GeneratorsPanel g) {
		this.boardEditor = b;
		this.generator = g;
		this.placementInstruction = null;
	}
	
	public void setPlacementInstruction(PlacementInterface p) {
		this.placementInstruction = p;
	}
	
	private boolean creatable () {
		return boardEditor.getBoard().creatable();
	}
	
	public void create (String name) {
		if(creatable() && nameUnique(name)) {
			boardEditor.getBoard().toJson(name);
			/* Creation Completed message */
		} else {
			/* Error message */
		}
	}
	
	private boolean nameUnique(String name) {
		try {
    		JSONParser jsonParser = new JSONParser();
    		FileReader reader = new FileReader("resources/" + name + ".json");
    		return false;
    	}catch(Exception e) {
    		return true;
    	}
	}
	
	public void clicked (int y, int x) {
		if(placementInstruction != null)
			this.placementInstruction.placement(boardEditor.getBoard(), y, x);
	}
	
	
}