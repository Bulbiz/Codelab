
package src.model.world;

import java.util.*;

/**
 *
 */
public class Door extends Decor implements Obstacle {

    private static int nbDoors = 0;
    protected int id;

    /**
     * Default constructor
     */
    public Door(Board b, int xPosition, int yPosition) {
        super(b,xPosition,yPosition);
        id = nbDoors;
        nbDoors ++;
    }
    public String toString() {
    	return "door";
    }
    
    public void open() {
    	this.levelBoard.setDecor(new Floor(this.levelBoard,x,y),y,x);
    }

    public int getId() {
        return id;
    }
}
