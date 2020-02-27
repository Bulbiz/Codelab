
package src.view.world;

import javax.swing.*;
import java.awt.*;
import src.model.world.*;
import java.util.*;

public class TestWorldView {
	
	private static JFrame createWindows (String title) {
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setSize(new Dimension(500,500));
        frame.setVisible(true);
        return frame;
	}
	private static void testDisplayWorld() {
		JFrame worldTest = TestWorldView.createWindows("Test World View");
		Board boardTest = new Board (7,7,null);
		BoardPanel viewBoardTest = new BoardPanel (boardTest.getCells());
		worldTest.setContentPane(viewBoardTest);
		worldTest.pack();
	}
    public static void run() {
        testDisplayWorld();
    }
}