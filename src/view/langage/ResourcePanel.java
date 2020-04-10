
package src.view.langage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;
import java.awt.Color;

import src.controller.ControllerLanguage;

import java.awt.Dimension;
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
        setPreferredSize(new Dimension(200, 600));

        setBorder(new TitledBorder(new LineBorder(Color.blue), "Instructions"));

        add(new DeletePanel(controller));
        add(Box.createVerticalGlue());
    }

    /**
     * 
     */
    private ArrayList<InstructionPanelGenerator> generators;

    /**
     * 
     */
    private EditPanel editPanel;

    public void addGenerator(InstructionPanelGenerator g) {
        add(g);
        add(Box.createVerticalGlue());
    }



}
