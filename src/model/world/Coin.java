
package src.model.world;

import java.util.*;

/**
 * 
 */
public class Coin extends Entity {

    /**
     * Default constructor
     */
    public Coin(Board b, int xStart, int yStart) {
    	super(b,xStart,yStart);
    }
    
    public String toString() {
    	return "coin";
    }
}
