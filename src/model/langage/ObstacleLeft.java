
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class ObstacleLeft extends Condition {


    public ObstacleLeft(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new ObstacleLeft(personage);
    }


    public boolean isTrue() {
        return personage.obstacleLeft();
	}

}
