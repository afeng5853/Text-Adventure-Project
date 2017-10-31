package Item;
import java.util.*;

public class RubberChicken extends Weapons {
	
	// fields
	private String name;
	private int value;
	private String type;
	
	public RubberChicken(String name, int value, String type) {
		super(name, type, value);
	}

	@Override
	public String toString() {
		return "Rubber chickens are mythical weapons. Their quackking sound can scare even the bravest ghosts!";
	}
}
