/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.character.enemies;

import Model.character.GameCharacter;
import Model.character.HitBox;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author usuarios
 */
public class Mongoose extends GameCharacter{
    public Mongoose(float x, float y) throws SlickException{
        super(90, x, y);
        
        speed = 0.25f;
        
        hitBox = new HitBox((int) (x + 10),(int) y, 140, 180);
        
        
        movingLeft = new Image[7];
        movingRight = new Image[7];
        
        attackRight = new Image[7];
        attackLeft = new Image[7];
        
        idleLeft = new Animation(new Image[]{new Image("res/monAnim/monIdle.png")},200);
        idleRight = new Animation(new Image[]{new Image("res/monAnim/monIdle.png").getFlippedCopy(true, false)},200);
        
        attackLeft[0]=new Image("res/monAnim/monAtk1.png");
        attackLeft[1]=new Image("res/monAnim/monAtk2.png");
        attackLeft[2]=new Image("res/monAnim/monAtk3.png");
        attackLeft[3]=new Image("res/monAnim/monAtk4.png");
        attackLeft[4]=new Image("res/monAnim/monAtk5.png");
        attackLeft[5]=new Image("res/monAnim/monAtk6.png");
        attackLeft[6]=new Image("res/monAnim/monAtk7.png");
        
        attackRight[0]=attackLeft[0].getFlippedCopy(true, false);
        attackRight[1]=attackLeft[1].getFlippedCopy(true, false);
        attackRight[2]=attackLeft[2].getFlippedCopy(true, false);
        attackRight[3]=attackLeft[3].getFlippedCopy(true, false);
        attackRight[4]=attackLeft[4].getFlippedCopy(true, false);
        attackRight[5]=attackLeft[5].getFlippedCopy(true, false);
        attackRight[6]=attackLeft[6].getFlippedCopy(true, false);
        
        movingLeft[0]=new Image("res/monAnim/monWalk1.png");
        movingLeft[1]=new Image("res/monAnim/monWalk2.png");
        movingLeft[2]=new Image("res/monAnim/monWalk37.png");
        movingLeft[3]=new Image("res/monAnim/monWalk46.png");
        movingLeft[4]=new Image("res/monAnim/monWalk5.png");
        movingLeft[5]=new Image("res/monAnim/monWalk46.png");
        movingLeft[6]=new Image("res/monAnim/monWalk37.png");
        
        movingRight[0]=movingLeft[0].getFlippedCopy(true, false);
        movingRight[1]=movingLeft[1].getFlippedCopy(true, false);
        movingRight[2]=movingLeft[2].getFlippedCopy(true, false);
        movingRight[3]=movingLeft[3].getFlippedCopy(true, false);
        movingRight[4]=movingLeft[4].getFlippedCopy(true, false);
        movingRight[5]=movingLeft[5].getFlippedCopy(true, false);
        movingRight[6]=movingLeft[6].getFlippedCopy(true, false);
        
        left=new Animation(movingLeft,40);
        right=new Animation(movingRight,40);
        aRight=new Animation(attackRight,40);
        aLeft=new Animation(attackLeft,40);
        
        current = left;
    }

    @Override
    public void draw(GameContainer gc) {
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
            current.draw(x,y);
        }else{
            if(isIdle){
                current=idleLeft;
            }else{
                if(attacking){
                    current=aLeft;
                }else{
                    current=left;
                }
            }current.draw(x-100,y);
        }
     }
    
    ////////////////////////////////////////////////////////////
    public static GameCharacter newEnemy(int posX, int posY) throws SlickException{
        return new Mongoose(posX, posY);
    }
}
