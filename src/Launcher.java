package src;

import src.model.langage.*;
import src.model.world.*;
import src.view.langage.*;
import src.view.world.*;
import src.view.*;
import src.editor.view.*;
import src.controller.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import org.json.*;
import java.io.*;

public class Launcher{
    //Auxiliary methods used for other purpose :

     public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch(Exception e){
                //Do nothing
            }
            MenuPanel.beginMenu();
        });
    }
}
