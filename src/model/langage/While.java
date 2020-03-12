
package src.model.langage;

import java.util.*;
import src.model.world.*;
/**
 *
 */
public class While extends ControlFlowStatement {

	private int limit = 0;

    public While(Personage personage) {
    	super(personage);
		this.addAction(new FinWhile(personage));
    }


	class FinWhile extends Action{

			public FinWhile(Personage personage){
				super(personage);
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


		int verification = actions.peek().run();
		while(verification == 0) {				//do the no count actions.
			actions.offer(actions.poll());		//add this action in the end of the actions list
			verification = actions.peek().run();
		}

		if(limit>100){
			System.out.println("Boucle infini");
			System.exit(0);
		}

		if(verification == 2){			//if is a controle flow statement, don't depile
			return 2;
		}

		if(verification == 1){
			actions.offer(actions.poll());
			return 2;					//when the list isn't over
		}

		return 1;						//when the list of actions is over
	}
}
