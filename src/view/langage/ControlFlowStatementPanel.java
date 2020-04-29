
package src.view.langage;

import src.controller.ControllerLanguage;
import src.controller.ControllerLevel;
import src.model.langage.*;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;



public class ControlFlowStatementPanel extends ActionPanel implements IActionPanelListable, IConditionPanelAdjustable {

    ActionPanel head;

    private JPanel actionPanelsPanel;

    private ConditionPanel conditionPanel;
    private JPanel conditionPanelPanel;

    public ControlFlowStatementPanel(ControllerLanguage controller, ControlFlowStatement cfs) {
        super(controller);
        instruction = InstructionFactory.createInstruction(cfs);

        normalColor = Color.green.darker();
        highlightColor = Color.green;
        
        initPanel();
        
        actionPanelsPanel.setMaximumSize(new Dimension(300, 32));
        setMinimumSize(new Dimension(300, 64));
        setMaximumSize(new Dimension(300, 64));
        actionPanelsPanel.setBackground(Color.GREEN);
    }    

    private void initConditionPanelPanel() {
        conditionPanel = ControlFlowStatementPanel.createEmptyConditionPanel(this, controller);
        conditionPanelPanel = new JPanel();        
        conditionPanelPanel.setLayout(new BoxLayout(conditionPanelPanel, BoxLayout.Y_AXIS));
        conditionPanelPanel.add(conditionPanel);
    }
    private void initActionPanelsPanel() {
        ActionPanel ap = new ActionPanel(controller, null);
        ap.setParentPanel(this);
        head = ap;
        actionPanelsPanel = new JPanel();
        actionPanelsPanel.setLayout(new BoxLayout(actionPanelsPanel, BoxLayout.Y_AXIS));
        actionPanelsPanel.add(ap);
    }
    private void initUpPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel up = new JPanel();
        up.setLayout(new BoxLayout(up, BoxLayout.LINE_AXIS));
        JLabel l1 = new JLabel(instruction.getVersion());
        up.add(l1);
        up.add(conditionPanelPanel);
        up.setBackground(Color.GREEN);
        add(up);
    }
    private void initDownPanel() {
        JPanel down = new JPanel();
        down.setLayout(new BoxLayout(down, BoxLayout.LINE_AXIS));
        JLabel l2 = new JLabel("do");
        down.add(l2);
        down.add(actionPanelsPanel);
        down.setBackground(Color.GREEN);
        add(down);
    }
    private void initPanel() {
        initConditionPanelPanel();
        initActionPanelsPanel();

        initUpPanel();
        initDownPanel();
    }
    
    public void changeConditionPanel(ConditionPanel cp) {
        changeConditionPanel(cp, conditionPanelPanel, controller);
        updateSize();
        validate();
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

    public void addActionPanel(ActionPanel ap, ActionPanel previous) {
        if (IActionPanelListable.cantAdd(ap, previous))
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
        updateSize();
        validate();
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
        updateSize();
        validate();
    }

    public String getListType() {
        return "flowControlStatementList";
    }

    public ActionPanel getHead() {
        return head;
    }

    private boolean convertConditionToInstruction(ControlFlowStatement cfs) {
        Condition condition = (Condition) conditionPanel.toInstruction();
        
        if (condition == null) {
            ControllerLevel.errorPopUp("Il manque une condition");
            return false;
        }

        cfs.setCondition(condition);
        return true;
    }
    private boolean convertActionsToInstructions(ControlFlowStatement cfs) {
        ActionPanel cur = head;
        while (cur != null) {
            Action a = (Action)cur.toInstruction();
            if (a == null) {
                ControllerLevel.errorPopUp("Il manque une action");
                return false;
            }
            cfs.addAction(a);
            cur = cur.next;
        }

        return true;
    }
	public Instruction toInstruction() {
        ControlFlowStatement cfs = (ControlFlowStatement) instruction;

        if (!convertConditionToInstruction(cfs))
            return null;

        if (!convertActionsToInstructions(cfs))
            return null;

        return instruction;
	}

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
        return new ControlFlowStatementPanel(controller, (ControlFlowStatement)instruction);
    }

    public void highlight() {
        JPanel up = (JPanel) this.getComponent(0);
        up.setBackground(highlightColor);
        JPanel down = (JPanel) this.getComponent(1);
        down.setBackground(highlightColor);
        if (next != null)
            next.highlight();
    }

    public void dehighlight() {
        JPanel up = (JPanel) this.getComponent(0);
        up.setBackground(normalColor);
        JPanel down = (JPanel) this.getComponent(1);
        down.setBackground(normalColor);
        if (next != null)
            next.dehighlight();
    }

    private void updateActionPanelsPanelSize() {
        int aph = 0;
        ActionPanel ap = head;
        while (ap != null) {            
            aph += ap.getMaximumSize().height;
            ap = ap.next;
        }
        actionPanelsPanel.setMaximumSize(new Dimension(300, aph));
    }
    public void updateSize() {        
        updateActionPanelsPanelSize();

        int w = 300;
        int h = 0;
        h += conditionPanel.getMaximumSize().getHeight();
        h += actionPanelsPanel.getMaximumSize().getHeight();
        setMaximumSize(new Dimension(w, h));        

        if (parent instanceof ControlFlowStatementPanel) {
            ControlFlowStatementPanel p = (ControlFlowStatementPanel) parent;
            p.updateSize();
        }
    }
}
