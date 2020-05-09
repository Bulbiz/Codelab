
package src.model.langage;

import src.model.world.*;
/**
 *
 */
public class TurnRight extends Action {


    public TurnRight(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new TurnRight(personage);
    }

    /**
     * @return return the number of actions executed
     */
    public int run() {
    	this.personage.turnRight();
    	return 0;
	}

}
