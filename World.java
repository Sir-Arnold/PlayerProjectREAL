public class World
{

/////////////////////////////////// Initialization
   public int myLength;
   
   public World()
   {
      myLength = 10;
   }
   
   public World(int len)
   {
      myLength = len;
   }

//////////////////////////////////// accessor methods
   public int getLength()
   {
      return myLength;
   }

//////////////////////////////////// interesting methods
   public void displayWorld(Player player, Zombie zombie, World world)
   {
      int playerX = player.getX();
      int playerY = player.getY();
      
      int zombieX = zombie.getX();
      int zombieY = zombie.getY();
      
      int worldLength = world.getLength();
      
      if (zombieY > playerY)
      {
      
         for (int i = 0; i < worldLength; i++)
         {
            if (zombieY < ((worldLength / 2) - i))
            {
               for (int j = 0; j <= worldLength; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
            else if (zombieY == ((worldLength / 2) - i))
            {
               for (int j = 0; j < zombieX; j++)
               {
                  System.out.print("#");
               }
            
               System.out.print("X");
            
               for (int j = 0; j < (worldLength - zombieX); j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }  
            else if (playerY < ((worldLength / 2) - i))
            {
               for (int j = 0; j <= worldLength; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
            else if (playerY == ((worldLength / 2) - i))
            {
               for (int j = 0; j < playerX; j++)
               {
                  System.out.print("#");
               }
               
               System.out.print(player.shape());
               
               for (int j = 0; j < worldLength - playerX; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
            else if ((playerY > ((worldLength / 2) - i) && (zombieY > ((worldLength / 2) - i))))
            {
               for (int j = 0; j <= worldLength; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
         } // end of for loop
      } // end of if zombieY > playerY
      
      if (zombieY == playerY)
      {
      
         for (int i = 0; i < worldLength; i++)
         {
            if (playerY < ((worldLength / 2) - i))
            {
               for (int j = 0; j <= worldLength; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
            else if (playerY == ((worldLength / 2) - i))
            {
               if (playerX < zombieX)
               {
                  for (int j = 0; j < playerX; j++)
                  {
                     System.out.print("#");
                  }
                  
                  System.out.print(player.shape());
                  
                  for (int j = 0; j < (zombieX - playerX); j++)
                  {
                     System.out.print("#");
                  }
                  
                  System.out.print("X");
                  
                  for (int j = 0; j < (worldLength - zombieX); j++)
                  {
                     System.out.print("#");
                  }
               }
            
               for (int j = 0; j < (worldLength - playerX); j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }  
            else if (playerY > ((worldLength / 2) - i))
            {
               for (int j = 0; j <= worldLength; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
            
         } // end of for loop
      } // end of if zombieY == playerY
      
      if (zombieY < playerY)
      {
      
         for (int i = 0; i < worldLength; i++)
         {
            if (playerY < ((worldLength / 2) - i))
            {
               for (int j = 0; j <= worldLength; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
            else if (playerY == ((worldLength / 2) - i))
            {
               for (int j = 0; j < playerX; j++)
               {
                  System.out.print("#");
               }
            
               System.out.print(player.shape());
            
               for (int j = 0; j < (worldLength - playerX); j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }  
            else if (zombieY < ((worldLength / 2) - i))
            {
               for (int j = 0; j <= worldLength; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
            else if (zombieY == ((worldLength / 2) - i))
            {
               for (int j = 0; j < zombieX; j++)
               {
                  System.out.print("#");
               }
               
               System.out.print("X");
               
               for (int j = 0; j < worldLength - zombieX; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
            else if ((zombieY > ((worldLength / 2) - i) && (playerY > ((worldLength / 2) - i))))
            {
               for (int j = 0; j <= worldLength; j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
            }
         } // end of for loop
      } // end of if zombieY < playerY
   }
   
   public void displayWorld(Player player, World world)
   {
      int playerX = player.getX();
      int playerY = player.getY();
      
      int worldLength = world.getLength();
      
      for (int i = 0; i < worldLength; i++)
      {
         if (playerY < ((worldLength / 2) - i))
         {
            for (int j = 0; j <= worldLength; j++)
            {
               System.out.print("#");
            }
            System.out.print("\n");
         }
         
         else if (playerY == ((worldLength / 2) - i))
         {
            for (int j = 0; j < playerX; j++)
               {
                  System.out.print("#");
               }
            
               System.out.print(player.shape());
            
               for (int j = 0; j < (worldLength - playerX); j++)
               {
                  System.out.print("#");
               }
               System.out.print("\n");
         }
         
         else if (playerY > ((worldLength / 2) - i))
         {
            for (int j = 0; j <= worldLength; j++)
            {
               System.out.print("#");
            }
            System.out.print("\n");
         }
      }
   }
} // end of world class