package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.GridLayout;

/**
 * Display the Board in general.
 */
public class BoardPanel extends JPanel implements IDisplayable {
	
	private CellPanel[][] cellPanels;
	 
    /**
     * FIXME : 17 is a magic number + should we display the border ?
     */
    public BoardPanel(Board b) {
    	this.setLayout(new GridLayout(17,17));
    	Cell[][] board = b.getCells();
    	cellPanels = new CellPanel [17][17];
    	
    	for(int i = 0 ; i < 17 ; i++) {
    		for(int j = 0 ; j < 17 ; j++) {
    			cellPanels [i][j] = new CellPanel (board [i][j]);
    			this.add(cellPanels[i][j]);
    		}
    	}
    }

    public void updateDisplay() {
        for(int i = 0 ; i < cellPanels.length ; i++) {
        	for(int j = 0 ; j < cellPanels[i].length ; j++)
        		cellPanels [i][j].updateDisplay();
        }
    }

}
