/* 
 * Coded by Adriaan van Wijk || 2019
 * <Insert Professional Quip or Joke Here>
 */

public class Cosmic
{
  public static void main(String[] args)
  {
    //Initializations
    int w, a, d, p = 0; //Used for keyboard controls
    StdDraw.setCanvasSize(1024, 700);
    
    /* Keyboard Controls
     * [w] shoot
     * [a] move left
     * [d] move right
     * [p] screen capture
     * 
     * Use the mouse to Aim. [May be changed later left and right arrow keys
     * if this poses an issue later]
    */
    
    //Main Menu Start
      //DRAW MAIN MENU FUCTION
    StdDraw.text(0.5, 0.5, "This is the main menu Press <Space> to start Game");
    while(!StdDraw.isKeyPressed(32))
    {
      
    }
    
    //START
    while(!StdDraw.isKeyPressed(81))
    {
    
      /* The keyboard controls work on a loop by loop basis, as 
       long as a key is pressed the value should be '1' and while
       it's not pressed it will be '0'
      */
      if(StdDraw.isKeyPressed(87)) w = 1;
        else w = 0;
         
       if(StdDraw.isKeyPressed(65)) a = 1;
        else a = 0;
               
       if(StdDraw.isKeyPressed(68)) d = 1;
        else d = 0;
        
        if(StdDraw.isKeyPressed(80)) p = 1;
        else p = 0;

       //Display the First frame of the game. 
        StdDraw.clear();
        //The Font flickering is a clear example of why we should use objects.
        StdDraw.text(0.5, 0.5, "This is the game Press <q> to quit");
      
    }
     System.out.println("*****************");
    System.out.println("The game has ended");
    System.out.println("*****************");
    
  } 
}