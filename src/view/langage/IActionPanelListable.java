
package src.view.langage;

import javax.swing.JPanel;

interface IActionPanelListable {

    void addActionPanel(ActionPanel ap, ActionPanel previous);
    default void addRecursively(ActionPanel ap, ControlFlowStatementPanel parent, JPanel panel) {
        ActionPanel cur = ap;
        while (cur != null) {
            panel.add(cur);
            cur.setParentPanel(parent);
            cur = cur.next;
        }
    }
    void removeActionPanel(ActionPanel ap);
    default void removeRecursively(ActionPanel ap, JPanel panel) {
        ActionPanel cur = ap;
        while (cur != null) {
            panel.remove(cur);
            cur.setParentPanel(null);
            cur = cur.next;
        }
    }
    default void updateNext(ActionPanel ap, ActionPanel previous) {
        ActionPanel last = getLast(ap);

        if (previous != null) {
            last.next = previous.next;        
            previous.next = ap;
        }
        else 
            last.next = null;
    }
    default int getIndexInPane(ActionPanel ap, ActionPanel head) {
        ActionPanel cur = head;
        int index = 0;
        while (cur != null && cur != ap) {
            index ++;
            cur = cur.next;            
        }

        return cur == null ? -1 : index;
    }
    default ActionPanel getLast(ActionPanel ap) {
        ActionPanel last = ap;
        while (last.next != null)
            last = last.next;
        return last;
    }
    default ActionPanel getPrevious(ActionPanel ap, ActionPanel head) {
        ActionPanel cur = head;
        while (cur != null && cur.next != ap)
            cur = cur.next;
        
        return cur;
    }

}