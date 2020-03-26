
package src.model.world;

import src.model.langage.*;
import src.Test;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
/**
 *
 */
public class Level {

    private Board board;
    private int id;
    private ArrayList<Action> actions; /*actions is the action the player can do for the level */
    private JSONObject jsonSave;
    /**
     * FIXME : Use a JSON as a argument should be better

    public Level(Board b, int id, ArrayList<Action> a) {
        this.board = b;
        this.id = id;
        this.actions = a;
    }*/

    //FIXME : Change a little bit
    public Level (int id,JSONObject json) {
    	this.id = id;
    	this.actions = null;
      this.jsonSave = json;
    	this.board = initiateBoard (json);
    }

    public void run () {
        this.board.run();
        System.out.println(this.board + "\n ************* \n"); //Terminal View
    }

    public void restart(){
      this.board = initiateBoard(jsonSave);
    }
    public boolean win(){
    	return board.win();
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
    private Board initiateBoard (JSONObject json) {

    	Board board = new Board ();
    	//FIXME : Should be changed
    	initiateBoardDecor(board,(JSONArray)json.get("decor"));
    	initiateBoardGoal(board,(JSONObject) json.get("goal"));
    	initiateBoardObjectEntity(board,(JSONArray)json.get("entity"));
    	initiateBoardPersonageEntity(board,(JSONArray)json.get("perso"));
      return board;
    }

    private void initiateBoardPersonageEntity(Board b, JSONArray jsonEntity) {
    	for(Object o : jsonEntity) {
        JSONObject entity = (JSONObject) o;
    		initiatePersonageEntity(b,entity);
    	}
    }

    private void initiatePersonageEntity(Board b, JSONObject information) {
    	String classe = information.get("namePerso").toString();
    	int x =  Integer.parseInt(information.get("xPosition").toString());
    	int y =  Integer.parseInt(information.get("yPosition").toString());
    	int facing =  Integer.parseInt(information.get("facing").toString());
    	switch(classe) {
			case "Player" : b.initiateEntity(y, x, new Player(b , x , y, facing));break;
    	}
    }


    private void initiateBoardObjectEntity(Board b, JSONArray jsonEntity) {
    	for(Object o : jsonEntity) {
            JSONObject object = (JSONObject) o;
    		initiateObjectEntity(b,object);
    	}
    }

    private void initiateObjectEntity(Board b, JSONObject information) {
    	String classe = information.get("nameEntity").toString();
    	int x =  Integer.parseInt(information.get("xPosition").toString());
    	int y =  Integer.parseInt(information.get("yPosition").toString());

    	switch(classe) {
			case "Coin" : b.initiateEntity(y, x, new Coin(b , x , y));break;
			case "Key" : b.initiateEntity(y, x, new Key(b , x , y));break;
    	}
    }

    private void initiateBoardDecor(Board b, JSONArray jsonDecor) {
    	for(int i=0; i< Board.boardLength ; i++) {
    		for(int j=0; j< Board.boardLength ; j++) {
    			JSONObject json = (JSONObject) jsonDecor.get(i* Board.boardLength + j);
    			initiateDecor( b , json, j , i);
    		}
    	}
    }

    private void initiateDecor (Board b, JSONObject information, int y , int x) {
    	switch(information.get("nameDecor").toString()) {
    		case "Door" : b.setDecor(new Door (b, x , y ), y , x); break;
    		case "Wall" : b.setDecor(new Wall (b, x , y ), y , x); break;
    		default : b.setDecor(null,y,x); break;
    	}
    }

    private void initiateBoardGoal (Board b, JSONObject information) {
    	int x = Integer.parseInt(information.get("xPosition").toString());
    	int y = Integer.parseInt(information.get("yPosition").toString());
    	b.initiateGoal(y, x);
    }
}
