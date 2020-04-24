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
    //Auxiliary methods used for other purpose :
    
    public static void loadLevelForMenu(){
        try{
            JFrame testLoad = TestWorldView.createWindows ("TestLoad");
            testLoad.setContentPane(new LoadLevel(testLoad));
            testLoad.pack();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void editorForMenu(){
        JFrame testWindows = TestWorldView.createWindows ("Test");
        ControllerEditor controller = new ControllerEditor();
        EditorPanel editorPanel = new EditorPanel(controller);
        controller.setPanels(editorPanel);
        testWindows.setContentPane(editorPanel);
        testWindows.pack();
    }

    private static void testEditorButton(){
    	JFrame testWindows = TestWorldView.createWindows ("Test");

        ControllerEditor controller = new ControllerEditor();
        EditorPanel editorPanel = new EditorPanel(controller);
        controller.setPanels(editorPanel);
        testWindows.setContentPane(editorPanel);
        testWindows.pack();
    }
    
    //Executing the game
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
