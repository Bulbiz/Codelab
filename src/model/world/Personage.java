
package src.model.world;

import src.model.langage.*;

import java.util.*;

public class Personage extends Entity {
    protected int facing;
    protected Queue<Action> actions;
    
    private static final int [][] rotate = {{1,0},{0,1},{-1,0},{0,-1}}; 
    public Personage(Board b, int xStart, int yStart,int facingStart,Queue<Action> a) {
    	super(b,xStart,yStart);
    	facing = facingStart % 4;
    	actions = a;
    }

    private void turn (int rotate) {
    	this.facing = ((this.facing + rotate) + 4) % 4; // "+ 4" is to always get positif modulus
    }

    public void turnLeft () {
    	this.turn(-1);
    }

    public void turnRight () {
    	this.turn(1);
    }
    
    public void move () {
    	if(this.levelBoard.move (x,y, x + rotate [facing][0] , y + rotate [facing][1] )) {
    		x = x + rotate [facing][0];
    		y = y + rotate [facing][1];
    	}
    }

}
