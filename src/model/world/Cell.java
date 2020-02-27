package src.model.world;

import java.util.*;

public class Cell {
	
	private Decor decor;
	private Entity being;
    
    public Entity getEntity () {
    	return this.entity;
    }
    
    public Decor getDecor() {
    	return this.decor;
    } 

    public Cell(Decor decor) {
    	this.decor = decor;
    	this.being = null;
    }
}
