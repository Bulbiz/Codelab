package src.view.langage;

import java.awt.Dimension;
import java.util.Queue;

import javax.swing.JPanel;

import src.controller.ControllerLanguage;
import src.model.langage.Action;
import src.model.langage.IfElse;
import src.model.langage.Instruction;

public class IfElsePanel extends ControlFlowStatementPanel {

    protected ActionPanel elseHead;

    JPanel elsePanel;

    public IfElsePanel(ControllerLanguage controller, IfElse cfs) {
        super(controller, cfs);

        elsePanel = new JPanel();
        initElsePanel();

        setMinimumSize(new Dimension(300, 96));
        setMaximumSize(new Dimension(300, 96));

    }

    private void initElsePanel() {        
        elseHead = initActionPanelsPanel(elsePanel);
        linkLabelAndPanel("else", elsePanel);
        elsePanel.setMaximumSize(new Dimension(300, 32));
    }

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {        
        return new IfElsePanel(controller, (IfElse)instruction);
    }

    public ActionPanel getHead(ActionPanel ap) {
        ActionPanel cur = head;
        while (cur != null) {
            if (cur == ap)
                return head;
            cur = cur.next;
        }
        
        return elseHead;
    }

    public ActionPanel changeHead(ActionPanel h, ActionPanel newHead) {
        if (h == head)
            head = newHead;        
        else 
            elseHead = newHead;
        
        return newHead;
    }

    public JPanel getReceivingPanel(ActionPanel h) {
        if (head == h)
            return actionPanelsPanel;
        
        return elsePanel; 
    }

    protected void updatePanelsSize() {
        updateActionPanelsPanelSize(head);
        updateActionPanelsPanelSize(elseHead);
    }

    public boolean canAdd(ActionPanel ap) {
        if (elseHead != null && !elseHead.canAdd(ap))
            return false;

        return super.canAdd(ap);
    }

    protected int calculateHeight() {
        int h = 0;
        h += super.calculateHeight();
        h += elsePanel.getMaximumSize().getHeight();

        return h;
    }

    public Instruction toInstruction() {
        IfElse cfs = (IfElse)super.toInstruction();
        
        Queue<Action> q = convertActionsToInstructions(cfs, elseHead);
        if (q == null)
            return null;
        cfs.addElseActions(q);

        return cfs;
	}

    public void highlight() {
        super.highlight();
        JPanel elsePanel = (JPanel) this.getComponent(2);
        elsePanel.setBackground(highlightColor);
    }

    public void dehighlight() {
        super.dehighlight();
        JPanel elsePanel = (JPanel) this.getComponent(2);
        elsePanel.setBackground(normalColor);
    }

}