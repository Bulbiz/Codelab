
package src.view.langage;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
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

    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub

    }

    public void onRelease(InstructionPanel source) {
        if (source != null)
            source.delete();
    }

    public String getDestType() {
        return "deletePanel";
    }
    
}