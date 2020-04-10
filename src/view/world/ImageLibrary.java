package src.view.world;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.util.*;

public class ImageLibrary {
	private HashMap<String,Icon> storedSprite;

	public ImageLibrary () {
		this.storedSprite = new HashMap<String,Icon>();
		this.putImage("vide", "vide.png");
	}

	public Icon getSprite (String spriteName) {
		return this.storedSprite.get(spriteName);
	}

	private void putImage (String key, String filename) {
		this.storedSprite.put(key,new ImageIcon("resourcesImages/" + filename));
	}

	public void loadWorldImage () {
		loadDecorImage();
		loadPlayerImage();
		loadEntityImage();
	}

	public void loadPlayerImage() {
		this.putImage("player0", "player0.gif");
		this.putImage("player1", "player1.gif");
		this.putImage("player2", "player2.gif");
		this.putImage("player3", "player3.gif");
	}

	public void loadDecorImage() {
		this.putImage("door", "door.png");
		this.putImage("goal", "goal.png");
		this.putImage("wall", "wall.png");
		this.putImage("floor", "floor.png");
	}

	public void loadEntityImage() {
		this.putImage("coin", "coin.png");
		this.putImage("key", "key.png");
	}
	
	public void loadEraserImage() {
		this.putImage("eraser","eraser.png");
	}
}
