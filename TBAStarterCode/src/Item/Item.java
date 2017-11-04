package Item;

/**
 * Used to create the various items in the game.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public interface Item {
	
	public abstract void useItem();
	
	// item name
	public abstract String toString();
	
	// description of item
	public abstract String getInfo();

}
