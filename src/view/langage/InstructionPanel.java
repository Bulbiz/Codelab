
package src.view.langage;
import src.model.langage.*;

import java.util.*;
import javax.swing.JPanel;

/**
 * 
 */
public abstract class InstructionPanel extends JPanel {

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
