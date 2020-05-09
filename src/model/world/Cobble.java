package src.model.world;

import java.util.*;

public class Cobble extends Decor {
	public Cobble(Board b, int xPosition, int yPosition) {
        super(b,xPosition,yPosition);
    }
	
    public String toString() {
    	return "cobble";
    }
}
