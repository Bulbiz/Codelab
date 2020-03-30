
package src.editor.view;

import src.controller.ControllerEditor;
import src.model.world.Cell;
import src.model.world.Entity;

public class EntityGeneratorPanel extends CellElementGeneratorPanel {

    Entity entity;

    EntityGeneratorPanel(ControllerEditor controller, Entity entity) {
        super(controller);
        /* il faut faire un duplicat de l'entité passée en argument */ 
        //this.entity = entity; 
    }

    @Override
    public void setCellElement(Cell cell) {
        cell.setEntity(entity);
    }

}