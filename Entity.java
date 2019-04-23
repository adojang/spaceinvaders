public class Entity implements EntityInterface{

     double xPos;
     double yPos;
     int width;
     int height;
     String filename;

    //Gets and Sets values common to all Entity* classes
    public double getX()
    {
        return xPos;
    }
    public double getY()
    {
        return yPos;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    public String getFilename()
    { 
        return filename; 
    }    
    public void setX(double x)
    {
        xPos = x;
    }
    public void setY(double y)
    {
        yPos = y;
    }
   
}
