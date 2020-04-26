package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.*;
import src.view.world.ImageLibrary;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

public class PersonageGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton player;
	private FacingButton facing;
	private ImageLibrary sprite;
	
	public PersonageGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		loadSprite();
		this.facing = new FacingButton ();
		this.player = new PlacementButton(sprite.getSprite("player0"),c, (b,y,x) -> playerPlacement(b,y,x,facing.getFacing()));
		layoutPlacement();
	}
	
	private void loadSprite() {
		sprite = new ImageLibrary();
		sprite.loadPlayerImage();
	}
	
	private void layoutPlacement() {
		TitledBorder title = BorderFactory.createTitledBorder("Personage");
		this.setBorder(title);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.addButton();
	}
	
	private void addButton() {
		this.addWithSeparation(facing);
		this.addWithSeparation(player);
	}
	private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(0,5)));
    }
	
	private static void playerPlacement(Board b, int y, int x, int face) {
		if(!entityPresent(y,x,b)) {
			Player p = b.getPlayer();
			if(p != null) {
				b.erased(p.getY(),p.getX());
			}
			b.initiateEntity(y,x,new Player (b,x,y,face));
		}
	}
	
	private static boolean entityPresent(int y, int x , Board b) {
		if(b.entityPresent(y,x)) 
			ControllerLevel.errorPopUp("Impossible ! Il y a une entité dans la case choisie ! Supprimer la d'abord");
		return b.entityPresent(y,x);
	}
}
