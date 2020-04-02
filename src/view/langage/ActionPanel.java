
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
      super(controller, null);
      if (action != null) {
          instruction = InstructionFactory.createAction(action.getPersonage(), action.getVersion());
          add(new JLabel(action.getVersion()));
      }
      else 
          add(new JLabel("nothing"));

      setBackground(Color.ORANGE);
    }

    public ActionPanel(ControllerLanguage controller) {
      super(controller, null);
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

}
