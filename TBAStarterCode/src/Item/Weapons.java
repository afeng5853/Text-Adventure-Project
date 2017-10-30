package Item;

public class Weapons extends Item{
	private String name;
	private int value;
	private int quantity;
	
	public Weapons(String name, int value, int quantity) {
		super(name, value, quantity);
	}
	
	@Override
	public String toString() {
		return "You have" + getQuantity() + "weapons";
	}
}
