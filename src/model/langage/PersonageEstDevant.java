package src.model.langage;

import src.model.world.Personage;

public class PersonageEstDevant extends Condition {

    public PersonageEstDevant(Personage personage) {
        super(personage);
    }

    public Instruction createNewInstruction() {
        return new PersonageEstDevant(personage);
    }

    @Override
    public boolean isTrue() {
        // TODO Auto-generated method stub
        return false;
    }

}