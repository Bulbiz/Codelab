
package src.model.langage;

import src.model.world.*;
/**
 *
 */
public class ChestFront extends Condition {


    public ChestFront(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new ChestFront(personage);
    }


    public boolean isTrue() {
        return personage.chestFront();
	}

}
