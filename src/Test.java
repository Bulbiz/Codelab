
package src;
import src.model.langage.*;
import src.model.world.*;
import src.view.langage.*;
import src.view.world.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;


class Test {
    //test of running the project
    public static void begin(){
      ArrayList<Personage> p = new ArrayList();
      Board b = new Board(6, 1, p);
      Player steve = new Player(b, 6, 15, 1);
      Queue<src.model.langage.Action> action = new LinkedList <src.model.langage.Action>();

      for(int i = 15; i>1; i--){
        action.offer(new Move(steve));
      }
      steve.setActions(action);
      b.initiateEntity(15,6,steve);
      p.add(steve);
      Level levelTest = new Level(b,1,null);
      LevelPanel vueLevel = new LevelPanel (levelTest);
      JFrame testWindows = TestWorldView.createWindows ("Test");
      testWindows.setContentPane(vueLevel);
      testWindows.pack();
    }

    public static void main(String[] args) {
        TestLanguageModel.run();
        TestWorldModel.run();
        TestLanguageView.run();
        TestWorldView.run();

        /*begin();*/

        System.out.println("fin de test");
    }
}
