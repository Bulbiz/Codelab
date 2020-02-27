
package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.util.*;

/**
 * 
 */
public class EntityPanel extends JLabel implements IDisplayable {
	
	private Entity entity;
    /**
     * FIXME : Should replace the text with an Image
     */
    public EntityPanel(Entity e) {
    	this.entity = e;
    	this.updateDisplay();
    }

    /**
     * FIXME : Should replace the text with an Image
     */
    public void updateDisplay() {
    	if (this.entity == null) 
    		this.setText("v"); //v for Vide
    	else
    		this.setText(e.toString().charAt(0));
    }

}
