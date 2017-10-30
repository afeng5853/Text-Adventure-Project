package Item;

import java.util.Random;

public abstract class Item {
	private String name;
	private String type;
	private int value;
	private int quantity;
	private int upgrade = 2;
	
	public Item(String name, int value, int quantity) {
		this.setName(name);
		this.setValue(value);
		this.setQuantity(quantity);
	}
	
	public int useItem() {
		Random rand = new Random();
		int High = getValue();
		int Low = 1;
		int x = rand.nextInt(High-Low) + Low;
		return x;
	}
	
	public int useItem(int count) {
		if (count > upgrade) {
			setValue(getValue() + count);
			upgrade += upgrade;
			setQuantity(0);
		}
		useItem();
	}
	
	public String toString() {
		return "You have" + this.quantity + "items";
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
