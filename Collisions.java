public class Collisions
{

    public static boolean hitDetection(double x1, double y1, double x2, double y2)
    {
        
        boolean xFlag = false;
        boolean yFlag = false;
        
        int range = 30;
        
        if(x1>x2)
        {
            
            if((x1-x2)<range) xFlag = true;
            
        }else if(x1<x2)
        {
            
            if((x2-x1)<range) xFlag = true;
            
        }
        
        if(y1>y2)
        {
            
            if((y1-y2)<range) yFlag = true;
            
        }else if(y1<y2)
        {
            
            if((y2-y1)<range) yFlag = true;

        }
        
        if(xFlag == true && yFlag == true)
        {
            
            return true;
            
        }else
        {
            
            return false;
        }
   
    }//hitDetection
    
    public static void detectHits(PlayerEntity player, MissileEntity[] missiles, EnemyEntity[][] enemies)
    {
        
        for(int i = 0; i < GameLoop.missileCount; i++)
        {
            
            for(int j = 0; j < GameLoop.enemyCount; j++)
            {
                
                for(int k = 0; k < GameLoop.enemyCount; k++)
                {
                    
                    if(hitDetection(  missiles[i].getX(), missiles[i].getY(), enemies[j][k].getX(), enemies[j][k].getY()    ) == true  && enemies[j][k].getActive() == true       )
                    {
                        
                        StdDraw.text(800,200,"HIT");
                        missiles[i].setActive(false);
                        missiles[i].setX(0);
                        missiles[i].setY(0);
                        enemies[j][k].setActive(false);
                        
                    }
                    
                }//k
                
            }//j
           
        }//i
        

    }//detectHits
    
    public static boolean ShipCrash(PlayerEntity player, EnemyEntity[][] enemies)
      
    {
      /*
       * if player and enemy are within 15 pixels of eachother, then crash happens.
      
      
      return true;
      else return false
      
     
    }
    //Detects if the player ship touches an enemy ship. Used to display GAMEOVER screen.
    
 */
      return true; // Remove this after you've written the function.
    }
}
