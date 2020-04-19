
package src.model.world;

import src.model.langage.*;
import src.Test;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 */
public class Level {

    private Board board;
    private ArrayList<Action> actions; /*actions is the action the player can do for the level */
    private JSONObject save;
    /**
     * FIXME : Use a JSON as a argument should be better

    public Level(Board b, int id, ArrayList<Action> a) {
        this.board = b;
        this.id = id;
        this.actions = a;
    }*/

    public Level (String name) throws Exception {
    	this.actions = null;
        this.save = readJSON(name);
    	this.board = initiateBoard (this.save);
    }

    private JSONObject readJSON (String name) throws Exception{
    	try {
    		JSONParser jsonParser = new JSONParser();
    		FileReader reader = new FileReader("resources/" + name + ".json");
    		Object obj = jsonParser.parse(reader);
    		JSONObject jsonLevel = (JSONObject) obj;
    		return jsonLevel;
    	}catch(Exception e) {
        throw new Exception ("Fichier non existant");
    	}
    }
    public void run () {
        this.board.run();
        System.out.println(this.board + "\n ************* \n"); //Terminal View
    }

    public void restart(){
      try{
        this.board = initiateBoard(this.save);
      }catch(Exception e){
        System.out.println("Si initiateBoard marche une fois ça devrait pas bugguer la deuxieme je pense");
      }
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

    private Board initiateBoard (JSONObject json) throws Exception{

    	Board board = new Board ();
    	initiateBoardDecor(board,(JSONArray)json.get("decor"));
    	initiateBoardGoal(board,(JSONObject) json.get("goal"));
    	initiateBoardObjectEntity(board,(JSONArray)json.get("entity"));
    	initiateBoardPersonageEntity(board,(JSONArray)json.get("perso"));
      return board;
    }

    private void initiateBoardPersonageEntity(Board b, JSONArray jsonEntity) throws Exception{
    	for(Object o : jsonEntity) {
        JSONObject entity = (JSONObject) o;
    		if(!initiatePersonageEntity(b,entity))
          throw new Exception ("Erreur, Personage impossible à placer");
    	}
    }

    private boolean initiatePersonageEntity(Board b, JSONObject information) {
    	String classe = information.get("namePerso").toString();
    	int x =  Integer.parseInt(information.get("xPosition").toString());
    	int y =  Integer.parseInt(information.get("yPosition").toString());
    	int facing =  Integer.parseInt(information.get("facing").toString());
    	switch(classe) {
           case "Player" : return b.initiateEntity(y, x, new Player(b , x , y, facing));
           default : return false;
    	}
    }


    private void initiateBoardObjectEntity(Board b, JSONArray jsonEntity) throws Exception{
    	for(Object o : jsonEntity) {
            JSONObject object = (JSONObject) o;
    		    if(!initiateObjectEntity(b,object))
              throw new Exception("Erreur, Objet impossible à placer : " + o.toString());
    	}
    }

    private boolean initiateObjectEntity(Board b, JSONObject information) {
    	String classe = information.get("nameEntity").toString();
    	int x =  Integer.parseInt(information.get("xPosition").toString());
    	int y =  Integer.parseInt(information.get("yPosition").toString());

    	switch(classe) {
			     case "Coin" : return b.initiateEntity(y, x, new Coin(b , x , y));
			     case "Key" : return b.initiateEntity(y, x, new Key(b , x , y));
           default : return false;
    	}
    }

    private void initiateBoardDecor(Board b, JSONArray jsonDecor) {
    	for(int i=0; i < 15 ; i++) {
    		for(int j=0; j < 15 ; j++) {
    			JSONObject json = (JSONObject) jsonDecor.get(i* 15 + j);
    			initiateDecor( b , json, i+1 , j+1);
    		}
    	}
    }

    private void initiateDecor (Board b, JSONObject information, int y , int x) {
    	switch(information.get("nameDecor").toString()) {
    		case "Door" : b.setDecor(new Door (b, x , y ), y , x); break;
    		case "Wall" : b.setDecor(new Wall (b, x , y ), y , x); break;
    		case "Floor": b.setDecor(new Floor(b, x, y ), y , x);break;
    		default : b.setDecor(null,y,x); break;
    	}
    }

    private void initiateBoardGoal (Board b, JSONObject information) {
    	int x = Integer.parseInt(information.get("xPosition").toString());
    	int y = Integer.parseInt(information.get("yPosition").toString());
    	b.initiateGoal(y, x);
    }
}
