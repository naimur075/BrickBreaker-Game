
package brickbreaker;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;


public class Input 
{
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    boolean enter = false;
    boolean m = false;
    
    Scene scene;
    
   
    public Input(Scene scene)
    {
        this.scene = scene;
        init();
    }
    
    public void init()
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
       {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP : up = true; break;
                    case DOWN : down = true; break;
                    case LEFT : left  = true; break;
                    case RIGHT : right  = true; break;
                    case ENTER : enter = true; break;
                    case M : m = true; break;
                }
            }
        });
      
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() 
       {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP :  up = false; break;
                    case DOWN : down = false; break;
                    case LEFT : left = false; break;
                    case RIGHT : right = false; break;
                    case ENTER : enter = false; break;
                    case M : m = false; break;
                }
            }
        });
        
    }
    
    
    
}
