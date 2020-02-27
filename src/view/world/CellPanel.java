
package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Display a Cell
 */
public class CellPanel extends JPanel implements IDisplayable {

	/* FIXME: Is a Cell Useful Here ?
	 * private Cell cell;
	 */
	
    private DecorPanel decorPanel;
    private EntityPanel entityPanel;
    
    /*
     * FIXME : Should Change the GridLayout into another Layout
     */
    public CellPanel(Cell c) {
    	this.setLayout(new GridLayout(1,2));
    	decorPanel = new DecorPanel(c.getDecor());
    	entityPanel = new EntityPanel(c.getEntity());
    	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	this.add(decorPanel);
    	this.add(entityPanel);
    }

    public void updateDisplay() {
    	this.decorPanel.updateDisplay(); //FIXME: Should we update the decor since he never really change ?
        this.entityPanel.updateDisplay();
    }

}
