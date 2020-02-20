
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
     * @return it return the amount of the action.
     */
    public int run() {
		//TODO implement here
      this.personage.stay();
		  return 1;
	}

}
