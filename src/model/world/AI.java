
package src.model.world;

import src.model.langage.*;
import java.util.*;

/**
 * Define the non playable character in the Levelboard
 */
public class AI extends Personage {

    public AI(Board b, int xStart, int yStart,int facingStart,Queue<Action> a) {
    	super(b,xStart,yStart,facingStart,a);
    }

}
