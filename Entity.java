public class Entity {

  /* Each entity subclass should inherit these common attributs */
     int xPos; //Made double because of MissleEntity
     int yPos; //Made because of MissleEntity
     int width;
     int height;
     String filename;
     
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
    public void setY(int y) //PlayerEntity doesn't use this, but I feel justified in including it here anyway.
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
}