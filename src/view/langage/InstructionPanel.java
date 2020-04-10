
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Graphics;

/**
 * 
 */
public abstract class InstructionPanel extends JPanel implements IMouseReactive {


    public InstructionPanel(ControllerLanguage controller) {
        this.controller = controller;
        this.isHighlighted = false;
        addMouseListener(controller);
        addMouseMotionListener(controller);
        setPreferredSize(new Dimension(300, 32));
        setMaximumSize(new Dimension(300, 32));
        setBorder(new LineBorder(Color.black));
    }

    protected IParent parent;

    protected ControllerLanguage controller;

    protected Instruction instruction;

    protected boolean isHighlighted;
    protected Color normalColor;
    protected Color highlightColor;

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
    public void Create() {
        // TODO implement here
    }

    public abstract InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction);

    /**
     * 
     */
    public abstract void delete();

    public Instruction toInstruction() {
        return instruction;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public ControllerLanguage getController() {
        return controller;
    }

    public IParent getParentPanel() {
        return parent;
    }

    public void setParentPanel(IParent parent) {
        this.parent = parent;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public InstructionPanel getSourcePanel() {
        return this;
    }

    public String getDestType() {
        return "instructionPanel";
    }

    public void highlight() {
        if (!isHighlighted) {
            setBackground(highlightColor);
            isHighlighted = true;
        }
    }
    public void dehighlight() {
        if (isHighlighted) {
            setBackground(normalColor);
            isHighlighted = false;
        }
    }
}
