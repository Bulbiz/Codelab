
package src.view.langage;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controller.ControllerLanguage;
import src.model.langage.*;

public class NotPanel extends ConditionPanel {

    ConditionPanel conditionPanel;
    JPanel conditionPanelPanel = new JPanel();

    public NotPanel(ControllerLanguage controller, Condition not) {
        super(controller, not);
    }

    @Override 
    public void setUpPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(new JLabel("NOT"));
        add(conditionPanelPanel);
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