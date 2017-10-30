package Item;
import java.util.*;

public class Key extends Consumables{
	
	private int locks; 
	
	public Key(String name, int value, int quantity, int locks) {
		super(name,value, quantity);
		this.setLocks(locks); 
	}
	
	public boolean useKey() {
		if (getQuantity() > getLocks()) {
			return true;
		}
		return false;
	}
	
	public int getLocks() {
		return locks;
	}
	
	public void setLocks(int locks) {
		this.locks = locks;
	}
	
	@Override
	public String toString() {
		return "You have" + getQuantity() + getName() + "keys";
	}
}
