package Item;

import people.Person;

public abstract class Weapon implements Item {
	private int strength;
	private Person person;
	
	public Weapon(int strength) {
		this.strength = strength;
	}
	
	public Weapon(Person p, int strength) {
		this.person = p;
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
