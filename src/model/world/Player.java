
package src.model.world;

import java.util.*;
import src.model.langage.*;
/**
 * 
 */
public class Player extends Personage {

    /**
     * Default constructor
     */
    public Player(Board b, int xStart, int yStart,int facingStart) {
    	super(b,xStart,yStart,facingStart,null);
    }
    public void setActions (Queue<Action> actions) {
    	this.actions = actions;
    }

}
