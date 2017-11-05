package game;

//import items.Item;
import rooms.*;
import people.Enemy;
import people.Ghost;
import people.Person;
import people.Player;

import java.util.ArrayList;
import java.util.Scanner;

import Item.Key;
import area.AbandonedHouse;
import constants.Constants;
import floor.Floor;

import utilities.util;

/**
 * Initializes the text adventure game by creating a player and the game board.
 * Additionally, allows the player to move around the game board
 * @author Alex Feng
 * @author Raymond Cheung 
 * @since 10/30/17
 */

public class GameRunner {
	
	private static int state = 0;
	private final static int INTRO = 0;
	private final static int IN_PLAY = 1;
	private static String help = "Commands:" + "\n" +
								   "Movement: up, right, left, down, climb" + "\n" +
								   "Search: search for items in a room" + "\n" +
								   "Take: takes items from a room" + "\n" +
								   "Eat: uses consumables" + "\n" +
								   "Attack: attack enemies if you have a weapon" + "\n";
	
    public static void main (String[] args)
    {        
        Floor floor = GenerationUtilities.createFloor();
        AbandonedHouse house = new AbandonedHouse(new Floor[] {floor, new Floor(), new Floor(), new Floor(), new Floor(), new Floor(), new Floor(), new Floor(), new Floor(), new Floor(), new Floor(), new Floor(), new Floor(), new Floor()});
        GenerationUtilities.placeRandomItems(floor);
        Player me = new Player(2, 4, 0, 20, 1, floor, house);
        Ghost ghost = new Ghost(0, 0, 0, 25, 1, 2, me, floor, house);
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(ghost);
        
        floor.placePlayer(me);
        floor.placePlayer(ghost);
        me.setRoom(me.getFloor().getRoom(me.getX(), me.getY()));
        
        printIntro();
        
        boolean gameOn = true;
        Scanner in = new Scanner(System.in);
        
        int turns = 0;
        while(gameOn)
        {
        	System.out.println("---------------------------------------");
        	if (gameOn) {
        		gameOn = enemyTurn(me.getFloor(), me, enemies, turns);
        	}
        	if (gameOn) {
        		gameOn = playerTurn(me.getFloor(), me, in);
        	}

        	System.out.println("---------------------------------------");
        	turns++;
        }
        
		in.close();
    }
    
    /**
     * The enemy's actions
     * @param floor The current floor where actions are being made
     * @param p The player playing
     * @param enemies The enemies on the floor
     * @param turns Count of turns
     * @return Whether or not the game should end
     */
    private static boolean enemyTurn(Floor floor, Player p, ArrayList<Enemy> enemies, int turns) {
    	if (state == IN_PLAY) {
    		for (int i = enemies.size() - 1; i >= 0; i--) {
    			Enemy enemy = enemies.get(i);
    			// Only one enemy in this game, so this works
    			if (isDead(enemy)) {
    				enemies.remove(enemy);
    				System.out.println("The " + enemy + " drops a key! You take it and add it to you inventory");
            		p.addToInventory(new Key());
    				continue;
    			}
        		int nextMove = enemy.getNextMove(p);
        		if (enemy.canAttack(p)) {
        			enemy.attack(p);
        			if (isDead(p))  {
        				return false;
        		    }
        		}
        		// move every other turn
        		if (turns % 2 == 1) {
        			floor.removePlayer(enemy);
        			enemy.move(nextMove);
        			floor.placePlayer(enemy);
        		}
        	}
    	}
		return true;
    }
    
    /**
     * The player's actions
     * @param floor The current floor where actions are being made
     * @param me The player playing
     * @param in The scanner to get player's response
     * @return
     */
    private static boolean playerTurn(Floor floor, Player me, Scanner in) {
    	System.out.println("What would you like to do?");
        String response = in.nextLine();
        //	public String parseResponse(Player p, String response_) {

        if (state == INTRO) {
     	   String introResponse = parseIntroResponse(response);
     	   if (introResponse.equals("~ENTERED")) {
     		   state = IN_PLAY;
     		   System.out.println("You hear the door suddenly slam behind you. You are stuck.");
     	   } else {
     		   System.out.println(introResponse);
     	   }
        }
        
        if (state == IN_PLAY) {
      	   if (util.findKeyword(response, "help") != -1) {
            	System.out.println(help);
        	   }
        	    if (util.findKeyword(response, "stair") != -1) {
               	System.out.println(me.getRoom().parseResponse(me, response));
      	   }
        	    else if (util.findKeyword(response, "up") != -1) {
     		   movePlayer(floor, me, Constants.UP);
     	   }
            else if (util.findKeyword(response, "left") != -1) {
         	   movePlayer(floor, me, Constants.LEFT);
            } else if (util.findKeyword(response, "right") != -1) {
         	   movePlayer(floor, me, Constants.RIGHT);
            } else if (util.findKeyword(response, "down") != -1) {
         	   movePlayer(floor, me, Constants.DOWN);
            } else {
            	floor.printMap();
            	String roomResponse = me.getRoom().parseResponse(me, response);
            	System.out.println(roomResponse);
            	if (roomResponse.equals("You've won the game!")) {
            		return false;
            	}
            }
        }
        if (isDead(me))  {
     	   return false;
        }
        
        return true;
    }
    /**
     * Returns a boolean whether or not the player is dead
     * @param me The player to be checked
     * @return Whether or not the player is dead
     */
    private static boolean isDead(Player me) {
    	if (me.getHp() <= 0)  {
      	   printDeath();
      	   System.out.println("You've died. Game over.");
      	   if (me.getInventory().size() == 0) {
      		   System.out.println("It seems like you're new to this game, try searching for items.");
      	   }
      	   return true;
         }
    	return false;
    }
    
