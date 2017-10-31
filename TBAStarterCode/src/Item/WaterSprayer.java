package Item;
import java.util.*;

public class WaterSprayer extends Weapons {
	
	// fields
	private String name;
	private int value;
	private String type;
	
	public WaterSprayer(String name, int value, String type) {
		super(name, type, value);
	}

	@Override
	public String toString() {
		return "Water Sprayers spray a special type of purifying water.";
	}
}
