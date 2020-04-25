package src.model.world;
import java.util.*;

public class Wall extends Decor implements Obstacle {

    //FIXME: maybe not pertinent to add Board in call
    public Wall(Board b,int xPosition, int yPosition) {
        super(b, xPosition, yPosition);
    }
    
    public String toString() {
    	return "wall";
    }

}