    /**
     * Returns a boolean whether or not the enemy is dead
     * @param e The enemy to be checked
     * @return Whether or not the enemy is dead
     */
    private static boolean isDead(Enemy e) {
    	if (e.getHp() <= 0)  {
      	   return true;
         }
    	return false;
    }
    
	/**
	 * If the player wishes to enter the house, the game will begin.
	 * @param statement the response of the user
	 * @return response	the action that happens
	 */
    
	private static String parseIntroResponse(String statement) {
		String response = "Nothing happens.";
		if (util.findKeyword(statement, "enter") != -1 || 
			util.findKeyword(statement, "go in") != -1 ||  
			util.findKeyword(statement, "go inside") != -1){
			response = "~ENTERED";
		}
		return response;
	}
	
	/**
	 * Intro ASCII Art
	 */
	private static void printIntro() {
		System.out.println("                           \n"
				+ "                                                /\\\n"
				+ "                             _                 /  \\  /\\\n"
				+ "                    ________[_]________      /\\/    \\/  \\\n"
				+ "           /\\      /\\        ______    \\    /   /\\/\\  /\\/\\\n"
				+ "          /  \\    //_\\       \\    /\\    \\  /\\/\\/    \\/    \\\n"
				+ "   /\\    / /\\/\\  //___\\       \\__/  \\    \\/\n"
				+ "  /  \\  /\\/    \\//_____\\       \\ |[]|     \\\n"
				+ " /\\/\\/\\/       //_______\\       \\|__|      \\\n"
				+ "/      \\      /XXXXXXXXXX\\                  \\\n"
				+ "        \\    /_I_II  I__I_\\__________________\\\n"
				+ "               I_I|  I__I_____[]_|_[]_____I\n"
				+ "               I_II  I__I_____[]_|_[]_____I\n"
				+ "               I II__I  I     XXXXXXX     I\n"
				+ "            ~~~~~\"   \"~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("You have discovered an abandoned house in the middle of nowhere.");
	}

	/**
	 * End ASCII Art
	 */
	private static void printDeath() {
			System.out.println("                uuuuuuu\n"
	+ "             uu$$$$$$$$$$$uu\n"
	+ "          uu$$$$$$$$$$$$$$$$$uu\n"
	+ "         u$$$nick$w$$$$$$$$$$$u\n"
	+ "        u$$$$$$$$$$$$$$$$$$$$$$$u\n"
	+ "       u$$$$$$was$$$$here$$$$$$$$u\n"
	+ "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n"
	+ "       u$$$$$$\"   \"$$$\"   \"$$$$$$u\n"
	+ "       \"$$$$\"      u$u       $$$$\"\n"
	+ "        $$$u       u$u       u$$$\n"
	+ "        $$$u      u$$$u      u$$$\n"
	+ "        \"$$$$uu$$$   $$$uu$$$$\"\n"
	+ "          \"$$$$$$$\"   \"$$$$$$$\"\n"
	+ "            u$$$$$$$u$$$$$$$u\n"
	+ "             u$\"$\"$\"$\"$\"$\"$u\n"
	+ "  uuu        $$u$ $ $ $ $u$$       uuu\n"
	+ " u$$$$        $$$$$u$u$u$$$       u$$$$\n"
	+ "  $$$$$uu      \"$$$$$$$$$\"     uu$$$$$$\n"
	+ "u$$$$$$$$$$$uu    \"\"\"\"\"    uuuu$$$$$$$$$$\n"
	+ "$$$$\"\"\"$$$$$$$$$$uuu   uu$$$$$$$$$\"\"\"$$$\"\n"
	+ " \"\"\"      \"\"$$$$$$$$$$$uu \"\"$\"\"\"\n"
	+ "           uuuu \"\"$$$$$$$$$$uuu\n"
	+ "  u$$$uuu$$$$$$$$$uu \"\"$$$$$$$$$$$uuu$$$\n"
	+ "  $$$$$$$$$$\"\"\"\"           \"\"$$$$$$$$$$$\"\n"
	+ "   \"$$$$$\"                      \"\"$$$$\"\"\n"
	+ "     $$$\"                         $$$$\"\n");
		}
		
	/**
	 * Displays the player moving across the game board.
	 * @param floor the current floor the player is on
	 * @param user	the player that should be moved
	 * @param dir	the direction as an integer to move in
	 */
	
	private static void movePlayer(Floor current, Person user, int x) {
	   current.removePlayer(user);
	   user.move(x);
	   current.placePlayer(user);
	   current.printMap();
	   System.out.println(user.getRoom().getDesc());
	}
	
}


