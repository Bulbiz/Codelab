package src.controller;

import src.model.world.*;
import java.util.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;
import javax.swing.JOptionPane;

public class ControllerLevel{
	private Level level;
	private LevelPanel vueLevel;
	private WorldThreadSwitch worldInterrupter;
	private boolean isRunning;
	public static boolean isInfinite = false;

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
		if(hasWon && !isInfinite){
			victoryPopUp();
			endOfLevel();
		} else {
			defeatPopUp();
			restart();
		}
	}

	public void acceleration (){
		if(WorldThread.speed == 400)
			WorldThread.speed = 100;
		else
			WorldThread.speed = 400;
	}
	
	public void speedReset(){
		WorldThread.speed = 400;
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
		isInfinite = false;
		this.worldInterrupter.switchOff();
	}

	public static void errorPopUp(String message) {
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(null, message, "A fatal error has occured",
				JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
				null, options, options[0]);
	}

	public static void successPopUp(String message) {
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(null, message, "Success",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, options[0]);
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
