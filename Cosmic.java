/* 
 * Coded by:
 * Adriaan van Wijk 21786275
 * Eberhardt Korf - ????????
 * William Theron 21564418
 * (c) 2019
 * <Insert Professional Quip or Joke Here>
 */

public class Cosmic
{
  public static void main(String[] args)
  {
    //Initializations
    double  x=512, y=200; //Used for keyboard controls
    StdDraw.enableDoubleBuffering(); // IMPORTANT! Have a look at the StdDraw API to understand how this works.
    //Sets the canvas size and changes default scale. 1 pixel = 1 unit now.
    StdDraw.setCanvasSize(1024, 700);
    StdDraw.setXscale(0,1024);
    StdDraw.setYscale(0,700);
    
    /* Keyboard Controls
     * [w] shoot
     * [a] move left
     * [d] move right
     * [p] screen capture
     * 
     * Use the mouse to Aim. [May be changed later left and right arrow keys
     * if this poses an issue later]
    */
    
    /* Lets use CustomObjects as the file where all our objects are stored. */
    CustomObjects player = new CustomObjects();
    player.ship(512, 50);
   
    
    //Main Menu Start
      //DRAW MAIN MENU FUCTION
    StdDraw.text(512, 350, "This is the main menu Press <Space> to start Game");
    StdDraw.show();
    while(!StdDraw.isKeyPressed(32))
    {
      
    }
    
    //START
    while(!StdDraw.isKeyPressed(81))
    {
      //Clears the screen before next frame is shown.
      StdDraw.clear();
     
      /* K E Y B O A R D   C O N T R O L S */
    
      // W - Up
      if(StdDraw.isKeyPressed(87)) y = y+1.5;

      // A - Left
      if(StdDraw.isKeyPressed(65)) x = x-1.5;
    
      // S - Down     
      if(StdDraw.isKeyPressed(68)) x = x+1.5;
   
      //D - Right
      if(StdDraw.isKeyPressed(83)) y = y-1.5;
      
      //Screenshot Utility
      if(StdDraw.isKeyPressed(80)) /* Take a Screenshot */;

        //Prevent ship from flying off screen, with a margin of 24px
      if(x < 24) x = 25;
      if(x > 1000) x = 1000;
      if(y < 24) y = 24;
      if(y > 676) y = 676;
      
      
       /* Display the Current Frame */
        
        StdDraw.text(512, 350, "This is the game Press <q> to quit");
        player.ship(x, y);
        StdDraw.show();
        
        
    }
     System.out.println("*****************");
    System.out.println("The game has ended");
    System.out.println("*****************");
    System.exit(1);
    
  } 
}