package src.editor.view;

import javax.swing.*;
import src.model.world.*;
import src.controller.ControllerEditor;
import src.view.world.ImageLibrary;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

public class EraserGeneratorPanel extends JPanel{
	private ControllerEditor controller;
	private PlacementButton eraser;
	private ImageLibrary sprite;
	
	public EraserGeneratorPanel (ControllerEditor c) {
		this.controller = c;
		loadSprite();
		this.eraser = new PlacementButton(sprite.getSprite("eraser"),c, (b,y,x) -> eraserPlacement(b,y,x));
		layoutPlacement();
	}
	
	private void loadSprite() {
		sprite = new ImageLibrary();
		sprite.loadEraserImage();
	}
	
	private void layoutPlacement() {
		TitledBorder title = BorderFactory.createTitledBorder("Eraser");
		this.setBorder(title);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.addButton();
	}
	
	private void addButton() {
		this.addWithSeparation(eraser);
	}
	
	private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(0,5)));
    }
	
	private static void eraserPlacement(Board b, int y, int x) {
		/* Make a remove Function in Board */
	}
}
