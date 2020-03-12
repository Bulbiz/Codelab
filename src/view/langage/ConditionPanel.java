
package src.view.langage;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;

import src.model.langage.*;

/**
 * 
 */
public class ConditionPanel extends InstructionPanel {

    /**
     * Default constructor
     */
    public ConditionPanel(MouseAdapter controller, Condition condition) {
        super(controller, null);
        if (condition != null)
            instruction = InstructionFactory.createCondition(condition.getPersonage(), condition.getVersion());
        add(new JLabel(condition != null ? condition.getVersion() : "null"));
        setBackground(Color.BLUE);
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
