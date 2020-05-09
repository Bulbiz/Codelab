
package src.editor.view;

import javax.swing.*;
import src.controller.ControllerEditor;
import src.model.world.Board;
import src.view.world.MenuPanel;

public class EditorPanel extends JPanel {

    BoardEditorPanel leftPanel;
    GeneratorsPanel rightPanel;
    private JFrame parent;
    private JButton backToMenu;

    public EditorPanel(ControllerEditor controller, JFrame parent) {
        leftPanel = new BoardEditorPanel(new Board(), controller);
        rightPanel = new GeneratorsPanel(controller);
        this.backToMenu = new JButton("<--");
        this.add(backToMenu);
        this.parent = parent;
        add(leftPanel);
        add(rightPanel);

        this.backToMenu.addActionListener((e) -> {
            parent.dispose();
            MenuPanel.beginMenu();
	    });
    }

    public BoardEditorPanel getBoardPanel() {
        return leftPanel;
    }

    public GeneratorsPanel getGeneratorsPanel() {
        return rightPanel;
    }
}