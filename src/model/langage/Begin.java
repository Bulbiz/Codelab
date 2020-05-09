
package src.model.langage;

import src.model.world.Personage;

public class Begin extends Action {
    public Begin(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new Begin(personage);
    }
    
    public int run() {
    	return 0;
    }
}