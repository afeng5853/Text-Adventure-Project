package people;

import java.util.ArrayList;

import Item.Consumables;
import Item.Item;
import Item.Weapon;
import area.AbandonedHouse;
import constants.Constants;
import floor.Floor;
import rooms.Room;

/**
 * A generic person that can move and attack
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public abstract class Person implements Movable, Attacker {
	//fields

	private Room room;
	private int x;
	private int y;
	private int z;
	private ArrayList<Item> inventory;
	private int hp;
	private int hitRange;
	private Floor floor;
	private AbandonedHouse house;
	
	//constructor
	public Person(int x, int y, int z, int hp, int hitRange, Floor floor, AbandonedHouse house) {

		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.inventory = new ArrayList<>();
		this.setHp(hp);
		this.setHitRange(hitRange);
		this.setFloor(floor);
		this.setHouse(house);
	}
	
	/**
     * the greeting of the person as a string
     */
	
	public abstract String toString();
	
	//methods
	

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void printRoom() {
		System.out.println(this.room);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void addToInventory(Item i) {
		this.inventory.add(i);
	}
	
	public void removeFromInventory(Item i) {
		this.inventory.remove(i);
	}
	
	public ArrayList<Item> getInventory() {
		return this.inventory;
	}
	
	/**
	 * Player action of consuming and using the item, deletes the item from inventory
	 * @param i the targeted item
	 */
	public void consumeItem(Item i) {
		if (i instanceof Consumables) {
			((Consumables) i).setPerson(this);
			i.useItem();
		    removeFromInventory(i);
		}
	}
	
	/**
	 * A boolean of whether or not the player has a type of item
	 * @param item the targeted item
	 * @return true or false if the player has the type of item
	 */
	public boolean hasItem(Item item) {
		for (Item check : this.getInventory()) {
			if (check.toString().equals(item.toString())) {
				return true;
			}
		}
		return false;
	}	
	
	/**
	 * Gets the item of type item from inventory
	 * @param item the targeted item
	 * @return a item of type item
	 */
	public Item getItem(Item item) {
		for (Item check : this.getInventory()) {
			if (check.toString().equals(item.toString())) {
				return item;
			}
		}
		return null;
	}	
	
	/**
	 * Gets all consumable items from the inventory
	 * @return an ArrayList of consumables
	 */
	public ArrayList<Item> getConsumables() {
		ArrayList<Item> consumables = new ArrayList<>();
		for (int i = 0; i < inventory.size(); i++) {
			Item currentItem = inventory.get(i);
			if (currentItem instanceof Consumables) {
				consumables.add(currentItem);
			}
		}
		return consumables;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void addHp(int amount) {
		this.hp += amount;
	}
	
	/**
	 * Get's the players weapon from inventory (as they can only have one)
	 * @return the player's weapon
	 */
	public Weapon getWeapon() {
		for (Item i : this.getInventory()) {
			if (i instanceof Weapon) {
				return (Weapon) i;
			}
		}
		return null;
	}
	
	/**
	 * A boolean of whether or not the player can attack Person p
	 * @param p the targeted person
	 */
	public boolean canAttack(Person p) {
		// If the player is in the Enemy's hit range (includes diagonal)
		return (Math.abs(p.getX() - this.getX()) <= this.getHitRange()) && (Math.abs(p.getY() - this.getY()) <= this.getHitRange());
	}
	
	/**
	 * Uses the players weapon to attack Person p
	 * @param p The targeted person
	 */
	public void attack(Person p) {
		Weapon weapon = getWeapon();
		if (weapon != null) {
			System.out.println(this + " attack with the " + weapon + " dealing " + weapon.getStrength() + " damage");
			p.addHp(-1 * weapon.getStrength());
		} else if (this instanceof Enemy) {
			int enemyStrength = ((Enemy) this).getStrength();
			System.out.println(this + " attacks dealing " + enemyStrength + " damage");
			p.addHp(-enemyStrength);
		} else {
			System.out.println(this + " attacks!");
			p.addHp(-1);
		}
	}
	
	/**
	 * A helper method to determine if it is possible to move in the specified direction.
	 * Checks if the move will be in the bounds of the array and if there is a door that can be passed through.
	 * @param	dir	the direction to be moved
     * @return		whether or not it is possible to move in the specified direction
     */
	
	public boolean canMove(int dir) {
		if (dir == Constants.LEFT) {
			if (x > 0 && room.getDoors()[Constants.LEFT]) {
				return true;
			} else {
				return false;
			}
		} else if (dir == Constants.RIGHT) {
			if (x < Constants.WIDTH - 1 && room.getDoors()[Constants.RIGHT])  {
				return true;
			} else {
				return false;
			}
		} else if (dir == Constants.UP ) {
			if (y > 0 && room.getDoors()[Constants.UP]) {
				return true;
			} else {
				return false;
			}
		} else if (dir == Constants.DOWN) {
			if (y < Constants.LENGTH - 1 && room.getDoors()[Constants.DOWN]) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Moves the user in the specified direction if it is possible
	 * @param	dir	the direction to be moved
     */
	
	public void move(int dir) {
		if (dir == Constants.LEFT) {
			if (canMove(dir)) {
				this.x--;
			}
		} else if (dir == Constants.RIGHT) {
			if (canMove(dir)) {
				this.x++;
			}
		} else if (dir == Constants.UP) {
			if (canMove(dir)) {
				this.y--;
			}
		} else if (dir == Constants.DOWN) {
			if (canMove(dir)) {
				this.y++;
			}
		} else {
			System.out.println("????????error????????");
		}
	}

	/**
	 * Moves the player upstairs to another floor
	 */
	public void goUpstairs() {
		this.z++;
		if (this.z < this.getHouse().getHouse().length) {
			floor.removePlayer(this);
			this.floor = this.getHouse().getHouse()[this.z];
			floor.placePlayer(this);
		} else {
			this.z--;
		}
	}
	
	/**
	 * Moves the player downstairs to another floor
	 */
	public void goDownstairs() {
		this.z--;
		if (this.z >= 0) {
			floor.removePlayer(this);
			this.floor = this.getHouse().getHouse()[this.z];
			floor.placePlayer(this);
		} else {
			this.z++;
		}
	}
	
	public int getHitRange() {
		return hitRange;
	}

	public void setHitRange(int hitRange) {
		this.hitRange = hitRange;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public AbandonedHouse getHouse() {
		return house;
	}

	public void setHouse(AbandonedHouse house) {
		this.house = house;
	}
	
}
