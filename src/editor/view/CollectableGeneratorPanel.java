package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.*;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import src.view.world.ImageLibrary;

public class CollectableGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton key;
	private PlacementButton coin;
	private ImageLibrary sprite;

	public CollectableGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		loadSprite();
		this.key = new PlacementButton(sprite.getSprite("key"),c,(b,y,x) -> keyPlacement(b,y,x));
		this.coin = new PlacementButton(sprite.getSprite("coin"),c,(b,y,x) -> coinPlacement(b,y,x));
		layoutPlacement();
	}
	private void loadSprite() {
		sprite = new ImageLibrary();
		sprite.loadEntityImage();
	}
	private void layoutPlacement() {
		TitledBorder title = BorderFactory.createTitledBorder("Items");
		this.setBorder(title);
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		this.addButton();
	}

	private void addButton() {
		this.addWithSeparation(key);
		this.addWithSeparation(coin);
	}

	private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(5,0)));
    }

	private static void keyPlacement(Board b, int y, int x) {
		if(!entityPresent(y,x,b))
			b.initiateEntity( y, x , new Key(b,x,y));
	}

	private static void coinPlacement(Board b, int y, int x) {
		if(!entityPresent(y,x,b))
			b.initiateEntity( y, x , new Coin(b,x,y));
	}

	private static boolean entityPresent(int y, int x, Board b) {
		if(b.entityPresent(y,x))
			ControllerLevel.errorPopUp("Warning ! There is an Entity here ! ");
		return b.entityPresent(y,x);
	}
}
