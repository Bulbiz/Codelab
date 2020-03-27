package src.view.world;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class LoadLevel extends JPanel{

  private JTextField placeholder;
  private JButton confirm;

  public LoadLevel(){
    placeholder = new JTextField(50);
    this.add(placeholder);
    this.confirm = new JButton("Confirm");
    this.add(confirm);

    this.confirm.addActionListener((e) -> {
                                          try{
                                            LevelPanel vueLevel = new LevelPanel (this.placeholder.getText());
                                            JFrame testWindows = TestWorldView.createWindows (this.placeholder.getText());
                                            testWindows.setContentPane(vueLevel);
                                            testWindows.pack();
                                          } catch(Exception exc){
                                            System.out.println("Le niveau n'existe pas");
                                            //this.add(new JTextField("Le niveau portant le nom : " + this.placeholder.getText() + " n'existe pas"));
                                          }
                                          });
  }
}
