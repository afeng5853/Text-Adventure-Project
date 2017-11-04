package rooms;

import constants.Constants;
import floor.Floor;
import Item.Item;
import people.Person;
import people.Player;

/**
 * Normal room
 * @since 11/4/17
 */

public class NormalRoom extends Room {
	
	//constructor
	public NormalRoom(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}
	
	// Uses basic responses
	@Override
	public String parseResponse(Player p, String response_) {
		String response = this.parseBasicResponses(p, response_);
		return response;
	}
	
}
