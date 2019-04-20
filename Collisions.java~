
public class Collisions
{
  public static int playerscore = 0;
  private static int hits=0;
  private static int[] enemy2Hp=new int[GameLoop.enemyCount];
  private static int Hp=5;
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
    
   public static void detectHits(PlayerEntity player, MissileEntity[] missiles, MissileEntity[] laser, EnemyEntity[][] enemies,EnemyEntity[]enemy2, PowerUpEntity[] powerUps)
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
                        score(10);
                        
                    }//check for missiles and enemies
                    
                    if(hitDetection(  player.getX(), player.getY(), enemies[j][k].getX(), enemies[j][k].getY()    ) == true  && enemies[j][k].getActive() == true       )
                    {
                        //Set gamestate to gameover
                        Cosmic.gameState = 3;
                        
                    }//check for player and enemies
                    
                }//k
                for(int m=0;m<GameLoop.enemy2Count;m++){
                  if(hitDetection(  missiles[i].getX(), missiles[i].getY(), enemy2[m].getX(), enemy2[m].getY()    ) == true  && enemy2[m].getActive() == true ){
                    
                    StdDraw.text(800,200,"HIT");
                    missiles[i].setActive(false);
                    missiles[i].setX(0);
                    missiles[i].setY(0);
                    enemy2Hp[m]++;
                    if(enemy2Hp[m]==Hp){
                      enemy2[m].setActive(false);
                    }
                    
                  }
                  if(hitDetection( laser[m].getX(), laser[m].getY(), player.getX(), player.getY() )  == true ){
                    
                    StdDraw.text(800,200,"HIT");
                    laser[m].setActive(false);
                    laser[m].setX(0);
                    laser[m].setY(0);
                    hits++;
                    if(hits==3){
                      Cosmic.gameState = 3;
                    }
                  }//Checks if enemy laser hits player
                }
            }//j
           
        }//i
        
        for(int i = 0; i < GameLoop.maxPowerUpCount; i++)
        {
            
            if(hitDetection(  player.getX(), player.getY(), powerUps[i].getX(), powerUps[i].getY()    ) == true  && powerUps[i].getActive() == true       )
            {
                
                StdDraw.text(300,400,"POWERUP");
                
                GameLoop.currentPowerUpActive = powerUps[i].getPowerUpType();
                powerUps[i].setActive(false);
                GameLoop.activePowerUp = true;
                GameLoop.powerUpCounter = 0;
                
            }//check for player and power ups
                
        }//i
        
    }//detectHits
    
      public static int score(int add)
    {
        playerscore = playerscore + add;
       // System.out.println(playerscore);
       return playerscore;
      }
      /*
      public static int score()
      {
       return playerscore; 
      } */
    
}//Collisions
