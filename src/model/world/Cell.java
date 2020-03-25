package src.model.world;

import java.util.*;

public class Cell {

	private Decor decor;
	private Entity being;

    public Cell() {
    	this.decor = null;
    	this.being = null;
    }

    public Cell(Decor decor) {
    	this.decor = decor;
    	this.being = null;
    }
    
    public Entity getEntity() {
    	return this.being;
    }
    
    public Decor getDecor() {
    	return this.decor;
    }
    
    protected void setEntity(Entity e) {
    	this.being = e;
    }
    public void setDecor(Decor d) {
    	this.decor = d;
    }
    //Terminal View
    public String toString() {
    	String decorText = this.decor != null? Character.toString(this.decor.toString().charAt(0)) : "N";
    	String beingText = this.being != null? Character.toString(this.being.toString().charAt(0)) : "N";
    	return "(" + beingText + "," + decorText + ")";
    }
}
