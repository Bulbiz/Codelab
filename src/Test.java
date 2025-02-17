package src;

import src.model.language.*;
import src.model.world.*;
import src.view.language.*;
import src.view.world.*;
import src.editor.view.*;
import src.controller.*;
import src.story.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import org.json.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

    public static String jsonToStringPersonage(){
        String s = "";
        try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("resources/test.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonLevel = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray)jsonLevel.get("perso");
            for (Object o : jsonArray) {
                JSONObject jo = (JSONObject) o;
                s += jo.get("namePerso") + ",";
                s += jo.get("xPosition") + ",";
                s += jo.get("yPosition") + ",";
                s += jo.get("facing") + "|";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public static String jsonToStringDecor(){
        String s = "";
        try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("resources/test.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonLevel = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray)jsonLevel.get("decor");
            for (Object o : jsonArray) {
                JSONObject jo = (JSONObject) o;
                s += jo.get("nameDecor") + "|";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(s);
        return s;
    }


    public static String jsonToStringEntity(){
        String s = "";
        try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("resources/test.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonLevel = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray)jsonLevel.get("entity");
            for (Object o : jsonArray) {
                JSONObject jo = (JSONObject) o;
                s += jo.get("nameEntity") + ",";
                s += jo.get("xPosition") + ",";
                s += jo.get("yPosition") + "|";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public static String jsonToStringGoal(){
        String s = "";
        try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("resources/test.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonLevel = (JSONObject) obj;
            JSONObject goal = (JSONObject) jsonLevel.get("goal");
            s += (String) goal.get("xPosition") + "," + (String) goal.get("yPosition");
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }

    private static void testPasDansLeMainThierry() {
        //Cell c = new Cell();
        //ArrayList<Personage> p = new ArrayList();
        //Board b = new Board(1,1,p);
        //b.toJson();
        //int x = 5;
        //int y = 7;
        //b.CellToJson(c,x,y);
        System.out.println(jsonToStringPersonage());
        System.out.println(jsonToStringDecor());
        System.out.println(jsonToStringEntity());
        System.out.println(jsonToStringGoal());
    }

    public static void begin(){
      try{
        /*JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/test.json");
        Object obj = jsonParser.parse(reader);
        JSONObject jsonLevel = (JSONObject) obj;
        //RECUPERATION DE JSON
        Level levelTest = new Level("test");*/
        /**/LevelPanel vueLevel = new LevelPanel ("test");
        JFrame testWindows = MenuPanel.createWindows ();
        testWindows.setContentPane(vueLevel);
        testWindows.pack();/**/
        /*JFrame testLoad = MenuPanel.createWindows ();
        testLoad.setContentPane(new LoadLevel());
        testLoad.pack(); */
      }catch(Exception e){
        e.printStackTrace();
      }
    }

    private static void testEditorButton(){
    	JFrame testWindows = MenuPanel.createWindows ();

        ControllerEditor controller = new ControllerEditor();
        EditorPanel editorPanel = new EditorPanel(controller, testWindows);
        controller.setPanels(editorPanel);
        testWindows.setContentPane(editorPanel);
        testWindows.pack();
    }

    public static void main(String[] args) throws Exception {
        //TestLanguageModel.run();
        //TestWorldModel.run();
        //TestLanguageView.run();
        //TestWorldView.run();
        //testPasDansLeMainThierry();
    	//testEditorButton();
        //begin();
    	// beginMenu();
    	//testStory();
        //ControllerLevel.errorPopUp("Rémy répond pas dans Discord ce con...");
        System.out.println("fin de test");
    }
}
