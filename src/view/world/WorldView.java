package src.view.world;

import src.model.world.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 */
public class BoardPanel extends JPanel implements IDisplayable {
	private static final int caseLength = 32;
	private Queue<EntityView> entityView;
	private CellView cellView;
    /**
     *
     */
    public BoardPanel(Board b) {

    }

    public void updateDisplay() {
    }

}
