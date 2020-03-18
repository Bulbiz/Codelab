package src.model.world;

import java.util.*;
import org.json.*;

public class Board {

	private Cell[][] cells;
	private Cell finish;
	//FIXME ArrayList characters attributes must be the class Personage or Avatar
	private ArrayList<Personage> characters;

	public static final int boardLength = 17;

    public Board(int yFinish, int xFinish, ArrayList<Personage> characters) {
    	this.cells = new Cell[boardLength][boardLength];
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

    public Decor getDecor(int y, int x) {
    	try {
    		return this.cells[y][x].getDecor();
    	} catch(IndexOutOfBoundsException e) {
    		System.out.println("[Erreur] : Case inexistante");
    		return null;
    	}
    }

    //method to initiate the entity when its not on the board
    public void initiateEntity(int y, int x, Entity being) {
    	try {
    		this.cells[y][x].setEntity(being);
    	} catch(IndexOutOfBoundsException e) {
    		System.out.println("[Erreur] : Case inexistante");
    	}
    }

	public Cell[][] getCells(){
		return cells;
	}

	public ArrayList<Personage> getCharacter(){
		return this.characters;
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
    public boolean move (int yStart, int xStart, int yEnd, int xEnd) {
    	try {
    		this.cells[yEnd][xEnd].setEntity(this.cells[yStart][xStart].getEntity());
    		this.cells[yStart][xStart].setEntity(null);
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


	public JSONArray toJson(){
		JSONArray jsonCells = new JSONArray();
		try{
			for(int i = 0; i < this.cells.length; i++){
				for(int j = 0; j < this.cells[i].length; j++){
					jsonCells.put(CellToJson(cells[j][i],j,i));
				}
			}



			System.out.println(jsonCells.toString(2));
		}catch(Exception e){
			System.out.println("le json n'a pas pu être créer");
		}
		return jsonCells;
	}

	public JSONObject CellToJson(Cell c, int x, int y){
		JSONObject json = new JSONObject();
		try{
			if(c.getDecor() == null)
				json.put("decor","null");
			else
				json.put("decor",c.getDecor().toString());

			if(c.getEntity() == null)
				json.put("entity","null");
			else
				json.put("entity",c.getEntity().toString());

			json.put("xPosition",x);
			json.put("yPosition",y);
			//System.out.println(json.toString(2));
		}catch(Exception e){
			System.out.println("le json n'a pas pu être créer");
		}
		return json;
	}
}
