package items;
import java.util.*;

public class WaterSprayer extends Items{
	private String name;
	private String type;
	private int value;
	private int quantity;
	
	public WaterSprayer(String name, String type, int value, int quantity) {
		super(name, type, value, quantity);
	}
	
	@Override
	public String toString() {
		return "You have" + this.quantity + "water sprayers";
	}
}
