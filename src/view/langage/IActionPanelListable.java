
package src.view.langage;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Point;

public interface IActionPanelListable extends IParent {

    void addActionPanel(ActionPanel ap, ActionPanel previous);
    InstructionPanel removeActionPanel(ActionPanel ap);
    
    default void updateNext(ActionPanel ap, ActionPanel previous) {
        ActionPanel last = getLast(ap);

        if (previous != null) {
            last.next = previous.next;        
            previous.next = ap;
        }
        else 
            last.next = null;
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
    ActionPanel getHead(ActionPanel ap);

    String getListType();

    default void setToDragAndDropLayer(InstructionPanel ip, JLayeredPane layeredPanel) {

        layeredPanel.setLayer(ip, JLayeredPane.DRAG_LAYER); 
        ip.highlight();
        layeredPanel.add(ip);
    }
    default void setToDefaultLayer(InstructionPanel ip, JLayeredPane layeredPanel) {
        layeredPanel.setLayer(ip, JLayeredPane.DEFAULT_LAYER);
        ip.dehighlight();
    }

    default InstructionPanel removePanel(InstructionPanel ip) {
        return removeActionPanel((ActionPanel) ip);
    }
}