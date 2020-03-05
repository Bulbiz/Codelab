package src.controller;

import src.model.world.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;

public class WorldThread extends Thread {
	private Level level;
	private LevelPanel vueLevel;
	
	public WorldThread (Level l, LevelPanel v) {
		this.level = l;
		this.vueLevel = v;
	}
	
	public void run () {
		while(!level.endOfLevel()) {
				level.run();
				vueLevel.updateDisplay();
			try {
				this.sleep(2500);
			}catch (InterruptedException e) {
				return;
			}
		}
	}
}