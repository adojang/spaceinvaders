public class GameLoop
{
    
    public static PlayerEntity player;
    
    public static int missileCount = 100;
    public static MissileEntity[] missiles = new MissileEntity[missileCount];
    public static int loopCounter = 0;
    public static int missileRapidSpeed = 15;
    public static boolean missileTime = true;
    
    public static int enemyCount = 5;
    public static EnemyEntity[][] enemies = new EnemyEntity[enemyCount][enemyCount];
    
    public static PowerUpEntity[] powerUps = new PowerUpEntity[10];
    public static int maxPowerUpCount = 10;
    public static int powerUpActive = 0;
    public static boolean activePowerUp = false;
    public static int powerUpCounter = 0;
    public static int powerUpTime = 200;
    
    
    public static void runGameLoop()
    {
        
        while(true)
        {
            
            initialiseEntities();
            
            while(/*UserInput.checkKeyPressed("SPACE") == false*/ Cosmic.gameState == 0)
            {
                
                UserInput.checkUserInput();
                Interface.updateMenu();
                if(UserInput.checkKeyPressed("SPACE") == true) Cosmic.gameState = 1;
                if(UserInput.checkKeyPressed("QUIT") == true) System.exit(1);
                
            }// Main Menu, gameState = 0

            while(/*UserInput.checkKeyPressed("QUIT") == false*/ Cosmic.gameState == 1)
            {
                
                StdDraw.clear();
                
                UserInput.checkUserInput();
                
                entityMovement();
                
                createPowerUps();
                
                hitDetection(player, missiles, enemies, powerUps);
                
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
                        powerUpActive = 0;
                        missileRapidSpeed = 15;
                    }
                }
                
                
                if(UserInput.checkKeyPressed("QUIT") == true) System.exit(1);
                
                //bugchecking
                StdDraw.text(500,600,Boolean.toString(activePowerUp));
                StdDraw.text(400,600,Integer.toString(powerUpCounter));
                //StdDraw.text(300,600,Boolean.toString(missileTime));
                //bugchecking
                
                StdDraw.show();
                StdDraw.pause(10); //games speed
                
                /*if (UserInput.checkKeyPressed("SCREENSHOT") == true)
                 {
                 Interface.gameOver();
                 break;
                 }*/
                
                
                
            }// While in active game, gameState = 1
            
            if(Cosmic.gameState == 2)
            {
                
                Interface.gameOver();
                StdDraw.pause(1000);
                Cosmic.gameState = 0;
                
            }//check if game over screen
            
        }//while true, able to switch between gamestates
        
    }// RunGameLoop
    
    public static void initialiseEntities()
    {
        
        player = new PlayerEntity("playerChar.png", 512, 50, 50, 50, 0);

        for(int i = 0; i < missileCount; i++)
        {
            
            missiles[i] = new MissileEntity("missileChar.png", 0, 0, 15, 15, false, 0);
            
        }//missiles creation
        
        for(int i = 0; i < enemyCount; i++)
        {
            for(int j = 0; j < enemyCount; j++)
            {
                
                enemies[i][j] = new EnemyEntity("enemyChar.png", 200 + i*60, 500 + j*60, 50, 50, true);
                
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
            int missileNumber = 0;
            
            for(int i = 0; i < missileCount; i++)
            {
                if(missiles[i].getActive() == false)
                {
                    
                    missiles[i].setActive(true);
                    missiles[i].setX((double) player.getX());
                    missiles[i].setY((double) player.getY());
                    missileNumber = i;
                    break;
                    
                }
            }// Check if there are any missiles available to shoot and sets them up
            
            if(player.getRotation() < 0)
            {
                
                missiles[missileNumber].setYVel( missiles[missileNumber].getVelocity()  *  Math.sin( 2*Math.PI/4 + player.getRotation()*(Math.PI/180) ));
                missiles[missileNumber].setXVel( missiles[missileNumber].getVelocity()  *  Math.cos( 2*Math.PI/4 + player.getRotation()*(Math.PI/180) ));
                
            }else if(player.getRotation() > 0)
            {
                
                missiles[missileNumber].setYVel( missiles[missileNumber].getVelocity()  *  Math.sin( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) ));
                missiles[missileNumber].setXVel( -missiles[missileNumber].getVelocity()  *  Math.cos( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) ));
                
            }else
            {
                
                missiles[missileNumber].setYVel(missiles[missileNumber].getVelocity());
                
            }
            
            missileTime = false;
            
        }//check if user presses space and if a missile can be shot
        
    }//entityMovement
    
    public static void updateScreen()
    {
        
        Interface.updatePositions(player.getFilename(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), player.getRotation());
        
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
    
    public static void hitDetection(PlayerEntity player, MissileEntity[] missiles, EnemyEntity[][] ememies, PowerUpEntity[] powerUps)
    {
        
        Collisions.detectHits(player, missiles, enemies, powerUps);
        
    }//hitDetection
    
    public static void createPowerUps()
    {
        
        if(Math.random() < 0.001)
        {
            
            for(int i = 0; i < maxPowerUpCount; i++)
            {
                
                if(powerUps[i].getActive() == false)
                {
                    
                    powerUps[i] = PowerUpEntity.create();
                    System.out.println(powerUps[i].getPowerUpType());
                    break;
                    
                }
                
            }
            
        }
        
    }//checkPowerUps
    
    public static void activatePowerUps()
    {
        
        if(powerUpActive == 2)
        {
            
            missileRapidSpeed = 2;

        }
        if(powerUpActive == 3)
        {
            
            
            
        }
    
    }//activatePowerUps

}//GameLoop
