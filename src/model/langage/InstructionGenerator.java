
package src.model.langage;

import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONArray;
import org.json.JSONObject;

import src.model.world.Personage;

class InstructionGenerator {

    //TODO gestion des erreurs
    public static Queue<Instruction> createInstructions(Personage pers, JSONArray json_instructions) {

        Queue<Instruction> queue = new LinkedList<Instruction>();
        Instruction instruction;

        for (int i = 0; i < json_instructions.length(); i++) {
            try {
                instruction = createInstruction(pers, json_instructions.getJSONObject(i));
                queue.add(instruction);
            } catch (Exception e) { return null; }
        }

        return null;
    }

    //TODO gestion des erreurs 
    public static Instruction createInstruction(Personage pers, JSONObject json_instruction) {

        try {
            String type = json_instruction.getString("type"); 
            String version = json_instruction.getString("version");
        
            switch (type) {
                case "condition": return createCondition(pers, version);
                case "action": return createAction(pers, version);
                case "flow_control_statement": return createFlowControlStatement(pers, version, json_instruction);
                default: return null;
            }
        } catch (Exception e) { return null; }
    }

    private static Condition createCondition(Personage pers, String version) {
        //TODO implement here
        switch (version) {
            case "personageestdevant": return new PersonageEstDevant(pers);
            default: return null;
        }
    }

    private static Action createAction(Personage pers, String version) {
        switch(version) {
            case "move": return new Move(pers);
            case "turnleft": return new TurnLeft(pers);
            case "turnright": return new TurnRight(pers);
            case "stay": return new Stay(pers);
            default: return null;
        }
    }

    private static ControlFlowStatement createFlowControlStatement(Personage pers, String version, JSONObject json) {
        
        ControlFlowStatement i = null;

        switch(version) {
            case "if": i = new If(pers); break;
            case "while": i = new While(pers); break;
        }

        try {
            String conditionVersion = json.getJSONObject("condition").getString("version");
            i.setCondition((Condition)createCondition(pers, conditionVersion));
        } catch (Exception e) { return null; }        

        return i;
    }

    /**/
}