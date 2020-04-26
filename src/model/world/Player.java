
package src.model.world;

import java.util.*;
import src.model.langage.*;
/**
 * Define the Player
 */
public class Player extends Personage {

    protected ArrayList<Collectable> inventory = new ArrayList<Collectable>();

	/*The list of actions have to be set after the player has been created because the 
	 * actions need to have the player to be created
	 */
    public Player(Board b, int xStart, int yStart,int facingStart) {
    	super(b,xStart,yStart,facingStart,null);
    }
    
    public void setActions (Queue<Action> actions) {
    	this.actions = actions;
    }
    
    /* 0 => Action qui ne compte pas comme une action (turn)
     * 1 => Action terminer
     * 2 => Action n'est pas terminer (cas dans le if/while) */
    public void run () {
        int verification = actions.peek().run();
        while (verification == 0) {
            actions.poll();
            if(!this.hasActionsLeft())
            	return;
            verification = actions.peek().run();            
        }

        if(verification == 1)
            actions.poll();
    }

    public void addToInventory(Collectable collectable) {
        inventory.add(collectable);
    }

    public ArrayList<Collectable> getInventory() {
        return inventory;
    }
    
    public boolean hasActionsLeft () {
    	return !(this.actions.isEmpty());
    }
    
    public void setFacing(int facing) {
    	this.facing = (this.facing + 4) % 4;;
    }
    
    public String toString() {
    	return "player"+this.facing;
    }
}
