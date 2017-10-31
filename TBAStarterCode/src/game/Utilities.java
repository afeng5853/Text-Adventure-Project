package game;

import java.util.Random;
import Item.*;
import people.Person;
	
/**
 * General utilities for the game
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class Utilities {

	/**
     * Creates a person for the current player.
     * @param firstName the first name of the player
     * @param lastName  the last name of the player
     * @return 		    created person   
     */
	
	public static Person createPerson(String firstName, String lastName) {
		return new Person(firstName, lastName);
	}
	
	/**
     * Randomly creates one of the four possible items in the game. 
     * @return			the randomly created item  
     */
	
	public static Item createRandomItem() {
        Random rand = new Random();
        int randInt = rand.nextInt(4);
        boolean randomBool = rand.nextBoolean();

        switch (randInt) 
        {
            case 0:
                return new Key("floor1", 1, rand.nextInt(3) + 1, 10);
            case 1:
                return (Item) new RubberChicken("Rubber Chicken 1.0", 10, 1);
            case 2:
                return new Teleport("Teleport", 3 , rand.nextInt(3) + 1, randomBool);
            case 3:
                return (Item) new WaterSprayer("Water Sprayer 1.0", 5, 1);
            default:
                return new Key("floor1", 1, rand.nextInt(3) + 1, 10);
        }
	}
}


