
package src.model.world;
import java.util.*;
import src.model.langage.*;

public class TestWorldModel {
	
	private static Board bTest = new Board ();
	private static Player pTest = new Player (bTest,0,0,0);
	
	private static void testPlayerMoveTurn () {
		System.out.println("Test Player Move and Turn");
        pTest.move();
        pTest.turnLeft();
        pTest.move();
        pTest.turnRight();
        pTest.move();
	}
	
	private static void testPlayerRun () {
		System.out.println("Test Player Run");
		Queue<Action> listAction = new LinkedList<Action> ();
		for(int i=0; i<10; i++)
			listAction.offer(new Move (pTest));
		pTest.setActions(listAction);
		
		while(pTest.hasActionsLeft())
			pTest.run();
	}
	
    public static void run() {
    	testPlayerMoveTurn();
    	testPlayerRun();
    }
}