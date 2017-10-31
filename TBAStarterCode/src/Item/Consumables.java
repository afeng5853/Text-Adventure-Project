package Item;

import people.Person;

public abstract class Consumables implements Item {
	private Person person;
	private int hp;

	public Consumables(int hp) {
		this.setHp(hp);
	}
	
	public Consumables(Person p, int hp) {
		this.person = p;
		this.setHp(hp);
	}

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
	
}
