
package src.editor.view;

import javax.swing.JPanel;

import src.controller.ControllerEditor;

public class EditorPanel extends JPanel {

    BoardEditorPanel leftPanel;
    GeneratorsPanel rightPanel;

    public EditorPanel(ControllerEditor controller) {
        leftPanel = new BoardEditorPanel(controller);
        rightPanel = new GeneratorsPanel(controller);
    }
}