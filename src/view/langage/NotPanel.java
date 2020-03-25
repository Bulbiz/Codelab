
package src.view.langage;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controller.ControllerLanguage;
import src.model.langage.*;

public class NotPanel extends ConditionPanel implements IParent {

    ConditionPanel conditionPanel;
    JPanel conditionPanelPanel;

    public NotPanel(ControllerLanguage controller, Not not) {
        super(controller, not);           
    }

    public void setUpPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(new JLabel("NOT"));
        conditionPanelPanel = new JPanel();
        conditionPanelPanel.add(ControlFlowStatementPanel.createEmptyConditionPanel(this, controller));
        add(conditionPanelPanel);
        System.out.println("set up override");  
    }

    public void setConditionPanel(ConditionPanel cp) {
        conditionPanel = cp;
    }

    @Override
    public Instruction toInstruction() {
        // TODO Auto-generated method stub
        return null;
    }

}