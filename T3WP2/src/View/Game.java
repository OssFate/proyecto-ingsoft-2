/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
    
    public static final int menu = 0;
    public static final int load = 1;
    public static final int create = 2;
    public static final int play = 3;
    public static final int cred = 4;
    
    public Game(String gameName) {
        super(gameName);
        this.addState(new Menu(menu));
        this.addState(new Load(load));
        this.addState(new Create(create));
        this.addState(new Play(play));
        this.addState(new Credits(cred));
    }
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(menu).init(gc, this);
        this.getState(load).init(gc, this);
        this.getState(create).init(gc, this);
        this.getState(play).init(gc, this);
        this.getState(cred).init(gc, this);
        this.enterState(menu);
    }
}
