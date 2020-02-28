
package src.model.langage;

import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

import src.model.world.*;

/**
 *
 */
public abstract class Condition extends Instruction {

    public Condition(Personage personage) {
        super(personage);
    }

    /**
     * @return
     */
    public boolean isTrue() {
        // TODO implement here
        return false;
    }

    public String getType() { return "condition"; }

}
