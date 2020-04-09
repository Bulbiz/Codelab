
package src.editor.view;

import javax.swing.JPanel;

import src.controller.ControllerEditor;
import src.model.world.Board;

public class EditorPanel extends JPanel {

    BoardEditorPanel leftPanel;
    GeneratorsPanel rightPanel;

    public EditorPanel(ControllerEditor controller) {
        leftPanel = new BoardEditorPanel(new Board(), controller);
        rightPanel = new GeneratorsPanel(controller);

        add(leftPanel);
        add(rightPanel);
    }

    public BoardEditorPanel getBoardPanel() {
        return leftPanel;
    }

    public GeneratorsPanel getGeneratorsPanel() {
        return rightPanel;
    }
}