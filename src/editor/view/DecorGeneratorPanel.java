package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.*;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import src.view.world.ImageLibrary;
import java.awt.Color;

public class DecorGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton wall;
	private PlacementButton river;
	private PlacementButton ruin;
	private PlacementButton floor;
	private PlacementButton sand;
	private PlacementButton cobble;
	private PlacementButton goal;
	private PlacementButton door;
	private ImageLibrary sprite;

	public DecorGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		loadSprite();
		this.wall = new PlacementButton(sprite.getSprite("wall"),c,(b,y,x) -> wallPlacement(b,y,x));
		this.floor = new PlacementButton(sprite.getSprite("floor"),c,(b,y,x) -> floorPlacement(b,y,x));
		this.sand = new PlacementButton(sprite.getSprite("sand"),c,(b,y,x) -> sandPlacement(b,y,x));
		this.cobble = new PlacementButton(sprite.getSprite("cobble"),c,(b,y,x) -> cobblePlacement(b,y,x));
		this.river = new PlacementButton(sprite.getSprite("river"),c,(b,y,x) -> riverPlacement(b,y,x));
		this.ruin = new PlacementButton(sprite.getSprite("ruin"),c,(b,y,x) -> ruinPlacement(b,y,x));
		this.goal = new PlacementButton(sprite.getSprite("goal"),c,(b,y,x) -> goalPlacement(b,y,x));		
		this.door = new PlacementButton(sprite.getSprite("door"),c,(b,y,x) -> doorPlacement(b,y,x));
		layoutPlacement();
	}
	private void loadSprite() {
		sprite = new ImageLibrary();
		sprite.loadDecorImage();
	}
	private void layoutPlacement () {
		TitledBorder title = BorderFactory.createTitledBorder("Decoration");
		this.setBorder(title);
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		this.addButtons();
	}

	private void addButtonToType(JPanel panel, PlacementButton button) {
		panel.add(button);
    	panel.add(Box.createRigidArea(new Dimension(5,0)));
	}
	private JPanel createAndAddButtonTypePanel(String type) {
		JPanel panel = new JPanel();
		TitledBorder titleBorder = new TitledBorder(new LineBorder(Color.gray), type);
		titleBorder.setTitlePosition(TitledBorder.BOTTOM);
		panel.setBorder(titleBorder);
		add(panel);

		return panel;
	}
	private void addButtons() {
		JPanel floors = createAndAddButtonTypePanel("floor");
		addButtonToType(floors, floor);
		addButtonToType(floors, sand);
		addButtonToType(floors, cobble);
		JPanel obstacles = createAndAddButtonTypePanel("obstacle");		
		addButtonToType(obstacles, wall);
		addButtonToType(obstacles, river);
		addButtonToType(obstacles, ruin);
		JPanel others = createAndAddButtonTypePanel("other");
		addButtonToType(others, goal);
		addButtonToType(others, door);
	}

	private static void wallPlacement(Board b,int y,int x) {
		if(b.entityPresent(y,x)) {
			ControllerLevel.errorPopUp("Impossible ! There is an Entity on the selected cell ! Please remove it first");
			return;
		}
		if(!isBorder(y,x))
			b.setDecor(new Wall(b,x,y),y,x);
	}
	
	private static void riverPlacement(Board b,int y,int x) {
		if(b.entityPresent(y,x)) {
			ControllerLevel.errorPopUp("Impossible ! Il y a une entité dans la case choisie ! Supprimer la d'abord");
			return;
		}
		if(!isBorder(y,x))
			b.setDecor(new River(b,x,y),y,x);
	}

	private static void ruinPlacement(Board b,int y,int x) {
		if(b.entityPresent(y,x)) {
			ControllerLevel.errorPopUp("Impossible ! Il y a une entité dans la case choisie ! Supprimer la d'abord");
			return;
		}
		if(!isBorder(y,x))
			b.setDecor(new Ruin(b,x,y),y,x);
	}


	private static void floorPlacement(Board b,int y,int x) {
		if(!isBorder(y,x))
			b.setDecor(new Floor(b,y,x),y,x);
	}

	private static void sandPlacement(Board b,int y,int x) {
		if(!isBorder(y,x))
			b.setDecor(new Sand(b,y,x),y,x);
	}

	private static void cobblePlacement(Board b,int y,int x) {
		if(!isBorder(y,x))
			b.setDecor(new Cobble(b,y,x),y,x);
	}
	
	private static void doorPlacement(Board b,int y,int x) {
		if(b.entityPresent(y,x)) {
			ControllerLevel.errorPopUp("Impossible ! Il y a une entité dans la case choisie ! Supprimer la d'abord");
			return;
		}
		if(!isBorder(y,x))
			b.setDecor(new Door(b,x,y),y,x);
	}
	private static void goalPlacement (Board b, int y, int x) {
		if(!isBorder(y,x))
			b.initiateGoal(y,x);
	}

	private static boolean isBorder(int y, int x) {
		if(x == 0 || y ==0 || x == Board.boardLength - 1 || y == Board.boardLength - 1)
			ControllerLevel.errorPopUp("This cell is on the border ! You can't modify this");

    	return x == 0 || y ==0 || x == Board.boardLength - 1 || y == Board.boardLength - 1;
    }
}
