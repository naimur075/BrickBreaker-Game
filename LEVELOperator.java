
package brickbreaker;


import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;


public class LEVELOperator 
{
    int levelNumber = 1;
    
    LEVELmenu menu = new LEVELmenu();
    LEVELone firstLevel = new LEVELone();
    LEVELtwo secondLevel = new LEVELtwo();
   
    public void levelRender( GraphicsContext gc, double t)
    {//determines which level will render
        switch(levelNumber)
        {
            case 0:
            {//exit               
                break;
            }
            case 1:
            {//Menu
                menu.render(gc, t);
                break;
            }
            case 2:
            {//levelOne
                firstLevel.render(gc,t);
                break;
            }
            case 3:
            {//leveltwo
                secondLevel.render(gc,t);
                break;
            }
        }  
    }
    
    public void levelTick( Input input, int tickCount)
    {// tells the game to perform a logic tick and asks if the 
       //level should be exited
        switch(levelNumber)
        {
            case 0: 
            {//exit application
                Platform.exit();
                break;
            }
            case 1:
            {//opening menu
                menu.activate();
                menu.tick(input);
                if(menu.exit())
                {
                    menu.deactivate();
                    levelNumber = menu.destination();
                }
                break;
            }
            case 2:
            {//first level
                firstLevel.activate();
                
                firstLevel.tick(input, tickCount);
                if(firstLevel.exit())
                {
                    firstLevel.deactivate();
                    levelNumber = firstLevel.destination();
                }
                break;      
            }
            
            case 3:
            {//second level
                secondLevel.activate();
                
                secondLevel.tick(input, tickCount);
                if(secondLevel.exit())
                {
                    secondLevel.deactivate();
                    levelNumber = secondLevel.destination();
                }
                break;      
            }
            
            
        }
    }
    
}