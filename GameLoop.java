public class GameLoop
{
    
    public static PlayerEntity player;
    
    public static int missileCount = 100;
    public static MissileEntity[] missiles = new MissileEntity[missileCount];
    public static int loopCounter = 0;
    public static int missileRapidSpeed = 20;
    public static boolean missileTime = true;
    
    public static int enemyCount = 5;
    public static int enemy2Count=3;
    public static EnemyEntity[][] enemies = new EnemyEntity[enemyCount][enemyCount];
    public static int spawnCheck=0;
    public static EnemyEntity[] enemy2= new EnemyEntity[enemyCount];
    public static int specialEnemy=267;
    public static int angleCounter=0;
    public static MissileEntity[] laser= new MissileEntity[enemyCount]; 
  
    public static PowerUpEntity[] powerUps = new PowerUpEntity[10];
    public static int maxPowerUpCount = 10;
    public static int currentPowerUpActive = 0;
    public static boolean activePowerUp = false;
    public static int powerUpCounter = 0;
    public static int powerUpTime = 150;
    public static Audio mainmenumusic = new Audio();
    public static Audio shoot = new Audio();
    
    
    public static void runGameLoop()
    {
      
        
        while(true)
        {
            
            initialiseEntities();
            
            //Play main menu music
            mainmenumusic.playloop("maintheme.wav");
            while(/*UserInput.checkKeyPressed("SPACE") == false*/ Cosmic.gameState == 0)
            {
                
                UserInput.checkUserInput();
                Interface.updateMenu();
                if(UserInput.checkKeyPressed("SPACE") == true) Cosmic.gameState = 1;
                if(UserInput.checkKeyPressed("QUIT") == true) System.exit(1);
                
            }// Main Menu, gameState = 0
            
            //After main menu exit, will go down, so this ensures that music is stopped
            mainmenumusic.stopmusic(); //Checks if gameState is 0. Here it will be 1 so music will stop playing.
            
            while(/*UserInput.checkKeyPressed("QUIT") == false*/ Cosmic.gameState == 1)
            {
              /* 
               * STOP PLAYING MAINMENY MUSIC HERE. Trigger once only.
               * */
              
              
                StdDraw.clear();
                // https://wallpaperaccess.com/full/436082.png
                StdDraw.picture(512, 350, "b3.jpeg", 1024, 700, 0); 
                StdDraw.setPenColor(StdDraw.WHITE);
                
                UserInput.checkUserInput();
                
                entityMovement();
                
                createPowerUps();
                
                hitDetection(player, missiles,laser, enemies, enemy2, powerUps);
                
                activatePowerUps();
                
                updateScreen();
                
                loopCounter++;
                
                if(loopCounter >= missileRapidSpeed)
                {
                    loopCounter = 0;
                    missileTime = true;
                }
                
                if(activePowerUp == true)
                {
                    powerUpCounter++;
                    if(powerUpCounter == powerUpTime)
                    {
                        activePowerUp = false;
                        currentPowerUpActive = 0;
                        missileRapidSpeed = 15;
                    }
                }
                
                
                if(UserInput.checkKeyPressed("QUIT") == true) System.exit(1);
                
                //bugchecking
                StdDraw.text(500,600,Boolean.toString(activePowerUp));
                StdDraw.text(400,600,Integer.toString(powerUpCounter));
                StdDraw.text(300,600,Integer.toString(player.getRotation()));
                //StdDraw.text(300,600,Boolean.toString(missileTime));
                //bugchecking
                
                StdDraw.show();
                StdDraw.pause(10); //games speed
                
                if (UserInput.checkKeyPressed("SCREENSHOT") == true)
                 {
                  //Using screenshot as a debugging trigger key for now.
                  StdDraw.save("screenshot.png");
                  StdDraw.pause(50);
                 //Cosmic.gameState = 3;
                 }
                
                
                
            }// While in active game, gameState = 1
            
            if(Cosmic.gameState == 3)
            {
                Interface.gameOver();
                Cosmic.gameState = 0;
                runGameLoop();
              
                
            }//check if game over screen
            
        }//while true, able to switch between gamestates
        
    }// RunGameLoop
    
    public static void initialiseEntities()
    {
        
        player = new PlayerEntity("playerChar.png", 512, 50, 50, 50, 0);

        for(int i = 0; i < missileCount; i++)
        {
            
            missiles[i] = new MissileEntity("missileChar.png", 0, 0, 15, 15, false, 0);
            if(i< enemy2Count){
              laser[i] = new MissileEntity("missileChar.png",0,0,15,15,false,0);
              
            }
        }//missiles creation
        
        for(int i = 0; i < enemyCount; i++)
        {specialEnemy=(specialEnemy+ 200)+ 15;
          for(int j = 0; j < enemyCount; j++)
          {
            
            enemies[i][j] = new EnemyEntity("enemyChar.png", 200 + i*60, 500 + j*60, 50, 50, true);
            
            if(i<enemy2Count){
              enemy2[i] = new EnemyEntity("playerChar.png",specialEnemy,600,75,75,false);
            }
          }
          
        }//enemy creation
        
        for(int i = 0; i < 10; i++)
        {
            
            powerUps[i] = new PowerUpEntity("powerUpChar.png", 0, 0, 30, 30, 0, false);
            
        }//missiles creation
        
        
  
    }//initialiseEntities
    
    public static void entityMovement()
    {
        
        player.update();
        
        EnemyEntity.update(enemies);
        
        for(int i = 0; i < missileCount; i++)
        {
            
            missiles[i].update();
            
        }
         
        if(UserInput.checkKeyPressed("SPACE") == true && missileTime == true)
        {

            MissileEntity.shoot(missiles, currentPowerUpActive, player);
            shoot.playsound("shoot.wav");
            //Shoot.wav was provided by a housemate and heavily edited and distorted by me. Original work.
            
            missileTime = false;
            
        }//check if user presses space and if a missile can be shot
        
        if(enemyCheck(enemies)==false){
          
          for(int i = 0; i < enemy2Count; i++)
          {
            if(spawnCheck==0){
              for(int j=0;j<enemy2Count;j++){
                enemy2[j].setActive(true);
              }
              spawnCheck=1;
            }
            enemy2[i].update1(enemy2,angleCounter+=1);
            enemyShoot(laser);

          }
          
        }
        
        
    }//entityMovement
    
    public static void updateScreen()
    {
      
      //HUD
      StdDraw.textLeft(10, 680, "SCORE: " + Collisions.score(0));
        
        Interface.updatePositions(player.getFilename(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), player.getRotation());
        
        for(int i = 0; i < enemy2Count; i++)
        {
          if(enemy2[i].getActive()==true){
            Interface.updatePositions(enemy2[i].getFilename(), enemy2[i].getX(), enemy2[i].getY(), enemy2[i].getWidth(), enemy2[i].getHeight(), 0);
          }
        }
        
        for(int i = 0; i < enemy2Count; i++)
        {
          if(laser[i].getActive()==true){
            Interface.updatePositions(laser[i].getFilename(), (int)laser[i].getX(), (int)laser[i].getY(), laser[i].getWidth(), laser[i].getHeight(), 0);
          }
        }
             
        for(int i = 0; i < missileCount; i++)
        {
            
            if(missiles[i].getActive() == true) Interface.updatePositions(missiles[i].getFilename(), (int) missiles[i].getX(), (int) missiles[i].getY(), missiles[i].getWidth(), missiles[i].getHeight(), 0);
            
        }
        
        for(int i = 0; i < enemyCount; i++)
        {
            for(int j = 0; j < enemyCount; j++)
            {
                
                if(enemies[i][j].getActive() == true) Interface.updatePositions(enemies[i][j].getFilename(), enemies[i][j].getX(), enemies[i][j].getY(), enemies[i][j].getWidth(), enemies[i][j].getHeight(), 0);
                
            }
            
        }
        
        for(int i = 0; i < maxPowerUpCount; i++)
        {
            
            if(powerUps[i].getActive() == true) Interface.updatePositions(powerUps[i].getFilename(), powerUps[i].getX(), powerUps[i].getY(), powerUps[i].getWidth(), powerUps[i].getHeight(), 0);
            
        }
        
    }//updateScreen
    
  public static void hitDetection(PlayerEntity player, MissileEntity[] missiles,MissileEntity[] laser, EnemyEntity[][] ememies,EnemyEntity[] enemy2, PowerUpEntity[] powerUps)
  {
    
    Collisions.detectHits(player, missiles, laser, enemies , enemy2, powerUps);
    
  }//hitDetection
    
    public static void createPowerUps()
    {
        
        if(Math.random() < PowerUpEntity.spawnOdds)
        {
            
            for(int i = 0; i < maxPowerUpCount; i++)
            {
                
                if(powerUps[i].getActive() == false)
                {
                    
                    powerUps[i] = PowerUpEntity.create();
                    break;
                    
                }
                
            }
            
        }
        
    }//checkPowerUps
    
    public static void activatePowerUps()
    {
        
        if(currentPowerUpActive == 2)
        {
            
            missileRapidSpeed = 2;

        }
    
    }//activatePowerUps
    
    public static boolean enemyCheck(EnemyEntity evil[][]){ 
      for(int i=0;i<enemyCount;i++){
        for(int j=0;j<enemyCount;j++){
          if(evil[i][j].getActive()==true){
            return true;
          }
          
        }
      }
      
      return false;
      
      
    }
    
    public static void enemyShoot(MissileEntity zap[]){
      for(int i =0; i< enemy2Count; i++){
        if(zap[i].getActive() == false && StdRandom.bernoulli(0.02)==true && enemy2[i].getActive()==true){
          laser[i].setActive(true);
          laser[i].setX(enemy2[i].getX());
          laser[i].setY(enemy2[i].getY());
          laser[i].setXVel(enemy2[i].getXvel());
          laser[i].setYVel(2);
        }
        //laser[i].setActive(false);      
        
        laser[i].update1();
      } 
    }

}//GameLoop
