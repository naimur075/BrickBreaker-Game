package brickbreaker;

public class BrickArray2 
{
    int column = 13;
    int row = 10;
    Brick bricks[][] = new Brick[row][column];
   
    
    public BrickArray2()
    {
        init();
    }
 
    void init()
    {
        for(int i =0; i < row;i++)
        {
            for(int j = 0; j <column;j++)
            {
                if(j==0){
                   bricks[i][j] = new Brick((j * 60)+600,(i *50)+50,3);
                }
                else{
                   bricks[i][j] = new Brick((j * 60)+300,(i *50)+50,3);
                }
            }
        }
    }
    
    
    int checkAll(Ball ball)
    {
        int numberKilled = 0;
        for(int i =0; i <row;i++)
        {
            for(int j=0; j<column;j++)
            {
                if(bricks[i][j].detect(ball))
                {
                    numberKilled++;
                }
                
            }
        }
        return numberKilled;
    }
    
    // for clearing out all the bricks in the event of a defeat
    void killAll()
    {
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<column;j++)
            {
                bricks[i][j].kill();
            }
        }
    }
} 
   
    
    