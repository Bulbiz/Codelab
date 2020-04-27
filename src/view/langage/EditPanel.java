
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;

import java.awt.Color;
import java.awt.Dimension;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * 
 */
public class EditPanel extends JPanel implements IActionPanelListable {

    /**
     * 
     */
    protected ActionPanel head;
    protected ControllerLanguage controller;

    /**
     * Default constructor
     */
    public EditPanel(ControllerLanguage controller) {
        this.controller = controller;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 600));
        setBorder(new TitledBorder(new LineBorder(Color.blue), "Votre Code"));

        head = new BeginPanel( controller, new Begin(null) );
        head.setParentPanel(this);
        add(head);
    }   


    /**
     * 
     */
    public void addActionPanel(ActionPanel ap, ActionPanel previous) {
        // TODO merge with ControlFlowStatementPanel's version
        if (IActionPanelListable.cantAdd(ap, previous))
            return;

        if (ap.getParentPanel() != null) 
            ap.getParentPanel().removeActionPanel(ap);

        updateNext(ap, previous);
        addRecursively(ap, this, this);
    }

    /**
     * 
     */
    public void removeActionPanel(ActionPanel ap) {
        // TODO merge with ControlFlowStatementPanel's version
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

    public ActionPanel getHead() {
        return head;
    }

    /**
     * @return
     */
    public ArrayList<Instruction> convertToInstructions() {
        // TODO implement here
        return null;
    }

}
