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
    	for(int i = 0 ; i < Board.boardLength ; i++) {
    		for(int j = 0 ; j < Board.boardLength ; j++) {
    			String decorSpriteName = boardModel.getDecor(i,j) != null ? boardModel.getDecor(i,j).toString(): "vide";
    			spriteLibrary.getSprite(decorSpriteName).paintIcon(this,g,i*tileLength, j*tileLength);
    		}
    	}
    	spriteLibrary.getSprite("player0").paintIcon(this,g,tileLength, tileLength);
    	
    	/*ImageIcon img = new ImageIcon(this.getClass().getResource("image/Sol.png"));
        //Draw Here;
    	for(int i=0; i< 17 ; i++)
    		for(int j = 0 ; j < 17 ; j ++) {
    			g.drawImage(img.getImage(),i*tileLength, j*tileLength,null);
    		}
    	ImageIcon img2 = new ImageIcon(this.getClass().getResource("image/Front.gif"));
    	img2.paintIcon(this, g, 2*tileLength, 5*tileLength);*/
    }
    
    public void updateDisplay() {
    	
    }
}
