package Item;
import java.util.*;

public class Potion extends Consumables{
	
	private boolean special; 
	
	public Potion(String name, int value, boolean special) {
		super(name,value);
		this.special = special;
	}
	
	public int useItem(boolean special) {
		if (special) {
			return useItem() + 5;
		}
		return useItem();
	}
	
	@Override
	public String toString() {
		return "Potions are magically drinks that strengths your hits, special potions give a stronger effect";
	}
}
