
package src.model.world;

import src.model.langage.*;
import java.util.*;

/**
 * Define the non playable character in the Levelboard
 */
public abstract class AI extends Personage {

    public AI(Board b, int xStart, int yStart,int facingStart,Queue<Action> a) {
    	super(b,xStart,yStart,facingStart,a);
    }
    
    /* 0 => Action qui ne compte pas comme une action (turn)
     * 1 => Action terminer
     * 2 => Action n'est pas terminer (cas dans le if/while) */
    public void run () {
        int verification = actions.peek().run();
        while (verification == 0) {
            actions.offer(actions.poll());
            verification = actions.peek().run();
        }

        if(verification == 1)
        	actions.offer(actions.poll());
    }
}
