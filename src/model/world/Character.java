
package src.model.world;

import src.model.langage.*;

import java.util.*;

/**
 * 
 */
public class Character extends Entity {
    protected int facing;
    protected ArrayList<Action> actions;
    
    public Character(int facingStart) {
    	facing = facingStart % 4;
    }

    /**
     * 
     */

}
