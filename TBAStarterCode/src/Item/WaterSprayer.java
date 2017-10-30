package Item;
import java.util.*;

public class WaterSprayer extends Weapons {
	private String name;
	private int value;
	private int quantity;
	
	public WaterSprayer(String name, int value, int quantity) {
		super(name, value, quantity);
	}
	
	@Override
	public String toString() {
		return "You have" + getQuantity() + "water sprayers";
	}
}
