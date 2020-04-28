package src.view.world;

import src.model.langage.*;
import src.model.world.*;
import src.view.langage.*;
import src.view.world.*;
import src.view.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

import src.model.world.*;
//import java.util.*;

public class TestWorldView {
	/*
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
	private static void testViewWorld() {
		ArrayList<Personage> p = new ArrayList();
    	Board b = new Board(6, 1, p);
    	Player steve = new Player(b, 6, 15, 1);
    	Queue<src.model.langage.Action> action = new LinkedList <src.model.langage.Action>();
    	action.offer(new TurnLeft(steve));
    	for(int i = 5; i>1; i--){
    		action.offer(new Move(steve));
    	}
    	action.offer(new TurnLeft(steve));
    	for(int i = 5; i>1; i--){
    		action.offer(new Move(steve));
    	}
    	action.offer(new TurnRight(steve));
    	for(int i = 5; i>1; i--){
    		action.offer(new Move(steve));
    	}
    	action.offer(new TurnRight(steve));
    	for(int i = 5; i>1; i--){
        	action.offer(new Move(steve));
    		}
    	steve.setActions(action);
    	b.initiateEntity(6,15,steve);
    	p.add(steve);
    	Level levelTest = new Level(b,1,null);
    	LevelPanel vueLevel = new LevelPanel (levelTest, steve);
    	JFrame testWindows = TestWorldView.createWindows ("Test");
    	testWindows.setContentPane(vueLevel);
    	testWindows.pack();
	}*/

    public static void run() {
    }
}