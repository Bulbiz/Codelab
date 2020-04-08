
package src.view.langage;

import java.awt.Graphics;

public interface IMouseReactive {

    default IMouseReactive getSourcePanel() {
        return null;
    }
    
    default String getDestType() {
        return "null";
    }

    default void onRelease(IMouseReactive source) { }

    void paintComponent(Graphics g);
}