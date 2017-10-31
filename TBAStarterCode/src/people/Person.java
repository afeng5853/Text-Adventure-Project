package people;

import java.util.ArrayList;

import Item.Item;
import constants.Constants;
import rooms.Room;

/**
 * Used to create person objects that may ____.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public abstract class Person {
	//fields
	private String firstName;
	private String lastName;
	private Room room;
	private int x;
	private int y;
	private ArrayList<Item> inventory;
	private int hp;
	
	//constructor
	public Person(String firstName, String lastName, int x, int y, int hp) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setX(x);
		this.setY(y);
		this.inventory = new ArrayList<>();
		this.setHp(hp);
	}
	
	/**
     * the greeting of the person as a string
     */
	
	public abstract String getGreeting();
	
	//methods
	
	/**
     * @return		the full name of the person
     */
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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
