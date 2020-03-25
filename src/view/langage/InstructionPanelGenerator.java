
package src.view.langage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;

import src.controller.ControllerLanguage;
import src.model.langage.*;

/**
 * 
 */
public class InstructionPanelGenerator extends JPanel implements IMouseReactive {
	protected int height, width, y;

	Instruction instruction;
	ControllerLanguage controller;

	public InstructionPanelGenerator(Instruction instruction, ControllerLanguage controller) {
		this.instruction = instruction;
		this.controller = controller;
		addMouseListener(controller);
		addMouseMotionListener(controller);
		// pour les tests
		add(new JLabel(instruction.getVersion()));
		setBackground(Color.GRAY);
	}

	public InstructionPanel createInstructionPanel() {
		switch (instruction.getType()) {
			case "condition": 
				if (instruction.getVersion().equals("not"))
					return new NotPanel(controller, (Not) instruction);
				else 
					return new ConditionPanel(controller, (Condition)instruction);
			case "action": return new ActionPanel(controller, (Action)instruction);
			default: return new ControlFlowStatementPanel(controller, (ControlFlowStatement)instruction);
		}
	}

	public String getSourceType() {
		return "generatorPanel";
	}

	public String getDestType() {
		return "generatorPanel";
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
