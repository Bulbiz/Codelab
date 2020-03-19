
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

    /*public static void testJson(){
        try{
            String s = "{\"name\":\"John\"}";
            File f = new File("niveau1.json");
            System.out.println(f == null);

            System.out.println(json.getString("name"));
        }catch(Exception e){
            System.out.println("erreur");
        }
    }*/

    public static void main(String[] args) throws Exception {
        /*TestLanguageModel.run();
        TestWorldModel.run();
        TestLanguageView.run();
        TestWorldView.run();*/

        Cell c = new Cell();
        ArrayList<Personage> p = new ArrayList();
        Board b = new Board(1,1,p);
        b.toJson();
        //int x = 5;
        //int y = 7;
        //b.CellToJson(c,x,y);

        //testJson();
       // begin();
        System.out.println("fin de test");
    }
}
