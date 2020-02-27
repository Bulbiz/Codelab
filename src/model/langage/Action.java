
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public abstract class Action extends Instruction {


    public Action(Personage personage) {
    	super(personage);
    }



    /**
     *
     */
    public abstract int run();

}
