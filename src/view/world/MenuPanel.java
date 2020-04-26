package src.view.world;
import src.*;
import src.model.langage.*;
import src.model.world.*;
import src.view.langage.*;
import src.view.world.*;
import src.view.*;
import src.controller.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

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
            Test.storyForMenu();
            parent.dispose();
        });
        
        load.addActionListener((e) -> {
            Test.loadLevelForMenu();
            parent.dispose();
        });

        editor.addActionListener((e) -> {
            Test.editorForMenu();
            parent.dispose();
        });

        this.add(story);
        this.add(load);
        this.add(editor);
    }
}
