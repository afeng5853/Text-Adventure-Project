package rooms;

import people.Enemy;
import people.Person;
import people.Player;
import utilities.util;
import Item.Item;
import Item.RubberChicken;
import Item.TeleportPill;

import java.util.ArrayList;
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
    
    public void deleteItem()
    {
        this.items = new Item[] {};
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
    
    public boolean hasEnemy() {
		Person[] occupants = this.getOccupants();
		for (Person p : occupants) {
			if (p instanceof Enemy) {
				return true;
			}
		}
		return false;
	}
    
    public Enemy[] getEnemies() {
    	Person[] occupants = this.getOccupants();
    	Enemy[] enemies = new Enemy[occupants.length];
		for (int i = 0; i < occupants.length; i++) {
			if (occupants[i] instanceof Enemy) {
				enemies[i] = (Enemy) occupants[i];
			}
		}
		return enemies;
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
		String[] useKeywords = {"consume", "eat", "use", "swallow"};
	
		if (util.findKeyword(response, searchKeywords ,0) != -1) {
			if (this.items.length > 0) {
				StringBuilder build = new StringBuilder();
				for (Item i : items) {
					build.append(i.toString() + " ");
				}
				response =  "You find " + build.toString();
			} else {
				response = "You find nothing";
			}
		} else if (util.findKeyword(response, pickUpKeywords) != -1){
			if (this.items.length > 0) {
				p.addToInventory(this.items[0]);
				response = "You picked up " + this.items[0];
				System.out.println(this.items[0].getInfo());
				// If the player already has a rubber chicken, upgrade it
				if (this.items[0] instanceof RubberChicken && p.hasItem(this.items[0])) {
					((RubberChicken) p.getItem(this.items[0])).increaseStrength(2);
					System.out.println("Your chicken grows larger");
				}
				deleteItem();
			} else {
				response = "There is nothing to pick up.";
			}
		} else if (util.findKeyword(response, useKeywords) != -1){
			if (p.getInventory().size() > 0) {
				ArrayList<Item> consumables = p.getConsumables();
				System.out.println(consumables);
				for (Item consumable : consumables) {
					if (util.findKeyword(response, consumable.toString()) != -1) {
						p.consumeItem(consumable);
						response = "You ate the " + consumable;
						//special case of teleport
						if (consumable instanceof TeleportPill) {
							this.removeOccupant(p);
						}
					}
				}
			}
		} else {
			response = "";
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
		
		if (this.hasEnemy()) {
			Enemy[] enemies = this.getEnemies();
			for (Enemy e : enemies) {
				if (e == null) {
					continue;
				}
				if (e.canAttack()) {
					roomGraphic[4] = 'G';
				}
			}
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


