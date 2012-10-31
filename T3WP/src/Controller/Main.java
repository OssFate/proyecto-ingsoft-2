package Controller;

import View.gameState;
import View.magicState;
import View.menuState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame{
       
    public static void main( String[] args ) throws SlickException{
        AppGameContainer app = new AppGameContainer(new Main(gamename));
        
        app.setDisplayMode(800, 600, false);
        app.setVSync(true);
        app.start();
        
    }
    
    public static final String gamename = "T3WP!";
    public static final int menu = 0;
    public static final int game = 1;
    public static final int magic = 2;
 
    public Main(String name) {
        super(name);
        this.addState(new menuState(menu));
        this.addState(new gameState(game));
        this.addState(new magicState(magic));
    }
  
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(menu).init(gc, this);
        this.getState(game).init(gc, this);
        this.getState(magic).init(gc, this);
        this.enterState(menu);
    }
}
