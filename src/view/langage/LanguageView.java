
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;
import src.model.world.Personage;
import javax.swing.JPanel;
import java.util.LinkedList;
import java.util.Queue;

public class LanguageView extends JPanel {

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

        add(editPanel);
        add(resourcePanel);

        TestLanguageView.testInstructionPanelGeneratorClick(this, controller);
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

    public void mousePressed(IMouseReactive source) {
        InstructionPanel pressedPanelSource = source.getSourcePanel();
        controller.setSource(pressedPanelSource);
        if (pressedPanelSource != null)
            pressedPanelSource.highlight();
    }

    public void mouseReleased(InstructionPanel source, IMouseReactive dest) {
        if (dest == null || source == null)
            return;
        
        dest.onRelease(source);
    }

    public void mouseReleasedOverDeletePanel(InstructionPanel source) {
        if (source == null)
            return;

        source.delete();
    }
    
    
}