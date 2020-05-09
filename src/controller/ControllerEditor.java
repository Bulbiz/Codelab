
package src.controller;

import java.io.FileReader;

import src.editor.view.*;
import src.model.world.*;

import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerEditor extends MouseAdapter {


	private BoardEditorPanel boardEditor;
	private GeneratorsPanel generator;
	private PlacementInterface placementInstruction;

	public ControllerEditor () {
		this.placementInstruction = (b,x,y) -> ControllerLevel.errorPopUp("Aucun bouton n'a été choisi !");
	}

	public void setPanels(EditorPanel editorPanel) {
		boardEditor = editorPanel.getBoardPanel();
		generator = editorPanel.getGeneratorsPanel();
	}

	public void setPlacementInstruction(PlacementInterface p) {
		this.placementInstruction = p;
	}

	private boolean creatable () {
		return boardEditor.getBoard().creatable();
	}

	public void mouseClicked(MouseEvent me) {
		if (placementInstruction != null) {
			boardEditor.updateFromClick(me.getX(), me.getY());
			placementInstruction.placement(boardEditor.getBoard(), boardEditor.getSelectedX(), boardEditor.getSelectedY());
			boardEditor.updateDisplay();
		}
	}

	public void create (String name) {
		if(!creatable()) {
			ControllerLevel.errorPopUp("Saving process failed ! You need a Chest and a Player !");
		}
		else if (!nameUnique(name)) {
			ControllerLevel.errorPopUp("Saving process failed ! This name has already been used");
		}
		else {
			boardEditor.getBoard().toJson(name);
			ControllerLevel.successPopUp("The Level has been succesfully created with the name \"" + name + "\"");
		}
	}

	public void load (String name) {
		try{
			Level level = new Level(name);
			boardEditor.setBoard(level.getBoard());
			boardEditor.updateUI();
			/* Creation Completed message */
		}catch(Exception e){
			/* Error message */
		}
	}

	public static boolean nameUnique(String name) {
		try {
    		JSONParser jsonParser = new JSONParser();
    		FileReader reader = new FileReader("resources/" + name + ".json");
    		return false;
    	}catch(Exception e) {
    		return true;
    	}
	}

}
