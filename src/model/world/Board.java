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
    public void initiateEntity(int x, int y, Entity being) {
    	try {
    		this.cells[y][x].setEntity(being);
    	} catch(IndexOutOfBoundsException e) {
    		System.out.println("[Erreur] : Case inexistante");
    	}
    }

	public Cell[][] getCells(){
		return cells;
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
    
    //TODO the method should verify that the entity isnt trying to go into an obstacle
    //TODO what happens if a player entity try to go into an ennemy entity ? 
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
    
    //FIXME Function Place Holder for the view
    private void filling () {
    	for (int i = 1; i < this.cells.length - 1; i++) 
    		for(int j = 1; j < this.cells[i].length - 1; j++)
    				this.cells[i][j] = new Cell ();
    }
    //FIXME: Code to implement
    public boolean endOfLevel() {
    	return false;
    }
    //FIXME: Code to implement
    public void run() {
    	for(Personage p : this.characters)
    		p.run();
    }
    
    //Terminal View
    public String toString() {
    	String res = "";
    	for(int i = 0; i< this.cells.length ; i++) {
    		res = res + "\n";
    		for (int j=0; j< this.cells[i].length ; j++)
    			res = res + this.cells[i][j].toString() + " | ";
    	}
    	return res;	
    }
}
