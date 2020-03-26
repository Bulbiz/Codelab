package src.view.world;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class LoadLevel extends JPanel{

  private String name;
  private JTextField placeholder;
  private JButton confirm;

  public LoadLevel(String name){
    this.confirm = new JButton("Confirm");
    this.name = name;
    placeholder = new JTextField();
  }
}
