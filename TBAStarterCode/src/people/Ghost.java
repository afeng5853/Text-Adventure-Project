package people;

import area.AbandonedHouse;
import constants.Constants;
import floor.Floor;

public class Ghost extends Enemy {

	public Ghost(int x, int y, int z, int hp, int hitRange, int strength, Person focus, Floor floor, AbandonedHouse house) {
		super(x, y, z, hp, hitRange, strength, focus, floor, house);
	}
	
	@Override
	public int getNextMove(Player p) {
		// If the player is in the Ghost's hit range (includes diagonal)
		if (p.getY() > this.getY()) {
			return Constants.DOWN;
		} else if (p.getY() < this.getY()) {
			return Constants.UP;
		} else if (p.getX() > this.getX()) {
			return Constants.RIGHT;
		} else if (p.getX() < this.getX()) {
			return Constants.LEFT;
		}
		return -1;
	}

	@Override
	public void counterAttack(Player p) {
	}

	@Override
	public String toString() {
		return "Ghost";
	}
	
	/**
	 * Ghosts can go through walls so they don't need to check if there is a wall (Also messed up by not making the floor a graph, so implementation
	 * would be sloppy)
	 * @param dir The direction the enemy goes (an int constant)
	 */
	@Override
	public void move(int dir) {
		if (dir == Constants.LEFT) {
			this.setX(this.getX() - 1);
		} else if (dir == Constants.RIGHT) {
			this.setX(this.getX() + 1);
		} else if (dir == Constants.UP) {
			this.setY(this.getY() - 1);
		} else if (dir == Constants.DOWN) {
			this.setY(this.getY() + 1);
		} else {
		}
	}

}
