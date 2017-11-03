package people;

/**
 * Creates the player. 
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class Player extends Person {

	public Player(String firstName, String lastName, int x, int y, int hp) {
		super(firstName, lastName, x, y, hp);
	}

	@Override
	public String getGreeting() {
		return "You";
	}	
}


