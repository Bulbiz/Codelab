
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

    protected Color color;

    int x = 0;
    int y = 0;
    int height = 32;
    int width = standardWidth;

    public static final int standardWidth = EditPanel.width - 2*EditPanel.margeleft;

    public InstructionPanel(ControllerLanguage controller) {
        this.controller = controller;

        addMouseListener(controller);
        addMouseMotionListener(controller);


        setBorder(new LineBorder(Color.black));
    }    

    public void setPosition(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.width = w;        
        setBounds(x, y, width, height);
    }

    public void setPosition(int x, int y) {
        setPosition(x, y, width);
    }
    

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int w) {
        width = w;
    }

    public int getWidth() {
        return width;
    }

    public void updatePosition(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

    public abstract InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction);

    public void delete() {
        if (getParent() != null)
            getParent().remove(this);
        setVisible(false);
    }

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

}
