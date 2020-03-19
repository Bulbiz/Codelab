
package src.view.langage;

import src.controller.ControllerLanguage;
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
public class ControlFlowStatementPanel extends ActionPanel implements IActionPanelListable {

    ActionPanel head;

    /**
     * Default constructor
     */
    public ControlFlowStatementPanel(ControllerLanguage controller, ControlFlowStatement cfs) {
        super(controller);
        instruction = InstructionFactory.createFlowControlStatement(cfs.getPersonage(), cfs.getVersion());

        conditionPanel = new ConditionPanel(controller, null);
        conditionPanel.setParentPanel(this);
        conditionPanelPanel = new JPanel();        
        conditionPanelPanel.add(conditionPanel);

        ActionPanel ap = new ActionPanel(controller, null);
        ap.setParentPanel(this);
        head = ap;
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

    private JPanel actionPanelsPanel;

    private ConditionPanel conditionPanel;
    private JPanel conditionPanelPanel;
    
    public void setConditionPanel(ConditionPanel cp) {
        if (cp.getParentPanel() != null) {
            cp.getParentPanel().setConditionPanel(createEmptyConditionPanel());
        }

        conditionPanelPanel.remove(conditionPanel);
        conditionPanel = cp;
        conditionPanel.setParentPanel(this);
        conditionPanelPanel.add(cp);
        revalidate();
    }

    private ConditionPanel createEmptyConditionPanel() {
        return new ConditionPanel(controller, null);
    }

    private ActionPanel createEmptyActionPanel() {
        return new ActionPanel(controller, null);
    }

    public void addActionPanel(ActionPanel ap, ActionPanel previous) {
        if (ap.getParentPanel() == previous.getParentPanel() && getIndexInPane(ap, head) <= getIndexInPane(previous, head))
            return;

        if (ap.getParentPanel() != null)
            ap.getParentPanel().removeActionPanel(ap);

        if (previous.getInstruction() == null) { 
            actionPanelsPanel.remove(head);           
            head = ap;
            updateNext(ap, null);
        }
        else {
            updateNext(ap, previous);
        }

        addRecursively(ap, this, actionPanelsPanel);
        revalidate();
    }

    public void removeActionPanel(ActionPanel ap) {
        if (ap.getInstruction() == null)
            return;

        removeRecursively(ap, actionPanelsPanel);

        ActionPanel previous = getPrevious(ap, head);
        if (previous != null) {
            System.out.println("previous != null");
            previous.next = null;
        }
        else {
            System.out.println("previous == null");
            head = createEmptyActionPanel();
            actionPanelsPanel.add(head);
        }

    }

	public Instruction toInstruction() {
        ControlFlowStatement cfs = (ControlFlowStatement) instruction;

        Condition condition = conditionPanel.getCondition();
        if (condition == null) return null;
        cfs.setCondition(condition);

        ActionPanel cur = head;
        while (cur != null) {
            Action a = (Action)cur.toInstruction();
            if (a == null) return null;
            cfs.addAction(a);
            cur = cur.next;
        }

        return instruction;
	}

}
