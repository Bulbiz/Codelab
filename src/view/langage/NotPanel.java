
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
        
        conditionPanel = ControlFlowStatementPanel.createEmptyConditionPanel(this, controller);
        
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        initConditionPanelPanel(conditionPanel);
        setMaximumSize(new Dimension(300, 32 + conditionPanel.getMaximumSize().height));
    }

    public void initConditionPanelPanel(ConditionPanel conditionPanel) {        
        conditionPanelPanel = new JPanel();
        conditionPanelPanel.setLayout(new BoxLayout(conditionPanelPanel, BoxLayout.Y_AXIS));
        conditionPanelPanel.add(conditionPanel);        
        conditionPanelPanel.setBackground(Color.cyan);

        add(conditionPanelPanel);
    }

    public ConditionPanel getConditionPanel() {
        return conditionPanel;
    }

    public void setConditionPanel(ConditionPanel cp) {
        conditionPanel = cp;
        setMaximumSize(new Dimension(300, 32 + cp.getMaximumSize().height));
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
        conditionPanel.highlight();
    }

    public void dehighlight() {
        super.dehighlight();
        conditionPanelPanel.setBackground(normalColor);
        conditionPanel.dehighlight();
    }

}