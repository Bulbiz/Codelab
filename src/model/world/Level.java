
package src.model.world;

import src.model.langage.*;

import java.util.*;
import org.json.simple.*;
/**
 * 
 */
public class Level {

    private Board board;
    //private int type; FIXME: What is the type ?
    private int id;
    /*FIXME: is actions the actions available for the player 
    or the actions made by the player*/
    private ArrayList<Action> actions;
    
    /**
     * FIXME : Use a JSON as a argument should be better
     */
    public Level(Board b, int id, ArrayList<Action> a) {
        this.board = b;
        this.id = id;
        this.actions = a;
    }
    
    public boolean run () {
        if(!board.endOfLevel()){
            this.board.run();
            return true;
        }
        return false;
    }
    
    /*FIXME : Read the actions from a json*/
    private ArrayList<Action> readActions (JSONObject json){
        return null;
    }
    
    /*FIXME : Create a board from a json*/
    private Board readBoard (JSONObject json){
        return null;
    }
}
