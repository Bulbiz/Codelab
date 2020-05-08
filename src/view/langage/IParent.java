
package src.view.langage;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.Point;

public interface IParent {
    
    void setToDragAndDropLayer(InstructionPanel ip, JLayeredPane layeredPanel);
    void setToDefaultLayer(InstructionPanel ip, JLayeredPane layeredPanel);

    InstructionPanel removePanel(InstructionPanel ip);
}