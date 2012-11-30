/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Load extends BasicGameState {
    Image load;
    int x, y;
    File[] user;
    int maxUsers = 10;
    int currentUsers;
    
    public Load(int load) { }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        load = new Image("res/load.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        load.draw(0,0);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        x = Mouse.getX();
        y = Mouse.getY();
        
        if(input.isKeyPressed(Input.KEY_ESCAPE)) sbg.enterState(0);
        if(input.isMouseButtonDown(0) && (x > 100 && x < 300) && (y > 40 && y < 85)
                && currentUsers < 10) sbg.enterState(2);
        if(input.isMouseButtonDown(0) && (x > 325 && x < 525) && (y > 40 && y < 85)
                && (currentUsers < 10 && currentUsers > 0)){
        } 
        if(input.isMouseButtonDown(0) && (x > 550 && x < 750) && (y > 115 && y < 160)
                && currentUsers < 10){
            sbg.enterState(7);
        } 
        if(input.isMouseButtonDown(0) && (x > 550 && x < 750) && (y > 45 && y < 90)) sbg.enterState(0);
    }
    @Override
    public int getID() { return 1; }
    public int getMaxUsers() { return maxUsers; }
    public int getCurrentUsers() { return currentUsers; }
}
