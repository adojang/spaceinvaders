import java.awt.Font;
public class Interface
{
    
    public static String type = "Monospaced";
    public static Font f0 = new Font(type, Font.BOLD, 80);
    public static Font f1 = new Font(type, Font.BOLD, 50);
    public static Font f2 = new Font(type, Font.BOLD, 20);
    private static int loop = 0;
    public static void updatePositions(String filename, double entityX, double entityY, int entityW, int entityH, int entityR)
    {

        StdDraw.picture((int) entityX, (int) entityY, filename, entityW, entityH, entityR);
        
    }
    
    //Draw Main Menu
    public static void updateMenu()
    {

        if(loop == 0)
        {
          StdDraw.picture(512, 350, "Intro.jpeg", 1024, 700, 0);
            StdDraw.show();
            StdDraw.pause(3000);
            loop++;
            
        }else
        {

          StdDraw.show();
            StdDraw.picture(512, 350, "b1.jpeg", 1024, 700, 0);
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
            StdDraw.text(512, 210, "O - Lose Hope");       
            StdDraw.picture(512, 600, "cosmicCrocodilesTitle.png", 900, 100, 0);
            StdDraw.picture(512, 60, "pressSpaceToPlay.png", 512, 50, 0);  
            StdDraw.setFont(f1);
            if(Cosmic.highscore != 0) StdDraw.text(512, 150, "High Score: " + Cosmic.highscore);
            StdDraw.show(); 
        }
      
    } //mainMenu
    
    //Draw GameOver
    public static void gameOver()
    {
      Font gfont = new Font("Monospaced", Font.BOLD, 60);
      StdDraw.setFont(gfont);
      if (Collisions.score(0) > Cosmic.highscore) 
      {
        Cosmic.highscore = Collisions.score(0); //Set HighScore
       
        for(int i=4;i>=0;i--)
      {
       StdDraw.picture(512, 350, "victory.jpeg", 1024, 700, 0);
       StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(512, 660, "HIGHSCORE!");
        StdDraw.setPenColor(StdDraw.RED);
       StdDraw.text(512, 200, "SCORE:" + " " + String.valueOf(Collisions.score(0)));
        StdDraw.setPenColor(243, 241, 239);
       StdDraw.text(512, 100, "Restart in... " + i);
       StdDraw.pause(1000);
       StdDraw.show();
        }
      }
      else
      {
    
      for(int i=4;i>=0;i--)
      {
       StdDraw.picture(512, 350, "b0.jpeg", 1024, 700, 0);
       StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(512, 350, "GAME OVER");
        StdDraw.setPenColor(243, 241, 239);
       StdDraw.text(512, 200, "SCORE:" + " " + String.valueOf(Collisions.score(0)));
       StdDraw.text(512, 100, "Restart in... " + i);
       StdDraw.pause(1000);
       StdDraw.show();
      
      }
      }
 
    } //gameOver
}




