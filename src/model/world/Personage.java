
package src.model.world;

import src.model.langage.*;

import java.util.*;

public class Personage extends Entity {
    protected int facing;
    protected ArrayList<Action> actions;

    public Personage(Board b, int xStart, int yStart,int facingStart,ArrayList<Action> a) {
    	super(b,xStart,yStart);
    	facing = facingStart % 4;
    	actions = a;
    }

    private void turn (int rotate) {
    	this.facing = (this.facing + rotate) % 4;
    }

    public void turnLeft () {
    	this.turn(-1);
    }

    public void turnRight () {
    	this.turn(1);
    }

}
