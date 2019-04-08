public class PlayerEntity
{

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private String filename;
    private int rotation;
    private int velocity = 5;
    
    PlayerEntity(String f, int x, int y, int w, int h, int r)
    {
        
        filename = f;
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        rotation = r;
        
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
    public int getRotation()
    {
        
        return rotation;
        
    }
    public void setRotation(int r)
    {
        
        rotation = r;
        
    }
    
    public void update()
    {
        
        if(UserInput.checkUserInput() == "RIGHT" && xPos < 1024) xPos = xPos + velocity;
        if(UserInput.checkUserInput() == "LEFT" && xPos > 0) xPos = xPos - velocity;
        if(UserInput.checkUserInput() == "ROTATELEFT" && rotation < 85) rotation = rotation + 5;
        if(UserInput.checkUserInput() == "ROTATERIGHT" && rotation > -85) rotation = rotation - 5;
        
    }
    




}//PlayerEntity
