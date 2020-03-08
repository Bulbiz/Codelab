
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class If extends ControlFlowStatement {


    public If(Personage personage) {
    	super(personage);
    }

	public int run() {
        class FinIf extends Action{

			public FinIf(Personage personage){
				super(personage);
				FinIf end = new FinIf(personage);
				actions.add(end);		//add the condition for the verification
			}

			public int run(){
				if(condition.isTrue())
					return 0;
				return -1;						//condition is not verify
			}
		}

		int verification = actions.peek().run();
		while(actions != null && verification == 0) {
			actions.poll();
			verification = actions.peek().run();
		}

		if(actions != null && verification == 1){
			actions.poll();
			return 2;                          // continu to execute the actions list
		}
        return 1;                              // end actions list for the if
	}

}
