public class LevelPanel {
	private Level l;
	
	private BoardPanel worldView;
	
	public LevelPanel (Level l) {
		this.level = l;
		//To Finish
		this.worldView = new BoardPanel (l.getBoard());
	}
}
