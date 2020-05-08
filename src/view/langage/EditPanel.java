
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel containing the user's InstructionPanel
 * of his code
 */
public class EditPanel extends JPanel implements IActionPanelListable {

    protected ActionPanel head;
    protected ControllerLanguage controller;

    public EditPanel(ControllerLanguage controller) {
        this.controller = controller;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 600));
        setBorder(new TitledBorder(new LineBorder(Color.blue), "Your Code"));

        head = new BeginPanel( controller, new Begin(null) );
        head.setParentPanel(this);
        add(head);
    }   

    public void addActionPanel(ActionPanel ap, ActionPanel previous) {
        if (!ap.canAdd(previous))
            return;

        if (ap.getParentPanel() != null) 
            ap.getParentPanel().removeActionPanel(ap);

        updateNext(ap, previous);
        addRecursively(ap, this, this);
    }

    public void removeActionPanel(ActionPanel ap) {
        if (ap.getInstruction() == null)
            return;

        ActionPanel previous = getPrevious(ap, head);
        if (previous != null)
            previous.next = null;

        removeRecursively(ap, this);
    }

    public String getListType() {
        return "editPanelList";
    }

    public ActionPanel getHead(ActionPanel ap) {
        return head;
    }

}
