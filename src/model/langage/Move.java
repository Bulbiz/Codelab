
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
     * @return it return the amount of the action.
     */
    public int run() {
		//TODO implement here
    this.personage.move();
		return 1;
	}

}
