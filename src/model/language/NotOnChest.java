package src.model.language;

import src.model.world.Personage;

public class NotOnChest extends Condition {

    public NotOnChest(Personage personage) {
        super(personage);
    }

    public boolean isTrue() {
        return true;
    }

    @Override
    public Instruction createNewInstruction() {
        return new NotOnChest(personage);
    }
    
    public String toString() {
        return "Goal isn't reached";
    }
}