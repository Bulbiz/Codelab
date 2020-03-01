package src.view.world;

import javax.swing.*;
import java.awt.*;
import src.model.world.*;
//import java.util.*;

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
		/*JFrame worldTest = TestWorldView.createWindows("Test World View");
		Board boardTest = new Board (7,7,null);
		BoardPanel viewBoardTest = new BoardPanel (boardTest.getCells());
		worldTest.setContentPane(viewBoardTest);
		worldTest.pack();*/
	}
	
	private static void testDisplayLevel() {
		/*JFrame levelTest = TestWorldView.createWindows("Test Level View");
		Board boardTest = new Board (7,7,null);
		Level level = new Level (boardTest,1,null);
		LevelPanel viewLevelTest = new LevelPanel (level);
		levelTest.setContentPane(viewLevelTest);
		levelTest.pack();*/
	}
	
    public static void run() {
        testDisplayLevel();
    }
}