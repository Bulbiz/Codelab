
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;



public abstract class InstructionPanel extends JPanel implements IMouseReactive {

    protected IParent parent;

    protected ControllerLanguage controller;

    protected Instruction instruction;

    protected boolean isHighlighted;
    protected Color normalColor;
    protected Color highlightColor;

    public InstructionPanel(ControllerLanguage controller) {
        this.controller = controller;
        this.isHighlighted = false;

        addMouseListener(controller);
        addMouseMotionListener(controller);

        setPreferredSize(new Dimension(300, 32));
        setMaximumSize(new Dimension(300, 32));
        setBorder(new LineBorder(Color.black));
    }    

    public abstract InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction);

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
