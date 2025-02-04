public class PlayerEntity extends Entity
{
    private int rotation;
    private int velocity = 5;
    private static int HP = 3;
    
    PlayerEntity(String f, double x, double y, int w, int h, int r)
    {
        
        filename = f;
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        rotation = r;
        
    }//create
    
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
 
    }//update
    
    public static int currentHP(int modifyHP)
    {
      if (modifyHP == -1) HP = 3;
       else
       {
     HP = HP - modifyHP;
       }
     return HP;
    }
    

}//PlayerEntity
