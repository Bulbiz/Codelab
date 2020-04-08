
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class ObstacleFront extends Condition {


    public ObstacleFront(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new ObstacleFront(personage); 
    }


    public boolean isTrue() {
        return personage.obstacleFront();
	}

}
