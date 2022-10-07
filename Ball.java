package brickbreaker;

public class Ball 
{
   
    int ballx;
    int bally;
    int xSize;
    int ySize;
    boolean free = false;
    int left;
    int right;
    int up;
    int down;
    
    int balldx;
    int balldy;
   
    int maxSpeed=20;
    int optSpeed=5;
   
    
    public Ball()
    {
        this.ballx= 500;
        this.bally = 300;
        this.xSize = 15;
        this.ySize = 15;
        this.balldx= -optSpeed;
        this.balldy= optSpeed;
    }
   
    
    void init()
    {
        this.left = ballx;
        this.right = ballx + xSize;
        this.up = bally;
        this.down = bally + ySize;
    }
    
    //ball moving in x axis
    void movx()
    {
        ballx += balldx;
        if(ballx <0)
        {
            ballx = 0;
            reflectX();
        }
        else if(ballx >1346)
        {
            ballx = 1346;
            reflectX();
        }
    }
    
     //ball moving in y axis
    boolean movy(Paddle player)
    {
        bally += balldy;
        if(bally<0)
        {
            bally= 0;
            reflectY();
            return false;
        }
        else if( (ballx >player.barposx) &&(ballx <player.barposx+player.xSize)&& (bally== player.barposy-ySize))
        {
            
            reflectY();
            return false;
        }
        else if(bally> 760)
        {
            bally = 760;
            reflectY();
            return true;
        }
            
        return false;
    }
    
    
    boolean Delta(Paddle player, Boolean onPaddle)
    {
        if(onPaddle)
        {
            ballx = player.barposx + (player.xSize/2) -(this.xSize/2);
            bally= player.barposy - 20;
            return false;
        }
        else
        {
            movx();
            return movy(player);
        }
        
    }
    
    
    void normalizeX()
    {
        if(balldx < optSpeed)
        {
           balldx= optSpeed;
        }
        else if(balldx> optSpeed)
        {
           balldx--;
        }
    }
    
    void normalizeY()
    {
        if(balldy< optSpeed)
        {
            balldy= optSpeed;
        }
        else if(balldy>optSpeed)
        {
            balldy--;
        }
    }
    
    //speed control
    void normalize()
    {
        normalizeX();
        normalizeY();
    }
    
    void limit()
    {
        if(balldx>maxSpeed)
        {
            balldx=maxSpeed;
        }
        if(balldy>maxSpeed)
        {
           balldy = maxSpeed;
        }
    }
    
    //checks if speed is normal
    void check()
    {
        limit();
        normalize();
    }
    
    
    void reflectX()
    {
        balldx = balldx*-1;
    }
    void reflectY()
    {
       balldy= balldy*-1;
    }
    void toggleFree()
    {
        this.free = !free;
    }
    
}
