package rooms;

import constants.Constants;
import floor.Floor;
import Item.Item;
import people.Person;
import people.Player;
import utilities.util;

/**
 * Staircase is a room that allows you to move between floors.
 * @since 11/4/17
 */

public class Staircase extends Room {
	
	//constructor
	public Staircase(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}

	/**
	 * Defines interaction when moving between floors and displays the new floor.
	 * @param  p		     the player
	 * @param  response_ the player's response
	 * @return response  the action that has occurred
	 */

	@Override
	public String parseResponse(Player p, String response_) {
		String response = "";
		String[] upstairKeywords = new String[] {"upstair", "upstairs", "climb"};
		String[] downstairKeywords = new String[] {"downstair", "downstairs"};
		if (util.findKeyword(response_, upstairKeywords) != -1) {
			p.goUpstairs();
			p.getFloor().printMap();
			response = "You go upstairs, but suddenly the stair breaks! You're trapped!";
		} else if (util.findKeyword(response_, downstairKeywords) != -1) {
			p.goDownstairs();
			p.getFloor().printMap();
			response = "You go downstairs, but suddenly the stair breaks! You're trapped!";
		} else {
			response = this.parseBasicResponses(p, response_);
		}
		return response;
	}
	
}
