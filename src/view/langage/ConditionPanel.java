
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
        normalColor = Color.CYAN.darker();
        highlightColor = Color.CYAN;

        setBackground(normalColor);
        add(new JLabel(instruction != null ? instruction.getVersion() : "null"));
    }

    public void setCondition(Condition condition) {
        instruction = condition;
    }

    public Condition getCondition() {
        return (Condition)instruction;
    }

    @Override
    public void delete() {
        if (parent != null) {
            IConditionPanelAdjustable p = (IConditionPanelAdjustable) parent;
            p.changeConditionPanel(ControlFlowStatementPanel.createEmptyConditionPanel(parent, controller));
        }
    }

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
        return new ConditionPanel(controller, (Condition)instruction);
    }
    
    public void onRelease(InstructionPanel source) {
        super.onRelease(source);

        if (!(source instanceof ConditionPanel))
            return;

        if (source.getInstruction() == null)
            return;

        if (getParentPanel() != null) {
            IConditionPanelAdjustable parent = (IConditionPanelAdjustable) getParentPanel();
            parent.changeConditionPanel((ConditionPanel)source);
        }
    }

}
