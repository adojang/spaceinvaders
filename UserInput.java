/* keycodes:
 32 - space
 65 - A
 68 - D
 79 - O
 80 - P
 81 - Q
 83 - S
 87 - W
 */

public class UserInput
{

    public static String checkUserInput()
    {
        
        if(StdDraw.isKeyPressed(32)) return "SPACE";
        if(StdDraw.isKeyPressed(65)) return "LEFT";
        if(StdDraw.isKeyPressed(68)) return "RIGHT";
        if(StdDraw.isKeyPressed(77)) return "MENU";
        if(StdDraw.isKeyPressed(87)) return "SHOOT";
        if(StdDraw.isKeyPressed(81)) return "QUIT";
        if(StdDraw.isKeyPressed(79)) return "ROTATELEFT";
        if(StdDraw.isKeyPressed(80)) return "ROTATERIGHT";
        
        return "NULL";
        
    }//checkUserInput
    
}//userInout
