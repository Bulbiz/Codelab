
package src.model.langage;

import java.util.*;

/**
 * 
 */
public abstract class ControlFlowStatement extends Action {

    /**
     * Default constructor
     */
    public ControlFlowStatement() {
    }

    /**
     * 
     */
    protected Condition condition;

    /**
     * 
     */
    protected ArrayList<Action> actions;




    /**
     * @return
     */
    public abstract int run();

}
