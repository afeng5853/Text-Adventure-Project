package Item;

/**
 * Used to create the various items in the game.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public interface Item {
	
	// how the item is used
	public abstract int useItem();

	// description of the item
	public abstract String toString();
}
