package game;

import floor.Floor;
import items.Item;
import people.Person;
import rooms.NormalRoom;
import rooms.Room;

public class GenerationUtilities {
	public static Floor createFloor() {
		/*
		 *  [1]  [2]  [3]  [4]  [5] 
		 *  [6]  [7]  [8]  [9]  [10] 
		 *  [11] [12] [13] [14] [15] 
		 *  [16] [17] [18] [19] [20] 
		 *  [21] [22] [23] [24] [25] 
		 */
		NormalRoom room1 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room2 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room3 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room4 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room5 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room6 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room7 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room8 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room9 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room10 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room11 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room12 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room13 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room14 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room15 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room16 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room17 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room18 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room19 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room20 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room21 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room22 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room23 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room24 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		NormalRoom room25 = new NormalRoom(new boolean[] {true, true, true, true}, new Person[] {}, null, 0, 0);
		
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
