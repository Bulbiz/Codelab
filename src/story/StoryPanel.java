package src.story;

import src.model.langage.*;
import src.view.world.*;
import javax.swing.*;
import java.awt.*;
import org.json.simple.JSONObject;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StoryPanel extends JPanel{
	private int advancement;
	private static final int nbOfLevel = 3;
	private LevelPanel level;
	private String storyMessage;
	private JFrame parent;
	
	public StoryPanel (JFrame parent) {
		this.parent = parent;
		if(advancement > nbOfLevel) {
			this.add(victoryPanel());
		}else {
			System.out.println("new Level" + advancement);
			this.advancement = getAdvancement();
			this.level = new StoryLevel("story/" + advancement, this);
			this.storyMessage = readJSON("story/" + advancement).get("story").toString();
			this.add(level);
			storyPopUp(storyMessage);
		}
	}
	
	private int getAdvancement() {
		JSONObject save = readJSON ("story/sauvegarde");
		return Integer.parseInt(save.get("advancement").toString());
	}
	
	private JPanel victoryPanel() {
		JPanel victory = new JPanel ();
		victory.add(new JLabel("Ouais cette page est moche mais tu as gagné !"));
		return victory;
	}
	
	public void nextLevel() {
		loadNextLevel(advancement+1);
		this.parent.dispose();
	}
	
	private static void loadNextLevel(int advancement) {
		JFrame windows = createWindows("Story");
		windows.setContentPane(new StoryPanel(windows));
		windows.pack();
	}
	
	private static JFrame createWindows (String title) {
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setMinimumSize(new Dimension(1300,700));
        frame.setVisible(true);
        return frame;
	}
	
	private static void storyPopUp(String message){
		Object[] options = {"OK"};
		JOptionPane.showOptionDialog(null, message, "Histoire",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, options[0]);
	}
	
	private JSONObject readJSON (String name){
    	try {
    		JSONParser jsonParser = new JSONParser();
    		FileReader reader = new FileReader("resources/" + name + ".json");
    		Object obj = jsonParser.parse(reader);
    		JSONObject jsonLevel = (JSONObject) obj;
    		return jsonLevel;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}