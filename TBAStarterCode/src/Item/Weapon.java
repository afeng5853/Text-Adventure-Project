package Item;

import people.Person;

/**
 * Defines how weapons are to be created.
 * Weapons have differing strengths that determine how damage they do.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/31/17
 */

public abstract class Weapon implements Item {
	
	//fields
	private int strength;
	private Person person;
	
	//constructors
	public Weapon(int strength) {
		this.strength = strength;
	}
	
	public Weapon(Person p, int strength) {
		this.person = p;
		this.strength = strength;
	}
	
	//methods
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void increaseStrength(int strength) {
		this.strength += strength;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
}
