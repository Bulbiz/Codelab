package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 *
 */
public class WorldPanel extends JPanel implements IDisplayable {

	private static final int tileLength = 32;
	private Board boardModel;
	
    /**
     *
     */
    public WorldPanel (Board b) {
    	this.boardModel = b ;
    	updateDisplay();
    }
    
    private void createCanvas() {
    	int length = Board.boardLength * tileLength;
    	this.setPreferredSize(new Dimension(length,length));
    	this.setMinimumSize(new Dimension(length,length));
    	this.setMaximumSize(new Dimension(length,length));
    	
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw Here
        g.drawString("This is my custom Panel!",10,20);
    }  
    public void updateDisplay() {
    	repaint();
    }

}
