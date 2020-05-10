
package src.model.langage;

import src.model.world.*;
/**
 *
 */
public class CoinFront extends Condition {


    public CoinFront(Personage personage) {
    	super(personage);
    }

    public Instruction createNewInstruction() {
        return new CoinFront(personage);
    }


    public boolean isTrue() {
        return personage.coinFront();
    }
    
    public String toString() {
        return "Coin is ahead";
    }

}
