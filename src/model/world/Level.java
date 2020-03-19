
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
        System.out.println(this.board + "\n ************* \n"); //Terminal View
    }

    public boolean endOfLevel(){
    	return board.endOfLevel();
    }

    public Board getBoard () {
    	return this.board;
    }
    
    public ArrayList<Action> getActions () {
    	return this.actions;
    }
    
    private void initiateBoardEntity(Board b, String[] boardEntity) {
    	for(String entity : boardEntity) {
    		initiateEntity(b,entity);
    	}
    }
    
    private void initiateEntity(Board b, String entity) {
    	//TODO :
    }
    
    private void initiateBoardDecor(Board b, String[] boardDecor) {
    	for(int i=0; i< Board.boardLength ; i++) {
    		for(int j=0; j< Board.boardLength ; j++) {
    			initiateDecor( b , boardDecor[i* Board.boardLength + j], j , i);
    		}
    	}
    }
    private void initiateDecor (Board b, String decor, int y , int x) {
    	switch(decor) {
    		case "Door" : b.setDecor(new Door (b, x , y ), y , x); break;
    		case "Goal" : b.setDecor(new Goal (b, x , y ), y , x); break;
    		case "Wall" : b.setDecor(new Wall (b, x , y ), y , x); break;
    		default : b.setDecor(null,x,y); break;
    	}
    }
    
    
}
