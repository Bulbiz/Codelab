
package src.view.langage;

import javax.swing.JPanel;

import src.controller.ControllerLanguage;
import src.model.langage.*;
import src.model.world.Personage;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

public class LanguageView extends JPanel {

    ControllerLanguage controller;
    Personage player;
    
    EditPanel editPanel;
    ResourcePanel resourcePanel;

    Queue<Action> instructionQueue = new LinkedList<Action>();

    JPanel movableObject;

    public LanguageView(ControllerLanguage controller, Personage player) {
        this.controller = controller;
        this.player = player;

        editPanel = new EditPanel();
        resourcePanel = new ResourcePanel();

        add(editPanel);
        add(resourcePanel);

        editPanel.addActionPanel(new ActionPanel(controller, new Move(null)));
        TestLanguageView.testInstructionPanelGeneratorClick(this, controller);
    }

    public void setMovableObject(JPanel o) {
        movableObject = o;
    }

    public Queue<Action> getInstructionQueue() {
        return instructionQueue;
    }

    public void fillInstructionQueue() {
        while(!instructionQueue.isEmpty())
            instructionQueue.poll();

        for (int i = editPanel.instructionPanels.size() - 1 ; i >= 0; i--) {
            InstructionPanel ip = editPanel.instructionPanels.get(i);
            Instruction instruction = ip.toInstruction();            
            if (instruction == null)
                return;
                instruction.setPersonage(player);
            instructionQueue.add((Action)instruction);
        }
    }

    public Queue<Instruction> toInstruction() {
        Queue<Instruction> q = new LinkedList<Instruction>();
        
        for (int i = editPanel.instructionPanels.size()- 1 ; i >= 0; i++) {
            InstructionPanel ip = editPanel.instructionPanels.get(i);
            Instruction instruction = ip.toInstruction();
            if (instruction == null)
                return null;
            q.add(instruction);
        }

        return q;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (movableObject != null) {
            g.drawRect(movableObject.getX(), movableObject.getY(), 100, 100);
        }            
    }

    public void mousePressedGenerator(InstructionPanelGenerator generatorPanel) {
        System.out.println("click generateur");
        InstructionPanel createdPanel = generatorPanel.createInstructionPanel();
        controller.setSource(createdPanel);
        // display InstructionPanel
    }
    public void mousePressedInstructionPanel(InstructionPanel instructionPanel) {
        System.out.println("click instruction panel");
        controller.setSource(instructionPanel);
    }

    public void mouseReleasedOverInstructionPanel(InstructionPanel instructionPanel, InstructionPanel source) {
        System.out.println("mouse released over instruction panel");

        Instruction instruction = instructionPanel.getInstruction();        
        if (instruction == null) {
            System.out.println("instruction morte");
            if (instructionPanel instanceof ConditionPanel)
                mouseReleasedOverConditionPanel((ConditionPanel)instructionPanel, source);
            else 
                mouseReleasedOverActionPanel((ActionPanel)instructionPanel, source);
        }
        else {
            System.out.println("instruction existe");

            switch (instruction.getType()) {
                case "condition": mouseReleasedOverConditionPanel((ConditionPanel)instructionPanel, source); break;
                default: mouseReleasedOverActionPanel((ActionPanel)instructionPanel, source); break;
            }
        }
    }
    
    private void mouseReleasedOverConditionPanel(ConditionPanel conditionPanel, InstructionPanel source) {
        // change model
        System.out.println("over condition panel");
        if (source.getInstruction() == null)
            return;        
        if (!source.getInstruction().getType().equals("condition"))
            return;            

        if (conditionPanel.getParentPanel() != null)
            conditionPanel.getParentPanel().setConditionPanel((ConditionPanel)source);
    }

    private void mouseReleasedOverActionPanel(ActionPanel ap, InstructionPanel source) {
        System.out.println("over action panel");
        if (source == null || source.getInstruction() == null)
            return;
        if (source.getInstruction().getType().equals("condition"))
            return;
        

        if (ap.getParentPanel() == null)
            editPanel.addActionPanel((ActionPanel)source);
        else 
            ap.getParentPanel().addActionPanel((ActionPanel)source);
            
    }
}