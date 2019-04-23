
public class Collisions
{
  public static int playerscore = 0;
  private static int[] enemy2Hp=new int[GameLoop.enemyCount];
  private static int Hp=10;
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
                        
                        //Detects if player missile has hit basic enemy type.
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
                        GameLoop.difficulty=1;
                        GameLoop.resetPlayer();
                        
                    }

                    if(enemies[j][k].getY() <= 0 && (enemies[j][k].getActive() == true))
                    {
                      //Set gamestate to gameover
                        Cosmic.gameState = 3;
                        GameLoop.difficulty=1;
                        GameLoop.resetPlayer();
                    }
                    
                }
                for(int m=0;m<GameLoop.enemy2Count;m++){
                  if(hitDetection(  player.getX(), player.getY(), enemy2[m].getX(), enemy2[m].getY()    ) == true  && enemy2[m].getActive() == true       )
                  {
                    //Set gamestate to gameover
                    Cosmic.gameState = 3;
                    GameLoop.difficulty=1;
                    GameLoop.resetPlayer();
                    
                  }
                                      
                  if(hitDetection(  missiles[i].getX(), missiles[i].getY(), enemy2[m].getX(), enemy2[m].getY()    ) == true  && enemy2[m].getActive() == true ){
                    
                    ////Detects if player missile collides with shark
                    missiles[i].setActive(false);
                    missiles[i].setX(0);
                    missiles[i].setY(0);
                    enemy2Hp[m]++;
                    if(enemy2Hp[m]==Hp){
                      enemy2[m].setActive(false);
                      score(50);
                      enemy2Hp[m]=0;
                    }
                    
                  }
                  if(hitDetection( laser[m].getX(), laser[m].getY(), player.getX(), player.getY() )  == true ){
                    
                    //Checks if shark missle hits player
                    laser[m].setActive(false);
                    laser[m].setX(0);
                    laser[m].setY(0);
                    //This is where our 'HP' is calculated
                    
                    PlayerEntity.currentHP(1);
                    if(PlayerEntity.currentHP(0) <= 0){
                      Cosmic.gameState = 3;
                      GameLoop.difficulty=1;
                      GameLoop.resetPlayer();
                      for(int q=0;q<GameLoop.enemy2Count;q++){
                        enemy2Hp[m]=0;
                      }
                    }
                  }//Checks if enemy laser hits player
                }
            }//j
           
        }//i
        
        for(int i = 0; i < GameLoop.maxPowerUpCount; i++)
        {
            
            if(hitDetection(  player.getX(), player.getY(), powerUps[i].getX(), powerUps[i].getY()    ) == true  && powerUps[i].getActive() == true       )
            {
                
                //Check for player and powerups
                
                GameLoop.currentPowerUpActive = powerUps[i].getPowerUpType();
                powerUps[i].setActive(false);
                GameLoop.activePowerUp = true;
                GameLoop.powerUpCounter = 0;
                
            }
                
        }
        
    }
    
      public static int score(int add)
    {
        if (add == -1) {
          
          playerscore = 0;
        }
          else
        {
        playerscore = playerscore + add;
        }
       return playerscore;
      }  
}
