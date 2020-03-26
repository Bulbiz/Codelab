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
	private WorldThread worldTime;

	public ControllerLevel (Level l, LevelPanel v) {
		this.level = l;
		this.vueLevel = v;
	}

	//FIXME : Run should also initiate the program for the player
	public void runOrStop (LanguageView lv) {
		Queue<Action> script = lv.getInstructionQueue();
		if(this.worldTime == null) {
			lv.fillInstructionQueue();
			this.level.getBoard().initiatePlayerActions(script);
			this.worldTime = new WorldThread (level.getBoard(), vueLevel.getWorldView(),this);
		}

		if(this.worldTime.isAlive())
			this.worldTime.stop();
		else {
			this.worldTime = new WorldThread (level.getBoard(), vueLevel.getWorldView(),this);
			this.worldTime.start();
		}
	}

	public void endGame(boolean hasWon) {
    String message = hasWon ? "You Win !" : "You Lose, PFFFFFF !";
    System.out.println(message);
    restart();
	}

	public void restart() {
		this.level.restart();
		this.vueLevel.restart();
		this.worldTime = null;
	}

	//TODO: method based on a generic example
	public static void errorPopUp(String message) {
		Object[] options = { "ACNH", "OK" };
		//JOptionPane error = new JOptionPane();
		JOptionPane.showOptionDialog(null, message, "A fatal error has occured",
				JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
				null, options, options[0]);
	}
}
