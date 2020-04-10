
package src.view.langage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controller.ControllerLanguage;
import src.model.langage.*;

public class NotPanel extends ConditionPanel implements IConditionPanelAdjustable {

    ConditionPanel conditionPanel;
    JPanel conditionPanelPanel;

    public NotPanel(ControllerLanguage controller, Not not) {
        super(controller, not);           
    }

    public void setUpPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(new JLabel("NOT"));
        conditionPanel = ControlFlowStatementPanel.createEmptyConditionPanel(this, controller);
        conditionPanelPanel = new JPanel();
        conditionPanelPanel.setLayout(new BoxLayout(conditionPanelPanel, BoxLayout.Y_AXIS));
        conditionPanelPanel.add(conditionPanel);
        add(conditionPanelPanel);
        conditionPanelPanel.setBackground(Color.cyan);

        setMaximumSize(new Dimension(300, 32 + conditionPanel.getMaximumSize().height));
    }

    public void setConditionPanel(ConditionPanel cp) {
        conditionPanel = cp;
        setMaximumSize(new Dimension(300, 32 + cp.getMaximumSize().height));
        System.out.println(getMaximumSize().height);
    }

    public ConditionPanel getConditionPanel() {
        return conditionPanel;
    }

    public void changeConditionPanel(ConditionPanel cp) {
        changeConditionPanel(cp, conditionPanelPanel, controller);
        validate();
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

    public void highlight() {
        super.highlight();
        conditionPanelPanel.setBackground(highlightColor);
    }

    public void dehighlight() {
        super.dehighlight();
        conditionPanelPanel.setBackground(normalColor);
    }

}