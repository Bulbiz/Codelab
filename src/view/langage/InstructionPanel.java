
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;

import java.awt.Graphics;

/**
 * 
 */
public abstract class InstructionPanel extends JPanel implements IMouseReactive {

    /**
     * Default constructor
     */
    public InstructionPanel(ControllerLanguage controller, Instruction instruction) {
        this.instruction = instruction;
        this.controller = controller;
        addMouseListener(controller);
        addMouseMotionListener(controller);
    }

    /**
     * 
     */
    protected int x;

    /**
     * 
     */
    protected int y;

    protected ControlFlowStatementPanel parent;

    protected ControllerLanguage controller;

    protected Instruction instruction;

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
    public abstract Instruction toInstruction();

    public Instruction getInstruction() {
        return instruction;
    }

    public ControlFlowStatementPanel getParentPanel() {
        return parent;
    }

    public void setParentPanel(ControlFlowStatementPanel parent) {
        this.parent = parent;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public String getSourceType() {
        return "instructionPanel";
    }

    public String getDestType() {
        return "instructionPanel";
    }

}
