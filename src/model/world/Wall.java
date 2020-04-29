package src.model.world;
import java.util.*;

public class Wall extends Decor implements Obstacle {

    public Wall(Board b,int xPosition, int yPosition) {
        super(b, xPosition, yPosition);
    }

    public String toString() {
    	return "wall";
    }

}
