package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Display a Cell
 */
public class CellPanel extends JPanel implements IDisplayable {
	private Cell cell;
    private DecorPanel decorPanel;
    private EntityPanel entityPanel;
    
    /*
     * FIXME : Should Change the GridLayout into another Layout
     * + Should Entity be here or directly in the BoardPanel ?
     * (this version is more stable but less estetics but the other
     * is more estetics but less stable)
     */
    public CellPanel(Cell c) {
    	this.setLayout(new GridLayout(1,2));
    	this.decorPanel = new DecorPanel(c);
    	this.entityPanel = new EntityPanel(c);
    	this.cell = c;
    	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	this.add(this.decorPanel);
    	this.add(this.entityPanel);
    }

    public void updateDisplay() {
    	this.decorPanel.updateDisplay(); //FIXME: Should we update the decor since he never really change ?
        this.entityPanel.updateDisplay();
    }

}
