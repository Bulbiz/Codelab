
package src.view.langage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import src.controller.ControllerLanguage;
import src.model.langage.*;
import src.model.world.*;
import src.view.world.LevelPanel;

public class TestLanguageView {
    public static void run() {

        try {

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setSize(800, 800);

                    UserCode model = new UserCode();

                    ControllerLanguage controller = new ControllerLanguage(model);

                    LanguageView view = new LanguageView(controller, null);
                    frame.setContentPane(view);
                    controller.setView(view);

                    testInstructionPanel(view, controller);
                    testInstructionPanelGeneratorClick(view, controller);
                    frame.revalidate();
                }
            });
        } catch (Exception e) {
        }

    }

    public static void testInstructionPanel(LanguageView view, ControllerLanguage controller) {
        
        ConditionPanel cp = new ConditionPanel(controller, new ObstableFront(null));
        ActionPanel ap = new ActionPanel(controller, new Move(null));
        
        ControlFlowStatementPanel ifp = new ControlFlowStatementPanel(controller, new While(null)); 
        view.editPanel.addActionPanel(ifp); 
        ifp.addActionPanel(ap);
        ifp.setConditionPanel(cp);
        
        
        
    }

    public static void testInstructionPanelGeneratorGenerating(LanguageView view, ControllerLanguage controller) {


        InstructionPanelGenerator ig1 = new InstructionPanelGenerator(new If(null), controller);
        InstructionPanelGenerator ig2 = new InstructionPanelGenerator(new Move(null), controller);
        InstructionPanelGenerator ig3 = new InstructionPanelGenerator(new ObstableFront(null), controller);

        view.resourcePanel.add(ig1.createInstructionPanel());
        view.resourcePanel.add(ig2.createInstructionPanel());
        view.resourcePanel.add(ig3.createInstructionPanel());
    }

    public static void testInstructionPanelGeneratorClick(LanguageView view, ControllerLanguage controller) {
        InstructionPanelGenerator ig1 = new InstructionPanelGenerator(new If(null), controller);
        InstructionPanelGenerator ig2 = new InstructionPanelGenerator(new While(null), controller);
        InstructionPanelGenerator ig3 = new InstructionPanelGenerator(new Move(null), controller);
        InstructionPanelGenerator ig4 = new InstructionPanelGenerator(new TurnLeft(null), controller);
        InstructionPanelGenerator ig5 = new InstructionPanelGenerator(new ObstableFront(null), controller);
        InstructionPanelGenerator ig6 = new InstructionPanelGenerator(new PersonageEstDevant(null), controller);

        view.resourcePanel.add(ig1);
        view.resourcePanel.add(ig2);
        view.resourcePanel.add(ig3);
        view.resourcePanel.add(ig4);
        view.resourcePanel.add(ig5);
        view.resourcePanel.add(ig6);
    }

}