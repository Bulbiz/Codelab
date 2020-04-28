package src.view.world;
import src.controller.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import src.Test;


public class LoadLevel extends JPanel{

  private JTextField placeholder;
  private JButton confirm;
  private JFrame parent;
  private JButton backToMenu;

  public LoadLevel(JFrame parent){
    this.backToMenu = new JButton("<--");
    this.add(backToMenu);
    placeholder = new JTextField(50);
    this.parent = parent;
    this.add(placeholder);
    this.confirm = new JButton("Confirm");
    this.add(confirm);


    this.confirm.addActionListener((e) -> {
	    if(!ControllerEditor.nameUnique(this.placeholder.getText())){
		LevelPanel vueLevel = new LevelPanel (this.placeholder.getText());
		JFrame testWindows = MenuPanel.createWindows ();
		testWindows.setContentPane(vueLevel);
        vueLevel.setLevelFrame(testWindows);
		testWindows.pack();
		parent.dispose();
	    } else {
		ControllerLevel.errorPopUp("Le niveau portant le nom : \"" + this.placeholder.getText() + "\" n'existe pas");
		//this.add(new JTextField("Le niveau portant le nom : " + this.placeholder.getText() + " n'existe pas"));
	    }
	});

    this.backToMenu.addActionListener((e) -> {
        parent.dispose();
        MenuPanel.beginMenu();
	});
  }
}
