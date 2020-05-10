package src.model.language;

import java.util.LinkedList;
import java.util.Queue;
import src.model.world.Personage;

public class IfElse extends If {

    public Queue<Action> elseActions;
    public Queue<Action> ifActions;

    public IfElse(Personage personage) {
        super(personage);
        ifActions = actions;
        elseActions = new LinkedList<Action>();
    }

    public void setElseActions(Queue<Action> q) {
        elseActions.clear();
        elseActions.add(new FinIfElse(personage));
        elseActions.addAll(q);
    }
    
    public Instruction createNewInstruction() {
        return new IfElse(personage);
    }

    public void setPersonage(Personage pers) {
        this.personage = pers;
        if (condition != null)
            condition.setPersonage(pers);
        for (Action a : ifActions) 
            a.setPersonage(pers);
        for (Action a : elseActions) 
            a.setPersonage(pers);
    }

    protected Fin getConditionCheck() {
        return new FinIfElse(personage);
    }
    
    class FinIfElse extends FinIf {

        public FinIfElse(Personage personage){
            super(personage);
        }

        public Instruction createNewInstruction() {
            return new FinIfElse(personage);
        }

        public int run(){
            actions = condition.isTrue() ? ifActions : elseActions;
            
            return 0;
        }
    }
}