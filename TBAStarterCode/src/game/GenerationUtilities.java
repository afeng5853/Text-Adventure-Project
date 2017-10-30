package game;

import java.util.Random;

import floor.Floor;
import items.Item;
import people.Person;
import rooms.Kitchen;
import rooms.NormalRoom;
import rooms.Room;

public class GenerationUtilities {
	private static String getGenericResponse() {
		String[] responses = {"You sense something is wrong", "You hear absolutely nothing.", "You feel hopeless as you soon realize that you can never escape.", 
				"You feel something approaching.", "The floor creaks as you walk by"};
		Random rand = new Random();
		int idx = rand.nextInt(responses.length);
		return responses[idx];
	}
	
	
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
		NormalRoom room2 = new NormalRoom(new boolean[] {false, true, true, false}, new Person[] {}, new Item[] {}, 0, 0, hallway23);
		NormalRoom room3 = new NormalRoom(new boolean[] {false, true, false, true}, new Person[] {}, new Item[] {}, 0, 0, hallway23);
		NormalRoom room4 = new NormalRoom(new boolean[] {false, false, true, true}, new Person[] {}, new Item[] {}, 0, 0, "");
		NormalRoom room5 = new NormalRoom(new boolean[] {false, true, false, false}, new Person[] {}, new Item[] {}, 0, 0, "");
		NormalRoom room6 = new NormalRoom(new boolean[] {true, false, false, true}, new Person[] {}, new Item[] {}, 0, 0, hallway611);
		NormalRoom room7 = new NormalRoom(new boolean[] {false, false, false, true}, new Person[] {}, new Item[] {}, 0, 0, "You see something interesting ahead.");
		NormalRoom room8 = new NormalRoom(new boolean[] {true, false, true, true}, new Person[] {}, new Item[] {}, 0, 0, getGenericResponse());
		NormalRoom room9 = new NormalRoom(new boolean[] {true, true, true, false}, new Person[] {}, new Item[] {}, 0, 0, "");
		NormalRoom room10 = new NormalRoom(new boolean[] {false, true, false, true}, new Person[] {}, new Item[] {}, 0, 0, "");
		NormalRoom room11 = new NormalRoom(new boolean[] {true, false, false, true}, new Person[] {}, new Item[] {}, 0, 0, hallway611);
		NormalRoom room12 = new NormalRoom(new boolean[] {true, false, true, true}, new Person[] {}, new Item[] {}, 0, 0, "");
		NormalRoom room13 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, new Item[] {}, 0, 0, getGenericResponse());
		NormalRoom room14 = new NormalRoom(new boolean[] {false, true, true, false}, new Person[] {}, new Item[] {}, 0, 0, getGenericResponse());
		NormalRoom room15 = new NormalRoom(new boolean[] {true, true, false, true}, new Person[] {}, new Item[] {}, 0, 0, getGenericResponse());
		Kitchen room16 = new Kitchen(new boolean[] {true, false, true, true}, new Person[] {}, new Item[] {}, 0, 0, kitchen);
		Kitchen room17 = new Kitchen(new boolean[] {false, true, true, true}, new Person[] {}, new Item[] {}, 0, 0, kitchen);
		NormalRoom room18 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, new Item[] {}, 0, 0, getGenericResponse());
		NormalRoom room19 = new NormalRoom(new boolean[] {false, true, true, false}, new Person[] {}, new Item[] {}, 0, 0, getGenericResponse());
		NormalRoom room20 = new NormalRoom(new boolean[] {true, true, false, false}, new Person[] {}, new Item[] {}, 0, 0, getGenericResponse());
		Kitchen room21 = new Kitchen(new boolean[] {true, false, true, false}, new Person[] {}, new Item[] {}, 0, 0, kitchen);
		Kitchen room22 = new Kitchen(new boolean[] {true, true, false, false}, new Person[] {}, new Item[] {}, 0, 0, kitchen);
		NormalRoom room23 = new NormalRoom(new boolean[] {true, false, true, false}, new Person[] {}, new Item[] {}, 0, 0, "You return back to the entrance, but the entrance seems locked");
		NormalRoom room24 = new NormalRoom(new boolean[] {false, true, true, false}, new Person[] {}, new Item[] {}, 0, 0, "");
		NormalRoom room25 = new NormalRoom(new boolean[] {false, true, false, false}, new Person[] {}, new Item[] {}, 0, 0, "");
		
		Room[][] groundFloor = { {room1, room2, room3, room4, room5},
				     			 {room6, room7, room8, room9, room10},
				     			 {room11, room12, room13, room14, room15},
				     			 {room16, room17, room18, room19, room20},
				     			 {room21, room22, room23, room24, room25}};
		
		Floor ground = new Floor(groundFloor);
		
		return ground;
	}
	
	/*
	private static Room createRandomItems() {
		
	}
	*/
	
	
}
