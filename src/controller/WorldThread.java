package src.controller;

import src.model.world.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;

public class WorldThread extends Thread {
	private Board board;
	private WorldPanel vueWorld;

	public WorldThread (Board b, WorldPanel v) {
		this.board = b;
		this.vueWorld = v;
	}

	private void tick () {
		board.run();
	}
	private void render() {
		vueWorld.updateDisplay();
	}
	private void waiting (int milisecond) {
		try {
			this.sleep(milisecond);
		}catch (InterruptedException e) {
		}
	}
	
	public void run() {
		while(!board.endOfLevel()) {
			this.tick();
			this.render();
			this.waiting(1300);
		}
		this.interrupt();
	}
}
