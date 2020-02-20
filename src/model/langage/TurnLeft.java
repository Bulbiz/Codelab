
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
     * @return it return the amount of the action.
     */
    public int run() {
		//TODO implement here
      this.personage.turnLeft();
		  return 0;
    }

}
