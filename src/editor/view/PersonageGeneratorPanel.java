package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;
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
		Player p = b.getPlayer();
		if(p == null) {
			b.initiateEntity(y,x,new Player (b,x,y,face));
		}else {
			p.setFacing(face);
			b.move(p.getY(),p.getX(),y,x);
		}
	}
}
