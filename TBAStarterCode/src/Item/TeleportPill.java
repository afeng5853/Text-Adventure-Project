package Item;
import java.util.*;

import constants.Constants;
import people.Person;

/**
 * The Teleport Pill is a consumable that moves the player to a random location on the game board.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/31/17
 */

public class TeleportPill extends Consumables{
	
	//fields
	private int x;
	private int y;
	public final static int HP_RESTORE = 0;
	
	//constructors
	public TeleportPill() {
		super(HP_RESTORE);
		this.x = (int) (Math.random() * Constants.LENGTH) ;
		this.y = (int) (Math.random() * Constants.WIDTH) ;
	}
	
	public TeleportPill(Person p, int x, int y) {
		super(p, HP_RESTORE);
		this.x = x;
		this.y = y;
	}
	
	public TeleportPill(Person p) {
		super(p, HP_RESTORE);
		this.x = (int) (Math.random() * Constants.LENGTH) ;
		this.y = (int) (Math.random() * Constants.WIDTH) ;
	}
	
	// methods
	
	/**
     * Using the item, will teleport the player to a random location on the game board.
     */
	
	@Override
	public void useItem() {
		System.out.println("You magically appear in another room");
		this.getPerson().setX(this.x);
		this.getPerson().setX(this.y);
	}
	
	@Override
	public String getInfo() {
		return "This untested teleport pill can help you teleport into a safer room. Risks include getting stuck into another dimension and having a mild headache.";
	}
	
	@Override
	public String toString() {
		return "Pill";
	}

}