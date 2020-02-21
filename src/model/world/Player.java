
package src.model.world;

import java.util.*;
import src.model.langage.*;
/**
 * Define the Player
 */
public class Player extends Personage {

	/*The list of actions have to be set after the player has been created because the 
	 * actions need to have the player to be created
	 */
    public Player(Board b, int xStart, int yStart,int facingStart) {
    	super(b,xStart,yStart,facingStart,null);
    }
    
    public void setActions (Queue<Action> actions) {
    	this.actions = actions;
    }

}
