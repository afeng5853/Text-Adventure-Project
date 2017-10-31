package Item;

/**
 * Used to create the various items in the game.
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public interface Item {
	
	// how the item is to be used
	public abstract void useItem();
	
	// a brief description of the item
	public abstract String toString();

}
