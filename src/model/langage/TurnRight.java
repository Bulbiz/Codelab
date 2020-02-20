
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
     * @return it return the amount of the action.
     */
    public int run() {
		//TODO implement here
    this.personage.turnRight();
		return 0;
	}

}
