
package src.model.world;

import java.util.*;

public class Board {
	
	private Cell[][] cells;
	private Cell finish;
	private ArrayList<Character> characters;
    /**
     * Default constructor
     */
    public Board(Cell finish) {
    	this.finish = finish;
    	this.cells = new Cell[17][17];
    }

    private void createBorder() {
    	Cell mountain = new Cell();
    }
}
