package Item;

import java.util.Random;

public class Consumables implements Item{
	
	private String name;
	private int value;
	
	public Consumables(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public int useItem() {
		Random rand = new Random();
		int High = this.value;
		int Low = 1;
		int hit = rand.nextInt(High-Low) + Low;
		return hit;
	}
	
	@Override
	public String toString() {
		return "Consumables are items that can get you out of sticky situations. Use them wisely!";
	}

}
