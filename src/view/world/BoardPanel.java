
package src.view.world;

import src.model.world.*;

import java.util.*;

/**
 * 
 */
public class BoardPanel extends JPanel implements IDisplayable {
	 
	/*FIXME: is a board useful for the view when we have the cell inside?
	 * private Board board;*/
	
	//FIXME ArrayList or normal array ?
	private CellPanel[][] cellPanels;
	 
    /**
     * FIXME : 17 is a magic number + should we display the border ?
     * Should we give a Cell [][] or a Board directly as argument?
     */
    public BoardPanel(Cell [][] board) {
	cellPanels = new CellPanel [17][17];
	for(int i = 0 ; i < 17 ; i++)
	    for(int j = 0 ; j < 17 ; j++)
		cellPanels [i][j] = new CellPanel (board [i][j]);
    }

    public void updateDisplay() {
        for(int i = 0 ; i < cellPanels.length ; i++)
	    for(int j = 0 ; j < cellPanels[i].length ; j++)
		cellPanels [i][j].updateDisplay();
    }

}
