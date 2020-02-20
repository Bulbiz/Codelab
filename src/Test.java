
package src;
import src.model.langage.*;
import src.model.world.*;
import src.view.langage.*;
import src.view.world.*;

class Test {
    public static void main(String[] args) {
        TestLanguageModel.run();
        TestWorldModel.run();
        TestLanguageView.run();
        TestWorldView.run();

        System.out.println("fin de test");
    }
}