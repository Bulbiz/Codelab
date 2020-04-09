package src.model.world;

import java.util.*;

public class Goal extends Decor {

    private boolean haveDoor;

    public Goal(Board b, int xPosition, int yPosition) {
        super(b,xPosition,yPosition);
        this.haveDoor = false;
    }

    public void setDoor(boolean door) {
    	this.haveDoor = door;
    }

    public String toString() {
    	return "goal";
    }

}
