
package src.model.world;

/**
 *
 */
public class Coin extends Collectable {

    public Coin(Board b, int xStart, int yStart) {
    	super(b,xStart,yStart);
    }
    
    /* the run for the coin is DO NOTHING ! */
    public void run() {}

    public String toString() {
    	return "coin";
    }
}
