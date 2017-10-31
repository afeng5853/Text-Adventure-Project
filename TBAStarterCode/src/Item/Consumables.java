package Item;

import people.Person;

/**
 * Defines how consumables are to be created. 
 * Consumables are items that aid you in your journey, but can only be used once.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/31/17
 */

public abstract class Consumables implements Item {
	
	//fields
	private Person person;
	private int hp;
	
	//constructors
	public Consumables(int hp) {
		this.setHp(hp);
	}
	
	public Consumables(Person p, int hp) {
		this.person = p;
		this.setHp(hp);
	}
	
	//methods
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	@Override
	public String toString() {
		return "Consumables are items that can get you out of sticky situations. Use them wisely!";
	}
}
