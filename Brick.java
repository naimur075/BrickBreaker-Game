
package brickbreaker;
import javafx.scene.paint.Color;
public class Brick 
{
    int xPos;
    int yPos;
    int health;
    int sizeX = 40;
    int sizeY = 20;
    int lower;
    int left;
    int right;
    int top;
    Color shade;
    boolean notBroke = true;
   
    public Brick(int x,int y, int health)
    {
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        top = yPos;
        lower = yPos+sizeY;
        right = xPos;
        left = xPos + sizeX;
    }
    
    Color getShade()
    {
        if(health == 1)
        {
            shade = Color.BLUE;
        }
        else if(health ==2)
        {
            shade = Color.CRIMSON;
        }
        else if(health ==3)
        {
            shade = Color.GREEN;
        }
        return shade;
    }
      
    //Life Change
    boolean hit()
    {
        health --;
        if(health <= 0)
        {
            health = 0;
            notBroke = false;
            return true;
        }
        return false;
    }
    
    //detecting ball
    boolean ballDetect(Ball ball)
    {
        if(notBroke)
        {
            //detect top or bottom
        if(ball.ballx <left && ball.ballx >right)
        {
             //the ball is attacking from below 
            if((ball.bally+15) ==lower)
            {           
                ball.reflectY();
                return hit();
            }
            
             //the ball is attacking from above
            else if(ball.bally==top )
            {
                ball.reflectY();
                 return hit();
            }
        }
        
        
        //detect left or right
        else if(ball.bally < lower && ball.bally>top)
        {
            //ball is attacking from the right
            if(ball.ballx==right)
            {
                ball.reflectX();
                 return hit();
            }
            
            //ball is attacking from the right
            else if (ball.ballx== left)
            {
                ball.reflectX();
                 return hit();
            }
        }
        }
        return false;
    }
    
    //brick detect
    boolean detect(Ball ball)
    {
        if(notBroke)
        {
            //detect top or bottom
        if(ball.ballx <left && ball.ballx>right)
        {
              //the ball is attacking from below
            if(ball.bally ==lower)
            {
                ball.reflectY();
                return hit();
            }
            else if(ball.bally==top )
            {
                //the ball is attacking from above
                ball.reflectY();
                return hit();
            }
        }
        
        //detect left or right
        else if(ball.bally < lower && ball.bally>top)
        {
            if(ball.ballx ==right)
            {
                //ball is attacking from the right
                ball.reflectX();
                 return hit();
            }
            else if (ball.ballx == left)
            {
                //ball is attacking from the right
                ball.reflectX();
                return hit();
            }
        }
        }
        return false;
    }
    
    void kill()
    {
        this.health = 0;
        this.notBroke = false;
    }
    
}
