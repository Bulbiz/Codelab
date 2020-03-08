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
	private Canvas boardView;

    /**
     *
     */
    public WorldPanel (Board b) {
    	this.boardModel = b ;
    }
    
    private void initiateDisplay() {
    	Canvas worldView= new Canvas ();
    	int length = Board.boardLength * tileLength;
    	worldView.setPreferredSize(new Dimension(length,length));
    	worldView.setMinimumSize(new Dimension(length,length));
    	worldView.setMaximumSize(new Dimension(length,length));
    	
    	this.add(worldView);
    }
    public void updateDisplay() {
    	
    }

}
