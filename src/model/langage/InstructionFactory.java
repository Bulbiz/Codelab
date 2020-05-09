
package src.model.langage;

import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;
import src.model.world.Personage;

public class InstructionFactory {

    public static Instruction createInstruction(Instruction instruction) {
        return instruction.createNewInstruction();
    }

}