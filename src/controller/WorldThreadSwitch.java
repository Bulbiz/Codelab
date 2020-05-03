package src.controller;

import src.model.world.*;
import src.view.world.*;


public class WorldThreadSwitch {
	
    private  WorldThread worldTime;
	private ControllerLevel controller;
	private boolean on;
	
	public WorldThreadSwitch (ControllerLevel c) {
		this.controller = c;
        this.on = false;
	}


    public void switchOff(){
    	System.out.println("off");
        this.on = false;
        this.worldTime.stopThread();
    }

    public void switchOn(){
    	System.out.println("on");
        this.on = true;
        this.worldTime = new WorldThread(this.controller.getBoard(),this.controller.getVueLevel(),this.controller,this);
        worldTime.start();
    }

    public boolean getOn(){
        return on;
    }
}
