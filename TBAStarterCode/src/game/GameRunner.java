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
        floor.printMap();
        //me.move(Constants.LEFT);
        
        boolean gameOn = true;
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
           System.out.println("Direction?");
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



