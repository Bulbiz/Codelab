
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;
import src.model.world.Personage;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Queue;

public class LanguageView extends JLayeredPane {

    public static final int width = 500 + 32;
    public static final int height = 500;

    ControllerLanguage controller;
    Personage player;

    JScrollPane editScroll;
    EditPanel editPanel;
    JScrollPane resourceScroll;
    ResourcePanel resourcePanel;

    Queue<Action> instructionQueue = new LinkedList<Action>();

    public LanguageView(ControllerLanguage controller, Personage player) {
        this.controller = controller;
        this.player = player;

        setLayout(null);
        
        editPanel = new EditPanel(controller);
        resourcePanel = new ResourcePanel(controller);        
        
        editScroll = new JScrollPane(editPanel);
        editScroll.getVerticalScrollBar().setUnitIncrement(12);
        int margeright = 24;
        editPanel.setPreferredSize(new Dimension(EditPanel.width, EditPanel.height));
        editScroll.setViewportBorder(null);
        editScroll.setBounds(0, 0, EditPanel.width + margeright, height);
        editScroll.setBorder(new TitledBorder(new LineBorder(Color.blue), "Your Code"));
        add(editScroll, JLayeredPane.DEFAULT_LAYER);
                
        
        resourceScroll = new JScrollPane(resourcePanel);
        resourceScroll.getVerticalScrollBar().setUnitIncrement(12);
        resourcePanel.setPreferredSize(new Dimension(ResourcePanel.width, ResourcePanel.height));
        resourceScroll.setViewportBorder(null);
        resourceScroll.setBounds(EditPanel.width + margeright, 0, ResourcePanel.width, height);
        resourceScroll.setBorder(new TitledBorder(new LineBorder(Color.blue), "Instructions"));
        add(resourceScroll, JLayeredPane.DEFAULT_LAYER);             

        setPreferredSize(new Dimension(width, height));
        setBounds(0, 0, width, height);

        resourcePanel.loadLevel(100);
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

    public void mousePressed(IMouseReactive source, int mousex, int mousey) {
        InstructionPanel pressedPanelSource = source.getSourcePanel();
        if (pressedPanelSource == null || pressedPanelSource instanceof BeginPanel) {
            controller.setSource(null);
            return;
        }

        controller.setSource(pressedPanelSource);        

        if (pressedPanelSource.getParentPanel() != null) {       
            InstructionPanel previous = pressedPanelSource.getParentPanel().removePanel(pressedPanelSource);
            controller.setSourcePrevious(previous);
            pressedPanelSource.getParentPanel().setToDragAndDropLayer(pressedPanelSource, this);  
        }
        else {
            setLayer(pressedPanelSource, JLayeredPane.DRAG_LAYER);
            pressedPanelSource.highlight();
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