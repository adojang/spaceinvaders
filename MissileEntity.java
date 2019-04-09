public class MissileEntity
{

    private double xPos;
    private double yPos;
    private int width;
    private int height;
    private String filename;
    private boolean active;
    public double velocity = 10;
    private double yVel;
    private double xVel;
    
    MissileEntity(String f, int x, int y, int w, int h, boolean state, int m)
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
    public double getX()
    {
        
        return xPos;
        
    }
    public double getY()
    {
        
        return yPos;
        
    }
    public void setX(double x)
    {
        
        xPos = x;
        
    }
    public void setY(double y)
    {
        
        yPos = y;
        
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
        
        active = state;
        
    }
    public void setYVel(double y)
    {
        
        yVel = y;
        
    }
    public void setXVel(double x)
    {
        
        xVel = x;
        
    }
    public double getVelocity()
    {
        
        return velocity;
        
    }
    
    public void update()
    {
        
        if(active == true)
        {
            
            yPos = yPos + yVel;
            xPos = xPos + xVel;
            
            if(yPos > 700 || xPos > 1024 || xPos < 0)
            {
                yPos = 0;
                xPos = 0;
                active = false;
            }
            
        }
    
    }//update

}//MissileEntity
