package people;

import java.util.ArrayList;

import Item.Consumables;
import Item.Item;
import Item.Weapon;
import constants.Constants;
import rooms.Room;

/**
 * Used to create person objects that may ____.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public abstract class Person implements Movable, Attacker{
	//fields

	private Room room;
	private int x;
	private int y;
	private ArrayList<Item> inventory;
	private int hp;
	
	//constructor
	public Person(int x, int y, int hp) {

		this.setX(x);
		this.setY(y);
		this.inventory = new ArrayList<>();
		this.setHp(hp);
	}
	
	/**
     * the greeting of the person as a string
     */
	
	public abstract String toString();
	
	//methods
	
	/**
     * @return		the full name of the person
     */
	

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void printRoom() {
		System.out.println(this.room);
	}
	
	/**
     * @return		the location of the user on the game board
     */
	
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
	
	public void consumeItem(Item i) {
		if (i instanceof Consumables) {
			((Consumables) i).setPerson(this);
			i.useItem();
		    removeFromInventory(i);
		}
	}
	
	public boolean hasItem(Item item) {
		for (Item check : this.getInventory()) {
			if (check.toString().equals(item.toString())) {
				return true;
			}
		}
		return false;
	}	
	
	public Item getItem(Item item) {
		for (Item check : this.getInventory()) {
			if (check.toString().equals(item.toString())) {
				return item;
			}
		}
		return null;
	}	
	
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
	
	public Weapon getWeapon() {
		for (Item i : this.getInventory()) {
			if (i instanceof Weapon) {
				return (Weapon) i;
			}
		}
		return null;
	}
	
	public void attack(Person p) {
		Weapon weapon = getWeapon();
		if (weapon != null) {
			System.out.println(this + " attack with the " + weapon + "dealing " + weapon.getStrength() + " damage");
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
	
}
