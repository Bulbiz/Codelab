
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class Stay extends Action {


    public Stay(Personage personage) {
    	super(personage);
    }

    /**
     * @return return the number of actions executed
     */
    public int run() {
        this.personage.stay();
		return 1;
	}

}
