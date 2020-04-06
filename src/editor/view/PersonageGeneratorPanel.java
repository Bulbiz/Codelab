package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;

public class PersonageGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton player;
	private FacingButton facing;
	
	public PersonageGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		this.facing = new FacingButton ();
		this.player = new PlacementButton(c, (b,y,x) -> playerPlacement(b,y,x,facing.getFacing()));
	}
	
	private void playerPlacement(Board b, int y, int x, int face) {
		Player p = b.getPlayer();
		if(p == null) {
			b.initiateEntity(y,x,new Player (b,x,y,face));
		}else {
			p.setFacing(face);
			b.move(p.getY(),p.getX(),y,x);
		}
	}
}
