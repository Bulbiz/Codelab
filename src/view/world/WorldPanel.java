package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.awt.Image;
import javax.imageio.ImageIO;
/**
 *
 */
public class WorldPanel extends JPanel implements IDisplayable {
	private static final int tileLength = 32;
	private Board boardModel;
	private ImageLibrary spriteLibrary;
	
    /**
     *
     */
    public WorldPanel (Board b) {
    	this.boardModel = b ;
    	initiateView();
    	this.spriteLibrary = new ImageLibrary ();
    	this.spriteLibrary.loadWorldImage();
    }
    
    private void initiateView() {
    	int length = Board.boardLength * tileLength;
    	this.setPreferredSize(new Dimension(length,length));
    	this.setMinimumSize(new Dimension(length,length));
    	this.setMaximumSize(new Dimension(length,length));
    	
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	//Draw Here
    	for(int i = 0 ; i < Board.boardLength ; i++) {
    		for(int j = 0 ; j < Board.boardLength ; j++) {
    			String decorSpriteName = boardModel.getDecor(i,j) != null ? boardModel.getDecor(i,j).toString(): "vide";
    			spriteLibrary.getSprite(decorSpriteName).paintIcon(this,g,i*tileLength, j*tileLength);
    		}
    	}
    	for(Personage p : boardModel.getCharacter()) {
    		String personageSpriteName = p.toString();
			spriteLibrary.getSprite(personageSpriteName).paintIcon(this,g,p.getY()*tileLength, p.getX()*tileLength);
    	}

    }
    
    public void updateDisplay() {
    	repaint();
    }
}
