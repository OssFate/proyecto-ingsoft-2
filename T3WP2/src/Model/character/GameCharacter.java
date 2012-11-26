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
public class GameCharacter {
    private double health;
    private Image[] movingRight;
    private Image[] movingLeft;
    private Animation left;
    private Animation right;
    private Animation current;
    private Animation idle;
    private boolean isIdle = true;
    private boolean facingRight = true;    
    private float x;
    private float y;
    
    public GameCharacter(double health, float x, float y) throws SlickException{
        this.health = health;
        this.x = x;
        this.y = y;
        movingRight = new Image[6];
        movingLeft = new Image[6];
        idle = new Animation(new Image[]{new Image("res/ratanimIdle.png")},200);
        
        movingRight[0]=new Image("res/ratanimIdle.png");
        movingRight[1]=new Image("res/ratanimWalk2.png");
        movingRight[2]=new Image("res/ratanimWalk3.png");
        movingRight[3]=new Image("res/ratanimWalk4.png");
        movingRight[4]=new Image("res/ratanimWalk5.png");
        movingRight[5]=new Image("res/ratanimWalk6.png");
        
        movingLeft[0]=movingRight[0].getFlippedCopy(true, false);
        movingLeft[1]=movingRight[1].getFlippedCopy(true, false);
        movingLeft[2]=movingRight[2].getFlippedCopy(true, false);
        movingLeft[3]=movingRight[3].getFlippedCopy(true, false);
        movingLeft[4]=movingRight[4].getFlippedCopy(true, false);
        movingLeft[5]=movingRight[5].getFlippedCopy(true, false);
        
        left=new Animation(movingLeft,100);
        right=new Animation(movingRight,100);
        
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
        
        if(isIdle){
            current = idle;
        }else{
            if(facingRight){
                current = right;
            }else{
                current = left;
            }
        }
        current.draw(x,y);
        }
    public void drawHealth(Graphics g){
        g.setColor(Color.black);
        g.drawString("Health:", 11, 11);
        g.drawRect(80, 10, 400, 20);
        g.setColor(Color.red);
        float percenthealth = (float) (health/100);
        g.fillRect(80, 10, 400*percenthealth , 20);
        g.setColor(Color.white);
        g.drawString( (int)(percenthealth*100)+"/100", 240, 11);
    }

    public double getLife() { return health; }
    //public Weapon[] getWeapons() { return weapons; }
    //public boolean isEnemy() { return isEnemy; }
}
