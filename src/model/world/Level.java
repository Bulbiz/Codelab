
package src.model.world;

import src.model.langage.*;

import java.util.*;
/**
 * 
 */
public class Level {

    private Board board;
    private int id;
    private ArrayList<Action> actions; /*actions is the action the player can do for the level */
    
    /**
     * FIXME : Use a JSON as a argument should be better
     */
    public Level(Board b, int id, ArrayList<Action> a) {
        this.board = b;
        this.id = id;
        this.actions = a;
    }
    
    public void run () {
        this.board.run();    
    }
    
    public boolean endOfLevel () {
    	return board.endOfLevel();
    }
    
    public Board getBoard () {
    	return this.board;
    } 
    public ArrayList<Action> getActions () {
    	return this.actions;
    } 
}
