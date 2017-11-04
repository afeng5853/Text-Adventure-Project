package Item;
import java.util.*;

import people.Person;

/**
 * The Orange consumable restores the HP of the player. 
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/31/17
 */

public class Orange extends Consumables {
	
	//field
	public final static int HP_RESTORE = 4;
	
	//constructors
	public Orange() {
		super(HP_RESTORE);
	}
	
	public Orange(Person p) {
		super(p, HP_RESTORE);
	}
	
	//methods
	@Override
	public String toString() {
		return "Orange";

	}
	
	@Override
	public String getInfo() {
		return "Exploring a haunted house can give you Vitamin C Deficiency. Restore your health by eating an orange!";

	}
	
	/**
     * Restores 2 HP to the player's current HP.
     */
	
	@Override
	public void useItem() {
		this.getPerson().addHp(Orange.HP_RESTORE);
		System.out.println("Your health has been restored by " + Orange.HP_RESTORE + "\n" + "You have" + this.getHp() + " hp left!");
	}
}
