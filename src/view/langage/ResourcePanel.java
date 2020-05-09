
package src.view.langage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.border.*;
import java.awt.Color;
import src.controller.ControllerLanguage;
import src.model.langage.*;

import java.awt.Dimension;
import java.awt.Point;
import java.util.*;

/**
 * Panel containing the delete button and all the InstructionPanelGenerators
 */
public class ResourcePanel extends JPanel{

    ArrayList<InstructionPanelGenerator> generators;

    public static final int margeright = 32;
    public static final int width = 200;
    public static final int height = 600;

    ControllerLanguage controller;

    public ResourcePanel(ControllerLanguage controller) {
        this.controller = controller;

        setLayout(null);        

        add(new DeletePanel(controller));

        generators = new ArrayList<InstructionPanelGenerator>();
    }

    public void addGenerator(InstructionPanelGenerator g) {        
        int margey = 128;
        for (InstructionPanelGenerator ipg : generators)
            margey += ipg.getHeight() + 8;
        g.setBounds(0, margey, InstructionPanelGenerator.standardWidth, g.getHeight());

        if (margey + g.getHeight() > this.getHeight())
            this.setPreferredSize(new Dimension(this.getWidth(), margey + g.getHeight()));

        add(g);
        generators.add(g);
    }
    
    public void loadLevel(int idLevel) {
        this.removeAll();
        generators.clear();
        add(new DeletePanel(controller));
        add(Box.createVerticalGlue());
        
        pattern.loadBasicActions(controller);
        if (idLevel >= 3) pattern.loadWhileAndFirstCondition(controller);
        if (idLevel >= 4) pattern.loadIfAndManyCondition(controller);
        if (idLevel >= 6) pattern.loadIfElse(controller);
        if (idLevel >= 7) pattern.loadAll(controller);
    }

    private ResourcePanelPattern pattern = new ResourcePanelPattern();

    public class ResourcePanelPattern {   

        public void loadBasicActions(ControllerLanguage controller) {
            ResourcePanel rp = ResourcePanel.this;

            InstructionPanelGenerator move = new InstructionPanelGenerator(new ActionPanel(controller, new Move(null)));
            InstructionPanelGenerator turnleft = new InstructionPanelGenerator(new ActionPanel(controller, new TurnLeft(null)));
            InstructionPanelGenerator turnright = new InstructionPanelGenerator(new ActionPanel(controller, new TurnRight(null)));

            rp.addGenerator(move);
            rp.addGenerator(turnleft);
            rp.addGenerator(turnright);
        }

        public void loadWhileAndFirstCondition(ControllerLanguage controller) {
            ResourcePanel rp = ResourcePanel.this;

            InstructionPanelGenerator w = new InstructionPanelGenerator(new ControlFlowStatementPanel(controller, new While(null)));
            InstructionPanelGenerator notonchest = new InstructionPanelGenerator(new ConditionPanel(controller, new NotOnChest(null)));
            rp.addGenerator(w);
            rp.addGenerator(notonchest);
        }

        public void loadIfAndManyCondition(ControllerLanguage controller) {
            ResourcePanel rp = ResourcePanel.this;

            InstructionPanelGenerator i = new InstructionPanelGenerator(new ControlFlowStatementPanel(controller, new If(null)));
            InstructionPanelGenerator not = new InstructionPanelGenerator(new NotPanel(controller, new Not(null)));
            InstructionPanelGenerator obstacleleft = new InstructionPanelGenerator(new ConditionPanel(controller, new ObstacleLeft(null)));
            InstructionPanelGenerator obstacleright = new InstructionPanelGenerator(new ConditionPanel(controller, new ObstacleRight(null)));
            InstructionPanelGenerator obstaclefront = new InstructionPanelGenerator(new ConditionPanel(controller, new ObstacleFront(null)));
            rp.addGenerator(i);
            rp.addGenerator(not);
            rp.addGenerator(obstacleleft);
            rp.addGenerator(obstacleright);
            rp.addGenerator(obstaclefront);
        }

        public void loadIfElse(ControllerLanguage controller) {
            ResourcePanel rp = ResourcePanel.this;

            InstructionPanelGenerator ifElse = new InstructionPanelGenerator(new IfElsePanel(controller, new IfElse(null)));
            rp.addGenerator(ifElse);
        }

        public void loadAll(ControllerLanguage controller) {
            ResourcePanel rp = ResourcePanel.this;

            InstructionPanelGenerator coinfront = new InstructionPanelGenerator(new ConditionPanel(controller, new CoinFront(null)));
            rp.addGenerator(coinfront);
        }
    }
}
