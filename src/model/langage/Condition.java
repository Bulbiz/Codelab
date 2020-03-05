
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public abstract class Condition extends Instruction {


    public Condition(Personage personage) {
    	super(personage);
    }


    public abstract boolean isTrue();
        

}
