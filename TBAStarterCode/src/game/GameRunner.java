package game;

import items.Item;
import rooms.*;
import people.Person;
import people.Player;

import java.util.Scanner;

import area.AbandonedHouse;
import constants.Constants;
import floor.Floor;

public class GameRunner {

    public static void main (String[] args)
    {        
        Floor floor = GenerationUtilities.createFloor();
        //floor.printMap();

        //System.out.println("***********************");
        Player me = new Player("Alex", "Feng", 2, 4);
        
        floor.placePlayer(me);
        me.setRoom(floor.getRoom(me.getX(), me.getY()));
        //floor.printMap();
        //me.move(Constants.LEFT);
        
        boolean gameOn = true;
        Scanner in = new Scanner(System.in);
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
        while(gameOn)
        {
           System.out.println("What would you like to do?");
           String dir = in.nextLine();
           
           if (dir.equals("up")) {
        	   if (me.canMove(Constants.UP)) {
        		   floor.removePlayer(me);
        		   me.move(Constants.UP);
        		   
        		   floor.placePlayer(me);
        	   }
           } else if (dir.equals("left")) {
        	   if (me.canMove(Constants.LEFT)) {
        		   floor.removePlayer(me);
        		   me.move(Constants.LEFT);
        		   
        		   floor.placePlayer(me);
        	   }
           } else if (dir.equals("right")) {
        	   if (me.canMove(Constants.RIGHT)) {
        		   floor.removePlayer(me);
        		   me.move(Constants.RIGHT);
        		   
        		   floor.placePlayer(me);
        	   }
           } else if (dir.equals("down")) {
        	   if (me.canMove(Constants.DOWN)) {
        		   floor.removePlayer(me);
        		   me.move(Constants.DOWN);
        		   
        		   floor.placePlayer(me);
        	   }
           } 
           
           floor.printMap();
        }
		in.close();
    }

}



