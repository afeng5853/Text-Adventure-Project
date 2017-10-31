package Item;

public class Weapons implements Item{
	
	// fields
	private String name;
	private String type;
	private int value;
	
	public Weapons(String name, String type, int value) {
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	public int useItem() {
		Random rand = new Random();
		int High = this.value;
		int Low;
		
		if (this.type == "Ranged") {
			Low = 5;
		}
		else {
			Low = 2;
		}
		
		int hit = rand.nextInt(High-Low) + Low;
		return hit;
	}
	
	@Override
	public String toString() {
		return "Weapons are items that help you fight the dangers of the haunted house. Upgrade them as you progress throughout your journey, by collecting more of them!";
	}

}
