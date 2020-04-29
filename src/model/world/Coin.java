
package src.model.world;

import java.util.*;

/**
 *
 */
public class Coin extends Collectable {

    /**
     * Default constructor
     */
    public Coin(Board b, int xStart, int yStart) {
    	super(b,xStart,yStart);
    }
    
    public void run() {}

    public String toString() {
    	return "coin";
    }
}
