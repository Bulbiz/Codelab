package src.view.world;

import src.story.*;
import src.editor.view.*;
import src.controller.*;
import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{
	private ImageLibrary menuSprite;
	
    public MenuPanel(JFrame parent){
    	this.menuSprite = new ImageLibrary ();
    	this.menuSprite.loadMenuImage();
    	
        GridLayout g = new GridLayout(1,3);
       // g.setHgap(50);
        this.setLayout(g);

        JButton story = new JButton(this.menuSprite.getSprite ("story"));
        JButton load = new JButton(this.menuSprite.getSprite ("load"));
        JButton editor = new JButton(this.menuSprite.getSprite ("editor"));

        story.addActionListener((e) -> {
            MenuPanel.storyForMenu();
            parent.dispose();
        });
        
        load.addActionListener((e) -> {
        	MenuPanel.loadLevelForMenu();
            parent.dispose();
        });

        editor.addActionListener((e) -> {
        	MenuPanel.editorForMenu();
            parent.dispose();
        });

        this.add(story);
        this.add(load);
        this.add(editor);
    }
    
    public static void storyForMenu(){
    	JFrame testWindows = createWindows ();
        testWindows.setContentPane(new StoryPanel(testWindows));
        testWindows.pack();
    }
    
    public static void beginMenu(){
        try{
            JFrame testMenuPanel = createWindows ();
            testMenuPanel.setContentPane(new MenuPanel(testMenuPanel));
            testMenuPanel.pack();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void editorForMenu(){
        JFrame testWindows = createWindows ();
        ControllerEditor controller = new ControllerEditor();
        EditorPanel editorPanel = new EditorPanel(controller, testWindows);
        controller.setPanels(editorPanel);
        testWindows.setContentPane(editorPanel);
        testWindows.pack();
    }
    
    public static void loadLevelForMenu(){
        try{
            JFrame testLoad = createWindows ();
            testLoad.setContentPane(new LoadLevel(testLoad));
            testLoad.pack();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static JFrame createWindows () {
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CodeLab de Bronze");
        frame.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
	}
}
