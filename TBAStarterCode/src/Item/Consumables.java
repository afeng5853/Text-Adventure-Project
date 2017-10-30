package Item;

public class Consumables extends Item{
	private String name;
	private int value;
	private int quantity;
	
	public Consumables(String name, int value, int quantity) {
		super(name, value, quantity);
	}
	
	@Override
	public String toString() {
		return "You have" + getQuantity() + "consumables";
	}
}
