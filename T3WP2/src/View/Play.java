/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.character.GameCharacter;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
    
    float bgX = 0;
    float bgY = 0;
    GameCharacter mouse;
    double health;
    float xMouse = 100;
    float yMouse = 250;
    int[] duration = {200};
    boolean quit = false;
    Image bg;
    Image pause;
    Animation anim;
    
    public Play(int state) { }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        health = 100;
        mouse = new GameCharacter(health, xMouse, yMouse);
        bg = new Image("res/Bg1.jpg");
        pause = new Image("res/pause.png");
        //Image[] mouse = {new Image("res/mouse.png")};
        //anim = new Animation(mouse, duration, false);
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bg.draw(bgX, bgY);
        mouse.drawHealth(g);
        mouse.draw(gc);
        if(quit == true){
            pause.draw(200,200);
            if(quit == false){
                g.clear();
            }
        }
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        Input input = gc.getInput();
        mouse.setIdle(true);
        mouse.setAttacking(false);
        if((input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W))
                && bgY < 170){ 
            bgY += delta * .1f;
            mouse.setIdle(false);
        }
        if((input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S))
                && bgY > -222){
            bgY -= delta * .1f;           
            mouse.setIdle(false);
        }
        if((input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A))
                && bgX < 144){ 
            bgX += delta *.1f;
            mouse.setFacingRight(false);
            mouse.setIdle(false);
        }
        if((input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D))
                && bgX > -765){ 
            bgX -= delta * .1f;
            mouse.setFacingRight(true);
            mouse.setIdle(false);
        }
        
        if (input.isKeyDown(Input.KEY_Z)){
            mouse.setIdle(false);
            mouse.setAttacking(true);
        }
        
        if(input.isKeyDown(Input.KEY_ESCAPE)) quit = true;
        
        if(quit == true){
            if(input.isKeyDown(Input.KEY_DOWN) && bgY > -222) bgY += delta * .1f;
            if(input.isKeyDown(Input.KEY_UP) && bgY < 170) bgY -= delta * .1f;
            if(input.isKeyDown(Input.KEY_RIGHT) && bgX > -765) bgX += delta * .1f;
            if(input.isKeyDown(Input.KEY_LEFT) && bgX < 144) bgX -= delta *.1f;
            
            if(input.isKeyDown(Input.KEY_R)) quit = false;
            if(input.isKeyDown(Input.KEY_M)){
                quit = false;
                bgX = 0;
                bgY = 0;
                sbg.enterState(0);
            }
            if(input.isKeyDown(Input.KEY_Q)) System.exit(0);
        }
    }
    
    public int getID(){ return 2; }
}
