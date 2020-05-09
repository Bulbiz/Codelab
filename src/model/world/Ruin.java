package src.model.world;
import java.util.*;

public class Ruin extends Decor implements Obstacle {

    public Ruin(Board b,int xPosition, int yPosition) {
        super(b, xPosition, yPosition);
    }
    
    public String toString() {
    	return "ruin";
    }

}