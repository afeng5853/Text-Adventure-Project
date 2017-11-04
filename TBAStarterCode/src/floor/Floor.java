package floor;

import constants.Constants;
import game.GenerationUtilities;
import people.Person;
import people.Player;
import rooms.Room;

/**
 * Floor represents the game board. It contains the multidimensional array of rooms and information about its dimensions.
 * The floor class provides a visual representation of the board and where the player is.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class Floor {
	
	//fields
	private Room[][] rooms;
	private int length;
	private int width;
	
	//constructors
	public Floor(Room[][] rooms) {
		this.rooms = rooms;
		this.length = rooms.length;
		this.width = rooms[0].length;
	}
	
	/**
	 * Overloaded constructor that returns a random floor
	 */
	public Floor() {
		Room[][] rooms = new Room[Constants.WIDTH][Constants.LENGTH];
		for (int i = 0; i < Constants.WIDTH; i++) {
			for (int j = 0; j < Constants.LENGTH; j++) {
				rooms[i][j] =  GenerationUtilities.randomRoom(i, j);
			}
		}
		this.rooms = rooms;
		this.length = rooms.length;
		this.width = rooms[0].length;
	}
	
	//methods
	public Room[][] getRooms() {
		return rooms;
	}
	
	/**
	 *  Gets the location of a room
     *  @param y the row location of the room
     *  @param x the column location of the room
     */
	
	public Room getRoom(int x, int y) {
		return rooms[y][x];
	}
	
	public void placePlayer(Person user) {
		rooms[user.getY()][user.getX()].addOccupant(user);
		user.setRoom(getRoom(user.getX(), user.getY()));
	}

	public void removePlayer(Person user) {
		rooms[user.getY()][user.getX()].removeOccupant(user);
	}
	
	/**
     * Displays the map by creating each room with its walls and doors.
     * @see StringBuilder
     */
	
	public void printMap()
    {
		int x = 0;
        for(Room[] row : rooms)
        {
        	StringBuilder top = new StringBuilder(); // top row of room
        	StringBuilder mid = new StringBuilder(); // mid row of room
        	StringBuilder bot = null;
        	if (x == row.length - 1) { // if the last row
        		bot = new StringBuilder(); // bot row of room
        	}
        	
            for (Room room : row)
            {
            	String roomStr = room.toString();
                top.append(roomStr.substring(0, 3));
                mid.append(roomStr.substring(3, 6));                                                                                                                                                                                
                if (x == row.length - 1) {
                	bot.append(roomStr.substring(6, 9));
                }
            }
            
            top.append('\n');
            mid.append('\n');
            System.out.print(top);
            System.out.print(mid);
         
            if (x == row.length - 1) {
            	bot.append('\n');
            	System.out.print(bot);
            }
            x++;
        }
    }
}
