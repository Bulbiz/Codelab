
package src.view.langage;

import src.model.langage.*;

import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;

import java.awt.Color;
import java.awt.GridLayout;

/**
 * 
 */
public class ControlFlowStatementPanel extends ActionPanel {

    /**
     * Default constructor
     */
    public ControlFlowStatementPanel(MouseAdapter controller, ControlFlowStatement cfs) {
        super(controller);
        instruction = InstructionFactory.createFlowControlStatement(cfs.getPersonage(), cfs.getVersion());

        conditionPanel = new ConditionPanel(controller, null);
        conditionPanel.setParent(this);
        conditionPanelPanel = new JPanel();        
        conditionPanelPanel.add(conditionPanel);

        actionPanelList = new ArrayList<ActionPanel>();
        ActionPanel ap = new ActionPanel(controller, null);
        ap.setParent(this);
        actionPanelList.add(ap);
        actionPanelsPanel = new JPanel();
        actionPanelsPanel.setLayout(new BoxLayout(actionPanelsPanel, BoxLayout.PAGE_AXIS));
        actionPanelsPanel.add(ap);

        setLayout(new GridLayout(2, 2));
        add(new JLabel(cfs.getVersion()));
        add(conditionPanelPanel);
        add(new JLabel("do"));
        add(actionPanelsPanel);
        setBackground(Color.GREEN);
    }

    private ArrayList<ActionPanel> actionPanelList;
    private JPanel actionPanelsPanel;

    private ConditionPanel conditionPanel;
    private JPanel conditionPanelPanel;
    
    public void setConditionPanel(ConditionPanel cp) {
        conditionPanelPanel.remove(conditionPanel);
        conditionPanel = cp;
        conditionPanel.setParent(this);
        conditionPanelPanel.add(cp);
        revalidate();
    }

    public void addActionPanel(ActionPanel ap) {
        if (actionPanelList.get(0).getInstruction() == null)
            removeActionPanel(actionPanelList.get(0));

        actionPanelList.add(ap);
        actionPanelsPanel.add(ap);
        ap.setParent(this);
        revalidate();
    }

    public void removeActionPanel(ActionPanel ap) {
        actionPanelList.remove(ap);
        actionPanelsPanel.remove(ap);
        ap.setParent(null);
    }

	public Instruction toInstruction() {
        ControlFlowStatement cfs = (ControlFlowStatement) instruction;

        Condition condition = conditionPanel.getCondition();
        if (condition == null) return null;
        cfs.setCondition(condition);

        for (ActionPanel ap : actionPanelList) {
            Action a = (Action)ap.toInstruction();
            if (a == null) return null;
            cfs.addAction(a);
        }

        return instruction;
	}

}
