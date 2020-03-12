
package src.model.langage;

import java.io.File;
import org.json.*;

import src.model.world.*;

public class TestLanguageModel {
    public static void run() {
        System.out.println("--------------------------------");
        System.out.println("----- TEST LANGUAGE MODELE -----");
        System.out.println("------------- START ------------");
        try {
            TestJson();
        } catch (Exception e) { System.out.println("erreur test"); e.printStackTrace(); }
        
        System.out.println("-------------- END -------------");
    }

    static void TestJson() throws JSONException {
        Player player = new Player(null, 0, 0, 0);

        /* on creer deux instructions : un If et un Move */
        Action a = new Move(player);

        If i = new If(player);
        //i.setCondition(new PersonageEstDevant(player));
        i.addAction(new Move(player));        

        /* on les convertit en json et on affiche le résultat */
        JSONObject jsonIf = i.toJSON();
        JSONObject jsonAction = a.toJSON();

        System.out.println(jsonIf.toString(2));
        System.out.println(jsonAction.toString(2));

        /* on convertit les json en objet et on affiche le résultat */
        Action afromjson = (Action)InstructionFactory.loadInstructionFromJson(player, jsonAction);
        If ifromjson = (If)InstructionFactory.loadInstructionFromJson(player, jsonIf);
        
        ifromjson.printTypeAndVersion();
        afromjson.printTypeAndVersion();             
        
        
    }
}