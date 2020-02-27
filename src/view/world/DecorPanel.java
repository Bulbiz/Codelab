
package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Display a Decor,
 */
public class DecorPanel extends JLabel implements IDisplayable {
	
	private Decor decor;
    /**
     * FIXME : Should replace the text with an Image
     */
    public DecorPanel(Decor d) {
    	this.decor = d;
    	this.updateDisplay();
    	
    }
    /**
     * FIXME : Should replace the text with an Image
     * What if decor == null? should we throw an exception since it's not allowed
     * Do we have to update the Display since it never really change ? 
     */
    public void updateDisplay() {
    	if (this.decor == null) 
    		this.setText("D");
    	else
    		this.setText(Character.toString(decor.toString().charAt(0)));
    }

}
