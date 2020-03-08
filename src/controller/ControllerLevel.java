package src.controller;

import src.model.world.*;
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
	public void run () {
		this.vueLevel.setEnableRunButton(false);
		this.vueLevel.setEnableStopButton(true);

		/*
		this.worldTime = new WorldThread (level, vueLevel);
		this.worldTime.start();
		*/
	}
	public void stop () {
		/*
		this.worldTime.stop();
		this.vueLevel.setEnableRunButton(true);
		this.vueLevel.setEnableStopButton(false);
		*/
	}
}
