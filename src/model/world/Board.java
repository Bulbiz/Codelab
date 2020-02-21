
package src.model.world;

import java.util.*;

/**
 * 
 */
public class Board {

    /**
     * Default constructor
     */
    public Board() {
    }

    /**
     * 
     */
    private Cell[][] cells;

    /**
     * 
     */
    private ArrayList<Character> characters;

    public boolean move (int xStart,int yStart, int xEnd , int yEnd) {
    	System.out.println ("("+xStart+":"+yStart+")"+" -> ("+ xEnd + ":" + yEnd + ")");
    	return true;
    }




}
