
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;
import src.model.world.Personage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Queue;

public class LanguageView extends JLayeredPane {

    ControllerLanguage controller;
    Personage player;

    EditPanel editPanel;
    ResourcePanel resourcePanel;

    Queue<Action> instructionQueue = new LinkedList<Action>();

    public LanguageView(ControllerLanguage controller, Personage player) {
        this.controller = controller;
        this.player = player;

        editPanel = new EditPanel(controller);
        resourcePanel = new ResourcePanel(controller);

        add(editPanel, JLayeredPane.DEFAULT_LAYER);
        editPanel.setBounds(0, 0, EditPanel.width, EditPanel.height);

        add(resourcePanel, JLayeredPane.DEFAULT_LAYER);
        resourcePanel.setBounds(300, 0, ResourcePanel.width, ResourcePanel.height);

        setPreferredSize(new Dimension(500, 800));

        resourcePanel.loadLevel(0);
    }

    public ResourcePanel getResourcePanel() {
        return resourcePanel;
    }
    
    public void setPlayer (Personage p){
      this.player = p;
    }
    
    public Queue<Action> getInstructionQueue() {
        return instructionQueue;
    }

    public void fillInstructionQueue() {
        instructionQueue.clear();

        ActionPanel cur = editPanel.head;
        boolean wentOk = true;
        while (cur != null) {
            Instruction instruction = cur.toInstruction();            
            if (instruction == null) {
                wentOk = false;
                break;
            }
            instruction.setPersonage(player);
            instructionQueue.add((Action)instruction);
            cur = cur.next;
        }
        if (!wentOk)
            instructionQueue.clear();
    }

    public void updateEditPanelPlacement() {
        editPanel.updatePlacement();
    }

    public void mousePressed(IMouseReactive source, int mousex, int mousey) {
        InstructionPanel pressedPanelSource = source.getSourcePanel();
        if (pressedPanelSource instanceof BeginPanel)
            return;

        controller.setSource(pressedPanelSource);        

        if (pressedPanelSource.getParentPanel() != null) {       
            InstructionPanel previous = pressedPanelSource.getParentPanel().removePanel(pressedPanelSource);
            controller.setSourcePrevious(previous);
            pressedPanelSource.getParentPanel().setToDragAndDropLayer(pressedPanelSource, this);  
        }
        else {
            setLayer(pressedPanelSource, JLayeredPane.DRAG_LAYER);
            add(pressedPanelSource);
        }

        pressedPanelSource.setPosition(mousex, mousey + 24);
        revalidate();
    }
    
    public void mouseDrag(InstructionPanel source, int mousex, int mousey) {
        
        source.setPosition(mousex, mousey + 24);
        revalidate();
    }
    
    public void loadResourcePanel(int idLevel) {
        resourcePanel.loadLevel(idLevel);
    }
    
}