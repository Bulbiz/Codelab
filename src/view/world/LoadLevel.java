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

    this.confirm.addActionListener((e) ->{
                                          System.out.println(this.placeholder.getText());
                                        });
  }
}
