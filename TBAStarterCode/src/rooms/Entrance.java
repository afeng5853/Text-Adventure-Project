package rooms;

import Item.Item;
import Item.Key;
import people.Person;
import people.Player;
import utilities.util;

/**
 * The entrance is where the player can exit and win the game.
 * @since 11/4/17
 */

public class Entrance extends Room {
	
	//constructor
	public Entrance(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}

	/**
	 * Defines interaction with the entrance. If the user has the "key" item,
	 * then they can exit and win the game.
	 * @param  p		     the player
	 * @param  response_ the player's response
	 * @return response  the action that has occurred
	 */
	
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
