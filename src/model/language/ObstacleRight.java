
package src.model.language;

import src.model.world.*;
/**
 *
 */
public class ObstacleRight extends Condition {


    public ObstacleRight(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new ObstacleRight(personage);
    }


    public boolean isTrue() {
        return personage.obstacleRight();
    }
    
    public String toString() {
        return "Obstacle on Right";
    }

}
