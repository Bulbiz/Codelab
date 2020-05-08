
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
public class ActionPanel extends InstructionPanel {

    protected ActionPanel next;

    public ActionPanel(ControllerLanguage controller, Action action) {
      super(controller);
      if (action != null)
        instruction = InstructionFactory.createInstruction(action);
      
      add(new JLabel(action != null ? action.getVersion() : "nothing"));

      color = Color.ORANGE;
      setBackground(color);
    }

    public ActionPanel(ControllerLanguage controller) {
      super(controller);
    }

    @Override 
    public IActionPanelListable getParentPanel() {
      return (IActionPanelListable) parent; 
    }

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
      return new ActionPanel(controller, (Action)instruction);
    }

    public boolean onRelease(InstructionPanel source) {  

      if (source instanceof ConditionPanel)
          return false;

      if (source instanceof BeginPanel)
          return false;

      if (source.getInstruction() == null)
        return false;

      if (getParentPanel() != null) {
        getParentPanel().addActionPanel((ActionPanel)source, this);
        return true;
      }

      return false;
    }


  }
