
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class Move extends Action {

    /**
     * Default constructor
     */
    public Move(Personage personage) {
      super(personage);
    }

    /**
     * FIXME: Place Holder
     */
    public int run() {
		personage.move();
		return 1;
	}

}
