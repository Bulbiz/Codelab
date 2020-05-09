
package src.model.world;


public class Key extends Collectable {

    private static int nbKeys = 0;
    protected int id;
    

    public Key(Board b, int xStart, int yStart) {
        super(b,xStart,yStart);
        id = nbKeys;
        nbKeys ++;
    }
    
    public void run() {}
      
    public String toString() {
    	return "key";
    }

    public void isCollected(Player player) {
        super.isCollected(player);
        levelBoard.openDoor();
    }
}
