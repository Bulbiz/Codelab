package src.story;

import src.model.language.*;
import src.view.world.*;
import javax.swing.*;
import java.awt.*;
import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;

public class StoryPanel extends JPanel{
	private int advancement;
	private static final int nbOfLevel = 9;
	private LevelPanel level;
	private String storyMessage;
	private String storyHint;
	private JFrame parent;
	private  static ImageLibrary sprite = initiateSprite();

	public StoryPanel (JFrame parent) {
		this.parent = parent;
		this.advancement = getAdvancement();
		this.storyHint = "Bonne Chance !";
		if(advancement > nbOfLevel) {
			this.add(victoryPanel());
			setAdvancement(1);
		}else {		
			org.json.simple.JSONObject json = readJSON("story/" + advancement);
			this.storyMessage = json.get("story") != null ? json.get("story").toString() : "Start !";
			this.storyHint = json.get("hint") != null ? json.get("hint").toString() : "Bonne Chance !";
			this.level = new StoryLevel("story/" + advancement, this);
			this.level.loadResourcePanel(advancement);
			this.level.setLevelFrame(parent);			
			this.add(level);
			storyPopUp(storyMessage);
		}
	}

	private static ImageLibrary initiateSprite() {
		ImageLibrary sprite = new ImageLibrary ();
		sprite.loadDialogue();
		sprite.loadStoryFinished();
		return sprite;
	}
	private static int getAdvancement() {
		org.json.simple.JSONObject save = readJSON ("story/sauvegarde");
		return Integer.parseInt(save.get("advancement").toString());
	}

	private static void setAdvancement(int advancement) {
		try {
			JSONObject jsonAdv = new JSONObject();
			jsonAdv.put("advancement", advancement);
			FileWriter fw = new FileWriter("resources/story/sauvegarde.json");
			fw.write(jsonAdv.toString());
			fw.flush();
		}catch(Exception e) {

		}
	}

	private JPanel victoryPanel() {
		JPanel victory = new JPanel ();
		JButton b = new JButton("<--");
		b.addActionListener((e) -> {
			parent.dispose();
			MenuPanel.beginMenu();
		});
		victory.add(b);
		victory.add(new JLabel(sprite.getSprite("storyFinished")));
		return victory;
	}

	public void nextLevel() {
		System.out.println(advancement);
		loadNextLevel(advancement+1);
		this.parent.dispose();
	}

	private static void loadNextLevel(int advancement) {
		JFrame windows = MenuPanel.createWindows();
		setAdvancement(advancement);
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
		JOptionPane.showMessageDialog(null,message,"Story",JOptionPane.DEFAULT_OPTION,sprite.getSprite("dialogue"));
	}

	private static org.json.simple.JSONObject readJSON (String name){
    	try {
    		JSONParser jsonParser = new JSONParser();
    		FileReader reader = new FileReader("resources/" + name + ".json");
    		Object obj = jsonParser.parse(reader);
    		org.json.simple.JSONObject jsonLevel = (org.json.simple.JSONObject) obj;
    		return jsonLevel;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
	}
	
	public String getHint() {
		return this.storyHint;
	}
}
