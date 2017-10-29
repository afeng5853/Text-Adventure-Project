package people;

public class Player extends Person {

	public Player(String firstName, String lastName, int x, int y) {
		super(firstName, lastName, x, y);
	}

	@Override
	public String getGreeting() {
		return "You";
	}

	
}


