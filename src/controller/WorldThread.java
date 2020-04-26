package src.controller;

import src.model.world.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;

public class WorldThread extends Thread {
	private Board board;
	private LevelPanel vueWorld;
	private ControllerLevel controller;

	public WorldThread (Board b, LevelPanel v,ControllerLevel c) {
		this.board = b;
		this.vueWorld = v;
		this.controller = c;
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
		while(this.board.getPlayer().hasActionsLeft() && !board.win()) {
			this.tick();
			this.render();
			this.waiting(1300);
		}
		this.controller.endGame(this.board.win());
		this.interrupt();
	}
}
