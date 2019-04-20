public class PlayerEntity extends Entity
{
/*
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private String filename;
    */
    
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
    /*
    public String getFilename()
    {
        
        return filename;
        
    }
    public int getX()
    {
        
        return (int)xPos;
        //If I made a terrible mistake remove (int)
    }
    public int getY()
    {
        
        return (int)yPos;
        //If I made a terrible mistake remove (int)
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
        
    } */
    // All of this can be removed after we've reviewed it doesn't break any code.
    
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
        
        if(UserInput.checkKeyPressed("RIGHT") == true && xPos < 1024) xPos = xPos + velocity;
        if(UserInput.checkKeyPressed("LEFT") == true && xPos > 0) xPos = xPos - velocity;
        if(UserInput.checkKeyPressed("UP") == true && yPos < 200) yPos = yPos + velocity;
        if(UserInput.checkKeyPressed("DOWN") == true && yPos > 0) yPos = yPos - velocity;
        
        
        /*if(UserInput.checkUserInput() == "RIGHT" && xPos < 1024) xPos = xPos + velocity;
        if(UserInput.checkUserInput() == "LEFT" && xPos > 0) xPos = xPos - velocity;
        if(UserInput.checkUserInput() == "UP" && yPos < 700) yPos = yPos + velocity;
        if(UserInput.checkUserInput() == "DOWN" && yPos > 0) yPos = yPos - velocity;*/
        
        //rotation through mouse
        double radians = 0;
        if(StdDraw.mouseX() > xPos && StdDraw.mouseY() > yPos)
        {
            
            radians = Math.atan((StdDraw.mouseY()-yPos)/(StdDraw.mouseX()-xPos));
            rotation = (int) Math.toDegrees(radians) - 90;
            
        }
        if(StdDraw.mouseX() < xPos && StdDraw.mouseY() > yPos)
        {
            
            radians = Math.atan((StdDraw.mouseY()-yPos)/(StdDraw.mouseX()-xPos));
            rotation = 90 + (int) Math.toDegrees(radians);
            
        }
        if(StdDraw.mouseX() < xPos && StdDraw.mouseY() < yPos)
        {
            
            radians = Math.atan((StdDraw.mouseY()-yPos)/(StdDraw.mouseX()-xPos));
            rotation = 90 + (int) Math.toDegrees(radians);
            
        }
        if(StdDraw.mouseX() > xPos && StdDraw.mouseY() < yPos)
        {
            
            radians = Math.atan((StdDraw.mouseY()-yPos)/(StdDraw.mouseX()-xPos));
            rotation = (int) Math.toDegrees(radians) - 90;
            
        }
        //rotation through mouse
     
        //rotation through keys
        //if(UserInput.checkUserInput() == "ROTATELEFT" && rotation < 85) rotation = rotation + 5;
        //if(UserInput.checkUserInput() == "ROTATERIGHT" && rotation > -85) rotation = rotation - 5;
        //rotation through keys
        
    }
    
    
    




}//PlayerEntity
