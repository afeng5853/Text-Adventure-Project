package people;

public class Player extends Person {

	public Player(String firstName, String lastName, int x, int y, int hp) {
		super(firstName, lastName, x, y, hp);
	}

	@Override
	public String getGreeting() {
		return "You";
	}

	
}


