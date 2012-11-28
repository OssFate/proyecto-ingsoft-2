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
    
    public GameCharacter(double health, float x, float y) throws SlickException{
        
        this.health = health;
        this.x = x;
        this.y = y;
        
        movingRight = new Image[6];
        movingLeft = new Image[6];
        
        attackRight = new Image[5];
        attackLeft = new Image[5];
        
        idleRight = new Animation(new Image[]{new Image("res/ratAnim/ratanimIdle.png")},200);
        idleLeft = new Animation(new Image[]{new Image("res/ratAnim/ratanimIdle.png").getFlippedCopy(true, false)},200);
        
        movingRight[0]=new Image("res/ratAnim/ratanimIdle.png");
        movingRight[1]=new Image("res/ratAnim/ratanimWalk2.png");
        movingRight[2]=new Image("res/ratAnim/ratanimWalk3.png");
        movingRight[3]=new Image("res/ratAnim/ratanimWalk4.png");
        movingRight[4]=new Image("res/ratAnim/ratanimWalk5.png");
        movingRight[5]=new Image("res/ratAnim/ratanimWalk6.png");
        
        movingLeft[0]=movingRight[0].getFlippedCopy(true, false);
        movingLeft[1]=movingRight[1].getFlippedCopy(true, false);
        movingLeft[2]=movingRight[2].getFlippedCopy(true, false);
        movingLeft[3]=movingRight[3].getFlippedCopy(true, false);
        movingLeft[4]=movingRight[4].getFlippedCopy(true, false);
        movingLeft[5]=movingRight[5].getFlippedCopy(true, false);
        
        attackRight[0]=new Image("res/ratAnim/ratanimIdle.png");
        attackRight[1]=new Image("res/ratAnim/ratanimAttack2.png");
        attackRight[2]=new Image("res/ratAnim/ratanimAttack3.png");
        attackRight[3]=new Image("res/ratAnim/ratanimAttack4.png");
        attackRight[4]=new Image("res/ratAnim/ratanimAttack5.png");
        
        attackLeft[0]=attackRight[0].getFlippedCopy(true, false);
        attackLeft[1]=attackRight[1].getFlippedCopy(true, false);
        attackLeft[2]=attackRight[2].getFlippedCopy(true, false);
        attackLeft[3]=attackRight[3].getFlippedCopy(true, false);
        attackLeft[4]=attackRight[4].getFlippedCopy(true, false);
        
        left=new Animation(movingLeft,80);
        right=new Animation(movingRight,80);
        aRight=new Animation(attackRight,80);
        aLeft=new Animation(attackLeft,80);
        
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

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
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
        g.setColor(Color.black);
        g.drawString("Health:", 11, 11);
        g.drawRoundRect(80, 10, 400, 20,4);
        g.setColor(Color.red);
        float percenthealth = (float) (curhealth/health);
        g.fillRoundRect(80, 10, 400*percenthealth , 20,4);
        g.setColor(Color.white);
        g.drawString( (int)(percenthealth*100)+"/"+health, 240, 11);
    }
    //public Weapon[] getWeapons() { return weapons; }
    //public boolean isEnemy() { return isEnemy; }
}
