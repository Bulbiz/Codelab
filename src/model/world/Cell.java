
package src.model.world;

import java.util.*;

/**
 * 
 */
public class Cell {

    /**
     * Default constructor
     */
    public Cell() {
    }

    public Entity getEntity () {
    	return this.entity;
    }
    
    public Decor getDecor() {
    	return this.decor;
    } 
    /**
     * 
     */
    private Entity entity;

    /**
     * 
     */
    private Decor decor;






}
