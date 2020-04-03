
public class CollectableGeneratorPanel extends JPannel{
	private PlacementButton key;
	private PlacementButton coin;
	
	public EntityGeneratorPanel (ControllerEditor c) {
		this.wall = new PlacementButton(c,(b,y,x) -> wallPlacement(b,y,x));
		this.floor = new PlacementButton(c,(b,y,x) -> floorPlacement(b,y,x));
		
	}
}
