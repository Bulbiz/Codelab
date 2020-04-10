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

    public MenuPanel(JFrame parent){
        GridLayout g = new GridLayout(1,2);
        g.setHgap(200);
        this.setLayout(g);

        JButton load = new JButton("Load");
        JButton editor = new JButton("Editor");

        load.addActionListener((e) -> {
            Test.loadLevelForMenu();
            parent.dispose();
        });

        editor.addActionListener((e) -> {
            Test.editorForMenu();
            parent.dispose();
        });

        this.add(load);
        this.add(editor);
    }
}
