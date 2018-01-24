public class Zombie
{
   // instance variables (properties) ********************
   
   private boolean myAlive;   // alive = true, dead = false
   private int myX;           // location on x-axis
   private int myY;           // location on y-axis
   private int mySpeed;       // speed of object
   private int myActions;     // number of actions by this object
   private int mySteps;       // # of total steps this object has taken
   private int myID;          // unique ID # of this object
   
   // class variables ************************************    
   
   private static int currentIDNumber = 1;     // ensures each object has unique ID #
   
   // class constants ************************************
   
   public final static int MAX_STEPS = 100;     // any player dies after this # of total steps
   public final static int MAX_ACTIONS = 30;    // any player dies after this # of total actions
    
   // default constructor *******************************
   // postcondition: Aombie object is instantiated with random direction, speed, and x position
   
   public Zombie()
   {
      myAlive = true;
      myActions = 0;
      mySteps = 0;       
        
      mySpeed = 1;
      myX = 2;
      myY = 2;
        
      myID = currentIDNumber;
      currentIDNumber++;;
   }//end of regular constructor
   
   // other constructor
   //postcondition: the created Zombie has specified paramaters
   public Zombie(int speed, int x,int y)
   {
      myAlive = true;
      myActions = 0;
      mySteps = 0;       
        
      mySpeed = speed;
      myX = x;
      myY = y;
        
      myID = currentIDNumber;
      currentIDNumber++;;
   }//end of regular constructor
   
   // accessor methods *************************************
   public int getX()
   {
      return myX;
   }
   
   public int getY()
   {
      return myY;
   }

   public int getSpeed()
   {
      return mySpeed;
   }

   public int getActions()
   {
      return myActions;
   }

   public int getSteps()
   {
      return mySteps;
   }
    
   public int getID()
   {
      return myID;
   }
    
   public boolean isAlive()
   {
      return myAlive;
   }
   
   // interesting metods ***********************************
   
   // moves zombie
   // postcondition: zombie moves closer to player
   public void move(World world, Player player)
   {
      int moveAmount = mySpeed;
      
      int xDifferential = myX - player.getX();                   // establshes a value to base directionality of Zombie in relation to player (x)
      int yDifferential = myY - player.getY();                   // (y)
      
      if ((xDifferential == 0) && (yDifferential == 0))
      {
         player.setAlive(false);
      }
      
      else
      {
         if (Math.abs(xDifferential) > Math.abs(yDifferential))     // Determines if the distance between X values is greater than the distance between y values
         {
            if (xDifferential > 0)                                  // Determines if zombie is to the right or left of player
            {
               myX -= moveAmount;
            }
            else                                                    // In the case that zombie is to the left of player
            {
               myX += moveAmount;
            }
         }
         else if (Math.abs(xDifferential) < Math.abs(yDifferential))// in the case that the zombie is farther from player in y value
         {
            if (yDifferential > 0)                                  // Determines if zombie is above or below player
            {
               myY -= moveAmount;
            }
            else
            {
               myY += moveAmount;
            }
         }
         else if (Math.abs(xDifferential) == Math.abs(yDifferential))// in the case that zombie is equally distant from player in x and y values
         {                                                           // same operation as xDif > yDif
            if (xDifferential > 0)                                  // Determines if zombie is to the right or left of player
            {
               myX -= moveAmount;
            }
            else                                                    // In the case that zombie is to the left of player
            {
               myX += moveAmount;
            } 
         }
      } // end of else
   } // end of move method


}// end of Zombie class