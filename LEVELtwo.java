
package brickbreaker;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
public class LEVELtwo 
{
    boolean ballOnPaddle = true;
    boolean shouldExit = false;
    boolean isActive;
    Paddle paddle = new Paddle();
    Ball ball = new Ball();
    BrickArray2 brickArray2 = new BrickArray2();
    Brick tempBrick;
    LEVELone l1=new LEVELone();
    BrickArray brickarray1=new BrickArray();
    int lives=l1.k;
    int score=brickarray1.column*brickarray1.row*10;
    int killed = 0;
   
    public void render(GraphicsContext gc, double time)
    {
        if(isActive)
        {
        
        //Background
        gc.setFill(Color.AQUA);
        gc.fillRect(0, 0, 1366, 768);
        
        // paddle
        gc.setFill(Color.CRIMSON);
        gc.fillRect(paddle.barposx, paddle.barposy, paddle.xSize, paddle.ySize);
        // Ball
        gc.setFill(Color.BLUE);
        gc.fillOval(ball.ballx, ball.bally, ball.xSize, ball.ySize);
        //Brick Array
        for(int i = 0; i<brickArray2.row;i++)
        {
            for(int j = 0; j < brickArray2.column; j++)    
            {
                tempBrick = brickArray2.bricks[i][j];
                gc.setFill(tempBrick.getShade());
                if(tempBrick.notBroke)
                {
                    gc.fillRect(tempBrick.xPos, tempBrick.yPos, tempBrick.sizeX, tempBrick.sizeY);
                }
                
               }
           }
        
        }
        //Showing Lives
        gc.setFill(Color.RED);
        Font f1=Font.font("Times New Roman",FontWeight.BOLD,30);
        gc.setFont(f1);
        gc.fillText("Life : "+lives, 1300, 25);
     
        //Showing Scores
        gc.setFill(Color.RED);
        Font f2=Font.font("Times New Roman",FontWeight.BOLD,30);
        gc.setFont(f2);
        gc.fillText("Score : "+score, 75, 25);
        
        //Showing Title
        gc.setFill(Color.RED);
        Font f3=Font.font("Times New Roman",FontWeight.BOLD,30);
        gc.setFont(f3);
        gc.fillText("LEVEL  2", 725, 25);
    }
    
    
    public void tick(Input input, int tickCount) 
    {
        if(isActive)
        {
            //paddle movement
        if(input.left)
        {
            paddle.decreasedx();
        }
        else if(input.right)
        {
            paddle.increasedx();
        }
        
        //ball movement
        if(input.up)
        {
            ballOnPaddle = false;
        }
        
        //apply friction to paddle
        if(tickCount % 2 ==0)
        {
            if(!input.left && !input.right)
           {
                paddle.normalizeX();     
           }
        }
   
        //update paddle's position
        paddle.movx();
        
        //update ball position
        if(ball.Delta(paddle, ballOnPaddle))
        {
            mistake();
        }
        
        
        killed += brickArray2.checkAll(ball);
        score=(brickarray1.column*brickarray1.row*10)+(killed*10);
        }   
    }

    
    public boolean exit()
    {
        return shouldExit;
    }
    
    //ball not received by paddle
    public void mistake()
    {
        this.lives--;
        if(this.lives == 0)
        {
            shouldExit = true;
        }
        this.ballOnPaddle = true;       
    }
    
    public int destination()
    {
            return 1;
    }
    
    //restart game
    public void activate()
    {
        this.isActive = true;
        if(this.shouldExit == true)
        {
            //this.lives = 3;
            shouldExit = false;
            ballOnPaddle = true;
            this.brickArray2= new BrickArray2(); 
        }     
    }
    
    public void deactivate()
    {
        this.isActive = false;
    }
    
    
}

