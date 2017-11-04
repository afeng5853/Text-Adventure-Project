package floor;

import java.util.ArrayList;

import constants.Constants;
import game.GenerationUtilities;
import people.Enemy;
import people.Person;
import people.Player;
import rooms.Room;

/**
 * Floor represents the game board. It contains the multidimensional array of rooms and information about its dimensions.
 * The floor class provides a visual representation of the board, where the player is and the enemies in it
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class Floor {
	
	//fields
	private Room[][] rooms;
	private int length;
	private int width;
	private Player player;
	private ArrayList<Enemy> enemies;
	
	//constructors
	public Floor(Room[][] rooms) {
		this.rooms = rooms;
		this.length = rooms.length;
		this.width = rooms[0].length;
		enemies = new ArrayList<>();
	}
	
	/**
	 * Overloaded constructor that returns a random floor
	 */
	public Floor() {
		Room[][] rooms = new Room[Constants.WIDTH][Constants.LENGTH];
		for (int i = 0; i < Constants.WIDTH; i++) {
			for (int j = 0; j < Constants.LENGTH; j++) {
				rooms[i][j] =  GenerationUtilities.randomRoom(i, j);
				rooms[i][j].setFloor(this);
			}
		}
		this.rooms = rooms;
		this.length = rooms.length;
		this.width = rooms[0].length;
		enemies = new ArrayList<>();
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
	
	/**
	 * Adds the user to the current room he is in and sets the player's room to the current room
	 * Also if it's the player being added, set the floor's player to the player (as there is multiple floors)
	 * and if it's an enemy, add to the enemy list
	 * @param user the person to be placed
	 */
	public void placePlayer(Person user) {
		rooms[user.getY()][user.getX()].addOccupant(user);
		user.setRoom(getRoom(user.getX(), user.getY()));
		if (user instanceof Player) {
			this.setPlayer((Player) user);
		} else if (user instanceof Enemy) {
			this.enemies.add((Enemy) user);
		}
		user.setFloor(this);
	}

	
	/**
	 * Removes the player from the room
	 * @param user the person to be removed
	 */
	public void removePlayer(Person user) {
		rooms[user.getY()][user.getX()].removeOccupant(user);
	}
	
	/**
     * Displays the map by creating each room with its walls and doors.
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
                top.append(roomStr.substring(0, 3)); // 0-3 top, 3-6, mid, 6-9 bot
                mid.append(roomStr.substring(3, 6));                                                                                                                                                                                
                if (x == row.length - 1) { //if the last row
                	bot.append(roomStr.substring(6, 9)); //append the bot row
                }
            }
            // add new lines
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
}
