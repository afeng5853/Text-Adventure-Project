package Item;
import java.util.*;

import people.Person;

/**
 * The Rubber Chicken weapon allows players to fight against the dangers of the haunted house.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/31/17
 */

public class RubberChicken extends Weapon {
	
	//fields
	public final static int STRENGTH = 1;
	
	//constructors
	public RubberChicken() {
		super(STRENGTH);
	}
	
	public RubberChicken(Person p) {
		super(p, STRENGTH);
	}
	
	//methods
	@Override
	public String toString() {
		return "Rubber Chicken";
	}
	
	@Override
	public String getInfo() {
		return "Rubber chickens are mythical weapons. Their quackking sound can scare even the bravest ghosts!";
	}
	
	/**
     * Deals 1 damage to an opposing foe.
     */
	
	@Override
	public void useItem() {
		//TODO: this.getPerson().attack(this.getStrength());
	}
}
