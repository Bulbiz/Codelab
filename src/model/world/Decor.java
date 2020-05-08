
package src.model.world;

/**
 *
 */
public abstract class Decor {
    protected Board levelBoard;
	protected int x;
	protected int y;


    public Decor(Board b, int xPosition, int yPosition) {
    	levelBoard = b;
    	x = xPosition;
    	y = yPosition;
    }


    public int getXPosition(){
        return x;
    }

    public int getYPosition(){
        return y;
    }
}
