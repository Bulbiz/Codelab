
package src.view.langage;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;

import src.model.langage.*;

/**
 * 
 */
public class ActionPanel extends InstructionPanel {

    /**
     * Default constructor
     */
    public ActionPanel(MouseAdapter controller, Action action) {
      super(controller, null);
      if (action != null) {
          instruction = InstructionFactory.createAction(action.getPersonage(), action.getVersion());
          add(new JLabel(action.getVersion()));
      }
      else 
          add(new JLabel("nothing"));

      setBackground(Color.ORANGE);
    }

    public ActionPanel(MouseAdapter controller) {
      super(controller, null);
    }

    /**
     * 
     */
    public Instruction toInstruction() {
      return instruction;
	}

}
