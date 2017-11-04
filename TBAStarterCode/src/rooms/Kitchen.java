package rooms;

import Item.Item;
import floor.Floor;
import people.Person;
import people.Player;
import utilities.util;

/**
 * Kitchen is a room that allows the player to eat.
 * @since 11/4/17
 */

public class Kitchen extends Room {
	
	//fields
	private boolean ratsEaten = false;
	
	//constructor
	public Kitchen(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}
	
	/**
	 * Defines interaction with rats that can be found in the Kitchen.
	 * @param  p		     the player
	 * @param  response_ the player's response
	 * @return response  the action that has occurred
	 */
	
	@Override
	public String parseResponse(Player p, String response_) {
		String response = this.parseBasicResponses(p, response_);
		if (util.findKeyword(response, "eat") != -1 &&
				(util.findKeyword(response, "it") != -1 ||
				util.findKeyword(response, "rat") != -1 || 
				util.findKeyword(response, "rats") != -1)) {
			if (!ratsEaten) {
				response = "You eat the corpses of dead rats and feel sick.";
				p.addHp(-1);
				this.setDesc("You regret eating those rats.");
				ratsEaten = true;
			} else {
				response = "You start to become crazy as you cannot find any more rats";
				p.addHp(-1);
			}
		}
		if (!ratsEaten && response.equals("You find nothing.")) {
			response = "Nothing but dead rats.";
		}
		return response;
	}
}
