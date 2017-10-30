package items;
import java.util.*;

public class Weapons implements Items{
	
	private boolean broken; 
	
	public Key(String name, String type, int value, int quantity, boolean broken) {
		super(name, type, value, quantity);
		this.broken = broken;
	}
	
	@Overload
	public int useItem(boolean broken) {
		Random rand = new Random();
		int x = rand.nextInt(1);
		if (x == 0) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public String getBroken() {
		return broken;
	}
	
	public void setBroken(String broken) {
		this.broken = broken;
	}
	
	@Override
	public String toString() {
		return "You have" + this.quantity + "teleporters";
	}
}