
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
		this.placementInstruction = (b,x,y) -> System.out.println("Vous n'avez rien choisi pour l'instant!");
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
			ControllerLevel.errorPopUp("Impossible de sauvegarder ! Il faut une Joueur et un coffre !");
		} 
		else if (!nameUnique(name)) {
			ControllerLevel.errorPopUp("Impossible de sauvegarder ! Ce nom est déjà pris");
		}
		else {
			boardEditor.getBoard().toJson(name);
			ControllerLevel.successPopUp("Le Niveau a bien été créer sous le nom de \"" + name + "\"");
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
