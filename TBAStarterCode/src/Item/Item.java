package Item;

import java.util.Random;

/**
 * Used to create the various items in the game.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public abstract class Item {
	
	//fields
	private String name;
	private String type;
	private int value;
	private int quantity;
	private int upgrade = 2;
	
	//constructor
	public Item(String name, int value, int quantity) {
		this.setName(name);
		this.setValue(value);
		this.setQuantity(quantity);
	}
	
	//methods
	
	
	/**
     * Selects a random response, from an array, to be used to describe a situation
     * @return	hit		the valu
     */
	
	public int useItem() {
		Random rand = new Random();
		int High = getValue();
		int Low = 1;
		int hit = rand.nextInt(High-Low) + Low;
		return hit;
	}
	
	public int useItem(int count) {
		if (count > upgrade) {
			setValue(getValue() + count);
			upgrade += upgrade;
			setQuantity(0);
		}
		return useItem();
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
