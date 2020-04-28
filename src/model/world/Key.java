
package src.model.world;

import java.util.*;

/**
 * 
 */
public class Key extends Collectable {

    private static int nbKeys = 0;
    protected int id;
    

    public Key(Board b, int xStart, int yStart) {
        super(b,xStart,yStart);
        id = nbKeys;
        nbKeys ++;
    }
    public void run() {
    	//FIXME : do nothing for now
    }
    public String toString() {
    	return "key";
    }

    public void isCollected(Player player) {
        super.isCollected(player);
        
        System.out.println("collectée");

        levelBoard.openDoor(id);
    }
}
