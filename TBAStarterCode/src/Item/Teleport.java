package Item;
import java.util.*;

public class Teleport extends Consumables{
	
	private boolean broken; 
	
	public Teleport(String name, int value, int quantity, boolean broken) {
		super(name, value, quantity);
		this.broken = broken;
	}
	
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
	
	public boolean getBroken() {
		return broken;
	}
	
	public void setBroken(boolean broken) {
		this.broken = broken;
	}
	
	@Override
	public String toString() {
		return "You have" + getQuantity() + "teleporters";
	}
}