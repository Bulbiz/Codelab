package src.story;

import src.view.world.*;

public class StoryLevel extends LevelPanel{
	
	private StoryPanel story;
	
	public StoryLevel(String name,StoryPanel story) {
		super(name);
		this.story = story;
		setMessageText(story.getHint());
	}
	
	public void endOfLevel() {
		this.story.nextLevel();
	}
}
