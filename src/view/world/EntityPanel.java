
package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * 
 */
public class EntityPanel extends JLabel implements IDisplayable {
	private Cell cell;
    /**
     * FIXME : Should replace the text with an Image
     */
    public EntityPanel(Cell c) {
    	this.cell = c;
    	this.updateDisplay();
    }

    /**
     * FIXME : Should replace the text with an Image
     */
    public void updateDisplay() {
    	this.setText(this.cell.getEntity() != null?Character.toString(this.cell.getEntity().toString().charAt(0)) : "E");
    }

}
