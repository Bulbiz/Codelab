
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class If extends ControlFlowStatement {
	private Queue<Action> save;
	private boolean hasBeenActionned;
	
    public If(Personage personage) {
    	super(personage);
        this.addAction(new FinIf(personage));
        this.save = new LinkedList<Action> ();
        this.hasBeenActionned = false;
    }

    public Instruction createNewInstruction() {
        return new If(personage);
    }

    class FinIf extends Action {

        public FinIf(Personage personage){
            super(personage);
        }

        public Instruction createNewInstruction() {
            return new FinIf(personage);
        }

        public int run(){
            if(condition.isTrue())
                return 0;
            return -1;						//condition is not verify
        }
    }

    @Override
    public void addAction(Action action) {
    	if(hasBeenActionned) {
    		hasBeenActionned = false;
    		this.actions = new LinkedList<Action>();
    	}
        actions.add(action);
    }
    
	public int run() {
	   if(!hasBeenActionned) 
		   hasBeenActionned = true;
	   
	   System.out.println("actionned");
       if(actions.peek() == null) {// end actions list for the if
        	this.actions = this.save;
        	this.save = new LinkedList<Action> ();
            return InstructionEnum.endAction.getReturnValue();
        }
       
		int verification = actions.peek().run();

		while(verification == InstructionEnum.noCostAction.getIdentity()) {
			save.offer(actions.poll());
            if(actions.peek() == null) {
            	this.actions = this.save;
            	this.save = new LinkedList<Action> ();
                return InstructionEnum.noCostAction.getReturnValue();
            }
			verification = actions.peek().run();
		}

        if(verification == InstructionEnum.ControlFlowStatementAction.getIdentity()){			//if is a controle flow statement, don't depile
			return InstructionEnum.ControlFlowStatementAction.getReturnValue();
		}

		if(verification == InstructionEnum.basicAction.getIdentity()){
			save.offer(actions.poll());
			return InstructionEnum.basicAction.getReturnValue();                          // continu to execute the actions list
		}
        return InstructionEnum.endAction.getReturnValue();
	}
}
