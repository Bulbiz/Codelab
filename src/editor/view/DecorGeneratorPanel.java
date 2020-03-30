
package src.editor.view;

import src.controller.ControllerEditor;
import src.model.world.Cell;
import src.model.world.Decor;

public class DecorGeneratorPanel extends CellElementGeneratorPanel {

    Decor decor;

    DecorGeneratorPanel(ControllerEditor controller, Decor decor) {
        super(controller);
        /* Il faut faire un duplicat du décor passé en argument */
        //this.decor = decor;
    }

    @Override
    public void setCellElement(Cell cell) {
        cell.setDecor(decor);

    }

}