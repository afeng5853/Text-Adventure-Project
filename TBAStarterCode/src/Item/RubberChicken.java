package Item;
import java.util.*;

public class RubberChicken extends Weapons {
	private String name;
	private int value;
	private int quantity;
	
	public RubberChicken(String name, int value, int quantity) {
		super(name, value, quantity);
	}
	
	@Override
	public String toString() {
		return "You have" + getQuantity() + "rubber chickens";
	}
}
