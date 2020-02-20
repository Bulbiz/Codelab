
package src.model.world;

import java.util.*;

/**
 * An Entity is an object in the board of a level
 */
public class Entity {
	protected Board levelBoard; 
	protected int x;
	protected int y;
	
    public Entity(Board b, int xStart, int yStart) {
    	levelBoard = b;
    	x = xStart;
    	y = yStart;
    }


}
