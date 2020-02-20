
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class TurnRight extends Action {


    public TurnRight(Personage personage) {
    	super(personage);
    }

    /**
     * @return return the number of actions executed
     */
    public int run() {
    	this.personage.turnRight();
    	return 0;
	}

}
