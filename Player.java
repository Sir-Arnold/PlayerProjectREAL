public class Player
{
   // instance variables (properties) ********************
   
   private boolean myAlive;   // alive = true, dead = false
   private int myDirection;   // -1 west, 1 east
   private int myX;           // location on x-axis
   private int mySpeed;       // speed of object
   private int myActions;     // number of actions by this object
   private int mySteps;       // # of total steps this object has taken
   private int myID;          // unique ID # of this object
    
   // class variables ************************************    
    
   private static int currentIDNumber = 1;     // ensures ea object has unique ID #
    
   // class constants ************************************
   
   public final static int MAX_STEPS = 100;     // any player dies after this # of total steps
   public final static int MAX_ACTIONS = 30;    // any player dies after this # of total actions
    
   // default constructor *******************************
   // postcondition: Player object is instantiated with random direction, speed, and x position
   public Player()
   {
      this((int) (Math.random() * 2) + 1, (int) (Math.random() * 2) + 1, (int) (Math.random() * 10) - 5);
   }
    
   // other constructor(s)  ******************************
   // postcondition: Player oject is instantiated with direction, speed, & x values
   public Player(int direction, int speed, int x)
   {
      myAlive = true;
      myActions = 0;
      mySteps = 0;       
        
      myDirection = direction;
      mySpeed = speed;
      myX = x;
        
      myID = currentIDNumber;
      currentIDNumber++;       // increment static counter for next player
   }
    
   // accessor methods *************************************
   
   public int getDirection()
   {
      return myDirection;
   }
    
   public int getX()
   {
      return myX;
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
        
   // modifier methods ***********************************

   public void setDirection(int direction)
   {
      myDirection = direction;
   }
    
   public void setX(int x)
   {
      myX = x;
   }

   public void setSpeed(int speed)
   {
      mySpeed = speed;
   }
    
   // interesting methods *******************************
    
   // turn to the other direction
   // postcondition: player object turns from east to west or vice versa
   public void turn()
   {
      myDirection *= -1;
   }
    
   // move in the current pointed direction
   // postcondition: player's position is updated based on its speed & direction
   public void move()
   {
      int moveAmount = mySpeed * myDirection;   // amount of this move
        
      if (mySteps + moveAmount < MAX_STEPS && myActions + 1 < MAX_ACTIONS && Math.abs(myX + moveAmount) < World.SIZE / 2)
      {
         mySteps += moveAmount;      // update lifetime # of steps
         myActions++;                // update lifetime # of actions
         myX += moveAmount;
      }
      else
      {
         myAlive = false;            // player dies if over max # of steps or actions
      }
        
   }
    
   // postcondition: returns the state of the object
   public String toString()
   {
      return "ID=" + myID + " location=" + myX + " speed=" + mySpeed + " direction=" + myDirection + " total actions=" + myActions + " total steps=" + mySteps;
   }
    
}// end of Player class