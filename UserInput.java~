/* keycodes:
 32 - space
 65 - A
 68 - D
 79 - O
 80 - P
 81 - Q
 83 - S
 87 - W
 */

public class UserInput
{
   
   public static String keys[] = {"NULL","NULL","NULL","NULL","NULL","NULL","NULL","NULL","NULL"};
    
    public static void checkUserInput()
    {
        
        
        
        keys[0] = "NULL";
        keys[1] = "NULL";
        keys[2] = "NULL";
        keys[3] = "NULL";
        keys[4] = "NULL";
        keys[5] = "NULL";
        keys[6] = "NULL";
        keys[7] = "NULL";
        keys[8] = "NULL";
        
        if(StdDraw.isKeyPressed(32)) keys[0] = "SPACE";
        if(StdDraw.isKeyPressed(65)) keys[1] = "LEFT";
        if(StdDraw.isKeyPressed(68)) keys[2] = "RIGHT";
        if(StdDraw.isKeyPressed(77)) keys[3] = "MENU";
        if(StdDraw.isKeyPressed(87)) keys[4] = "UP";
        if(StdDraw.isKeyPressed(81)) keys[5] = "QUIT";
        //if(StdDraw.isKeyPressed(79)) keys[6] = "ROTATELEFT";
        //if(StdDraw.isKeyPressed(80)) keys[7] = "ROTATERIGHT";
        
        //These are obsolete as we now have the mouse to control the turret
       
        if(StdDraw.isKeyPressed(80)) keys[6] = "SCREENSHOT" /* Take a Screenshot */;
        
        
        
        
         if(StdDraw.isKeyPressed(79)) keys[7] = "DEBUG"; /*Remove before final version */
         
         
         
         
        if(StdDraw.isKeyPressed(83)) keys[8] = "DOWN";
    }//checkUserInput
    
    public static boolean checkKeyPressed(String key)
    {
        for(int i = 0; i < 9; i++)
        {
            
            if(keys[i] == key)
            {
                return true;
            }
            
        }
        
        return false;
        
    }//checkKeyPressed
    
    public static void actions()
    {
      
      if(UserInput.checkKeyPressed("QUIT") == true) System.exit(1);
      
      if (UserInput.checkKeyPressed("SCREENSHOT") == true)
      {
        StdDraw.save("screenshot.png");
        StdDraw.pause(150);
      }
      
      //REMOVE ME BEFORE FINAL
      if (UserInput.checkKeyPressed("DEBUG") == true)
      {
        //Use this as a debugging key for now, assigned to key 'P'
        //GAME OVER
        Cosmic.gameState = 3;
      }

    }
    
    
}//userInout
