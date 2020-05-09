
package src.model.langage;

import src.model.world.*;
/**
 *
 */
public class Move extends Action {


    public Move(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new Move(personage);
    }

    /**
     * @return return the number of actions executed
     */
    public int run() {
    	this.personage.move();
    	return 1;
	}

}
