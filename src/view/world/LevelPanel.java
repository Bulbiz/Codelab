package src.view.world;

import javax.swing.*;
import java.awt.*;

public class LevelPanel {
	private Level l;
	
	private Controller controller;
	
	private BoardPanel worldView;
	private LanguagePanel langageView;
	private JButton runButton;
	
	public LevelPanel (Level l) extends JPanel{
		this.level = l;
		this.controller = new Controller (this.level, this);
		
		this.worldView = new BoardPanel(this.level.getBoard());
		this.langageView = new JPanel (); //FIXME : Should be constructed
		this.runButton = new JButton ("Run");
		this.runButton.addActionListener((e) -> controller.run());
	}
	
	public void updateDisplay() {
		this.worldView.updateDisplay();
		Thread.sleep(500);
	}
}
