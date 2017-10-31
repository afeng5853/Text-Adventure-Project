package Item;
import java.util.*;

import people.Person;

public class RubberChicken extends Weapon {
	public final static int STRENGTH = 1;
	
	public RubberChicken() {
		super(STRENGTH);
	}
	
	public RubberChicken(Person p) {
		super(p, STRENGTH);
	}
	
	@Override
	public String toString() {
		return "Rubber Chicken";
	}

	@Override
	public void useItem() {
		//TODO: this.getPerson().attack(this.getStrength());
	}
}
