
package src.model.world;

import src.model.langage.*;

import java.util.*;

/**
 * 
 */
public class Character extends Entity {
    protected int facing;
    protected ArrayList<Action> actions;
    
    public Character(Board b, int xStart, int yStart,int facingStart,ArrayList<Action> a) {
    	super(b,xStart,yStart);
    	facing = facingStart % 4;
    	actions = a;
    }
    
}
