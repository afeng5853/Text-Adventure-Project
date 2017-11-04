package people;

import Item.Item;
import Item.Weapon;

/**
 * For things that can attack
 * @since 11/04/17
 */

public interface Attacker {
	public Weapon getWeapon();
	
	public void attack(Person p);
	
	public boolean canAttack(Person p);
}
