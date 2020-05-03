
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class If extends ControlFlowStatement {
	protected Queue<Action> save;
    
    public If(Personage personage) {
        super(personage);        
        this.save = new LinkedList<Action> ();
        this.actions = new LinkedList<Action>();
        addFirstAction();
    }

    protected void addFirstAction() {
        this.addAction(new FinIf(personage));
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
    
    private void transfertSavetoAction () {
        this.actions.clear();
        this.actions.addAll(this.save);
        this.save.clear();
    }
    
	public int run() {
	   if(!hasBeenActionned) 
		   hasBeenActionned = true;
	   
       if(actions.peek() == null) {// end actions list for the if
    	   	transfertSavetoAction();
            return InstructionEnum.endAction.getReturnValue();
        }
       
		int verification = actions.peek().run();

		while(verification == InstructionEnum.noCostAction.getIdentity()) {
			save.offer(actions.poll());
            if(actions.peek() == null) {
            	transfertSavetoAction();
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
