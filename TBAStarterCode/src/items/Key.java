package items;
import java.util.*;

public class Key extends Items{
	
	private int locks; 
	
	public Key(String name, String type, int value, int quantity, int locks) {
		super(name, type, value, quantity);
		this.setLocks = locks;
	}
	
	public boolean useKey() {
		if (getQuantity > getLocks) {
			return true;
		}
		return false;
	}
	
	public String getLocks() {
		return locks;
	}
	
	public void setLocks(String locks) {
		this.locks = locks;
	}
	
	@Override
	public String toString() {
		return "You have" + this.quantity + this.name + "keys";
	}
}
