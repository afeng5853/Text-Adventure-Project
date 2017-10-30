package rooms;

import constants.Constants;
import items.Item;
import people.Person;
import people.Player;

public class NormalRoom extends Room {
	
	/**
	 * Creates a normal room
	 * @param doors
	 * @param occupants
	 * @param items
	 * @param x
	 * @param y
	 * @param desc
	 */
	public NormalRoom(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}

	/**
	 * places the door character in the according position of the room
	 * @param room
	 * @param door
	 */
	private static void addDoor(char[] room, int door) {
		char doorType = ' ';
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
		
		if (doors[Constants.UP]) {
			addDoor(roomGraphic, Constants.UP);
		}
		if (doors[Constants.LEFT]) {
			addDoor(roomGraphic, Constants.LEFT);
		}
		if (doors[Constants.DOWN]) {
			addDoor(roomGraphic, Constants.DOWN);
		}
		if (doors[Constants.RIGHT]) {
			addDoor(roomGraphic, Constants.RIGHT);
		}
		
		return String.valueOf(roomGraphic);
	}
	
	
}
