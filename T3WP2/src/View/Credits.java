/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Credits extends BasicGameState{
    
    Image credit;
    int x, y;
    
    public Credits(int state) { }
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        credit = new Image("res/creditos.png");
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        credit.draw(0, 0);
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        Input input = gc.getInput();
        x = Mouse.getX();
        y = Mouse.getY();
        
        if(input.isKeyPressed(Input.KEY_ESCAPE) || input.isMouseButtonDown(0)
                && (x > 550 && x < 750) && (y > 45 && y < 90)) sbg.enterState(0);
    }
    
    public int getID(){ return 4; }
    
}
