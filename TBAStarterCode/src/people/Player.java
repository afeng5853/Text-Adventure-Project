package people;

import Item.Item;

/**
 * Creates the player. 
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class Player extends Person {

	public Player(int x, int y, int hp) {
		super(x, y, hp);
	}

	@Override
	public String toString() {
		return "You";
	}

}


