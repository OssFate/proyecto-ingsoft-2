/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.character.enemies.Alligator;
import Model.character.enemies.Mongoose;
import Model.character.enemies.Pig;
import Model.character.enemies.Rabbit;
import Model.character.enemies.Rat;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
    
    private boolean lol;
    
    private Image rat;
    private Image rabbit;
    private Image pig;
    private Image mon;
    private Image alli;
    private Image bg;
    
    private Play play;

    public CharSelection(int i) {}
    
    @Override
    public int getID() {
        return 7;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        play = new Play(7);
        rat = new Image("res/ratAnim/ratanimIdle.png");
        rabbit = new Image("res/rabbitAnim/rabbitIdle.png");
        pig = new Image("res/pigAnim/pigIdle.png");
        mon = new Image("res/monAnim/monIdle.png");
        alli = new Image("res/crocAnim/crocIdle.png");
        bg = new Image("res/BgSelection.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bg.draw(0, 0);
        rat.draw(15, 50);
        rabbit.draw(205, 50);
        pig.draw(0,220);
        mon.draw(205,250);
        alli.draw(250,0);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        
        mouseX = Mouse.getX();
        mouseY = Mouse.getY();
        
        lol=false;
        
        if(input.isMouseButtonDown(0)){
            if((mouseX > 15 && mouseX < 215) && (mouseY < 600-50 && mouseY > 600-230)){
                play=(Play) sbg.getState(3);
                play.setGameChar(new Rat(300,380));
                sbg.enterState(3);
            }
            if((mouseX > 205 && mouseX < 415) && (mouseY < 600-50 && mouseY > 600-230)){
                play=(Play) sbg.getState(3);
                play.setGameChar(new Rabbit(300,390));
                sbg.enterState(3);
            }
            if((mouseX > 465 && mouseX < 715) && (mouseY < 480 && mouseY > 225)){
                play=(Play) sbg.getState(3);
                play.setGameChar(new Alligator(200,200));
                sbg.enterState(3);
            }
            if((mouseX > 50 && mouseX < 210) && (mouseY < 355 && mouseY > 185)){
                play=(Play) sbg.getState(3);
                play.setGameChar(new Pig(300,370));
                sbg.enterState(3);
            }
            if((mouseX > 250 && mouseX < 420) && (mouseY < 335 && mouseY > 200)){
                play=(Play) sbg.getState(3);
                play.setGameChar(new Mongoose(300,380));
                sbg.enterState(3);
            }
            
        }
    }
}