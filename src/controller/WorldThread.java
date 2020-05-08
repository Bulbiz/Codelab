package src.controller;

import src.model.world.*;
import src.model.langage.*;
import src.view.world.*;
import src.view.langage.*;

public class WorldThread extends Thread {
	private Board board;
	private LevelPanel vueWorld;
	private ControllerLevel controller;
	private WorldThreadSwitch interrupter;
	private boolean interrupted;

	public WorldThread (Board b, LevelPanel v,ControllerLevel c, WorldThreadSwitch i) {
		this.board = b;
		this.vueWorld = v;
		this.controller = c;
		this.interrupter = i;
		this.interrupted = false;
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
	
	public void stopThread() {
		this.interrupted = true;
	}

	public void run() {
		while(this.board.getPlayer().hasActionsLeft() && !board.win() && !this.interrupted) {
			this.tick();
			this.render();
			this.waiting(100);
		}
		if(!this.interrupted)
			this.controller.endGame(this.board.win());
		this.interrupt();
	}
}
