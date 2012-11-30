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
public abstract class GameCharacter implements Observer{
    
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
    
    ///////////////////////////////////////////////
    protected HitBox hitBox;
    protected boolean colide;
    
    protected boolean destroy;
    
    public GameCharacter(double health, float x, float y) throws SlickException{
        
        this.health = health;
        this.curhealth = this.health;
        this.x = x;
        this.y = y;
        
        destroy = false;
        
        attackSound = new Sound("res/sword(2).wav");
       
        ///////////////////////////////////////////////
	//hitBox = new HitBox(x, y, width, height);

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
    
    public boolean getIdle(){
        return this.isIdle;
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
    
    public abstract void draw(GameContainer gc);
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
    
    
    ////////////////////////////////////////////////
    
    @Override
    public void update(boolean b) {
        colision(b);
    }

    @Override
    public HitBox getBox() {
        return this.hitBox;
    }

    @Override
    public void setColide(boolean b) {
        this.colide = b;
    }

    public void colision(boolean b) {
        if(colide && b){
            destroy = true;
        }
    }

    public boolean isDestroy() {
        return destroy;
    }
    
    public void move(int delta, float charSpeed){
        if(facingRight){
            current = right;
            x += (speed+charSpeed)*delta;
            this.getBox().getHitBox()[0] += (speed+charSpeed)*delta;;
        }else{
            current = left;
            x -= (speed+charSpeed)*delta;
            this.getBox().getHitBox()[0] -= (speed+charSpeed)*delta;
        }
        current.draw(x, y);
    }
}
