
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
        setMinimumSize(new Dimension(200, 50));
    }

    public void onRelease(InstructionPanel source) {
        if (source != null)
            if (source.getInstruction() != null)
                source.delete();
            else 
                source.dehighlight();
    }

    public String getDestType() {
        return "deletePanel";
    }
    
}