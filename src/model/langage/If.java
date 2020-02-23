
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class If extends ControlFlowStatement {

    /**
     * Default constructor
     */
    public If(Personage personage) {
      super(personage);
    }

	public int run() {
		int verification = actions.peek().run();
		if(condition.isTrue()) {
			while(verification == 0) {	//do the no count actions.
				actions.poll();
				verification = actions.peek().run();
			}
			if(verification == 1) 
				actions.poll();
			
			if(actions.peek() != null)
				return 2;				//continue the list of actions while is not over
			
		}
		
		return 1;						//when the list of actions is over
	}
}
