import java.awt.Font;
public class Interface
{

    public static void updatePositions(String filename, int entityX, int entityY, int entityW, int entityH, int entityR)
    {

        StdDraw.picture(entityX, entityY, filename, entityW, entityH, entityR);
        
    }//updateGameScreen
    
    //DRAW MAIN MENU
    public static void updateMenu()
    {
          //Background picture source: https://unsplash.com/photos/pzwy4dL_huU  -Photo by Ahmed Sharyaan on Unsplash
          //This image is free for commericial use
        StdDraw.clear();
        StdDraw.picture(512, 350, "background1.jpeg", 1024, 700, 0);     
        StdDraw.show();
        
    }//updateGameScreen
    
    public static void gameOver()
    {
      //Will Add a Nice screen later. This is temp.
      
      StdDraw.clear();
      Font font = new Font("Arial", Font.BOLD, 60);
      StdDraw.setFont(font);
      StdDraw.text(512, 350, "GAME OVER");
      StdDraw.show();
      
    }




}//Interface
