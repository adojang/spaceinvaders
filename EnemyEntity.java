public class EnemyEntity
{
    
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private String filename;
    private static int velocity = 2;
    private boolean active;
    private static int movementState = 1;
    private static int cycles = 0;
    private static boolean flag = false;
    
    EnemyEntity(String f, int x, int y, int w, int h, boolean state)
    {
        
        filename = f;
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        active = state;
        
    }//create
    
    public String getFilename()
    {
        
        return filename;
        
    }
    public int getX()
    {
        
        return xPos;
        
    }
    public int getY()
    {
        
        return yPos;
        
    }
    public void setY(int y)
    {
        
        yPos = y;
        
    }
    public void setX(int x)
    {
        
        xPos = x;
        
    }
    public int getWidth()
    {
        
        return width;
        
    }
    public int getHeight()
    {
        
        return height;
        
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
                    
                    enemies[i][j].setX(enemies[i][j].getX() + velocity);
                    
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
                    
                    enemies[i][j].setX(enemies[i][j].getX() - velocity);
                    
                }
                
            }
            
            if(enemies[0][GameLoop.enemyCount-1].getX() < 0)
            {
                movementState = 2;
                flag = true;
            }
                        
        }
        
    }//update
    

    
}//EnemyEntity

