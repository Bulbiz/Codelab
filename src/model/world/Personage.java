package src.model.world;

import src.model.langage.*;

import java.util.*;

/*
 * Define every Entity that have actions in the board
 */
public abstract class Personage extends Entity {
    protected int facing;
    protected Queue<Action> actions;

    /*FIXME : Not very explicit
     * 0 => facing the bottom
     * 1 => facing the right
     * 2 => facing the top
     * 3 => facing the left */
    private static final int [][] rotate = {{1,0},{0,1},{-1,0},{0,-1}};

    //FIXME we need a Board to create a Personage but we need a Personage to create a Board
    public Personage(Board b, int xStart, int yStart,int facingStart,Queue<Action> a) {
    	super(b,xStart,yStart);
    	facing = (facingStart + 4) % 4; // "+ 4" is to always get positif modulus
    	actions = a;
    }

    public int getFacing(){
        return facing;
    }
    private void turn (int rotate) {
    	this.facing = ((this.facing + rotate) + 4) % 4; // "+ 4" is to always get positif modulus
    }

    public void turnLeft () {
    	this.turn(1);
    }

    public void turnRight () {
    	this.turn(-1);
    }

    public void move () {
    	if(this.levelBoard.move (y,x, y + rotate [facing][1], x + rotate [facing][0] )) {
    		x = x + rotate [facing][0];
    		y = y + rotate [facing][1];
    	}
    }
    public void stay () {
    	//Do nothing
    }

    public boolean obstacleFront(){
        int xFront = x + rotate [facing][0];
        int yFront = y + rotate [facing][1];
        return levelBoard.getCells()[ yFront ][ xFront ].getDecor() instanceof Obstacle;
    }

    public boolean chestFront(){
        int xFront = x + rotate [facing][0];
        int yFront = y + rotate [facing][1];
        return levelBoard.getCells()[ yFront ][ xFront ].getDecor() instanceof Goal;
    }

}
