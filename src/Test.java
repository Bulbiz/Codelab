
package src;
import src.model.langage.*;
import src.model.world.*;
import src.view.langage.*;
import src.view.world.*;
import src.view.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import org.json.*;
import java.io.*;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Test {
    //test of running the project
    public static void begin(){
     /* ArrayList<Personage> p = new ArrayList();
      Board b = new Board(6, 1, p);
      Player steve = new Player(b, 6, 15, 1);
      Queue<src.model.langage.Action> action = new LinkedList <src.model.langage.Action>();
      action.offer(new TurnLeft(steve));
      for(int i = 5; i>1; i--){
        action.offer(new Move(steve));
      }
      action.offer(new TurnLeft(steve));
      for(int i = 5; i>1; i--){
          action.offer(new Move(steve));
        }
      action.offer(new TurnRight(steve));
      for(int i = 5; i>1; i--){
          action.offer(new Move(steve));
        }
      action.offer(new TurnRight(steve));
      for(int i = 5; i>1; i--){
          action.offer(new Move(steve));
        }
      steve.setActions(action);
      b.initiateEntity(6,15,steve);
      p.add(steve);
      Level levelTest = new Level(b,1,null);
      LevelPanel vueLevel = new LevelPanel (levelTest);
      JFrame testWindows = TestWorldView.createWindows ("Test");
      testWindows.setContentPane(vueLevel);
      testWindows.pack();*/
    }




    /*public static String jsonToStringPersonage(){
        String s = "";
        try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("resources/test.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonLevel = (JSONObject) obj;
            JSONObject perso = (JSONObject) jsonLevel.get("perso");
            System.out.println(s);
        }catch(Exception e){
            System.out.println("erreur");
        }
        return s;
    }*/

    public static String jsonToStringDecor(){
        String s = "";
        try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("resources/test.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonLevel = (JSONObject) obj;
            JSONObject decor = (JSONObject) jsonLevel.get("decor");

            s = (String) decor.get("nameDecor");
            System.out.println(s);
        }catch(Exception e){
            System.out.println("erreur");
        }
        return s;
    }


    public static String jsonToStringEntity(){
        String s = "";
        try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("resources/test.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonLevel = (JSONObject) obj;
            JSONObject entity = (JSONObject) jsonLevel.get("entity");
            s = (String) entity.get("nameEntity");
            s += "," + (String) entity.get("xPosition");
            s += "," + (String) entity.get("yPosition");
            System.out.println(s);
        }catch(Exception e){
            System.out.println("erreur");
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
            s = (String) goal.get("xPosition");
            s += "," + (String) goal.get("yPosition");
            System.out.println(s);
        }catch(Exception e){
            System.out.println("erreur");
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        /*TestLanguageModel.run();
        TestWorldModel.run();
        TestLanguageView.run();
        TestWorldView.run();*/

        Cell c = new Cell();
        ArrayList<Personage> p = new ArrayList();
        Board b = new Board(1,1,p);
        //b.toJson();
        //int x = 5;
        //int y = 7;
        //b.CellToJson(c,x,y);
        //jsonToStringPersonage();
        jsonToStringDecor();
        jsonToStringEntity();
        jsonToStringGoal();
       // begin();
        System.out.println("fin de test");
    }
}
