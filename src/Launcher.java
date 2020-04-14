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
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Launcher{
    
    public static void beginMenu(){
        try{
            JFrame menuPanel = TestWorldView.createWindows ("Main Menu");
            menuPanel.setContentPane(new MenuPanel(menuPanel));
            menuPanel.pack();
        }catch(Exception e){
            ControllerLevel.errorPopUp("Codelab3 n'a pas pu être chargé");
	    System.exit(0);
        }
    }

     public static void main(String[] args) throws Exception {
        beginMenu();
    }
}
