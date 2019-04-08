public class Cosmic
{
    
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
