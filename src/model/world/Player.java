
package src.model.world;

import java.util.*;
import src.model.langage.*;
/**
 * 
 */
public class Player extends Character {

    /**
     * Default constructor
     */
    public Player(Board b, int xStart, int yStart,int facingStart,ArrayList<Action> a) {
    	super(b,xStart,yStart,facingStart,a);
    }

}
