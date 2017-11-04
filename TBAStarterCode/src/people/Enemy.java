package people;

import java.util.ArrayList;

import Item.Item;
import area.AbandonedHouse;
import floor.Floor;
import rooms.Room;

/**
 * Enemies are persons that pose a threat to the player. 
 * Similar to the player, they can move around the game board
 * and have an inventory and stats.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public abstract class Enemy extends Person {
	private int strength;
	private Person focus;
	
	//constructor
	public Enemy(int x, int y, int z, int hp, int hitRange, int strength, Person focus, Floor floor, AbandonedHouse house) {
		super(x, y, z, hp, hitRange, floor, house);
		this.setStrength(strength);
		this.focus = focus;
	}

	
	public abstract int getNextMove(Player p);

	public abstract void counterAttack(Player p);

	/**
	 * Tells if the enemy can attack or not it's focus
	 * @return whether or not the enemy can attack it's focus within range
	 */
	public boolean canAttack() {
		// If the player is in the Enemy's hit range (includes diagonal)
		return (Math.abs(focus.getX() - this.getX()) <= this.getHitRange()) && (Math.abs(focus.getY() - this.getY()) <= this.getHitRange());
	}
	
	/**
	 * Tells if the enemy can attack or not it's player
	 * @return whether or not the enemy can attack it's player within range
	 */
	public boolean canAttack(Person p) {
		// If the player is in the Enemy's hit range (includes diagonal)
		return (Math.abs(p.getX() - this.getX()) <= this.getHitRange()) && (Math.abs(p.getY() - this.getY()) <= this.getHitRange());
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}
}
