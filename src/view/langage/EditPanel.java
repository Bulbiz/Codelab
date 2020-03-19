
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;

import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

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

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        head = new ActionPanel( controller, new Move(null) );
        add(head);
    }   


    /**
     * 
     */
    public void addActionPanel(ActionPanel ap, ActionPanel previous) {
        updateNext(ap, previous);
        addRecursively(ap, null, this);
    }

    /**
     * 
     */
    public void removeActionPanel(ActionPanel ap) {
        if (ap == head)
            return;
        // TODO implement here
    }

    /**
     * @return
     */
    public ArrayList<Instruction> convertToInstructions() {
        // TODO implement here
        return null;
    }

}
