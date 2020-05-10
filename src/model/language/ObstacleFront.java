
package src.model.language;

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
    
    public String toString() {
        return "Obstacle Ahead";
    }
}
