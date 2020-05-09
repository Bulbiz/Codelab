package src.model.world;
import java.util.*;

public class River extends Decor implements Obstacle {

    public River(Board b,int xPosition, int yPosition) {
        super(b, xPosition, yPosition);
    }
    
    public String toString() {
    	return "river";
    }

}
