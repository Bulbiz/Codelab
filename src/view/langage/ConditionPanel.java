
package src.view.langage;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;

import src.controller.ControllerLanguage;
import src.model.langage.*;

/**
 * 
 */
public class ConditionPanel extends InstructionPanel {

    /**
     * Default constructor
     */
    public ConditionPanel(ControllerLanguage controller, Condition condition) {
        super(controller, null);
        if (condition != null)
            instruction = InstructionFactory.createCondition(condition.getPersonage(), condition.getVersion());  
        setUpPanel();                 
        setBackground(Color.CYAN);
    }

    public void setUpPanel() {
        add(new JLabel(instruction != null ? instruction.getVersion() : "null"));
    }

    public void setCondition(Condition condition) {
        instruction = condition;
    }

    public Condition getCondition() {
        return (Condition)instruction;
    }
    
    public Instruction toInstruction() {
        return instruction;
    }

}
