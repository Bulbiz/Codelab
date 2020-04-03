package src.model.world;

import java.util.*;

public class Floor extends Decor {
	public Floor(Board b, int xPosition, int yPosition) {
        super(b,xPosition,yPosition);
    }
	
    public String toString() {
    	return "floor";
    }
}
