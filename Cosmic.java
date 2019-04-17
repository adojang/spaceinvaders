public class Cosmic
{
    public static int highscore = 0;
    public static int gameState = 0;
    /*
        0 - menu
        1 - game
        3 - game over screen
    */
    
    public static void main(String[] args)
    {
      
        initialise();

        GameLoop.runGameLoop();       
        
    }//main
    
    public static void initialise()
    { 
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1024, 700);
        StdDraw.setXscale(0,1024);
        StdDraw.setYscale(0,700);
   
    }//initialise

}//Cosmic
