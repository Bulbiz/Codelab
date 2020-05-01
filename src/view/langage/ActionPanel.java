
package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.*;

import java.awt.Color;
import javax.swing.JLabel;

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

      normalColor = Color.ORANGE;
      highlightColor = Color.YELLOW;
      setBackground(normalColor);
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
      p.removeActionPanel(this);
    }

    public InstructionPanel createNewInstructionPanel(ControllerLanguage controller, Instruction instruction) {
      return new ActionPanel(controller, (Action)instruction);
    }

    public void onRelease(InstructionPanel source) {
      super.onRelease(source);

      if (source.getInstruction() == null)
        return;

      if (source instanceof ConditionPanel)
          return;

      if (source instanceof BeginPanel)
          return;

      getParentPanel().addActionPanel((ActionPanel)source, this);
    }

    public boolean canAdd(ActionPanel ap) {
      if (this == ap)
        return false;

      if (next != null)
        return next.canAdd(ap);
      return true;
    }

    public void highlight() {
      super.highlight();
      if (next != null)
        next.highlight();
    }
    public void dehighlight() {
      super.dehighlight();
      if (next != null)
        next.dehighlight();
    }
}
