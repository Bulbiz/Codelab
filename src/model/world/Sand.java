package src.model.world;


public class Sand extends Decor {
	public Sand(Board b, int xPosition, int yPosition) {
        super(b,xPosition,yPosition);
    }
	
    public String toString() {
    	return "sand";
    }
}