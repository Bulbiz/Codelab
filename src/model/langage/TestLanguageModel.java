
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

    static JSONObject TestObjectToJson(Player player, Instruction i) throws JSONException {
        JSONObject json = i.toJSON();
        //System.out.println(json.toString(2));
        return json;
    }

    static Object TestJsonToObject(Player player, JSONObject json) {
        Instruction i = InstructionGenerator.createInstruction(player, json);
        //i.printTypeAndVersion();
        return i;
    }

    static void TestJson() throws JSONException {
        Player player = new Player(null, 0, 0, 0);

        Action a = new Move(player);

        If i = new If(player);
        i.setCondition(new PersonageEstDevant(player));
        i.addAction(new Move(player));

        JSONObject jsonIf = TestObjectToJson(player, i);
        JSONObject jsonAction = TestObjectToJson(player, a);

        Action afromjson = (Action)TestJsonToObject(player, jsonAction);
        If ifromjson = (If)TestJsonToObject(player, jsonIf);
        
    }
}