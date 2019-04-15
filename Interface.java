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
      //Set Gamefonts
      String type = "Monospaced";
      Font f0 = new Font(type, Font.BOLD, 80);
      Font f1 = new Font(type, Font.BOLD, 50);
      Font f2 = new Font(type, Font.BOLD, 40);
      StdDraw.setFont(f0);
      StdDraw.setPenColor(243, 241, 239);
  
      //Background picture source: https://saundersanimation.files.wordpress.com/2014/06/spacecrododile.jpg
      StdDraw.clear();
      StdDraw.picture(512, 350, "b1.jpeg", 1024, 700, 0);     
      StdDraw.text(512, 600, "COSMIC CROCODILES");
      StdDraw.setFont(f1);
      StdDraw.textLeft(650, 500, "Controls");
      StdDraw.textLeft(600, 450, "W - Up");
      StdDraw.textLeft(600, 400, "A - Left");
      StdDraw.textLeft(600, 350, "S - Down");
      StdDraw.textLeft(600, 300, "D - Right");
      StdDraw.textLeft(600, 250, "P - Screenshot");
      StdDraw.textLeft(600, 200, "Q - Quit");
      StdDraw.textLeft(600, 150, "<Space>");
       StdDraw.textLeft(600, 100, "to shoot");
       
       
        StdDraw.show();
      StdDraw.setFont(f2);
    }//updateGameScreen
    
    public static void gameOver()
    {
      //Background Source:
      // https://wallpaperaccess.com/full/436082.png
      
       //StdDraw.picture(512, 350, "b6.jpeg", 1024, 700, 180); 
      Font gfont = new Font("Monospaced", Font.BOLD, 60);
      StdDraw.setFont(gfont);
      /*
      StdDraw.text(512, 350, "GAME OVER");
      StdDraw.text(512, 200, "SCORE:" + " " + String.valueOf(Collisions.score(0)));
      StdDraw.show();
      
      */
      
      for(int i=5;i>=-1;i--)
      {
       StdDraw.picture(512, 350, "b2.jpeg", 1024, 700, 180); 
        StdDraw.text(512, 350, "GAME OVER");
       StdDraw.text(512, 200, "SCORE:" + " " + String.valueOf(Collisions.score(0)));
       StdDraw.text(512, 100, "Restart in... " + i);
       StdDraw.pause(1000);
       StdDraw.show();
      
      }
      

      
    }




}//Interface

/* Extra Wallpapers for Use later on:
 * Level 2: use b3 - https://wallpaperaccess.com/full/348158.png
 * Bossfight use b4 - https://wallpaperaccess.com/full/43078.jpg
 * */

//https://wallpaperaccess.com/full/348158.png - b2old