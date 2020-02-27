
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class While extends ControlFlowStatement {

	private Queue<Action> actionsSave;
	
    public While(Personage personage) {
    	super(personage);
    }

	public int run() {
		if(condition.isTrue() && !swapActive) {		//if the condition is true, preserve the condition until the end
			active = true;
			swapActive = true;
			actionsSave = actions;
		}
		if(active) {
			int verification = actions.peek().run();
			while(verification == 0) {	//do the no count actions.
				actions.poll();
				verification = actions.peek().run();
			}
			if(verification == 1) 
				actions.poll();
			
			if(actions.peek() != null)
				return 2;				//continue the list of actions while is not over
			
			active = condition.isTrue();		//uptate the condition for the while
			if(active) {
				actions = actionsSave;
				return 2;
			}else {
				swapActive = false;
			}
				
			
		}
		
		return 1;						//when the list of actions is over
	}
}
