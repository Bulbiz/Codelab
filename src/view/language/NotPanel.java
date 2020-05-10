
package src.view.language;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controller.ControllerLanguage;
import src.model.language.*;

public class NotPanel extends ConditionPanel implements IConditionPanelAdjustable {

    ConditionPanel conditionPanel;

    JLabel notLabel;
    int labelWidth = 32;

    public NotPanel(ControllerLanguage controller, Not not) {
        super(controller, not); 
        
        setLayout(null);
        notLabel = new JLabel("Not");        
        notLabel.setBackground(normalColor);
        notLabel.setBounds(0, 0, labelWidth, 32);
        add(notLabel);

        conditionPanel = ControlFlowStatementPanel.createEmptyConditionPanel(this, controller);
        add(conditionPanel);
    }

    public ConditionPanel getConditionPanel() {
        return conditionPanel;
    }

    public void setConditionPanel(ConditionPanel cp) {
        conditionPanel = cp;
    }

    @Override
    public Instruction toInstruction() {

        Not not = (Not) instruction;
        if (conditionPanel.getCondition() == null)
            return null;
        
        not.setCondition(conditionPanel.getCondition());
        return not;
    }

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
        return new NotPanel(controller, (Not)instruction);
    }

    public void setPosition(int x, int y, int w) {
        conditionPanel.setPosition(labelWidth, 0, w - labelWidth);
        super.setPosition(x, y, w);
    }

    public void highlight() {
        conditionPanel.highlight();
        super.highlight();
    }

    public void dehighlight() {
        conditionPanel.dehighlight();
        super.dehighlight();
    }
}