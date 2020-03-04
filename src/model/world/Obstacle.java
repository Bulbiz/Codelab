
package src.model.world;

import java.util.*;

/**
 *
 */
public class Obstacle extends Decor {

    public Obstacle(Board b, int xPosition, int yPosition) {
    	super(b,xPosition,yPosition);
    }

    public boolean conditionObstacleFront(int xPosition, int yPosition){
        if(x == xPosition && y == yPosition)
            return true;
        return false;
    }

}
