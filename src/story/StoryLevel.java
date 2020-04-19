package src.story;

import src.view.world.*;
import javax.swing.*;
import java.awt.*;

public class StoryLevel extends LevelPanel{
	
	private StoryPanel story;
	
	public StoryLevel(String name,StoryPanel story) {
		super(name);
		this.story = story;
	}
	
	public void endOfLevel() {
		this.story.nextLevel();
	}
}
