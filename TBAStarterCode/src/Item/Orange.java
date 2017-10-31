package Item;
import java.util.*;

import people.Person;

public class Orange extends Consumables {
	public final static int HP_RESTORE = 2;
	public Orange() {
		super(HP_RESTORE);
	}
	
	public Orange(Person p) {
		super(p, HP_RESTORE);
	}

	@Override
	public String toString() {
		return "Orange";

	}

	@Override
	public void useItem() {
		//TODO : this.getPerson().consume(this.getHp());
	}
}
