package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;

public class CollectableGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton key;
	private PlacementButton coin;
	
	public CollectableGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		this.key = new PlacementButton(c,(b,y,x) -> keyPlacement(b,y,x));
		this.coin = new PlacementButton(c,(b,y,x) -> coinPlacement(b,y,x));
		
	}
	
	private static void keyPlacement(Board b, int x, int y) {
		b.initiateEntity( y, x , new Key(b,x,y));
	}
	private static void coinPlacement(Board b, int x, int y) {
		b.initiateEntity( y, x , new Coin(b,x,y));
	}
}
