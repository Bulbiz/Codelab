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
		if(hasWon){
			victoryPopUp();
		}
    restart();
	}

	public void restart() {
		this.level.restart();
		this.vueLevel.restart();
		this.worldTime = null;
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
}
