package rooms;

import Item.Item;
import people.Person;
import utilities.util;

public class Kitchen extends Room {
	private boolean ratsEaten = false;
	
	public Kitchen(boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc) {
		super(doors, occupants, items, x, y, desc);
	}

	@Override
	public String parseResponse(String response_) {
		String response = this.parseBasicResponses(response_);
		if (util.findKeyword(response, "eat", 0) != -1) {
			if (!ratsEaten) {
				response = "You eat the corpses of dead rats and feel sick.";
				this.setDesc("You regret eating those rats.");
				ratsEaten = true;
			} else {
				response = "You start to become crazy as you cannot find any more rats";
			}
		}
		return response;
	}
	

}
