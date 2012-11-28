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
public class Rat extends GameCharacter{

    public Rat(float x, float y) throws SlickException {
        super(110, x, y);
        
        hitBox = new HitBox((int) (x + 20),(int) y, 100, 180);
        
        
        speed = 0.15f;
        
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
    
    ////////////////////////////////////////////////////////////
    public static GameCharacter newEnemy(int posX, int posY) throws SlickException{
        return new Rat(posX, posY);
    }
}
