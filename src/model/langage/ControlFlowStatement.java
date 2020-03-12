
package src.model.langage;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import src.model.world.*;

/**
 *
 */
public abstract class ControlFlowStatement extends Action {

    protected Condition condition;
    protected Queue<Action> actions;

    public ControlFlowStatement(Personage personage) {
        super(personage);
        actions = new LinkedList<Action>();
    }

    /**
     * @return
     */
    public abstract int run();

    public JSONObject toJSON() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("type", getType());
        json.put("version", getVersion());

        if (condition != null)
            json.put("condition", condition.toJSON());

        JSONArray json_array = new JSONArray();
        for (Action a : actions)
            json_array.put(a.toJSON());
        json.put("actions", json_array);

        return json;
    }

    public String getType() { return "flow_control_statement"; }

    public void setCondition(Condition c) {
        this.condition = c;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void printTypeAndVersion() {
        super.printTypeAndVersion();

        System.out.print("condition : ") ;
        if (condition != null)
            condition.printTypeAndVersion();
        else
            System.out.println("null");

        System.out.print("liste actions :");
        for (int i = 0; i < actions.size(); i++) {
            Action a = actions.poll();
            System.out.print("action");
            a.printTypeAndVersion();
            System.out.println();
        }

        System.out.println();
    }
}
