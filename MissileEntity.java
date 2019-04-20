public class MissileEntity
{

    private double xPos;
    private double yPos;
    private int width;
    private int height;
    private String filename;
    //MissileEntity is not included for Entities yet because It's got weird stuff in it.
  
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
    public void setWidth(int w)
    {
        
        width = w;
        
    }
    public void setHeight(int h)
    {
        
        height = h;
        
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
    
    public static void shoot(MissileEntity[] missiles, int type, PlayerEntity player)
    {
        
        if(type == 0 || type == 2)
        {
            int missileNumber = 0;
            
            for(int i = 0; i < GameLoop.missileCount; i++)
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
            
        }//normal missiles and rapid fire
        
        if(type == 1)
        {
            
            int missileNumber = 0;
            
            for(int i = 0; i < GameLoop.missileCount -2; i++)
            {
                if(missiles[i].getActive() == false)
                {
                    
                    missiles[i].setActive(true);
                    missiles[i+1].setActive(true);
                    missiles[i+2].setActive(true);
                    missiles[i].setX((double) player.getX());
                    missiles[i+1].setX((double) player.getX());
                    missiles[i+2].setX((double) player.getX());
                    missiles[i].setY((double) player.getY());
                    missiles[i+1].setY((double) player.getY());
                    missiles[i+2].setY((double) player.getY());
                    missileNumber = i;
                    break;
                    
                }
            }// Check if there are any missiles available to shoot and sets them up
            
            if(player.getRotation() < 0)
            {
                
                missiles[missileNumber].setYVel( missiles[missileNumber].getVelocity()  *  Math.sin( 2*Math.PI/4 + player.getRotation()*(Math.PI/180) ));
                missiles[missileNumber].setXVel( missiles[missileNumber].getVelocity()  *  Math.cos( 2*Math.PI/4 + player.getRotation()*(Math.PI/180) ));
                
                missiles[missileNumber+1].setYVel( missiles[missileNumber+1].getVelocity()  *  Math.sin( 2*Math.PI/4 + player.getRotation()*(Math.PI/180)  - 0.2 ));
                missiles[missileNumber+1].setXVel( missiles[missileNumber+1].getVelocity()  *  Math.cos( 2*Math.PI/4 + player.getRotation()*(Math.PI/180)  - 0.2 ));
                
                missiles[missileNumber+2].setYVel( missiles[missileNumber+2].getVelocity()  *  Math.sin( 2*Math.PI/4 + player.getRotation()*(Math.PI/180)  + 0.2 ));
                missiles[missileNumber+2].setXVel( missiles[missileNumber+2].getVelocity()  *  Math.cos( 2*Math.PI/4 + player.getRotation()*(Math.PI/180)  + 0.2 ));
                
            }else if(player.getRotation() > 0)
            {
                
                missiles[missileNumber].setYVel( missiles[missileNumber].getVelocity()  *  Math.sin( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) ));
                missiles[missileNumber].setXVel( -missiles[missileNumber].getVelocity()  *  Math.cos( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) ));
                
                missiles[missileNumber+1].setYVel( missiles[missileNumber+1].getVelocity()  *  Math.sin( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) - 0.2 ));
                missiles[missileNumber+1].setXVel( -missiles[missileNumber+1].getVelocity()  *  Math.cos( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) - 0.2 ));
                
                missiles[missileNumber+2].setYVel( missiles[missileNumber+2].getVelocity()  *  Math.sin( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) + 0.2 ));
                missiles[missileNumber+2].setXVel( -missiles[missileNumber+2].getVelocity()  *  Math.cos( 2*Math.PI/4 - player.getRotation()*(Math.PI/180) + 0.2 ));
                
            }else
            {
                
                missiles[missileNumber].setYVel(missiles[missileNumber].getVelocity());
                
            }
            
        }//tri missiles
        
    }//shoot
    
     public void update1()
    {
        
        if(active == true)
        {
            
            yPos = yPos - yVel;
            xPos = xPos + xVel;
            
            if(yPos > 700 || xPos > 1024 || xPos < 0)
            {
                yPos = 0;
                xPos = 0;
                active = false;
            }
            
        }
    
    }//update for laser

}//MissileEntity
