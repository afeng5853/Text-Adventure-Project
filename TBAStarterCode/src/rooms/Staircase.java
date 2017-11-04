package rooms;

import constants.Constants;
import floor.Floor;
import Item.Item;
import people.Person;
import people.Player;
import utilities.util;

public class Staircase extends Room {
	
	/**
	 * Creates a normal room
	 * @param doors
	 * @param occupants
	 * @param items
	 * @param x
	 * @param y
	 * @param desc
	 */
	public Staircase(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}

	@Override
	public String parseResponse(Player p, String response_) {
		String response = "";
		String[] upstairKeywords = new String[] {"upstair", "upstairs", "climb"};
		if (util.findKeyword(response_, upstairKeywords) != -1) {
			p.goUpstairs();
			p.getFloor().printMap();
			response = "You go upstairs, but suddenly the stair breaks! You're trapped!";
		} else {
			response = this.parseBasicResponses(p, response_);
		}
		return response;
	}
	
}
