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
    GameCharacter gameChar;
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
        bg = new Image("res/Bg2 - resized.jpg");
        pause = new Image("res/pause.png");
        //Image[] mouse = {new Image("res/mouse.png")};
        //anim = new Animation(mouse, duration, false);
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bg.draw(bgX, bgY);
        gameChar.drawHealth(g);
        gameChar.draw(gc);
        if(quit == true){
            pause.draw(200,200);
            if(quit == false){
                g.clear();
            }
        }
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        Input input = gc.getInput();
        gameChar.setIdle(true);
        gameChar.setAttacking(false);
        if((input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W))
                && bgY < 170){ 
            bgY += delta * gameChar.getSpeed();
            gameChar.setIdle(false);
        }
        if((input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S))
                && bgY > -222){
            bgY -= delta * gameChar.getSpeed();           
            gameChar.setIdle(false);
        }
        if((input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A))
                && bgX < -10){ 
            bgX += delta *gameChar.getSpeed();
            gameChar.setFacingRight(false);
            gameChar.setIdle(false);
        }
        if((input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D))
                && bgX > -1000){ 
            bgX -= delta * gameChar.getSpeed();
            gameChar.setFacingRight(true);
            gameChar.setIdle(false);
        }
        
        if (input.isKeyDown(Input.KEY_Z) || input.isMouseButtonDown(0)){
            gameChar.setIdle(false);
            gameChar.setAttacking(true);
        }
        if (input.isKeyPressed(Input.KEY_Z) || input.isMouseButtonDown(0)) gameChar.getSound().play();
        if(input.isKeyDown(Input.KEY_ESCAPE)) quit = true;
        
        if(quit == true){
            //if(input.isKeyDown(Input.KEY_DOWN) && bgY > -222 && !gameChar.getAttacking()) bgY += delta * gameChar.getSpeed();
            //if(input.isKeyDown(Input.KEY_UP) && bgY < 170 && !gameChar.getAttacking()) bgY -= delta *  gameChar.getSpeed();
            if(input.isKeyDown(Input.KEY_RIGHT) && bgX > -765 && !gameChar.getAttacking()) bgX += delta *  gameChar.getSpeed();
            if(input.isKeyDown(Input.KEY_LEFT) && bgX < 144 && !gameChar.getAttacking()) bgX -= delta * gameChar.getSpeed();
            
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
    
    public int getID(){ return 3; }
    
    public void setGameChar(GameCharacter g){
        gameChar=g;
    }
}
