
package src.view.langage;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import src.controller.ControllerLanguage;

import java.util.*;

/**
 * 
 */
public class ResourcePanel extends JPanel {

    /**
     * Default constructor
     */
    public ResourcePanel(ControllerLanguage controller) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new DeletePanel(controller));
    }

    /**
     * 
     */
    private ArrayList<InstructionPanelGenerator> generators;

    /**
     * 
     */
    private EditPanel editPanel;





}
