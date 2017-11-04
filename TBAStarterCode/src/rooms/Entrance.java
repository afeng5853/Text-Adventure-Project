package rooms;

import Item.Item;
import Item.Key;
import people.Person;
import people.Player;
import utilities.util;

public class Entrance extends Room {
	
	/**
	 * Creates a normal room
	 * @param doors
	 * @param occupants
	 * @param items
	 * @param x
	 * @param y
	 * @param desc
	 */
	public Entrance(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}

	@Override
	public String parseResponse(Player p, String response_) {
		String response = "";
		String[] unlockKeywords = new String[] {"unlock", "open"};
		if (util.findKeyword(response_, unlockKeywords) != -1 && p.hasItem(new Key())) {
			response = "You've won the game!";
		} else {
			response = this.parseBasicResponses(p, response_);
		}
		return response;
	}
	
}
