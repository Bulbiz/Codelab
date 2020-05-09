
package src.model.langage;

import src.model.world.*;

import java.util.Queue;

import src.controller.*;
/**
 *
 */
public class While extends ControlFlowStatement {

	private int limit = 0;

    public While(Personage personage) {
    	super(personage);
	}

    public Instruction createNewInstruction() {
        return new While(personage);
    }


	class FinWhile extends Fin {

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

	protected Fin getConditionCheck() {
		return new FinWhile(personage);
	}

	public void setActions(Queue<Action> q) {
		super.setActions(q);
		limit = 0;
	}
	
	public int run() {

		int verification = actions.peek().run();
		int countUseless = 0;
		while(verification == InstructionEnum.noCostAction.getIdentity() && countUseless < 30) {				//do the no count actions.
			actions.offer(actions.poll());		//add this action in the end of the actions list
			verification = actions.peek().run();
			countUseless ++;
		}
		if (countUseless >= 30) {
			return InstructionEnum.endAction.getReturnValue();
		}

		if(limit>10000){
			ControllerLevel.errorPopUp("An infinite loop is occuring in your code");
			ControllerLevel.isInfinite = true;
			limit = 0;
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

	protected void addFirstAction() {
		this.actions.add(new FinWhile(personage));
	}
}
