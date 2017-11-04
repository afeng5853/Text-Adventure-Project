package people;

import Item.Item;
import area.AbandonedHouse;
import floor.Floor;

/**
 * Creates the player. 
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class Player extends Person {

	public Player(int x, int y, int z, int hp, int hitRange, Floor floor, AbandonedHouse house) {
		super(x, y, z, hp, hitRange, floor, house);
	}

	@Override
	public String toString() {
		return "You";
	}

	

}


