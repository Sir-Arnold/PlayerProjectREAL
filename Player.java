public class Player
{
   // instance variables (properties) ********************
   
   private boolean myAlive;   // alive = true, dead = false
   private int myDirection;   // 1 north, 2 east, -1 south, -2 west
   private int myX;           // location on x-axis
   private int myY;           // location on y-axis
   private int mySpeed;       // speed of object
   private int myActions;     // number of actions by this object
   private int mySteps;       // # of total steps this object has taken
   private int myID;          // unique ID # of this object
   private int myShapeValue;  // display of player based on direction: 1:^, 2: >, -1: v, -2: <
   private String reasonDead;    // justification for why player died
   
   // class variables ************************************    
   
   private static int currentIDNumber = 1;     // ensures each object has unique ID #
   
   // class constants ************************************
   
   public final static int MAX_STEPS = 100;     // any player dies after this # of total steps
   public final static int MAX_ACTIONS = 30;    // any player dies after this # of total actions
    
   // default constructor *******************************
   // postcondition: Player object is instantiated with random direction, speed, and x position
   public Player()
   {
      myAlive = true;
      myActions = 0;
      mySteps = 0;       
        
      myDirection = 2;
      mySpeed = 1;
      myX = 5;
      myY = 0;
      myShapeValue = 2;
        
      myID = currentIDNumber;
      currentIDNumber++;;
   }
    
   // other constructor(s)  ******************************
   // postcondition: Player oject is instantiated with direction, speed, & x values
   public Player(int direction, int speed, int x,int y)
   {
      myAlive = true;
      myActions = 0;
      mySteps = 0;       
        
      myDirection = direction;
      mySpeed = speed;
      myX = x;
      myY = y;
      myShapeValue = myDirection;
        
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
        
   // modifier methods ***********************************

   public void setDirection(int direction)
   {
      myDirection = direction;
   }
    
   public void setX(int x)
   {
      myX = x;
   }

   public void setY(int y)
   {
      myY = y;
   }
   
   public void setSpeed(int speed)
   {
      mySpeed = speed;
   }
   public void setAlive(boolean alive)
   {
      myAlive = alive;
   }
   public void setReasonDead(String reason)
   {
      reasonDead = reason;
   }
   public String whyDead()
   {
      return reasonDead;
   }
    
   // interesting methods *******************************
    
   // turn to player clockwise
   // postcondition: player object turns clockwise
   public void turnClockwise()
   {
      if (myDirection == -2)
      {
          myDirection = 1;
          myShapeValue = myDirection;
          return;
      }
      else if (myDirection == -1)
      {
          myDirection = -2;
          myShapeValue = myDirection;
          return;
      }
      else if (myDirection == 1)
      {
          myDirection = 2;
          myShapeValue = myDirection;
          return;
      }
      else if (myDirection == 2)
      {
          myDirection = -1;
          myShapeValue = myDirection;
          return;
      }
   }
   
   // turn to player counter-clockwise
   // postcondition: player object turns counter-clockwise
   public void turnCounterClockwise()
   {
      if (myDirection == -2)
      {
          myDirection = -1;
          myShapeValue = myDirection;
          return;
      }
      else if (myDirection == -1)
      {
          myDirection = 2;
          myShapeValue = myDirection;
          return;
      }
      else if (myDirection == 1)
      {
          myDirection = -2;
          myShapeValue = myDirection;
          return;
      }
      else if (myDirection == 2)
      {
          myDirection = 1;
          myShapeValue = myDirection;
          return;
      }
   }
   
   public String shape()
   {
      String shape;
      if (myShapeValue == 1)
      {
         shape = "^";
      }
      else if (myShapeValue == 2)
      {
         shape = ">";
      }
      else if (myShapeValue == -1)
      {
         shape = "v";
      }
      else if (myShapeValue == -2)
      {
         shape = "<";
      }
      else
      {
         shape = "E";
      }
      
      return shape;
   }
   
   // move in the current pointed direction
   // postcondition: player's position is updated based on its speed & direction
   public void moveForward(World world)
   {
      int moveAmount = mySpeed ;   // amount of this move
        
      if (mySteps + moveAmount < MAX_STEPS && myActions + 1 < MAX_ACTIONS)
      {
         if (myDirection % 2 == 0)         // determines if direction is East/West
         {
            if ((myX + moveAmount < world.getLength()+1) && (myX - moveAmount > -1))
            {
               mySteps += moveAmount;      // update lifetime # of steps
               myActions++;                // update lifetime # of actions
            
               if (myDirection > 0)        // determine if direction is east
               {
                  myX += moveAmount;
               }
               else
               {
                  myX -= moveAmount;
               }
            }
            else
            {
               myX = world.getLength() / 2;
               myY = 0;
            }
        }
        else if (myDirection % 2 != 0) 
        {
            if ((myY + (myDirection * moveAmount) <= world.getLength() / 2) && (myY - ((-1) * myDirection * moveAmount) >= -4))
            {
               mySteps += moveAmount;      // update lifetime # of steps
               myActions++;                // update lifetime # of actions
            
               if (myDirection > 0)        // Determine whether player is facing north 
               {
               myY += moveAmount;       // Player moves up on the Y axis
               }
               else
               {
                  myY -= moveAmount;       // Player moves down on the Y axis
               }
            }
            else
            {
               myX = world.getLength() / 2;
               myY = 0;
            }
            
         }
      }
      else
      {
         myAlive = false;            // player dies if over max # of steps or actions
         reasonDead = "Starved to death";
      }
        
   } // end of move method
   
   
   // postcondition: returns the state of the object
   public String toString()
   {
      return "ID=" + myID + " location=" + myX + "," + myY + " speed=" + mySpeed + " direction=" + myDirection + " total actions=" + myActions + " total steps=" + mySteps;
   }
    
}// end of Player class