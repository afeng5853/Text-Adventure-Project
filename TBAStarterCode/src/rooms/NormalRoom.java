package rooms;

import items.Item;
import people.Person;
import people.Player;

public class NormalRoom extends Room {
	// Constants
	private static final int UP_DOOR = 0;
	private static final int LEFT_DOOR = 1;
	private static final int DOWN_DOOR = 3;
	private static final int RIGHT_DOOR = 2;
	
	/**
	 * Creates a normal room
	 * @param doors
	 * @param occupants
	 * @param items
	 * @param x
	 * @param y
	 */
	public NormalRoom(boolean[] doors, Person[] occupants, Item[] items, int x, int y) {
		super(doors, occupants, items, x, y);
	}

	/**
	 * places the door character in the according position of the room
	 * @param room
	 * @param door
	 */
	private static void addDoor(char[] room, int door) {
		char doorType = door == UP_DOOR || door == DOWN_DOOR ? '—' : '|';
		int map = (door * 2) + 1; // maps doorType to index in the char array;

		room[map] = doorType;
	}
	
	public boolean hasPlayer() {
		Person[] occupants = this.getOccupants();
		for (Person p : occupants) {
			if (p instanceof Player) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		// top : 0:1
		// left : 1:3
		// right : 2:5
		// down : 3:7
		
		// char array to allow mutable elements
		char[] roomGraphic = ("###"
				 		   +  "# #"
				 		   +  "###").toCharArray();
		boolean[] doors = this.getDoors();
		
		// if this room has a player 
		if (this.hasPlayer()) {
			roomGraphic[4] = 'P';
		}
		
		if (doors[UP_DOOR]) {
			addDoor(roomGraphic, UP_DOOR);
		}
		if (doors[LEFT_DOOR]) {
			addDoor(roomGraphic, LEFT_DOOR);
		}
		if (doors[DOWN_DOOR]) {
			addDoor(roomGraphic, DOWN_DOOR);
		}
		if (doors[RIGHT_DOOR]) {
			addDoor(roomGraphic, RIGHT_DOOR);
		}
		
		return String.valueOf(roomGraphic);
	}

	
	
	
}
