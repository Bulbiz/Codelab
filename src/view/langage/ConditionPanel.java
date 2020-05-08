
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;
import java.awt.Color;
import javax.swing.JLabel;


public class ConditionPanel extends InstructionPanel {

    public ConditionPanel(ControllerLanguage controller, Condition condition) {
        super(controller);

        if (condition != null)
            instruction = InstructionFactory.createInstruction(condition);                      
        color = Color.CYAN.darker(); 

        setBackground(color);
        add(new JLabel(instruction != null ? instruction.getVersion() : "null"));        
    }

    public void setCondition(Condition condition) {
        instruction = condition;
    }

    public Condition getCondition() {
        return (Condition)instruction;
    }

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
        return new ConditionPanel(controller, (Condition)instruction);
    }
    
    public boolean onRelease(InstructionPanel source) {

        if (!(source instanceof ConditionPanel))
            return false;

        if (source.getInstruction() == null)
            return false;

        if (getParentPanel() != null) {
            IConditionPanelAdjustable parent = (IConditionPanelAdjustable) getParentPanel();
            parent.addConditionPanel((ConditionPanel)source);
            return true;
        }

        return false;
    }

}
