
package src.model.langage;

import src.model.world.Personage;

public class Not extends Condition {

    public Not(Personage personage) {
        super(personage);
    }

    Condition condition;

    public void setCondition(Condition c) {
        condition = c;
    }    

    public boolean isTrue() {
        return !condition.isTrue();
    }
    
}