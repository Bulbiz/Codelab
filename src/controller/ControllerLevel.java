package src.controller;

import src.model.world.*;
import java.util.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ControllerLevel{
	private Level level;
	private LevelPanel vueLevel;
	private WorldThreadSwitch worldInterrupter;
	private boolean isRunning;

	public ControllerLevel (Level l, LevelPanel v) {
		this.level = l;
		this.vueLevel = v;
		this.isRunning = false;
		this.worldInterrupter = new WorldThreadSwitch(this);
	}

	public Board getBoard() {
		return this.level.getBoard();
	}
	public LevelPanel getVueLevel() {
		return this.vueLevel;
	}
	public void runOrStop (LanguageView lv) {
		if(!isRunning) {
			isRunning = true;
			Queue<Action> script = lv.getInstructionQueue();
			lv.fillInstructionQueue();
			this.level.getBoard().initiatePlayerActions(script);
		}

		if(this.worldInterrupter.getOn()) {
			this.worldInterrupter.switchOff();
		}else {
			this.worldInterrupter.switchOn();
		}
	}

	public void endGame(boolean hasWon) {
    	String message = hasWon ? "You Win !" : "You Lose, PFFFFFF !";
		System.out.println(message);

		if(hasWon){
			victoryPopUp();
			endOfLevel();
		} else {
			defeatPopUp();
			restart();
		}
	}

	public void endOfLevel() {
		isRunning = false;
		this.level.restart();
		this.vueLevel.endOfLevel();
		this.worldInterrupter.switchOff();
	}

	public void restart() {
		isRunning = false;
		this.level.restart();
		this.vueLevel.restart();
		this.worldInterrupter.switchOff();
	}

	public static void errorPopUp(String message) {
		//JButton restart = new JButton("Restart");
		Object[] options = {"OK"};
		//JOptionPane error = new JOptionPane();
		JOptionPane.showOptionDialog(null, message, "A fatal error has occured",
				JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
				null, options, options[0]);
		//error.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public static void victoryPopUp(){
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(null, "Félicitation vous avez gagné la partie !", "Victoire !!",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, options[0]);
	}

	public static void defeatPopUp(){
		Object[] options = {"Recommencer"};
		JOptionPane.showOptionDialog(null, "Oups, vous n'avez pas atteint l'objectif, réessayer ?", "Perdu...",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, options[0]);
	}
}
