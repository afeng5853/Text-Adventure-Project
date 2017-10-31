package Item;
import java.util.*;

public class TeleportPill extends Consumables{
	
	private boolean broken; 

	
	public TeleportPill(String name, int value, boolean broken) {
		super(name, value);
		this.broken = broken;
	}

	public int useItem(boolean broken) {
		if (broken) {
				// do stuff
			}
		else {
			// do stuff
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "This untested teleport pill can help you teleport into a safer room. Risks include getting stuck into another dimension and having a mild headache.";
	}
}