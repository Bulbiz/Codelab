package src.model.world;

import java.util.*;

public class Board {
	
	private Cell[][] cells;
	private Cell finish;
	//FIXME ArrayList characters attributes must be the class Personage or Avatar
	private ArrayList<Personage> characters;
    
    public Board(int xFinish, int yFinish, ArrayList<Personage> characters) {
    	//TODO we would like the number 17 of cells to be addable from the call
    	this.cells = new Cell[17][17];
    	try{
    	    this.finish = this.cells[yFinish][xFinish];
    	} catch(Exception e){
    	    System.out.println("Erreur : Les coordonnées sont hors limite");
    	    return;
    	}
    	this.characters = characters;
    	createBorder();
    	initiateCells();
    }
    
    public Decor getDecor(int x, int y) {
    	try {
    		return this.cells[y][x].getDecor();
    	} catch(IndexOutOfBoundsException e) {
    		System.out.println("[Erreur] : Case inexistante");
    		return null;
    	}
    }
    
    //method to initiate the entity when its not on the board
    protected void initiateEntity(int x, int y, Entity being) {
    	try {
    		this.cells[y][x].setEntity(being);
    	} catch(IndexOutOfBoundsException e) {
    		System.out.println("[Erreur] : Case inexistante");
    	}
    }
    
    //This method will create a border on the board that won't be crossable
    private void createBorder() {
    	Cell mountain = new Cell(); //TODO La case qui servira de Bordure à déterminer
    	for(int i = 0; i < this.cells[0].length; i++) {
    		this.cells[0][i] = new Cell();
    		this.cells[16][i] = new Cell();
    		this.cells[i][0] = new Cell();
    		this.cells[i][16] = new Cell();
    	}
    }
    
    //This method will initiate all cells remaining that are still = null
    private void initiateCells() {
    	for(int i = 0; i < this.cells.length; i++) {
    		for(int j = 0; j < this.cells[0].length; j++) {
    			if(this.cells[i][j] == null) {
    				this.cells[i][j] = new Cell();
    			}
    		}
    	}
    }
    
    public boolean move (int xStart, int yStart, int xEnd, int yEnd) {
    	try {
    		this.cells[xEnd][yEnd].setEntity(this.cells[xStart][yStart].getEntity());
    		this.cells[xStart][yStart].setEntity(null);
    	} catch(IndexOutOfBoundsException e) {
    		System.out.println("[Erreur] : Le déplacement n'a pas pu se faire");
    		return false;
    	}
    	System.out.println("("+xStart+":"+yStart+")"+" -> ("+ xEnd + ":" + yEnd + ")");
    	return true;
    }

}
