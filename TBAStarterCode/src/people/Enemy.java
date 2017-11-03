package people;

import java.util.ArrayList;

import Item.Item;
import rooms.Room;

/**
 * Enemies are persons that pose a threat to the player. 
 * Similar to the player, they can move around the game board
 * and have an inventory and stats.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class Enemy extends Person{

	
	//constructor
	public Enemy(String firstName, String lastName, int x, int y, int hp) {
		super(firstName, lastName, x, y, hp);
	}
	
	@Override
	public String getGreeting() {
		return "I see you";
	}	
	
    //int x = (int)(Math.random() * 3);

}
