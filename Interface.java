import java.awt.Font;
public class Interface
{
    
    public static String type = "Monospaced";
    public static Font f0 = new Font(type, Font.BOLD, 80);
    public static Font f1 = new Font(type, Font.BOLD, 50);
    public static Font f2 = new Font(type, Font.BOLD, 20);

    public static void updatePositions(String filename, int entityX, int entityY, int entityW, int entityH, int entityR)
    {

        StdDraw.picture(entityX, entityY, filename, entityW, entityH, entityR);
        
    }//updateGameScreen
    
    //DRAW MAIN MENU
    public static void updateMenu(int a)
    {

       
         
        

       
        if(a == 0)
        {
            
            StdDraw.picture(512, 350, "mainMenuBackGround.png", 1024, 700, 0);
            StdDraw.picture(512, 600, "cosmicCrocodilesTitle.png", 900, 100, 0);
            
            StdDraw.setPenColor(243, 241, 239);
            StdDraw.setFont(f2);
            StdDraw.text(512, 450, "CONTROLS:");
            StdDraw.text(512, 420, "W - Up");
            StdDraw.text(512, 390, "A - Left");
            StdDraw.text(512, 360, "S - Down");
            StdDraw.text(512, 330, "D - Right");
            StdDraw.text(512, 300, "P - Screenshot");
            StdDraw.text(512, 270, "Q - Quit");
            StdDraw.text(512, 240, "<Space> - Shoot");
            
            StdDraw.setFont(f1);
            if(Cosmic.highscore != 0) StdDraw.text(512, 150, "High Score: " + Cosmic.highscore);
            
            StdDraw.picture(200, 350, "dinosaurSprite.png", 200, 200, 0);
            
            StdDraw.picture(512, 60, "pressSpaceToPlay.png", 512, 50, 0);
            
            StdDraw.show();
            
        }else
        {
            StdDraw.picture(512, 350, "mainMenuBackGround.png", 1024, 700, 0);
            
            StdDraw.setPenColor(243, 241, 239);
            StdDraw.setFont(f2);
            StdDraw.text(512, 450, "CONTROLS:");
            StdDraw.text(512, 420, "W - Up");
            StdDraw.text(512, 390, "A - Left");
            StdDraw.text(512, 360, "S - Down");
            StdDraw.text(512, 330, "D - Right");
            StdDraw.text(512, 300, "P - Screenshot");
            StdDraw.text(512, 270, "Q - Quit");
            StdDraw.text(512, 240, "<Space> - Shoot");
            
            StdDraw.setFont(f1);
            if(Cosmic.highscore != 0) StdDraw.text(512, 150, "High Score: " + Cosmic.highscore);
            
            StdDraw.picture(200, 350, "dinosaurSprite.png", 200, 200, 0);
            
            StdDraw.show();
            
        }
        
      //Background picture source: https://saundersanimation.files.wordpress.com/2014/06/spacecrododile.jpg
        
    }//updateGameScreen
    
    public static void gameOver()
    {
      //Background Source:
      // https://wallpaperaccess.com/full/436082.png
      Font gfont = new Font("Monospaced", Font.BOLD, 60);
      StdDraw.setFont(gfont);
      
      if (Collisions.score(0) > Cosmic.highscore) Cosmic.highscore = Collisions.score(0);

      for(int i=5;i>=0;i--)
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
