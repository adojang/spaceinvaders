public class GameLoop
{
    
    public static PlayerEntity player;
    public static int missileCount = 10;
    public static MissileEntity[] missiles = new MissileEntity[missileCount];
    public static int activeMissiles = 0;
    public static int enemyCount = 5;
    public static EnemyEntity[][] enemies = new EnemyEntity[enemyCount][enemyCount];
    public static int loopCycles = 0;
    
    public static void runGameLoop()
    {

        while(UserInput.checkUserInput() != "SPACE")
        {

            Interface.updateMenu();
            if(UserInput.checkUserInput() == "QUIT") System.exit(1);
            
        }//while in the menu
        
        initialiseEntities();
        
        while(UserInput.checkUserInput() != "QUIT")
        {
            
            StdDraw.clear();
            
            entityMovement();
            
            hitDetection(player, missiles, enemies);
            
            updateScreen();
            
            

            StdDraw.text(100,100, Integer.toString(activeMissiles));

            for(int i = 0; i < missileCount; i++)
            {
                
                StdDraw.text(200,20*i+100, Integer.toString(i) + Boolean.toString(missiles[i].getActive()));
                
                
            }
            
                
                
                
            
            StdDraw.show();
            StdDraw.pause(10); //games speed
            
        }//while in the game
        
        System.exit(1);
        
    }//runGameLoop
    
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

        }//entity creation
  
    }//initialiseEntities
    
    public static void entityMovement()
    {
        
        player.update();
        
        EnemyEntity.update(enemies);
        
        for(int i = 0; i < missileCount; i++)
        {
            
            missiles[i].update();
            
        }
        
        if(UserInput.checkUserInput() == "SHOOT" && activeMissiles < missileCount)
        {
            
            missiles[activeMissiles].setActive(true);
            missiles[activeMissiles].setX((double) player.getX());
            missiles[activeMissiles].setY((double) player.getY());

            if(player.getRotation() < 0)
            {
                
                missiles[activeMissiles].setYVel( missiles[activeMissiles].getVelocity()  *  Math.sin( 2*Math.PI/4 + player.getRotation()*(Math.PI/180) ));
                missiles[activeMissiles].setXVel( missiles[activeMissiles].getVelocity()  *  Math.cos( 2*Math.PI/4 + player.getRotation()*(Math.PI/180) ));
                
            }else if(player.getRotation() > 0)
            {
                
                missiles[activeMissiles].setYVel( missiles[activeMissiles].getVelocity()  *  Math.sin( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) ));
                missiles[activeMissiles].setXVel( -missiles[activeMissiles].getVelocity()  *  Math.cos( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) ));
                
            }else
            {
                
                missiles[activeMissiles].setYVel(missiles[activeMissiles].getVelocity());
                                                 
            }
            
            activeMissiles++;
            
        }//check if user shot and if there are missiles available
        
        
        
        
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
        
    }//updateScreen
    
    public static void hitDetection(PlayerEntity player, MissileEntity[] missiles, EnemyEntity[][] ememies)
    {
        
        Collisions.detectHits(player, missiles, enemies);
        
    }//hitDetection

}//GameLoop
