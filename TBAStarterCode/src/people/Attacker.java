package people;

import Item.Item;
import Item.Weapon;

public interface Attacker {
	public Weapon getWeapon();
	
	public void attack(Person p);
}
