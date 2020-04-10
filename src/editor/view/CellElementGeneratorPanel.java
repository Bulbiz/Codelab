
package src.editor.view;

import src.controller.ControllerEditor;
import src.model.world.*;

public abstract class CellElementGeneratorPanel {

    ControllerEditor controller;

    CellElementGeneratorPanel(ControllerEditor controller) {
        this.controller = controller;
    }

    public abstract void setCellElement(Cell cell);
}