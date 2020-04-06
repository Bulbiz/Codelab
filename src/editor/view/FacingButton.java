package src.editor.view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FacingButton extends JPanel{
	private int facing;
	private JButton back,right,front,left;
	
	public FacingButton () {
		this.facing = 0;
		this.back = createFacingButton("Back",0);
		this.right = createFacingButton("Right",1);
		this.front = createFacingButton("Front",2);
		this.left = createFacingButton("Left",3);
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
