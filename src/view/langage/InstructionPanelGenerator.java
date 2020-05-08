
package src.view.langage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import src.controller.ControllerLanguage;
import src.model.langage.*;

/**
 * 
 */
public class InstructionPanelGenerator extends JPanel implements IMouseReactive {

	Instruction instruction;
	InstructionPanel instructionPanel;
	ControllerLanguage controller;

	public static final int standardWidth = ResourcePanel.width - 2*ResourcePanel.margeleft;

	public InstructionPanelGenerator(InstructionPanel instructionPanel) {
		this.instruction = instructionPanel.getInstruction();
		this.instructionPanel = instructionPanel;
		this.controller = instructionPanel.getController();
		addMouseListener(controller);
		addMouseMotionListener(controller);
		
		InstructionPanel ip = createInstructionPanel();
		ip.setPosition(0, 0, standardWidth);
		ip.removeMouseListener(controller);
		ip.removeMouseMotionListener(controller);
		add(ip);
	}

	public int getHeight() {
		return instructionPanel.getHeight();
	}

	public InstructionPanel createInstructionPanel() {
		return instructionPanel.createNewInstructionPanel(controller, instruction);
	}

	public InstructionPanel getSourcePanel() {
		return createInstructionPanel();
	}
}
