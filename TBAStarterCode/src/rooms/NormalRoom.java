package rooms;

import constants.Constants;
import floor.Floor;
import Item.Item;
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
	public String parseResponse(Player p, String response_) {
		String response = this.parseBasicResponses(p, response_);
		return response;
	}
	
}
