/**
 * Derek A - Jack R
 * Player Project
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class of the Java program.
 */

public class Main 
{
    
         
    public static void main(String[] args)
    {
       
       String worldType = userInit();
       
       if (worldType.equals("bad_world"))
       {
          Player negan = new Player();
          Zombie glen = new Zombie();
          World badWorld = new World();
          run(negan, glen, badWorld);
       }
       else if (worldType.equals("good_world"))
       {
          Player glen = new Player();
          World goodWorld = new World();
          run(glen, goodWorld);
       }
       else
       {
          worldType = userInit();
       
          if (worldType.equals("bad_world"))
          {
             Player negan = new Player();
             Zombie glen = new Zombie();
             World badWorld = new World();
             run(negan, glen, badWorld);
          }
          else if (worldType.equals("good_world"))
          {
             Player glen = new Player();
             World goodWorld = new World();
             run(glen, goodWorld);
          }
          
       }
       
       /**
       Player testPlayer = new Player();
       Zombie testZombie = new Zombie();
       World testWorld = new World();
       
       run(testPlayer, testZombie, testWorld);
       */
       
    } // end of main method
    
    // Set up for world and characters
    // Postcondition: User chooses which gamemode to play
    public static String userInit()
    {
       String worldName = "";
       
       Scanner keyboard = new Scanner(System.in);
       String command = "";
       
       System.out.println("Play game?");
       command = keyboard.nextLine();
       
       if(((command.toLowerCase()).indexOf("ye") > -1) || ((command.toLowerCase()).indexOf("sure") > -1) || (command.equals("1")))      // determines if original play game input is yes
       {
          System.out.println("Would you like to " + "\n" + "A) Play against zombie" + "\n" + "B) against no-one");
          command = keyboard.nextLine();
          
          if(((command.toLowerCase()).indexOf("play against zombie") > -1) || ((command.length() < 2) && ((command.toLowerCase()).indexOf("a") > -1)) || (command.equals("1")))
          {
             return "bad_world";
          }
          else if(((command.toLowerCase()).indexOf("no-one") > -1) || ((command.length() < 2) && ((command.toLowerCase()).indexOf("b") > -1)) || (command.equals("0")))
          {
             return "good_world";
          }
          else                                                                                       // for indeterminite input
          {
             System.out.println("Unclear input, please try again");
             return userInit();
          }
          
       }
       else if(((command.toLowerCase()).indexOf("no") > -1) || ((command.toLowerCase()).indexOf("why") > -1) || (command.equals("0")))   // determines if original play game input is no
       {
          System.out.println("I question why you launched the game if you didn't want to play it");
          return userInit();
       }
       else                                                             // for when original play input is indeterminite
       {
          System.out.println("I can't understand what you mean, please try again");
          return userInit();
       }
       
       
    
    }
    
    
    
    // the body of the programming, determines the interactions between the inputted player, zombie, and world
    // postcondition: specific instance is executed with zombie 
    public static void run(Player player, Zombie zombie, World world)
    {
       Scanner keyboard = new Scanner(System.in);
       String command = "";

       while (player.isAlive() == true)
       {
         
         world.displayWorld(player, zombie, world);
         System.out.println("What would you like to do? D: Turn Right / A: Turn Left / W: Move Forward - type letter below and press \"enter\"");
         command = keyboard.nextLine();
         String tempCommand = command + "";
         
         if ((tempCommand.toLowerCase()).equals("d") || ((tempCommand.toLowerCase()).indexOf("right") > 0))
         {
            player.turnClockwise();
         }
         
         else if ((tempCommand.toLowerCase()).equals("a") || ((tempCommand.toLowerCase()).indexOf("left") > 0))
         {
            player.turnCounterClockwise();
         }
         
         else if ((tempCommand.toLowerCase()).equals("w") || ((tempCommand.toLowerCase()).indexOf("move") > 0) || ((tempCommand.toLowerCase()).indexOf("forward") > 0))
         {
            player.moveForward(world);
         }
         
         else
         {
            continue;
         }
         
         zombie.move(world, player);                                                                         // Zombie's turn to move
         
         if ((player.getX() == zombie.getX()) && (player.getY() == zombie.getY()))                           // zombie kills player if they occupy the same point
         {
            player.setAlive(false);
            player.setReasonDead("The zombie ate you");
            continue;
         }
         
       }
       for (int i = 0; i < 27; i++)                                                             // When player dies, prints "GAME OVER" 27 times
       {
           System.out.println("GAME OVER - " + (player.whyDead()));
       }
    }
    
    // same as regular run program, except there is no zombie
    public static void run(Player player,  World world)
    {
       Scanner keyboard = new Scanner(System.in);
       String command = "";

       while (player.isAlive() == true)
       {
         
         world.displayWorld(player, world);
         System.out.println("What would you like to do? A: Turn Left / D: Turn Right / W: Move Forward - type letter below and press \"enter\"");
         command = keyboard.nextLine();
         String tempCommand = command + "";
         
         if ((tempCommand.toLowerCase()).equals("a") || ((tempCommand.toLowerCase()).indexOf("left") > 0))
         {
            player.turnCounterClockwise();
         }
         
         else if ((tempCommand.toLowerCase()).equals("d") || ((tempCommand.toLowerCase()).indexOf("right") > 0))
         {
            player.turnClockwise();
         }
         
         else if ((tempCommand.toLowerCase()).equals("w") || ((tempCommand.toLowerCase()).indexOf("move") > 0) || ((tempCommand.toLowerCase()).indexOf("forward") > 0))
         {
            player.moveForward(world);
         }
         
         else
         {
            continue;
         }
         
       }
       
       
       for (int i = 0; i < 27; i++)                                                             // When player dies, prints "GAME OVER" 27 times
       {
           System.out.println("GAME OVER - " + (player.whyDead()));
       }
    }

}   // end of main class
