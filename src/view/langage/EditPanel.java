
package src.view.langage;
import src.model.langage.*;

import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * 
 */
public class EditPanel extends JPanel {

    /**
     * Default constructor
     */
    public EditPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    /**
     * 
     */
    protected ArrayList<InstructionPanel> instructionPanels = new ArrayList<InstructionPanel>();


    /**
     * 
     */
    public void addActionPanel(ActionPanel ap) {
        add(ap);
        instructionPanels.add(ap);
    }

    /**
     * 
     */
    public void removeInstructionPanel() {
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
