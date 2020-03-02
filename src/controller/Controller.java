package src.controller;

import src.model.world.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;

public class Controller{
	private Level level;
	private LevelPanel vueLevel;
	private WorldThread worldTime;
	
	public Controller (Level l, LevelPanel v) {
		this.level = l;
		this.vueLevel = v;
		this.worldTime = new WorldThread (level, vueLevel);
	}
	
	//FIXME : Run should also initiate the program for the player
	public void run () {
		this.worldTime.interrupt();
		this.worldTime = new WorldThread (level, vueLevel);
		this.worldTime.start();
	}
	
}