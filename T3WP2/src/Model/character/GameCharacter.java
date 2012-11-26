/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.character;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author usuarios
 */
public class GameCharacter {
    private double health;
    private int[] time;
    private Image[] sprite1;
    private Image[] sprite2;
    private Animation left;
    private Animation right;
    private Animation current;
    private boolean facingRight;
    private float x;
    private float y;
    
    public GameCharacter(double health) throws SlickException{
        this.health = health;
        time = new int[2];
        sprite1 = new Image[2];
        sprite2 = new Image[2];
        sprite1[0]=new Image("res/mouse.png");
        sprite1[1]=sprite1[0];
        sprite2[0]=sprite1[0].getFlippedCopy(true, false);
        sprite2[3]=sprite2[2];
        time[0]=100;
        time[1]=100;
        left=new Animation(sprite2,time,false);
        right=new Animation(sprite1,time,false);
        
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setFacing(boolean facing) {
        this.facingRight = facing;
    }
    
    public boolean getFacing(){
        return facingRight;
    }
    
    public void Draw(GameContainer gc){
        if(facingRight){
            current = right;
        }else{
            current = left;
        }
        current.draw();
    }

    public double getLife() { return health; }
    //public Weapon[] getWeapons() { return weapons; }
    //public boolean isEnemy() { return isEnemy; }
}
