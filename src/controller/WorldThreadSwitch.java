package src.controller;

public class WorldThreadSwitch {

    private  WorldThread worldTime;
	private ControllerLevel controller;
	private boolean on;

	public WorldThreadSwitch (ControllerLevel c) {
		this.controller = c;
        this.on = false;
	}


    public void switchOff(){
        this.on = false;
        this.worldTime.stopThread();
    }

    public void switchOn(){
        this.on = true;
        this.worldTime = new WorldThread(this.controller.getBoard(),this.controller.getVueLevel(),this.controller);
        worldTime.start();
    }

    public boolean getOn(){
        return on;
    }
}
