
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class If extends ControlFlowStatement {


    public If(Personage personage) {
    	super(personage);
        this.addAction(new FinIf(personage));
    }

    class FinIf extends Action{

        public FinIf(Personage personage){
            super(personage);
        }

        public int run(){
            if(condition.isTrue())
                return 0;
            return -1;						//condition is not verify
        }
    }

	public int run() {

		int verification = actions.peek().run();
		while(verification == 0) {
			actions.poll();
			verification = actions.peek().run();
		}

		if(verification == 1){
			actions.poll();
			return 2;                          // continu to execute the actions list
		}

        if(verification == 2){			//if is a controle flow statement, don't depile
			return 2;
		}

        return 1;                              // end actions list for the if
	}

}
