
package src.view.langage;

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
        conditionPanelPanel.add(conditionPanel);
        add(conditionPanelPanel);
    }

    public void setConditionPanel(ConditionPanel cp) {
        conditionPanel = cp;
    }

    public ConditionPanel getConditionPanel() {
        return conditionPanel;
    }

    public void changeConditionPanel(ConditionPanel cp) {
        changeConditionPanel(cp, conditionPanelPanel, controller);
        revalidate();
    }

    @Override
    public Instruction toInstruction() {
        // TODO Auto-generated method stub
        return null;
    }

}