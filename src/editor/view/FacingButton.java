package src.editor.view;

import javax.swing.*;
import java.awt.Dimension;

public class FacingButton extends JPanel{
	private int facing;
	private JButton back,right,front,left;
	
	public FacingButton () {
		this.facing = 0;
		this.back = createFacingButton("Back",2);
		this.right = createFacingButton("Right",1);
		this.front = createFacingButton("Front",0);
		this.left = createFacingButton("Left",3);
		
		this.layoutPlacement();
	}
	private void layoutPlacement() {
		this.setLayout(new BoxLayout (this,BoxLayout.LINE_AXIS));
		this.addButton();
	}
	
	private void addButton() {
		this.addWithSeparation(back);
		this.addWithSeparation(right);
		this.addWithSeparation(front);
		this.addWithSeparation(left);
	}
	
	private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(5,0)));
    }
	
	public int getFacing () {
		return facing;
	}
	private JButton createFacingButton(String label, int facing) {
		JButton button = new JButton(label);
		button.addActionListener((e) -> this.facing = facing );
		return button;
	}
}
