
package src;
import src.model.langage.*;
import src.model.world.*;
import src.view.langage.*;
import src.view.world.*;
import src.view.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
//import org.json.*;
import java.io.*;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Test {
    //test of running the project
    public static void begin(){
     /* ArrayList<Personage> p = new ArrayList();
      Board b = new Board(6, 1, p);
      Player steve = new Player(b, 6, 15, 1);
      Queue<src.model.langage.Action> action = new LinkedList <src.model.langage.Action>();
      While w = new While (steve);                    //test pour le while avec un mouvement
      w.addAction(new Move(steve));
      w.addAction(new TurnLeft(steve));
      w.setCondition(new ConditionTrue(steve));
      action.add(w);

      /*If i = new If(steve);                             //test pour le if
      i.addAction(new Move(steve));
      i.addAction(new TurnLeft(steve));
      i.addAction(new Move(steve));
      i.setCondition(new ConditionTrue(steve));
      action.add(i);*/

      steve.setActions(action);
      b.initiateEntity(6,15,steve);
      p.add(steve);
      Level levelTest = new Level(b,1,null);
      LevelPanel vueLevel = new LevelPanel (levelTest, steve);
      JFrame testWindows = TestWorldView.createWindows ("Test");
      testWindows.setContentPane(vueLevel);
      testWindows.pack();*/
    }




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
        System.out.println(jsonToStringPersonage());
        System.out.println(jsonToStringDecor());
        System.out.println(jsonToStringEntity());
        System.out.println(jsonToStringGoal());
       // begin();
        System.out.println("fin de test");
    }
}
