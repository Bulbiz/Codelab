
package src.model.langage;

import java.util.*;
import src.model.world.*;
import src.controller.*;
/**
 *
 */
public class While extends ControlFlowStatement {

	private int limit = 0;

    public While(Personage personage) {
    	super(personage);
		this.addAction(new FinWhile(personage));
	}

    public Instruction createNewInstruction() {
        return new While(personage);
    }


	class FinWhile extends Action{

			public FinWhile(Personage personage){
				super(personage);
			}

			public Instruction createNewInstruction() {
				return new FinWhile(personage);
			}

			public int run(){
				if(condition.isTrue()){
					limit +=1;					//limit for the infinite loop
					return 0;
				}
				return -1;						//condition is not verify
			}
		}


	public int run() {
		 if(!hasBeenActionned) 
			   hasBeenActionned = true;

		int verification = actions.peek().run();
		while(verification == InstructionEnum.noCostAction.getIdentity()) {				//do the no count actions.
			actions.offer(actions.poll());		//add this action in the end of the actions list
			verification = actions.peek().run();
		}

		if(limit>100){
			System.out.println("Boucle infini");
			ControllerLevel.errorPopUp("An infinite loop is occuring in your code");
			ControllerLevel.isInfinite = true;
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
