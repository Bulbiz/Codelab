
package src.model.world;
import java.util.*;

import javax.swing.Action;

import src.model.langage.*;

public class TestWorldModel {
	
	private static void testPlayerMove () {
		Board bTest = new Board ();
        Player pTest = new Player (bTest,0,0,0);
        pTest.move();
        pTest.turnLeft();
        pTest.move();
        pTest.turnRight();
        pTest.move();
	}
	
    public static void run() {
    	testPlayerMove();
    }
}