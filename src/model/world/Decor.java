
package src.model.world;

import java.util.*;

/**
 *
 */
public abstract class Decor {


    protected Board levelBoard;
	protected int x;
	protected int y;


    public Decor(Board b, int xPosition, int yPosition) {
        levelBoard = b;
    	x = xPosition;
    	y = yPosition;
    }
}
