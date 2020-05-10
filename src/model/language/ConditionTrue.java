
package src.model.language;

import src.model.world.*;
/**
 *
 */
public class ConditionTrue extends Condition {


    public ConditionTrue(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new ConditionTrue(personage);
    }


    public boolean isTrue() {
        return true;
	}

}
