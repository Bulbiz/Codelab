package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;

public class PersonageGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton player;
	
	public PersonageGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		this.player = new PlacementButton(c, (b,y,x) -> playerPlacement(b,y,x));
	}
	
	private static void playerPlacement(Board b, int y, int x) {
		Player p = b.getPlayer();
		if(p == null) {
			b.initiateEntity(y,x,new Player (b,x,y,0));
		}else {
			b.move(p.getY(),p.getX(),y,x);
		}
	}
}
