package Item;
import java.util.*;

import constants.Constants;
import people.Person;

public class TeleportPill extends Consumables{
	private int x;
	private int y;
	public final static int HP_RESTORE = 0;
	
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
	
	@Override
	public void useItem() {
		this.getPerson().setX(this.x);
		this.getPerson().setX(this.y);
	}
	

	@Override
	public String toString() {
		return "Teleport Pill";
	}

}