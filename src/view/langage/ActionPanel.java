
package src.view.langage;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;

import src.controller.ControllerLanguage;
import src.model.langage.*;

/**
 * 
 */
public class ActionPanel extends InstructionPanel {

    protected ActionPanel next;

    /**
     * Default constructor
     */
    public ActionPanel(ControllerLanguage controller, Action action) {
      super(controller);
      if (action != null) {
          instruction = InstructionFactory.createInstruction(action);
          add(new JLabel(action.getVersion()));
      }
      else 
          add(new JLabel("nothing"));

      setBackground(Color.ORANGE);
    }

    public ActionPanel(ControllerLanguage controller) {
      super(controller);
    }

    @Override 
    public IActionPanelListable getParentPanel() {
      return (IActionPanelListable) parent; 
    }

    @Override
    public void delete() {
      IActionPanelListable p = (IActionPanelListable) parent;
      if (instruction != null && !instruction.getVersion().equals("begin"))
        p.removeActionPanel(this);
    }

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
      return new ActionPanel(controller, (Action)instruction);
    }

    public void onRelease(IMouseReactive src) {
      InstructionPanel source = (InstructionPanel) src;

      System.out.println("over action panel");
        if (source.getInstruction() == null)
            return;
        if (source.getInstruction().getType().equals("condition"))
            return;
        if (source.getInstruction().getVersion().equals("begin"))
            return;

        getParentPanel().addActionPanel((ActionPanel)source, this);
    }

}
