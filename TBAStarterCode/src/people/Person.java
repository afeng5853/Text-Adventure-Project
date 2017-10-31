package people;


import java.util.ArrayList;

import Item.Item;
import constants.Constants;
import rooms.Room;

public abstract class Person {
	private String firstName;
	private String lastName;
	private Room room;
	private int x;
	private int y;
	private ArrayList<Item> inventory;
	private int hp;
	
	public Person(String firstName, String lastName, int x, int y, int hp) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setX(x);
		this.setY(y);
		this.inventory = new ArrayList<>();
		this.setHp(hp);
	}
	
	public abstract String getGreeting();
	
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
	
	public void addHp(int amount) {
		this.hp += amount;
	}
	
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
			System.out.println("????????error??????????");
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
}
