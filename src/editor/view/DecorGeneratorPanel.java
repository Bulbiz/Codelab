package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.*;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import src.view.world.ImageLibrary;

public class DecorGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton wall;
	private PlacementButton floor;
	private PlacementButton goal;
	private PlacementButton door;
	private ImageLibrary sprite;
	
	public DecorGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		loadSprite();
		this.wall = new PlacementButton(sprite.getSprite("wall"),c,(b,y,x) -> wallPlacement(b,y,x));
		this.floor = new PlacementButton(sprite.getSprite("floor"),c,(b,y,x) -> floorPlacement(b,y,x));
		this.goal = new PlacementButton(sprite.getSprite("goal"),c,(b,y,x) -> goalPlacement(b,y,x));		
		this.door = new PlacementButton(sprite.getSprite("door"),c,(b,y,x) -> doorPlacement(b,y,x));
		layoutPlacement();
	}
	private void loadSprite() {
		sprite = new ImageLibrary();
		sprite.loadDecorImage();
	}
	private void layoutPlacement () {
		TitledBorder title = BorderFactory.createTitledBorder("Décor");
		this.setBorder(title);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.addButton();
	}
	
	private void addButton() {
		this.addWithSeparation(wall);
		this.addWithSeparation(floor);
		this.addWithSeparation(goal);
		this.addWithSeparation(door);
	}
	
	private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(0,5)));
    }
	
	private static void wallPlacement(Board b,int y,int x) {
		if(b.entityPresent(y,x)) {
			ControllerLevel.errorPopUp("Impossible ! Il y a une entité dans la case choisie ! Supprimer la d'abord");
			return;
		}
		if(!isBorder(y,x))
			b.setDecor(new Wall(b,x,y),y,x);
	}
	
	private static void floorPlacement(Board b,int y,int x) {
		if(!isBorder(y,x))
			b.setDecor(new Floor(b,y,x),y,x);
	}
	private static void doorPlacement(Board b,int y,int x) {
		b.setDecor(new Door(b,y,x),y,x);
	}
	private static void goalPlacement (Board b, int y, int x) {
		if(!isBorder(y,x))
			b.initiateGoal(y,x);
	}
	
	private static boolean isBorder(int y, int x) {
		if(x == 0 || y ==0 || x == Board.boardLength - 1 || y == Board.boardLength - 1)
			ControllerLevel.errorPopUp("Cette Case est au bord ! Impossible de la modifier");
		
    	return x == 0 || y ==0 || x == Board.boardLength - 1 || y == Board.boardLength - 1;
    }
}
