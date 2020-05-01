
package src.view.langage;

import src.controller.ControllerLanguage;
import src.controller.ControllerLevel;
import src.model.langage.*;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Queue;



public class ControlFlowStatementPanel extends ActionPanel implements IActionPanelListable, IConditionPanelAdjustable {

    protected ActionPanel head;

    protected JPanel actionPanelsPanel;

    protected ConditionPanel conditionPanel;
    protected JPanel conditionPanelPanel;

    public ControlFlowStatementPanel(ControllerLanguage controller, ControlFlowStatement cfs) {
        super(controller);
        instruction = InstructionFactory.createInstruction(cfs);

        normalColor = Color.green.darker();
        highlightColor = Color.green;
        
        conditionPanelPanel = new JPanel();  
        actionPanelsPanel = new JPanel();
        initPanel();
        
        actionPanelsPanel.setMaximumSize(new Dimension(300, 32));
        setMinimumSize(new Dimension(300, 64));
        setMaximumSize(new Dimension(300, 64));
        actionPanelsPanel.setBackground(Color.GREEN);
    }    

    public ControlFlowStatementPanel(ControllerLanguage controller, ControlFlowStatement cfs, int i) {
        super(controller);
        instruction = InstructionFactory.createInstruction(cfs);

        normalColor = Color.green.darker();
        highlightColor = Color.green;

        System.out.println("constructeur 2");
    }

    private void initConditionPanelPanel() {
        conditionPanel = ControlFlowStatementPanel.createEmptyConditionPanel(this, controller);              
        conditionPanelPanel.setLayout(new BoxLayout(conditionPanelPanel, BoxLayout.Y_AXIS));
        conditionPanelPanel.add(conditionPanel);
    }
    protected ActionPanel initActionPanelsPanel(JPanel actionPanelsPanel) {
        ActionPanel ap = new ActionPanel(controller, null);
        ap.setParentPanel(this);    
        actionPanelsPanel.setLayout(new BoxLayout(actionPanelsPanel, BoxLayout.Y_AXIS));
        actionPanelsPanel.add(ap);

        return ap;
    }
    protected void linkLabelAndPanel(String labelTxt, JPanel panel) {
        JPanel link = new JPanel();

        link.setLayout(new BoxLayout(link, BoxLayout.LINE_AXIS));
        link.add(new JLabel(labelTxt));
        link.add(panel);
        link.setBackground(Color.GREEN);

        add(link);
    }
    private void initUpPanel() {  
        String txt = instruction instanceof If ? "if" : "while";
        linkLabelAndPanel(txt, conditionPanelPanel);
    }
    private void initDownPanel() {
        linkLabelAndPanel("do", actionPanelsPanel);
    }
    private void initPanel() {
        initConditionPanelPanel();
        head = initActionPanelsPanel(actionPanelsPanel);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
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

    public boolean canAdd(ActionPanel ap) {
        if (head != null && !head.canAdd(ap))
            return false;
            
        return super.canAdd(ap);
    }

    public void addActionPanel(ActionPanel ap, ActionPanel previous) {
        if (!ap.canAdd(previous))
            return;

        if (ap.getParentPanel() != null) 
            ap.getParentPanel().removeActionPanel(ap);

        JPanel receivingPanel = getReceivingPanel(getHead(previous));

        if (previous.getInstruction() == null) { 
            ActionPanel h = getHead(previous);
            receivingPanel.remove(h);            
            changeHead(h, ap);
            updateNext(ap, null);
        }
        else
            updateNext(ap, previous);

        addRecursively(ap, this, receivingPanel);
        updateSize();
        validate();
    }

    public void removeActionPanel(ActionPanel ap) {
        if (ap.getInstruction() == null)
            return;

        ActionPanel h = getHead(ap);
        JPanel receivingPanel = getReceivingPanel(h);
        
        removeRecursively(ap, receivingPanel);

        ActionPanel previous = getPrevious(ap, h);
        if (previous != null)
            previous.next = null;
        else {
            h = changeHead(h, createEmptyActionPanel());
            receivingPanel.add(h);
            System.out.println("wesh");
        }
        updateSize();
        validate();
    }

    public String getListType() {
        return "flowControlStatementList";
    }

    public ActionPanel getHead(ActionPanel ap) {
        return head;
    }

    public ActionPanel changeHead(ActionPanel h, ActionPanel newHead) {
        head = newHead;
        return head;
    }

    public JPanel getReceivingPanel(ActionPanel head) {
        return actionPanelsPanel;
    }

    protected boolean convertConditionToInstruction(ControlFlowStatement cfs) {
        Condition condition = (Condition) conditionPanel.toInstruction();
        
        if (condition == null) {
            ControllerLevel.errorPopUp("Il manque une condition");
            return false;
        }

        cfs.setCondition(condition);
        return true;
    }
    protected Queue<Action> convertActionsToInstructions(ControlFlowStatement cfs, ActionPanel h) {
        Queue<Action> q = new LinkedList<Action>();

        ActionPanel cur = h;
        while (cur != null) {
            Action a = (Action)cur.toInstruction();
            if (a == null) {
                ControllerLevel.errorPopUp("Il manque une action");
                return null;
            }
            q.add(a);

            cur = cur.next;
        }

        return q;
    }
	public Instruction toInstruction() {
        ControlFlowStatement cfs = (ControlFlowStatement) instruction;

        if (!convertConditionToInstruction(cfs))
            return null;

        Queue<Action> q = convertActionsToInstructions(cfs, head);
        if (q == null)
            return null;
        cfs.addActions(q);

        return cfs;
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

    protected void updateActionPanelsPanelSize(ActionPanel head) {
        int aph = 0;
        ActionPanel ap = head;
        while (ap != null) {            
            aph += ap.getMaximumSize().height;
            ap = ap.next;
        }
        
        JPanel receivingPanel = getReceivingPanel(head);
        receivingPanel.setMaximumSize(new Dimension(300, aph));
    }
    protected void updatePanelsSize() {
        updateActionPanelsPanelSize(head);
    }
    protected int calculateHeight() {
        int h = 0;
        h += conditionPanel.getMaximumSize().getHeight();
        h += actionPanelsPanel.getMaximumSize().getHeight();

        return h;
    }
    
    public void updateSize() {        
        updatePanelsSize();

        int w = 300;
        int h = calculateHeight();
        
        setMaximumSize(new Dimension(w, h));        

        if (parent instanceof ControlFlowStatementPanel) {
            ControlFlowStatementPanel p = (ControlFlowStatementPanel) parent;
            p.updateSize();
        }
    }
}
