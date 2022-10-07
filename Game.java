
package brickbreaker;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Game 
{
    
    public boolean playstatus = true;
    public int tickCount = 0;
    public int width = 1370;
    public int height = 768;
    Input input;
    LEVELOperator levelOperator = new LEVELOperator();
    
   
    public void run(Stage stg)
    {
        stg.setTitle("Brick Breaker");       
        Group root = new Group();
        Scene scene = new Scene(root);
        input = new Input(scene);
        stg.setScene(scene);
        Canvas canvas = new Canvas(width,height);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        stg.setResizable(false);
        stg.show();
      
       
        final long startTime = System.nanoTime();
        new AnimationTimer()
        {
            //start frame rate detection 
            long lastTime = System.nanoTime();
            double nsPerTick =1000000000D/60D;
        
            int frames = 0;
            int ticks = 0;
        
            long lastTimer = System.currentTimeMillis();
            double delta = 0;
            //end of frame rate 
            
            //timer start so game start
        @Override
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startTime) / 1000000000.0; 
            
            tick(input);
            //
            ticks++;
            paint(gc,t);
            //
            frames++;
            //reset the performance timer
            if(System.currentTimeMillis() - lastTimer >=1000)
            {
                lastTimer +=1000;
                System.out.println("Frames:" + frames + "  Ticks:" + ticks + " || " + input.enter);
                
                frames =0;
                ticks = 0;
            }
        }
        }.start();
    }
   
    public void tick(Input input)
    {
        tickCount++;
        levelOperator.levelTick( input, tickCount);    
    }
    
    public void paint(GraphicsContext gc, double t)
    {
        levelOperator.levelRender( gc,t);
    }
    
}

