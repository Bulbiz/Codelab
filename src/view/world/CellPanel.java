
package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.util.*;

/**
 * 
 */
public class CellPanel extends JPanel implements IDisplayable {

	/* FIXME: Is a Cell Useful Here ?
	 * private Cell cell;
	 */
	
    private DecorPanel decorPanel;
    private EntityPanel entityPanel;
    /**
     * Default constructor
     */
    public CellPanel(Cell c) {
    	decorPanel = new DecorPanel(c.getDecor());
    	entityPanel = new EntityPanel(c.getEntity());
    	this.add(decorPanel);
    	this.add(entityPanel);
    }
    /**
     * 
     */
    public void updateDisplay() {
    	this.decorPanel.updateDisplay(); //FIXME: Should we update the decor since he never really change ?
        this.entityPanel.updateDisplay();
    }

}
