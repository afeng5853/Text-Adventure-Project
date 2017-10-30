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

	@Override
	public String parseResponse(String response_) {
		String response = this.parseBasicResponses(response_);
		return response;
	}
	
	
}
