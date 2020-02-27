
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public abstract class ControlFlowStatement extends Action {


    public ControlFlowStatement(Personage personage) {
    	super(personage);
    	swapActive = false;
    	active = false;
    }

    /**
     *
     */
    protected Condition condition;

    /**
     *
     */
    protected Queue<Action> actions;
    protected boolean active; 				//true = the control struture is always active, false the control struture is end.
    protected boolean swapActive;

    /**
     * @return
     */
    public abstract int run();

}
