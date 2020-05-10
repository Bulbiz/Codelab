package src.view.language;

import java.awt.Dimension;
import java.util.Queue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import src.controller.ControllerLanguage;
import src.model.language.Action;
import src.model.language.IfElse;
import src.model.language.Instruction;

public class IfElsePanel extends ControlFlowStatementPanel {

    protected ActionPanel elseHead;
    protected JLabel elseLabel;

    public IfElsePanel(ControllerLanguage controller, IfElse cfs) {
        super(controller, cfs);

        height = 96;
        conditionLabel.setText("If");

        elseLabel = new JLabel("Else");
        elseLabel.setBounds(0, 64, labelWidth, 32);
        add(elseLabel);

        elseHead = createEmptyActionPanel();
        elseHead.removeMouseListener(controller);
        elseHead.removeMouseMotionListener(controller);

        elseHead.next = createEmptyActionPanel();
        add(elseHead.next);       
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

        cur = elseHead;
        while (cur != null) {
            if (cur == ap)
                return elseHead;
            cur = cur.next;
        }
        
        return null;
    }

    public void changeHeadNext(ActionPanel h, ActionPanel newHead) {

        ActionPanel selectedHead = h == head ? head : elseHead ;
        remove(selectedHead.next);
        selectedHead.next = newHead;
        add(newHead);
    }

    public Instruction toInstruction() {
        IfElse cfs = (IfElse)super.toInstruction();
        
        Queue<Action> q = convertActionsToInstructions(cfs, elseHead);
        if (q == null)
            return null;
        cfs.setElseActions(q);

        return cfs;
	}

    public void setPosition(int x, int y, int w) {
        setPosConditionAndActions(x, y, w);        

        ActionPanel cur = elseHead.next;
        elseLabel.setBounds(0, height, labelWidth, 32);
        while (cur != null) {
            cur.setPosition(labelWidth, height, w - labelWidth);
            height += cur.getHeight();
            cur = cur.next;
        }

        superSetPosition(x, y, w);
    }

    public void highlight() {
        ActionPanel cur = elseHead.next;
        while (cur != null) {
            cur.highlight();
            cur = cur.next;
        }
        super.highlight();
    }

    public void dehighlight() {
        ActionPanel cur = elseHead.next;
        while (cur != null) {
            cur.dehighlight();
            cur = cur.next;
        }
        super.dehighlight();
    }


}