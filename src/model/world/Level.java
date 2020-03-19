
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
    
    //FIXME : Should be changed to JSON
    private void initiateBoard (String information) {
    	String[] separation = information.split("/"); //Should be changed
    	this.board = new Board ();
    	initiateBoardDecor(this.board,separation[0].split("|"));
    	initiateBoardEntity(this.board,separation[1].split("|"));
    }
    
    private void initiateBoardEntity(Board b, String[] boardEntity) {
    	for(String entity : boardEntity) {
    		initiateEntity(b,entity);
    	}
    }
    
    private void initiateEntity(Board b, String entity) {
    	String [] information = entity.split(",");
    	String classe = information [0];
    	int x = Integer.parseInt(information[1]);
    	int y = Integer.parseInt(information[2]);
    	int facing = Integer.parseInt(information[3]);
    	
    	switch(classe) {
    		case "Player" : b.initiateEntity(y, x, new Player(b , x , y , facing));break;
			case "Coin" : b.initiateEntity(y, x, new Coin(b , x , y));break;
			case "Key" : b.initiateEntity(y, x, new Key(b , x , y));break;
    	}
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
