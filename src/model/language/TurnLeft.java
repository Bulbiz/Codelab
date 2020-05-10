
package src.model.language;

import src.model.world.*;
/**
 *
 */
public class TurnLeft extends Action {


    public TurnLeft(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new TurnLeft(personage);
    }

    /**
     * @return return the number of actions executed
     */
    public int run() {
    	this.personage.turnLeft();
    	return 0;
    }

    public String toString() {
        return "Turn left";
    }
}
