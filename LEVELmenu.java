
package brickbreaker;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class LEVELmenu 
{
    boolean isPlaySelected = true;
    boolean isActive;
    
    boolean shouldExit = false;
    boolean toggle = true;
    
    public void render(GraphicsContext gc, double time) 
    {     
        if(isActive){
         //Background    
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 1366, 768);
        //Title
        gc.setFill(Color.CRIMSON);
        Font f1=Font.font("Times New Roman",FontWeight.BOLD,50);
        gc.setFont(f1);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Welcome to BRICK BREAKER Game", 680, 170); 
        //instructions
        Font f3=Font.font("Times New Roman",FontWeight.BOLD,30);
        gc.setFont(f3);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Left and Right arrow key = Paddle", 680, 310);
        
        Font f4=Font.font("Times New Roman",FontWeight.BOLD,30);
        gc.setFont(f4);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Up arrow key = Ball", 680, 350);
        
        Font f5=Font.font("Times New Roman",FontWeight.BOLD,30);
        gc.setFont(f5);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Enter key = Choice", 680, 390);
        //play and exit signs
       Font f2=Font.font("Times New Roman",FontWeight.BOLD,50);
        gc.setFont(f2);
        //colors the active choice yellow
        if(isPlaySelected)
        {
            gc.setFill(Color.YELLOW);
        }
        else
        {
            gc.setFill(Color.RED);
        }
        
        gc.fillText("Play", 400, 500);       
        if(isPlaySelected)
        {
            gc.setFill(Color.RED);
        }
        else
        {
            gc.setFill(Color.YELLOW);
        }
        
        gc.fillText("Exit", 940, 500);       
        if(isPlaySelected)
        {
            gc.setFill(Color.YELLOW);
            gc.fillRect(350, 520, 100, 10);
            
        }
        else
        {
            gc.setFill(Color.YELLOW);
            gc.fillRect(890, 520, 100, 10);
        }
        
        }
             
    }

    //selects which level to display
    public void tick(Input input) 
    {
        if(this.isActive){
        if(input.left && toggle)
        {//select play
            isPlaySelected = true;
            toggle = false;
            
        }
        else if(input.right && toggle)
        {
            isPlaySelected = false;
            toggle = false;
        }
        else if(input.enter)
        { 
            System.out.println("exit");
            shouldExit = true;
            
        }
        else if(!input.right && !input.left)
        {
            toggle = true;
        }
        }
        
    }

   //exit game
    public boolean exit() 
    {
        return shouldExit;
    }
   
    //operations in start screen
    public int destination() 
    {
        if(isPlaySelected)
        {//the menu is exited to the game
            return 2;
        }
        else{
            //given the command to close 
            return 0;
        }
    }
    
    public void activate()
    {
        this.isActive = true;
        if(shouldExit = true)
        {
            
            this.shouldExit = false;
        }
    }
    public void deactivate()
    {
        this.isActive = false;
    }
    
}
