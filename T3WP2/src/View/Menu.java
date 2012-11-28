/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import org.newdawn.slick.*;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
    
    int xMCursor;
    int yMCursor;
    Image bg;
    Image cursor;
    
    public Menu(int state) { }
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        bg = new Image("res/menu.png");
        cursor = new Image("res/cursor.png");
        gc.setMouseCursor(cursor, 0, 0);
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bg.draw(0, 0);
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        Input input = gc.getInput();
        
        xMCursor = Mouse.getX();
        yMCursor = Mouse.getY();
        
        if((xMCursor > 315 && xMCursor < 485) && (yMCursor > 200 && yMCursor < 230) && 
                input.isMouseButtonDown(0)) sbg.enterState(1);
        if((xMCursor > 345 && xMCursor < 455) && (yMCursor > 150 && yMCursor < 180) && 
                input.isMouseButtonDown(0)) sbg.enterState(4);
        if((xMCursor > 370 && xMCursor < 430) && (yMCursor > 100 && yMCursor < 125) && 
                input.isMouseButtonDown(0)) System.exit(0);
    }
    
    public int getID(){ return 0; }
    
}
