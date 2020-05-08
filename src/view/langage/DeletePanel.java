
package src.view.langage;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

import src.controller.ControllerLanguage;

public class DeletePanel extends JPanel implements IMouseReactive {

    public DeletePanel(ControllerLanguage controller) {
        JLabel label = new JLabel("Delete");
        add(label);
        addMouseListener(controller);

        setBorder(new LineBorder(Color.BLACK));
        setBounds(32, 32, 128, 64);
    }

    public boolean onRelease(InstructionPanel source) {
        if (source != null) {
            source.delete();
            return true;
        }
        return false;
    }

    public String getDestType() {
        return "deletePanel";
    }
    
}