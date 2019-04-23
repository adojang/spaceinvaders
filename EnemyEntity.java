public class EnemyEntity extends Entity
{
  
  private static int velocity = 3;
  private static int xVel;
  private boolean active;
  private static int movementState = 1;
  private static int specialState =1;
  private static int verticalState=1;
  private static int cycles = 0;
  private static boolean flag = false;
  
  EnemyEntity(String f, double x, double y, int w, int h, boolean state)
  {
    filename = f;
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    active = state;
  } //Create Enemies
  
  
  public int getXvel(){
    return xVel;
  }
  
  public boolean getActive()
  {
    
    return active;
    
  }
  public void setActive(boolean state)
  {
    
    active = state;;
    
  }
  
  public static void update(EnemyEntity[][] enemies)
  {
    
    if(movementState == 1)
    {
      for(int i = 0; i < GameLoop.enemyCount; i++)
      {
        for(int j = 0; j < GameLoop.enemyCount; j++)
        {
          
          enemies[i][j].setX(enemies[i][j].getX() + (velocity * GameLoop.difficulty));
          
        }
        
      }
      
      if(enemies[GameLoop.enemyCount-1][GameLoop.enemyCount-1].getX() > 1024)
      {
        movementState = 2;
        flag = false;
      }
      
    }
    
    if(movementState == 2)
    {
      
      for(int i = 0; i < GameLoop.enemyCount; i++)
      {
        for(int j = 0; j < GameLoop.enemyCount; j++)
        {
          
          enemies[i][j].setY(enemies[i][j].getY() - velocity);
          
        }
        
      }
      
      cycles++;
      
      if(cycles == 20)
      {
        cycles = 0;
        if(flag == false)
        {
          movementState = 3;
        }
        if(flag == true)
        {
          movementState = 1;
        }
        
      }
      
    }
    
    if(movementState == 3)
    {
      
      for(int i = 0; i < GameLoop.enemyCount; i++)
      {
        for(int j = 0; j < GameLoop.enemyCount; j++)
        {
          
          enemies[i][j].setX(enemies[i][j].getX() - (velocity * GameLoop.difficulty));
          
        }
        
      }
      
      if(enemies[0][GameLoop.enemyCount-1].getX() < 0)
      {
        movementState = 2;
        flag = true;
      }
      
    }
    
  }//Update Enemies
  
  public void update1(EnemyEntity enemy[], int angle){
    int range=400;
    for(int i=0;i< GameLoop.enemy2Count;i++){
      if(verticalState ==1){
        enemy[i].setY(enemy[i].getY() - (1 + 0.1*GameLoop.difficulty));
        if(enemy[i].getY() <=175){
          verticalState=2;
        }
      }
      if(verticalState==2){
        enemy[i].setY(enemy[i].getY() + (1 + 0.1*GameLoop.difficulty));
        if(enemy[i].getY() >= 665){
          verticalState=1;
        }        
        
      }
      
      if(specialState==1){
        enemy[i].setX(enemy[i].getX() + (1 + 0.1*GameLoop.difficulty));
        xVel=1;
        if(enemy[i].getX()>=(512+range)){
          specialState=2;
          
        }
        
      }
      
      if(specialState==2){
        enemy[i].setX(enemy[i].getX() - (1 + 0.1*GameLoop.difficulty));
        xVel=(-1);
        if(enemy[i].getX()<=(512-range)){
          specialState=1;
          
        }
        
      }
    }
  }
  
  
}

