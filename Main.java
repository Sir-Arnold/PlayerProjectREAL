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
       Player bill = new Player();
       World plane1 = new World(10);
       Zombie glen = new Zombie();
       run(bill, glen, plane1);
       
       
    } // end of main method
    
    public static void run(Player player, Zombie zombie, World world)
    {
       Scanner keyboard = new Scanner(System.in);
       String command = "";

       while (player.isAlive() == true)
       {
         
         world.displayWorld(player, zombie, world);
         System.out.println("What would you like to do? A: Turn Right / S: Turn Left / D: Move Forward - type letter below and press \"enter\"");
         command = keyboard.nextLine();
         String tempCommand = command + "";
         
         if ((tempCommand.toLowerCase()).equals("a") || ((tempCommand.toLowerCase()).indexOf("right") > 0))
         {
            player.turnClockwise();
         }
         
         else if ((tempCommand.toLowerCase()).equals("s") || ((tempCommand.toLowerCase()).indexOf("left") > 0))
         {
            player.turnCounterClockwise();
         }
         
         else if ((tempCommand.toLowerCase()).equals("d") || ((tempCommand.toLowerCase()).indexOf("move") > 0) || ((tempCommand.toLowerCase()).indexOf("forward") > 0))
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
            continue;
         }
         
       }
       for (int i = 0; i < 27; i++)                                                             // When player dies, prints "GAME OVER" 27 times
        {
            System.out.println("GAME OVER");
        }
    }

}   // end of main class
