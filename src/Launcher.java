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

    private static void changePolice (){
        UIDefaults dd = UIManager.getDefaults();
        for(Enumeration e = dd.keys(); e.hasMoreElements();){
            Object obj = e.nextElement();
            if(obj.toString().endsWith("font"))
                UIManager.put(obj,new Font("SANS_SERIF", Font.BOLD,15));
        }
    }

     public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                changePolice();
            }catch(Exception e){
                //Do nothing
            }
            MenuPanel.beginMenu();
        });
    }
}
