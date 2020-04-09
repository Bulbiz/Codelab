
package src.editor.view;

import javax.swing.JPanel;
import src.model.world.*;
import src.view.world.WorldPanel;
import src.controller.ControllerEditor;
import java.awt.Graphics;

public class BoardEditorPanel extends WorldPanel {
    private ControllerEditor controller;

    int selectedX, selectedY;

    public BoardEditorPanel(Board board, ControllerEditor controller) {
        super(board);
        boardModel = board;
        addMouseListener(controller);
        this.controller = controller;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void updateFromClick(int mouseX, int mouseY) {
        selectedX = mouseX / tileLength;
        selectedY = mouseY / tileLength;
    }

    public int getSelectedX() {
        return selectedX;
    }
    public int getSelectedY() {
        return selectedY;
    }
    
    public Board getBoard() {
    	return boardModel;
    }
}