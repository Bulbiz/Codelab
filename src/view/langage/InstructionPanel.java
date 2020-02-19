
package src.view.langage;
import src.model.langage.*;

import java.util.*;

/**
 * 
 */
public abstract class InstructionPanel {

    /**
     * Default constructor
     */
    public InstructionPanel() {
    }

    /**
     * 
     */
    protected Instruction instruction;

    /**
     * 
     */
    protected int x;

    /**
     * 
     */
    protected int y;

    /**
     * 
     */
    protected InstructionPanel next;

    /**
     * 
     */
    protected int width;

    /**
     * 
     */
    protected int height;


    /**
     * 
     */
    public void Move() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Create() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Delete() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Select() {
        // TODO implement here
    }

    /**
     * 
     */
    public abstract void toInstruction();

}
