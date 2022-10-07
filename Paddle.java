
package brickbreaker;

public class Paddle 
{
    int barposx;
    int barposy;
    int xSize;
    int ySize;
        
    int xLimRight;
    int xLimLeft;
    
    
    int bardx=0;
    int bardy =0;
    int maxSpeed =20;
    int minSpeed = -20;
    
   
    public Paddle()
    {
        barposx = 0;
       barposy= 700;
        xSize = 220;
        ySize = 15;
        xLimRight = 1185;
        xLimLeft = 0;
        
    }
    
    //bar moving in x axis
    void movx()
    {
       barposx += bardx;
        if(barposx<0)
        {
            barposx=0;
        }
        if((barposx > 1136))
        {
            barposx=1136;
        }
    }
    
    //bar moving in y axis
    void movy()
    {
        barposy += bardy;
        if(barposy> 730)
        {
            barposy=730;
        }
        if(barposy <625)
        {
            barposy = 625;
        }
    }
    
    
    boolean xIsPositive()
    {
        return (bardx >=0);
    }
    
    boolean yIsPositive()
    {
        return (bardy >=0);
    }
    
    //increases movment if the movment is below max speed
    void increasedx()
    {
        if(bardx<maxSpeed)
        {
            bardx++;
        }
    }
    
    
    void increasedy()
    {
        if(bardy<maxSpeed)
        {
            bardy+=2;
        }
    }
    
    //decreases movment 
    void decreasedx()
    {
        if(bardx > minSpeed)
        {
            bardx-=2;
        }
    }
    
    void decreasedy()
    {
        if(bardy> minSpeed)
        {
            bardy--;
        }
    }
    
    // this applies friction to the paddle if called, slowing it's movment to 
        //zero
    void normalizeX()
    {
        if(bardx<0)
        {
            bardx++;
        }
        else if(bardx >0)
        {
            bardx--;
        }
       
    }
    void normalizeY()
    {
        if(bardy<-2)
        {
           bardy-=10;
        }
        else if(bardy >2)
        {
            
            //yVec--;
            //yVec = 0;
        }
    }
}
