public class GameLoop
{
    
    public static PlayerEntity player;
    
    public static int missileCount = 100;
    public static MissileEntity[] missiles = new MissileEntity[missileCount];
    public static int loopCounter = 0;
    public static int missileRapidSpeed = 20;
    public static boolean missileTime = true;
    public static int enemy2Count= 3;
    public static int enemyCount = 5;

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
            mainmenumusic.playloop("mainthemev2.wav");
            while(/*UserInput.checkKeyPressed("SPACE") == false*/ Cosmic.gameState == 0)
            {
                
                
                    Interface.updateMenu();
                
                
                   Interface.updateMenu();
                
                //if(menuTimer == 30) menuTimer = 0;
                
                
                
                UserInput.checkUserInput();

                if(UserInput.checkKeyPressed("SPACE") == true){
                  spawnCheck=0;
                  Cosmic.gameState = 1;
                }
                if(UserInput.checkKeyPressed("QUIT") == true) System.exit(1);
                
                StdDraw.pause(10);
                
            }// Main Menu, gameState = 0
            
            //After main menu exit, will go down, so this ensures that music is stopped
            
            //mainmenumusic.stopmusic(); //Checks if gameState is 0. Here it will be 1 so music will stop playing.
            
            while(/*UserInput.checkKeyPressed("QUIT") == false*/ Cosmic.gameState == 1)
            {
              /* 
               * STOP PLAYING MAINMENY MUSIC HERE. Trigger once only.
               * */
              
              
                StdDraw.clear();
                // https://wallpaperaccess.com/full/436082.png
                StdDraw.picture(512, 350, "b4.jpeg", 1024, 700, 0); 
                StdDraw.setPenColor(StdDraw.WHITE);
                
                UserInput.checkUserInput();
                
                HUD();
                
                entityMovement();
                
                createPowerUps();
                
                hitDetection(player, missiles,laser, enemies, enemy2, powerUps);
                
                activatePowerUps();
                
                updateScreen();
                
                loopCounter++;
                
                UserInput.actions(); //Screenshot Quit and FORCE game over
                
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
                 
                StdDraw.show();
                StdDraw.pause(10); //games speed
  
            } 
              if(Cosmic.gameState == 3)
            {
                mainmenumusic.stopmusic();
                mainmenumusic.playsound("gameOver.wav");
                Interface.gameOver();
                //Reset Things
                Collisions.score(-1); //-1 is the code to reset
                PlayerEntity.currentHP(-1); // -1 is the code to reset
                mainmenumusic.stopmusic();
                Cosmic.gameState = 0;
                //runGameLoop();
              
                
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
              laser[i] = new MissileEntity("enemyFire.png",0,0,15,15,false,0);
              
            }
        }//missiles creation
        
        for(int i = 0; i < enemyCount; i++)
        {
          specialEnemy=(specialEnemy+ 200)+ 15;
          for(int j = 0; j < enemyCount; j++)
          {
            
            enemies[i][j] = new EnemyEntity("enemyChar.png", 200 + i*60, 500 + j*60, 45, 55, true);
            
            if(i<enemy2Count){
              enemy2[i] = new EnemyEntity("enemyShark.png",specialEnemy,600,47,80,false);
            }
          }
          
        }//enemy creation
        specialEnemy=267;
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
            
            missileRapidSpeed = 7;

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
        if(zap[i].getActive() == false && StdRandom.bernoulli(1)==true && enemy2[i].getActive()==true){
          laser[i].setActive(true);
          laser[i].setX(enemy2[i].getX());
          laser[i].setY(enemy2[i].getY());
          laser[i].setXVel(enemy2[i].getXvel());
          laser[i].setYVel(2);
          shoot.playsound("shoot.wav");
        }
        //laser[i].setActive(false);      
        
        laser[i].update1();
      }
    }
    
 public static void HUD()
      {
       //HUD
      StdDraw.textLeft(5, 680, "SCORE: " + Collisions.score(0));
        if (PlayerEntity.currentHP(0) >= 1) StdDraw.picture(30, 30, "playerChar.png", 40,40, 0);
        if (PlayerEntity.currentHP(0) >= 2) StdDraw.picture(80, 30, "playerChar.png", 40,40, 0);
        if (PlayerEntity.currentHP(0) == 3) StdDraw.picture(130, 30, "playerChar.png", 40,40, 0); 
      }
    
    
    
}//GameLoop
