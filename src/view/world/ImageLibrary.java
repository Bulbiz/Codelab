package src.view.world;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.util.*;

public class ImageLibrary {
	private HashMap<String,Icon> storedSprite;
	
	public ImageLibrary () {
		this.storedSprite = new HashMap<String,Icon>();
	}
	public Icon getSprite (String spriteName) {
		return this.storedSprite.get(spriteName);
	}
	
	private void putImage (String key, String extension) {
		this.storedSprite.put(key,new ImageIcon(this.getClass().getResource("image/" + key + extension)));
	}
	public void loadWorldImage () {
		this.putImage("sol", ".png");
		this.putImage("player0", ".gif");
		this.putImage("player1", ".gif");
		this.putImage("player2", ".gif");
		this.putImage("player3", ".gif");
	}
}
