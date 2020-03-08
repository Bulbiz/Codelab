package src.model.world;

import java.util.*;

public class Board {

	private Cell[][] cells;
	private Cell finish;
	//FIXME ArrayList characters attributes must be the class Personage or Avatar
	private ArrayList<Personage> characters;
	
	//TODO we would like the number 17 of cells to be addable from the call
	//FIXME maybe we should give in parameters the Cell finish entirely so we wont have to initiate it later
    public Board(int xFinish, int yFinish, ArrayList<Personage> characters) {
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
    
    private boolean isNotOccupied(int x, int y) {
    	return this.cells[y][x].getEntity() == null && !(this.cells[y][x].getDecor() instanceof Obstacle);
    }
    
    //method to initiate the entity when its not on the board
    public boolean initiateEntity(int x, int y, Entity being) {
    	try {
    		if(isNotOccupied(x, y)) {
    			this.cells[y][x].setEntity(being);
    			return true;
    		} else {
    			System.out.println("[Erreur] : Il y a quelque chose sur cette case");
    			return false;
    		}
    	} catch(IndexOutOfBoundsException e) {
    		System.out.println("[Erreur] : Case inexistante");
    		return false;
    	}
    }

	public Cell[][] getCells(){
		return cells;
	}

    //This method will create a border on the board that won't be crossable
    private void createBorder() {
    	for(int i = 0; i < this.cells[0].length; i++) {
	    this.cells[0][i] = new Cell(new Wall(this, 0, i));
	    this.cells[16][i] = new Cell(new Wall(this, 16, i));
	    this.cells[i][0] = new Cell(new Wall(this, i, 0));
	    this.cells[i][16] = new Cell(new Wall(this, i, 16));
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
    		if(isNotOccupied(xEnd, yEnd)) {
    			this.cells[yEnd][xEnd].setEntity(this.cells[yStart][xStart].getEntity());
    			this.cells[yStart][xStart].setEntity(null);
    		} else {
    			System.out.println("[Erreur] : Il y a quelque chose sur la destination");
    			return false;
    		}
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
    
    //FIXME: maybe Personage rather than Player for instanceof
    public boolean endOfLevel() {
    	if(this.finish.getEntity() != null && this.finish.getEntity() instanceof Player) {
    		return true;
    	}
    	return false;
    }

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
