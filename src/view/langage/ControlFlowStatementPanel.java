
package src.view.langage;

import src.controller.ControllerLanguage;
import src.controller.ControllerLevel;
import src.model.langage.*;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;



public class ControlFlowStatementPanel extends ActionPanel implements IActionPanelListable, IConditionPanelAdjustable {

    protected ActionPanel head;

    protected ConditionPanel conditionPanel;

    protected JLabel conditionLabel;
    protected JLabel actionsLabel;
    protected int labelWidth = 32;

    public ControlFlowStatementPanel(ControllerLanguage controller, ControlFlowStatement cfs) {
        super(controller);
        instruction = InstructionFactory.createInstruction(cfs);

        normalColor = new Color(Color.GREEN.getRed() + 40, Color.GREEN.getGreen() - 40, Color.GREEN.getBlue() + 40);
        highlightColor = Color.GREEN;
        
        conditionPanel = createEmptyConditionPanel(this, controller);
        add(conditionPanel);
        
        head = createEmptyActionPanel();
        head.removeMouseListener(controller);
        head.removeMouseMotionListener(controller);

        head.next = createEmptyActionPanel();
        add(head.next);        
        
        height = 64;
        if (!cfs.getVersion().equals("if")) 
            labelWidth = 48;
        conditionLabel = new JLabel(instruction.toString());
        conditionLabel.setBounds(0, 0, labelWidth, 32);
        actionsLabel = new JLabel("Do");
        actionsLabel.setBounds(0, 32, labelWidth, 32);
        add(conditionLabel);
        add(actionsLabel);

        setLayout(null);
        setBackground(normalColor);
    }    

    public ControlFlowStatementPanel(ControllerLanguage controller, ControlFlowStatement cfs, int i) {
        super(controller);
        instruction = InstructionFactory.createInstruction(cfs);

        normalColor = Color.green.darker();
    }  

    protected void setPosConditionAndActions(int x, int y, int w) {
        conditionPanel.setPosition(labelWidth, 0, w - labelWidth);

        ActionPanel cur = head.next;
        height = 32;
        while (cur != null) {
            cur.setPosition(labelWidth, height, w - labelWidth);
            height += cur.getHeight();
            cur = cur.next;
        }
    }
    public void setPosition(int x, int y, int w) { 
        setPosConditionAndActions(x, y, w);
        super.setPosition(x, y, w);
    }

    protected void superSetPosition(int x, int y, int w) {
        super.setPosition(x, y, w);
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

    protected ActionPanel createEmptyActionPanel() {
        ActionPanel empty = new ActionPanel(controller, null);
        empty.setParentPanel(this);
        return empty;
    }

    public ActionPanel getPrevious(ActionPanel ap, ActionPanel head) {
        return IActionPanelListable.super.getPrevious(ap, head.next);
    }

    public void addActionPanel(ActionPanel ap, ActionPanel previous) {
        
        ActionPanel toReplace = previous == getHead(previous) ? previous.next : previous;
        if (toReplace.getInstruction() == null)
            changeHeadNext(getHead(previous), ap);
        else {
            ap.next = previous.next;
            previous.next = ap;
        }

        add(ap);
        ap.setParentPanel(this);
        ap.setWidth(width - labelWidth);

        findEditPanel().updatePlacement();

        validate();
    }

    public InstructionPanel removeActionPanel(ActionPanel ap) {

        ActionPanel h = getHead(ap);
        ActionPanel previous = getPrevious(ap, h);
        if (previous != null)
            previous.next = ap.next;
        else {
            previous = h;
            if (ap.next != null)
                changeHeadNext(h, ap.next);
            else 
                changeHeadNext(h, createEmptyActionPanel());
        }

        ap.next = null;
        remove(ap);
        
        findEditPanel().updatePlacement();
        
        return previous;
    }

    public String getListType() {
        return "flowControlStatementList";
    }

    public ActionPanel getHead(ActionPanel ap) {
        return head;
    }

    public void changeHeadNext(ActionPanel h, ActionPanel newHead) {
        remove(head.next);
        head.next = newHead;
        add(newHead);
    }

    protected boolean convertConditionToInstruction(ControlFlowStatement cfs) {
        Condition condition = (Condition) conditionPanel.toInstruction();

        if (condition == null) {
            ControllerLevel.errorPopUp("A condition is missing in your code");
            return false;
        }

        cfs.setCondition(condition);
        return true;
    }
    protected Queue<Action> convertActionsToInstructions(ControlFlowStatement cfs, ActionPanel h) {
        Queue<Action> q = new LinkedList<Action>();

        ActionPanel cur = h.next;
        while (cur != null) {
            Action a = (Action)cur.toInstruction();
            if (a == null) {
                ControllerLevel.errorPopUp("An action is missing in your code");
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
        cfs.setActions(q);

        return cfs;
	}

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
        return new ControlFlowStatementPanel(controller, (ControlFlowStatement)instruction);
    }

    @Override
    public void setToDragAndDropLayer(InstructionPanel ip, JLayeredPane layeredPanel) {
        if (ip == conditionPanel)
            IConditionPanelAdjustable.super.setToDragAndDropLayer(ip, layeredPanel);
        else 
            IActionPanelListable.super.setToDragAndDropLayer(ip, layeredPanel);
    }

    @Override
    public void setToDefaultLayer(InstructionPanel ip, JLayeredPane layeredPanel) {
        if (ip instanceof ConditionPanel)
            IConditionPanelAdjustable.super.setToDefaultLayer(ip, layeredPanel);
        else
            IActionPanelListable.super.setToDefaultLayer(ip, layeredPanel);
    }

    public InstructionPanel removePanel(InstructionPanel ip) {
        if (ip instanceof ConditionPanel)
            return IConditionPanelAdjustable.super.removePanel(ip);
        else
            return IActionPanelListable.super.removePanel(ip);
    }

    public void highlight() {
        conditionPanel.highlight();
        ActionPanel cur = head.next;
        while (cur != null) {
            cur.highlight();
            cur = cur.next;
        }
        super.highlight();
    }

    public void dehighlight() {
        conditionPanel.dehighlight();
        ActionPanel cur = head.next;
        while (cur != null) {
            cur.dehighlight();
            cur = cur.next;
        }
        super.dehighlight();
    }

}
