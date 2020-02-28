
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

    public ControlFlowStatement(Personage personage) {
        super(personage);
        swapActive = false;
        active = false;
        actions = new LinkedList<Action>();
    }

    /**
     *
     */
    protected Condition condition;

    /**
     *
     */
    protected Queue<Action> actions;
    protected boolean active; // true = the control struture is always active, false the control struture is
                              // end.
    protected boolean swapActive;

    /**
     * @return
     */
    public abstract int run();

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();

        json.put("type", getType());
        json.put("version", getVersion());
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
}
