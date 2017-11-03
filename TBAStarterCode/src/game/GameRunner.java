package game;

//import items.Item;
import rooms.*;
import people.Enemy;
import people.Person;
import people.Player;

import java.util.Scanner;

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
	
    public static void main (String[] args)
    {        
        Floor floor = GenerationUtilities.createFloor();
        GenerationUtilities.placeRandomItems(floor);
        Player me = new Player("Alex", "Feng", 2, 4, 10);
        Enemy ghost = new Enemy("Scary", "Ghost", 0, 0, 15);
        floor.placePlayer(me);
        me.setRoom(floor.getRoom(me.getX(), me.getY()));
        printIntro();
        
        boolean gameOn = true;
        Scanner in = new Scanner(System.in);
        
        while(gameOn)
        {
            int dir = (int)(Math.random() * 3);
            movePlayer(floor, ghost, dir);
            
            if (ghost.getRoom() == me.getRoom()) {
            	//encounterEnemy();
            }
            
           System.out.println("What would you like to do?");
           String response = in.nextLine();
           
           if (state == INTRO) {
        	   String introResponse = parseIntroResponse(response);
        	   if (introResponse.equals("~ENTERED")) {
        		   state = IN_PLAY;
        		   floor.printMap();
        		   System.out.println("You hear the door suddenly slam behind you. You are stuck.");
        		   continue;
        	   } else {
        		   System.out.println(introResponse);
        	   }
           }
           
           if (state == IN_PLAY) {
        	   if (util.findKeyword(response, "up") != -1) {
        		   movePlayer(floor, me, Constants.UP);
        	   }
               else if (util.findKeyword(response, "left") != -1) {
            	   movePlayer(floor, me, Constants.LEFT);
               } else if (util.findKeyword(response, "right") != -1) {
            	   movePlayer(floor, me, Constants.RIGHT);
               } else if (util.findKeyword(response, "down") != -1) {
            	   movePlayer(floor, me, Constants.DOWN);
               } else {
            	   System.out.println(me.getRoom().parseResponse(me, response));
               }
           }
           if (me.getHp() <= 0)  {
        	   printDeath();
        	   System.out.println("You've died. Game over.");
        	   gameOn = false;
           }
           
        }
		in.close();
    }
    
	/**
	 * If the player wishes to enter the house, the game will begin.
	 * @param statement the response of the user
	 * @return response	the action that happens
	 */
    
	private static String parseIntroResponse(String statement) {
		String response = "Nothing happens.";
		if (util.findKeyword(statement, "enter") != -1 || 
			util.findKeyword(statement, "go in") != -1) {
			response = "~ENTERED";
		}
		return response;
	}
	
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



