
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class If extends ControlFlowStatement {
	
	private boolean activated;

    public If(Personage personage) {
    	super(personage);
    	activated = false;
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
            if(condition.isTrue() && !activated) {
            	activated = true;
                return  InstructionEnum.noCostAction.getIdentity();
            }else {
            	activated = false;
            	return -1;
            }						//condition is not verify
        }
    }

	/*public int run() {

        if(actions.peek() == null)       // end actions list for the if
            return InstructionEnum.endAction.getReturnValue();

		int verification = actions.peek().run();

		while(verification == InstructionEnum.noCostAction.getIdentity()) {
			actions.poll();
            if(actions.peek() == null)
                return InstructionEnum.noCostAction.getReturnValue();
			verification = actions.peek().run();
		}

        if(verification == InstructionEnum.ControlFlowStatementAction.getIdentity()){			//if is a controle flow statement, don't depile
			return InstructionEnum.ControlFlowStatementAction.getReturnValue();
		}

		if(verification == InstructionEnum.basicAction.getIdentity()){
			actions.poll();
			return InstructionEnum.basicAction.getReturnValue();                          // continu to execute the actions list
		}
        return InstructionEnum.endAction.getReturnValue();
	}*/
    
    public int run() {
		int verification = actions.peek().run();
		while(verification == InstructionEnum.noCostAction.getIdentity()) {				//do the no count actions.
			actions.offer(actions.poll());		//add this action in the end of the actions list
			verification = actions.peek().run();
		}

		if(verification == InstructionEnum.ControlFlowStatementAction.getIdentity()){			//if is a controle flow statement, don't depile
			return InstructionEnum.ControlFlowStatementAction.getReturnValue();
		}

		if(verification == InstructionEnum.basicAction.getIdentity()){
			actions.offer(actions.poll());
			return InstructionEnum.basicAction.getReturnValue();					//when the list isn't over
		}

		return InstructionEnum.endAction.getReturnValue();						//when the list of actions is over
	}
}
