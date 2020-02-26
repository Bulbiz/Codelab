package src.model.world;

import java.util.*;

public class Cell {
	
	private Decor obstacle;
	private Entity being;
    
    public Cell() {
    	this.obstacle = null;
    	this.being = null;
    }

    public Cell(Decor obstacle) {
    	this.obstacle = obstacle;
    	this.being = null;
    }
}
