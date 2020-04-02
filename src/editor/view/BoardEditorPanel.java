
package src.editor.view;

import javax.swing.JPanel;
import src.model.world.*;
import src.controller.ControllerEditor;

public class BoardEditorPanel extends JPanel {
    private Board board;
    private ControllerEditor controller;
    public BoardEditorPanel(ControllerEditor controller) {
    	this.controller = controller;
    	this.board = new Board ();
    }
    
    public Board getBoard() {
    	return this.board;
    }
}