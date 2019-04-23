public class PowerUpEntity extends Entity
{
    private boolean active;
    private int powerUpType;
    public static double spawnOdds = 0.003;
    
    /*
     Power Up Types:
     1 - tri missiles
     2 - rapid fire
     */
    
    PowerUpEntity(String f, double x, double y, int w, int h, int p, boolean state)
    {
        
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        powerUpType = p;
        active = state;
        filename = f;
    
    }
    
    public boolean getActive()
    {
        return active;
    }
    public void setActive(boolean state)
    {
        active = state;
    }

    public int getPowerUpType()
    {
        return powerUpType;
    }
    
    public static PowerUpEntity create()
    { 
        PowerUpEntity temp;
        int randomType = (int) (Math.random() * ((2 - 1) + 1)) + 1;
        int randomX = (int) (Math.random() * ((1024 - 0) + 0)) + 0;
        int randomY = (int) (Math.random() * ((200 - 0) + 0)) + 0;
        
        if(randomType == 1)
        {
            temp = new PowerUpEntity("powerUpTriChar.png", randomX, randomY, 30, 30, randomType, true);
            return temp;
        }
        if(randomType == 2)
        {
            temp = new PowerUpEntity("powerUpRapidChar.png", randomX, randomY, 30, 30, randomType, true);
            return temp;
        }
        else
        {
            temp = new PowerUpEntity("powerUpChar.png", randomX, randomY, 30, 30, randomType, true);
        }
        return temp;
    }
}
