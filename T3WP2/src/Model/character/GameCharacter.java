/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.character;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author usuarios
 */
public abstract class GameCharacter {
    
    protected double health;
    protected double curhealth;
    
    protected Image[] movingRight;
    protected Image[] movingLeft;
    protected Image[] attackRight;
    protected Image[] attackLeft;
    
    protected Sound attackSound;
    
    protected Animation current;
    
    protected Animation left;
    protected Animation right;
    
    protected Animation idleRight;
    protected Animation idleLeft;
    
    protected Animation aRight;
    protected Animation aLeft;
    
    protected boolean isIdle = true;
    protected boolean facingRight = true;    
    protected boolean attacking = false;
    
    protected float x;
    protected float y;
    protected float speed;
    
    public GameCharacter(double health, float x, float y) throws SlickException{
        
        this.health = health;
        this.curhealth = this.health;
        this.x = x;
        this.y = y;
        
        attackSound = new Sound("res/sword(2).wav");
        
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setIdle(boolean isIdle){
        this.isIdle=isIdle;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean getAttacking() {
        return attacking;
    }
    
    

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    public Sound getSound(){
        return attackSound;
    }

    public void setFacingRight(boolean facing) {
        this.facingRight = facing;
    }
    
    public boolean getFacing(){
        return facingRight;
    }
    
    public void draw(GameContainer gc){
        
        if(facingRight){
            if(isIdle){
                current=idleRight;
            }else{
                if(attacking){
                    current=aRight;
                }else{
                    current=right;
                }
            }
        }else{
            if(isIdle){
                current=idleLeft;
            }else{
                if(attacking){
                    current=aLeft;
                }else{
                    current=left;
                }
            }
        }
        current.draw(x,y);
        }
    public void drawHealth(Graphics g){
        g.setColor(Color.white);
        g.drawString("Health:", 11, 11);
        g.drawRoundRect(80, 10, 400, 20,4);
        g.setColor(Color.red);
        float percenthealth = (float) (curhealth/health);
        g.fillRoundRect(80, 10, 400*percenthealth , 20,4);
        g.setColor(Color.white);
        g.drawString( (int)(percenthealth*curhealth)+"/"+(int)(health), 240, 11);
    }
    public float getSpeed(){
        return speed;
    }
}
