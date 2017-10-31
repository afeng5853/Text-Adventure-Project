package floor;

import people.Player;
import rooms.Room;

public class Floor {
	private Room[][] rooms;
	private int length;
	private int width;
	
	public Floor(Room[][] rooms) {
		this.rooms = rooms;
		this.length = rooms.length;
		this.width = rooms[0].length;
	}
	
	//TODO: generate random floor
	public Floor() {
		
	}
	
	public Room[][] getRooms() {
		return rooms;
	}
	
	public Room getRoom(int x, int y) {
		return rooms[y][x];
	}
	
	public void placePlayer(Player p) {
		rooms[p.getY()][p.getX()].addOccupant(p);
		p.setRoom(getRoom(p.getX(), p.getY()));
	}

	public void removePlayer(Player p) {
		rooms[p.getY()][p.getX()].removeOccupant(p);
	}
	
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
