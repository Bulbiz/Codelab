
package src.view.langage;

import java.awt.Graphics;

public interface IMouseReactive {

    default String getSourceType() {
        return "null";
    }
    
    default String getDestType() {
        return "null";
    }

    void paintComponent(Graphics g);
}