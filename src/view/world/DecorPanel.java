
package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Display a Decor,
 */
public class DecorPanel extends JLabel implements IDisplayable {
	private Cell cell;
    /**
     * FIXME : Should replace the text with an Image
     */
    public DecorPanel(Cell c) {
    	this.cell = c;
    	this.updateDisplay();
    	
    }
    /**
     * FIXME : Should replace the text with an Image
     * What if decor == null? should we throw an exception since it's not allowed
     * Do we have to update the Display since it never really change ? 
     */
    public void updateDisplay() {
    	this.setText(this.cell.getDecor() != null? Character.toString(this.cell.getDecor().toString().charAt(0)) : "D");
    }

}
