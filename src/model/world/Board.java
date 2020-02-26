package src.model.world;

import java.util.*;

public class Board {
	
	private Cell[][] cells;
	private Cell finish;
	//FIXME ArrayList characters attributes must be the class Personage or Avatar
	private ArrayList<Character> characters;
    
    public Board(Cell finish, ArrayList<Character> characters) {
    	this.finish = finish;
    	this.cells = new Cell[17][17];
    	this.characters = characters;
    	createBorder();
    }

    private void createBorder() {
    	Cell mountain = new Cell(); //La case qui servira de Bordure à déterminer
    	for(int i = 0; i < this.cells[0].length; i++) {
    		this.cells[0][i] = new Cell();
    		this.cells[16][i] = new Cell();
    		this.cells[i][0] = new Cell();
    		this.cells[i][16] = new Cell();
    	}
    }
}
