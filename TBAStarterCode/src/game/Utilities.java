package game;

import people.Person;

public class Utilities {

	public static Person createPerson(String firstName, String lastName) {
		return new Person(firstName, lastName);
	}
	
	public static Items createItem(string name, String type, int value, int quantity) {
        Random rand = new Random();
        int x = rand.nextInt(4);

        switch (x) 
        {
            case 0:
                return new Key();
            case 1:
                return new RubberChicken();
            case 2:
                return new Teleport();
            case 3:
                return new WaterSprayer();
            default:
                return new Key();
        }
	}
}


