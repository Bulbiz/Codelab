
package src.model.langage;

import src.model.world.Personage;

public class False extends Condition {

    public False(Personage personage) {
        super(personage);
    }

    @Override
    public boolean isTrue() {
        return false;
    }


}