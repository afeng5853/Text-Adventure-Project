package Item;

public class Key implements Item{

	@Override
	public void useItem() {
		System.out.println("You used the key and unlocked the door");
	}

	@Override
	public String getInfo() {
		return "A key to a door";
	}

	@Override
	public String toString() {
		return "Key";
	}
}
