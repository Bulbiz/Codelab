
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
        super(controller);
        if (condition != null)
            instruction = InstructionFactory.createInstruction(condition);                      
        setBackground(Color.CYAN);
        setUpPanel(); 
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

    @Override
    public void delete() {
        IConditionPanelAdjustable p = (IConditionPanelAdjustable) parent;
        p.changeConditionPanel(ControlFlowStatementPanel.createEmptyConditionPanel(parent, controller));
    }

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
        return new ConditionPanel(controller, (Condition)instruction);
    }
    
    public void onRelease(IMouseReactive src) {
        InstructionPanel source = (InstructionPanel) src;

        System.out.println("over condition panel");
        if (source.getInstruction() == null)
            return;
        if (!source.getInstruction().getType().equals("condition"))
            return;

        if (getParentPanel() != null) {
            IConditionPanelAdjustable parent = (IConditionPanelAdjustable) getParentPanel();
            parent.changeConditionPanel((ConditionPanel)source);
        }  
    }

}
