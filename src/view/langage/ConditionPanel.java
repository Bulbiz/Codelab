
package src.view.langage;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;

import src.controller.ControllerLanguage;
import src.model.langage.*;

/**
 * 
 */
public class ConditionPanel extends InstructionPanel {

    public ConditionPanel(ControllerLanguage controller, Condition condition) {
        super(controller, null);
        if (condition != null)
            instruction = InstructionFactory.createCondition(condition.getPersonage(), condition.getVersion());                      
        setBackground(Color.CYAN);
        setUpPanel(); 
    }

    public void setUpPanel() {
        add(new JLabel(instruction != null ? instruction.getVersion() : "null"));
        System.out.println("set up original");       
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
