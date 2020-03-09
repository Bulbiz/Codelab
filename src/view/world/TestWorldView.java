package src.view.world;

import javax.swing.*;
import java.awt.*;
import src.model.world.*;
//import java.util.*;

public class TestWorldView {
	
	public static JFrame createWindows (String title) {
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setMinimumSize(new Dimension(1000,1000));
        frame.setVisible(true);
        return frame;
	}
	
	private static void testDisplayLevel() {
		JFrame levelTest = TestWorldView.createWindows("Test Level View");
		Board boardTest = new Board (7,7,null);
		Level level = new Level (boardTest,1,null);
		LevelPanel viewLevelTest = new LevelPanel (level);
		levelTest.setContentPane(viewLevelTest);
		levelTest.pack();
	}
	
	
	private static void testDisplayWorld() {
		JFrame worldTest = TestWorldView.createWindows("Test World View");
		Board boardTest = new Board (7,7,null);
		WorldPanel worldView = new WorldPanel(boardTest);
		worldTest.setContentPane(worldView);
		worldTest.pack();
	}
	
    public static void run() {
    	/*EventQueue.invokeLater(() ->{
    		testDisplayLevel();
        });*/
    	//testDisplayLevel();
    }
}