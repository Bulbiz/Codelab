
package src.view.langage;

import java.awt.Graphics;

public interface IMouseReactive {

    default InstructionPanel getSourcePanel() {
        return null;
    }
    
    default String getDestType() {
        return "null";
    }

    default void onRelease(InstructionPanel source) {
        if (source != null)
            source.dehighlight();
    }

    void paintComponent(Graphics g);
}