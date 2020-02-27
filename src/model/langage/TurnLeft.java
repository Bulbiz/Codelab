
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class TurnLeft extends Action {


    public TurnLeft(Personage personage) {
    	super(personage);
    }

    /**
     * @return return the number of actions executed
     */
    public int run() {
    	this.personage.turnLeft();
    	return 0;
    }

}
