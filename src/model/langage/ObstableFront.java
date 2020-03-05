
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class ObstableFront extends Condition {


    public ObstableFront(Personage personage) {
    	super(personage);
    }


    public boolean isTrue() {
        return personage.obstacleFront();
	}

}
