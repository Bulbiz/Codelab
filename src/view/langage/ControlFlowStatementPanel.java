
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
public class ControlFlowStatementPanel extends ActionPanel implements IActionPanelListable, IConditionPanelAdjustable {

    ActionPanel head;

    /**
     * Default constructor
     */
    public ControlFlowStatementPanel(ControllerLanguage controller, ControlFlowStatement cfs) {
        super(controller);
        instruction = InstructionFactory.createFlowControlStatement(cfs.getPersonage(), cfs.getVersion());

        conditionPanel = ControlFlowStatementPanel.createEmptyConditionPanel(this, controller);
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
    
    public void changeConditionPanel(ConditionPanel cp) {
        changeConditionPanel(cp, conditionPanelPanel, controller);
        revalidate();
    }

    public void setConditionPanel(ConditionPanel cp) {
        conditionPanel = cp;
    }

    public ConditionPanel getConditionPanel() {
        return conditionPanel;
    }

    public static ConditionPanel createEmptyConditionPanel(IParent parent, ControllerLanguage controller) {
        ConditionPanel cp = new ConditionPanel(controller, null);
        cp.setParentPanel(parent);
        return cp;
    }

    private ActionPanel createEmptyActionPanel() {
        ActionPanel empty = new ActionPanel(controller, null);
        empty.setParentPanel(this);
        return empty;
    }

    public boolean isAddingToItself(ActionPanel ap) {

        ActionPanel receiver = this;
        IActionPanelListable receiverParent = this.getParentPanel();
        IActionPanelListable apParent = (IActionPanelListable) ap.getParentPanel();

        while (receiverParent != null && !(receiverParent instanceof EditPanel) && receiverParent != apParent) {
            receiver = (ActionPanel) receiverParent;
            receiverParent = (IActionPanelListable) receiver.getParentPanel();
        }

        if (apParent == null || receiverParent == null) 
            return false;

        if (receiverParent != apParent)
            return false;
            
        return getIndexInPane(receiver, head) <= getIndexInPane(ap, head);
        
    }
    public void addActionPanel(ActionPanel ap, ActionPanel previous) {
        if (ap.getParentPanel() == previous.getParentPanel() && getIndexInPane(ap, head) <= getIndexInPane(previous, head))
            return;

        if (isAddingToItself(ap))
            return;

        if (ap.getParentPanel() != null) 
            ap.getParentPanel().removeActionPanel(ap);

        if (previous.getInstruction() == null) { 
            actionPanelsPanel.remove(head);           
            head = ap;
            updateNext(ap, null);
        }
        else
            updateNext(ap, previous);

        addRecursively(ap, this, actionPanelsPanel);
        revalidate();
    }

    public void removeActionPanel(ActionPanel ap) {
        if (ap.getInstruction() == null)
            return;

        removeRecursively(ap, actionPanelsPanel);

        ActionPanel previous = getPrevious(ap, head);
        if (previous != null)
            previous.next = null;
        else {
            head = createEmptyActionPanel();
            actionPanelsPanel.add(head);
        }
        revalidate();
    }

    public String getListType() {
        return "flowControlStatementList";
    }

	public Instruction toInstruction() {
        ControlFlowStatement cfs = (ControlFlowStatement) instruction;

        Condition condition = (Condition) conditionPanel.toInstruction();
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
