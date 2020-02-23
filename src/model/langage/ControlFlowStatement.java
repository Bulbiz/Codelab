
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public abstract class ControlFlowStatement extends Action {

    /**
     * Default constructor
     */
    public ControlFlowStatement(Personage personage) {
    	super(personage);
    }

    /**
     *
     */
    protected Condition condition;

    /**
     *
     */
    protected Queue<Action> actions;




    /**
     * @return
     */
    public abstract int run();

}
