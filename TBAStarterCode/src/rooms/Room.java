package rooms;

import people.Person;
import people.Player;
import utilities.util;
import Item.Item;

import java.util.Arrays;

import constants.Constants;

public abstract class Room {

    private boolean[] doors;
    private Person[] occupants;
    private Item[] items;
    public boolean explored;
    private int x, y;
    private String desc;

    public Room (boolean[] doors, Person[] occupants, Item[] items, int x, int y, String desc)
    {
    	this.x = x;
    	this.y = y;
        this.doors = doors;
        this.occupants = occupants;
        this.items = items;
        this.explored = false;
        this.desc = desc;
    }

    public void addItem(Item i)
    {
        this.items = Arrays.copyOf(this.items,this.items.length+1);
        this.items[this.items.length-1] = i;
    }
    
    public Person[] getOccupants() {
        return occupants;
    }

    public boolean hasPlayer() {
		Person[] occupants = this.getOccupants();
		for (Person p : occupants) {
			if (p instanceof Player) {
				return true;
			}
		}
		return false;
	}
    
    public void setOccupants(Person[] occupants) {
        this.occupants = occupants;
    }

    public void removeOccupant(Person p) {
    	Person[] occupants = this.getOccupants();
        for (int i = 0; i < occupants.length; i++) {
        	if (occupants[i] == p) {
        		occupants[i] = null;
        		break;
        	}
        }
    }
    
    public void addOccupant(Person p)
    {
        this.occupants = Arrays.copyOf(this.occupants,this.occupants.length+1);
        this.occupants[this.occupants.length-1] = p;
        p.setRoom(this);
    }
    

    public boolean[] getDoors()
    {
    	return doors;
    }
    
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * places the door character in the according position of the room
	 * @param room
	 * @param door
	 */
	private static void addDoor(char[] room, int door) {
		char doorType = ' ';
		int map = (door * 2) + 1; // maps doorType to index in the char array;

		room[map] = doorType;
	}
	
	public String parseBasicResponses(Player p, String response) {
		String[] searchKeywords = {"examine", "search"};
		String[] pickUpKeywords = {"take", "pick up", "get"};
		if (util.findKeyword(response, searchKeywords ,0) != -1) {
			if (this.items.length > 0 ) {
				StringBuilder build = new StringBuilder();
				for (Item i : items) {
					build.append(i.toString() + " ");
				}
				return "You find " + build.toString();
			} else {
				return "You find nothing.";
			}
		} else if (util.findKeyword(response, pickUpKeywords) != -1){
			if (this.items.length > 0) {
				p.addToInventory(this.items[0]);
				return "You picked up " + this.items[0];
			}
		}
		return response;
	}
	
	public abstract String parseResponse(Player p, String response);
	
	@Override
	public String toString() {
		// top : 0:1
		// left : 1:3
		// right : 2:5
		// down : 3:7
		
		// char array to allow mutable elements
		char[] roomGraphic = ("###"
				 		   +  "# #"
				 		   +  "###").toCharArray();
		boolean[] doors = this.getDoors();
		
		if (this.hasPlayer()) {
			roomGraphic[4] = 'P';
		}
		
		// if door in current direction then replace wall with space
		
		if (doors[Constants.UP]) {
			addDoor(roomGraphic, Constants.UP);
		}
		if (doors[Constants.LEFT]) {
			addDoor(roomGraphic, Constants.LEFT);
		}
		if (doors[Constants.DOWN]) {
			addDoor(roomGraphic, Constants.DOWN);
		}
		if (doors[Constants.RIGHT]) {
			addDoor(roomGraphic, Constants.RIGHT);
		}
		
		return String.valueOf(roomGraphic);
	}
}


