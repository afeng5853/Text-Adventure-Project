package game;

//import items.Item;
import rooms.*;
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
	
    public static void main (String[] args)
    {        
        Floor floor = GenerationUtilities.createFloor();
        Player me = new Player("Alex", "Feng", 2, 4);
        floor.placePlayer(me);
        me.setRoom(floor.getRoom(me.getX(), me.getY()));
        printIntro();
        
        boolean gameOn = true;
        Scanner in = new Scanner(System.in);
        
        while(gameOn)
        {
           System.out.println("What would you like to do?");
           String response = in.nextLine();
           
           if (util.findKeyword(response, "up", 0) != -1) {
        	   if (me.canMove(Constants.UP)) {
        		   floor.removePlayer(me);
        		   me.move(Constants.UP);
        		   
        		   floor.placePlayer(me);
        		   floor.printMap();
                   System.out.println(me.getRoom().getDesc());
        	   }
           } else if (util.findKeyword(response, "left", 0) != -1) {
        	   if (me.canMove(Constants.LEFT)) {
        		   floor.removePlayer(me);
        		   me.move(Constants.LEFT);
        		   
        		   floor.placePlayer(me);
        		   floor.printMap();
                   System.out.println(me.getRoom().getDesc());
        	   }
           } else if (util.findKeyword(response, "right", 0) != -1) {
        	   if (me.canMove(Constants.RIGHT)) {
        		   floor.removePlayer(me);
        		   me.move(Constants.RIGHT);
        		   
        		   floor.placePlayer(me);
        		   floor.printMap();
                   System.out.println(me.getRoom().getDesc());
        	   }
           } else if (util.findKeyword(response, "down", 0) != -1) {
        	   if (me.canMove(Constants.DOWN)) {
        		   floor.removePlayer(me);
        		   me.move(Constants.DOWN);
        		   
        		   floor.placePlayer(me);
        		   floor.printMap();
                   System.out.println(me.getRoom().getDesc());
        	   }
           } else {
        	   System.out.println(me.getRoom().parseResponse(response));
           }
           
        }
		in.close();
    }
}



