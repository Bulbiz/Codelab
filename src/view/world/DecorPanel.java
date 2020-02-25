
package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.util.*;

/**
 * 
 */
public class DecorPanel extends JLabel implements IDisplayable {
	
	private Decor decor;
    /**
     * Default constructor
     */
    public DecorPanel(Decor d) {
    	ImageIcon image = new ImageIcon (this.getClass().getResource(d.toString() + ".png"));
    	this.decor = d;
    	this.setIcon(image);
    }
    /**
     * 
     */
    public void updateDisplay() {
        // TODO implement here
    }

}
