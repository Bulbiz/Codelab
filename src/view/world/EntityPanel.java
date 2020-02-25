
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
     * FIXME : What if entity == null ?
     */
    public EntityPanel(Entity e) {
    	ImageIcon image = new ImageIcon (this.getClass().getResource(e.toString() + ".png"));
    	this.entity = e;
    	this.setIcon(image);
    }

    /**
     * 
     */
    public void updateDisplay() {
    	ImageIcon image = new ImageIcon (this.getClass().getResource(entity.getClass().toString() + ".png"));
    	this.setIcon(image);
    }

}
