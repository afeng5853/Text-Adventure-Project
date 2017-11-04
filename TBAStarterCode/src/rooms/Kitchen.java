package rooms;

import Item.Item;
import floor.Floor;
import people.Person;
import people.Player;
import utilities.util;

public class Kitchen extends Room {
	private boolean ratsEaten = false;
	
	public Kitchen(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}

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
