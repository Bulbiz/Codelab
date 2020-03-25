package src.controller;

import src.model.world.*;
import java.util.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;

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
			this.worldTime = new WorldThread (level.getBoard(), vueLevel.getWorldView());
		}

		if(this.worldTime.isAlive())
			this.worldTime.stop();
		else {
			this.worldTime = new WorldThread (level.getBoard(), vueLevel.getWorldView());
			this.worldTime.start();
		}
	}

	public void restart() {
		this.level.restart();
		this.vueLevel.restart();
		this.worldTime = null;
	}
}
