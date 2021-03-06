package game;

import java.util.Random;

import floor.Floor;
import Item.Item;
import Item.Orange;
import Item.RubberChicken;
import Item.TeleportPill;
import people.Person;
import rooms.Entrance;
import rooms.Kitchen;
import rooms.NormalRoom;
import rooms.Room;
import rooms.Staircase;

/**
 * Utilities to create the game.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class GenerationUtilities {
	
	/**
     * Selects a random response, from an array, to be used to describe a situation
     * @return 		string containing the randomly generated response
     */
	
	private static String getGenericResponse() {
		String[] responses = {"You sense something is wrong", "You hear absolutely nothing.", "You feel hopeless as you soon realize that you can never escape.", 
				"You feel something approaching.", "The floor creaks as you walk by"};
		Random rand = new Random();
		int idx = rand.nextInt(responses.length);
		return responses[idx];
	}
	
	/**
     * Generates a random item
     * @return		the generated item
     */
	
	public static Item randomItem() {
		Item[] items = {new Orange(), new RubberChicken(), new TeleportPill()};
		Random rand = new Random();
		int idx = rand.nextInt(items.length);
		return items[idx];
	}
	
	/**
     * Has a x% chance to place a random item throughout the rooms of a floor.
     * @param 	f	the floor to be populated with items
     */
	
	public static void placeRandomItems(Floor f) {
		for (Room[] row : f.getRooms()) {
			for (Room room : row) {
				if (Math.random() < 0.9) {
					room.addItem(randomItem());
				}
			}
		}
	}
	
	/**
	 * Generates random door combinations
	 * @return A random door combination
	 */
	public static boolean[] randomDoors() {
		boolean[] doors = new boolean[4];
		for (int i = 0; i < doors.length; i++) {
			double randNum = Math.random();
			if (randNum > 0.75) {
				doors[i] = false;
			} else {
				doors[i] = true;
			}
		}
		return doors;
	}
	
	/**
	 * Creates a random room
	 * @param x The location X of the room
	 * @param y The location Y of the room
	 * @return a random room
	 */
	public static Room randomRoom(int x, int y) {
		boolean[] randomDoors = randomDoors();
		Person[] persons = new Person[] {};
		Item[] items = new Item[] {randomItem()};
		double random = Math.random();
		if (random < 0.75) {
			return new NormalRoom(randomDoors, persons, items, x, y, getGenericResponse());
		} else {
			return new Staircase(randomDoors, persons, items, x, y, "You found a staircase");
		}
	}
	
	/**
     * Creates a floor using a 5 by 5 array and populates the array with rooms. 
     * @return	ground	the generated floor
     */
	
	public static Floor createFloor() {
		/*
		 *  [1]  [2]  [3]  [4]  [5] 
		 *  [6]  [7]  [8]  [9]  [10] 
		 *  [11] [12] [13] [14] [15] 
		 *  [16] [17] [18] [19] [20] 
		 *  [21] [22] [23] [24] [25] 
		 */
		String kitchen = "Around you, you see dead rats on the floor of the kitchen";
		String hallway611 = "You are in a dark ominous hallway. You're not sure what lies ahead.";
		String hallway23 = "You can see a glimmer of light outside the window, but you realize you'll never be able to get out";
		
		NormalRoom room1 = new NormalRoom(new boolean[] {false, false, true, true}, new Person[] {}, new Item[] {}, 0, 0, "It feels as if the walls are crushing you.");
		NormalRoom room2 = new NormalRoom(new boolean[] {false, true, true, false}, new Person[] {}, new Item[] {}, 0, 1, hallway23);
		NormalRoom room3 = new NormalRoom(new boolean[] {false, true, false, true}, new Person[] {}, new Item[] {}, 0, 2, hallway23);
		NormalRoom room4 = new NormalRoom(new boolean[] {false, false, true, true}, new Person[] {}, new Item[] {}, 0, 3, "");
		Staircase room5 = new Staircase(new boolean[] {false, true, false, false}, new Person[] {}, new Item[] {}, 0, 4, "You found a staircase");
		NormalRoom room6 = new NormalRoom(new boolean[] {true, false, false, true}, new Person[] {}, new Item[] {}, 1, 0, hallway611);
		NormalRoom room7 = new NormalRoom(new boolean[] {false, false, false, true}, new Person[] {}, new Item[] {}, 1, 1, "You see something interesting ahead.");
		NormalRoom room8 = new NormalRoom(new boolean[] {true, false, true, true}, new Person[] {}, new Item[] {}, 1, 2, getGenericResponse());
		NormalRoom room9 = new NormalRoom(new boolean[] {true, true, true, false}, new Person[] {}, new Item[] {}, 1, 3, "");
		NormalRoom room10 = new NormalRoom(new boolean[] {false, true, false, true}, new Person[] {}, new Item[] {}, 1, 4, "");
		NormalRoom room11 = new NormalRoom(new boolean[] {true, false, false, true}, new Person[] {}, new Item[] {}, 2, 0, hallway611);
		NormalRoom room12 = new NormalRoom(new boolean[] {true, false, true, true}, new Person[] {}, new Item[] {}, 2, 1, "");
		NormalRoom room13 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, new Item[] {}, 2, 2, getGenericResponse());
		NormalRoom room14 = new NormalRoom(new boolean[] {false, true, true, false}, new Person[] {}, new Item[] {}, 2, 3, getGenericResponse());
		NormalRoom room15 = new NormalRoom(new boolean[] {true, true, false, true}, new Person[] {}, new Item[] {}, 2, 4, getGenericResponse());
		Kitchen room16 = new Kitchen(new boolean[] {true, false, true, true}, new Person[] {}, new Item[] {}, 3, 0, kitchen);
		Kitchen room17 = new Kitchen(new boolean[] {false, true, true, true}, new Person[] {}, new Item[] {}, 3, 1, kitchen);
		NormalRoom room18 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, new Item[] {}, 3, 2, getGenericResponse());
		NormalRoom room19 = new NormalRoom(new boolean[] {false, true, true, false}, new Person[] {}, new Item[] {}, 3, 3, getGenericResponse());
		NormalRoom room20 = new NormalRoom(new boolean[] {true, true, false, false}, new Person[] {}, new Item[] {}, 3, 4, getGenericResponse());
		Kitchen room21 = new Kitchen(new boolean[] {true, false, true, false}, new Person[] {}, new Item[] {}, 4, 0, kitchen);
		Kitchen room22 = new Kitchen(new boolean[] {true, true, false, false}, new Person[] {}, new Item[] {}, 4, 1, kitchen);
		Entrance room23 = new Entrance(new boolean[] {true, false, true, false}, new Person[] {}, new Item[] {}, 4, 2, "You return back to the entrance, but the entrance seems locked");
		NormalRoom room24 = new NormalRoom(new boolean[] {false, true, true, false}, new Person[] {}, new Item[] {}, 4, 3, "");
		NormalRoom room25 = new NormalRoom(new boolean[] {false, true, false, false}, new Person[] {}, new Item[] {}, 4, 4, "");
		
		Room[][] groundFloor = { {room1, room2, room3, room4, room5},
				     			 {room6, room7, room8, room9, room10},
				     			 {room11, room12, room13, room14, room15},
				     			 {room16, room17, room18, room19, room20},
				     			 {room21, room22, room23, room24, room25}};
		
		Floor ground = new Floor(groundFloor);
		
		room1.setFloor(ground);
		room2.setFloor(ground);
		room3.setFloor(ground);
		room4.setFloor(ground);
		room5.setFloor(ground);
		room6.setFloor(ground);
		room7.setFloor(ground);
		room8.setFloor(ground);
		room9.setFloor(ground);
		room10.setFloor(ground);
		room11.setFloor(ground);
		room12.setFloor(ground);
		room13.setFloor(ground);
		room14.setFloor(ground);
		room15.setFloor(ground);
		room16.setFloor(ground);
		room17.setFloor(ground);
		room18.setFloor(ground);
		room19.setFloor(ground);
		room20.setFloor(ground);
		room21.setFloor(ground);
		room22.setFloor(ground);
		room23.setFloor(ground);
		room24.setFloor(ground);
		room25.setFloor(ground);
		
		return ground;
	}
	
}
