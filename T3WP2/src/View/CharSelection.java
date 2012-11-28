/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author German
 */
public class CharSelection extends BasicGameState{
    private int mouseX;
    private int mouseY;

    @Override
    public int getID() {
        return 7;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        
        mouseX = Mouse.getX();
        mouseY = Mouse.getY();
        
    }
    
    
    
}
