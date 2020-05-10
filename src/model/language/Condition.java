
package src.model.language;

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


    public abstract boolean isTrue();
        

    public String getType() { return "condition"; }

}
