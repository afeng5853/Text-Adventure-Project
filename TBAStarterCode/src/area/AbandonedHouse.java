package area;

import floor.Floor;
import people.Player;
import rooms.Room;

/**
 * The AbandonedHouse is an abstracted away array of floors
 * @author alex
 *
 */
public class AbandonedHouse {

	private Floor[] house;
	
	public AbandonedHouse(Floor[] house) {
		this.setHouse(house);
	}

	public Floor[] getHouse() {
		return house;
	}

	public void setHouse(Floor[] house) {
		this.house = house;
	}


}
