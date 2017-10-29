package items;
import java.util.*;

public class RubberChicken extends Items {
	private String name;
	private String type;
	private int value;
	private int quantity;
	
	public RubberChicken(String name, String type, int value, int quantity) {
		super(name, type, value, quantity);
	}
	
	@Override
	public String toString() {
		return "You have" + this.quantity + "rubber chickens";
	}
}
