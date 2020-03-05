
package src.model.world;

import java.util.*;

/**
 * 
 */
public class Key extends Entity {

    /**
     * Default constructor
     */
    public Key(Board b, int xStart, int yStart) {
    	super(b,xStart,yStart);
    }
    
    public String toString() {
    	return "key";
    }
}
