
package src.model.world;

import src.model.langage.*;
import src.Test;
import org.json.simple.JSONObject;
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
     
    public Level(Board b, int id, ArrayList<Action> a) {
        this.board = b;
        this.id = id;
        this.actions = a;
    }*/

    public Level (int id,JSONObject json) {
    	this.id = id;
    	this.actions = null;
    	initiateBoard (json);
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
    public Player getPlayer() {
    	return this.board.getPlayer();
    }
    //FIXME : Should be changed to JSON
    private void initiateBoard (JSONObject json) {
    	this.board = new Board ();
    	//FIXME : Should be changed
    	System.out.println(Test.jsonToStringDecor().split("|"));
    	
    	initiateBoardDecor(this.board,Test.jsonToStringDecor().split("|"));
    	initiateBoardGoal(this.board,Test.jsonToStringGoal().split(","));
    	initiateBoardObjectEntity(this.board,Test.jsonToStringEntity().split("|"));
    	initiateBoardPersonageEntity(this.board,Test.jsonToStringPersonage().split("|"));
    }
    
    private void initiateBoardPersonageEntity(Board b, String[] boardEntity) {
    	for(String entity : boardEntity) {
    		initiateObjectEntity(b,entity);
    	}
    }
    
    private void initiatePersonageEntity(Board b, String entity) {
    	String [] information = entity.split(",");
    	String classe = information [0];
    	int x = Integer.parseInt(information[1]);
    	int y = Integer.parseInt(information[2]);
    	int facing = Integer.parseInt(information[3]);
    	switch(classe) {
			case "Player" : b.initiateEntity(y, x, new Player(b , x , y, facing));break;
    	}
    }
    
    
    private void initiateBoardObjectEntity(Board b, String[] boardEntity) {
    	for(String entity : boardEntity) {
    		initiateObjectEntity(b,entity);
    	}
    }
    
    private void initiateObjectEntity(Board b, String entity) {
    	String [] information = entity.split(",");
    	String classe = information [0];
    	int x = Integer.parseInt(information[1]);
    	int y = Integer.parseInt(information[2]);
    	
    	switch(classe) {
			case "Coin" : b.initiateEntity(y, x, new Coin(b , x , y));break;
			case "Key" : b.initiateEntity(y, x, new Key(b , x , y));break;
    	}
    }

    private void initiateBoardDecor(Board b, String[] boardDecor) {
    	System.out.println(boardDecor[0]);
    	for(int i=0; i< Board.boardLength ; i++) {
    		for(int j=0; j< Board.boardLength ; j++) {
    			initiateDecor( b , boardDecor[i* Board.boardLength + j], j , i);
    		}
    	}
    }
    
    private void initiateDecor (Board b, String decor, int y , int x) {
    	//System.out.println(decor);
    	switch(decor) {
    		case "Door" : b.setDecor(new Door (b, x , y ), y , x); break;
    		case "Wall" : b.setDecor(new Wall (b, x , y ), y , x); break;
    		default : b.setDecor(null,y,x); break;
    	}
    }
    
    private void initiateBoardGoal (Board b, String [] information) {
    	int x = Integer.parseInt(information[0]);
    	int y = Integer.parseInt(information[1]);
    	b.initiateGoal(y, x);
    }
}
