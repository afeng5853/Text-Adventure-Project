package rooms;

import people.Person;
import items.Item;

import java.util.Arrays;

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

    public Person[] getOccupants() {
        return occupants;
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

    @Override
    public abstract String toString();

}


