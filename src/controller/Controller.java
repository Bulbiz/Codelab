package src.controller;

import src.model.world.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;

public class Controller{
	private Level level;
	private LevelPanel vueLevel;
	
	public Controller (Level l, LevelPanel v) {
		level = l;
		vueLevel = v;
	}
	
	public void run () {
		while(!level.endOfLevel()) {
			level.run();
			vueLevel.updateDisplay();
			Thread.sleep(1000);
		}
	}
	
}