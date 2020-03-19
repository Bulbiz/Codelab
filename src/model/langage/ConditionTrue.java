
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class ConditionTrue extends Condition {


    public ConditionTrue(Personage personage) {
    	super(personage);
    }


    public boolean isTrue() {
        return true;
	}

}
