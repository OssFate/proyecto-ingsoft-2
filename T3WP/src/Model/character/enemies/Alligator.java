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
public class Alligator extends GameCharacter{
    public Alligator(float x, float y) throws SlickException {
        super(180, x, y);
        
        hitBox = new HitBox((int) (x + 20),(int) y, 220, 180);
        
        speed = 0.1f;
        
        movingLeft = new Image[13];
        movingRight = new Image[13];
        
        attackRight = new Image[13];
        attackLeft = new Image[13];
        
        idleLeft = new Animation(new Image[]{new Image("res/crocAnim/crocIdle.png")},200);
        idleRight = new Animation(new Image[]{new Image("res/crocAnim/crocIdle.png").getFlippedCopy(true, false)},200);
        
        attackLeft[0]=new Image("res/crocAnim/crocAtk1.png");
        attackLeft[1]=new Image("res/crocAnim/crocAtk2.png");
        attackLeft[2]=new Image("res/crocAnim/crocAtk3.png");
        attackLeft[3]=new Image("res/crocAnim/crocAtk4.png");
        attackLeft[4]=new Image("res/crocAnim/crocAtk5.png");
        attackLeft[5]=new Image("res/crocAnim/crocAtk6.png");
        attackLeft[6]=new Image("res/crocAnim/crocAtk7.png");
        attackLeft[7]=new Image("res/crocAnim/crocAtk8.png");
        attackLeft[8]=new Image("res/crocAnim/crocAtk9.png");
        attackLeft[9]=new Image("res/crocAnim/crocAtk10.png");
        attackLeft[10]=new Image("res/crocAnim/crocAtk11.png");
        attackLeft[11]=new Image("res/crocAnim/crocAtk12.png");
        attackLeft[12]=new Image("res/crocAnim/crocAtk13.png");
        
        attackRight[0]=attackLeft[0].getFlippedCopy(true, false);
        attackRight[1]=attackLeft[1].getFlippedCopy(true, false);
        attackRight[2]=attackLeft[2].getFlippedCopy(true, false);
        attackRight[3]=attackLeft[3].getFlippedCopy(true, false);
        attackRight[4]=attackLeft[4].getFlippedCopy(true, false);
        attackRight[5]=attackLeft[5].getFlippedCopy(true, false);
        attackRight[6]=attackLeft[6].getFlippedCopy(true, false);
        attackRight[7]=attackLeft[7].getFlippedCopy(true, false);
        attackRight[8]=attackLeft[8].getFlippedCopy(true, false);
        attackRight[9]=attackLeft[9].getFlippedCopy(true, false);
        attackRight[10]=attackLeft[10].getFlippedCopy(true, false);
        attackRight[11]=attackLeft[11].getFlippedCopy(true, false);
        attackRight[12]=attackLeft[12].getFlippedCopy(true, false);
        
        
        movingLeft[0]=new Image("res/crocAnim/crocWalk1.png");
        movingLeft[1]=new Image("res/crocAnim/crocWalk2.png");
        movingLeft[2]=new Image("res/crocAnim/crocWalk3.png");
        movingLeft[3]=new Image("res/crocAnim/crocWalk4.png");
        movingLeft[4]=new Image("res/crocAnim/crocWalk5.png");
        movingLeft[5]=new Image("res/crocAnim/crocWalk6.png");
        movingLeft[6]=new Image("res/crocAnim/crocWalk7.png");
        movingLeft[7]=new Image("res/crocAnim/crocWalk8.png");
        movingLeft[8]=new Image("res/crocAnim/crocWalk9.png");
        movingLeft[9]=new Image("res/crocAnim/crocWalk10.png");
        movingLeft[10]=new Image("res/crocAnim/crocWalk11.png");
        movingLeft[11]=new Image("res/crocAnim/crocWalk12.png");
        movingLeft[12]=new Image("res/crocAnim/crocWalk13.png");
        
        movingRight[0]=movingLeft[0].getFlippedCopy(true, false);
        movingRight[1]=movingLeft[1].getFlippedCopy(true, false);
        movingRight[2]=movingLeft[2].getFlippedCopy(true, false);
        movingRight[3]=movingLeft[3].getFlippedCopy(true, false);
        movingRight[4]=movingLeft[4].getFlippedCopy(true, false);
        movingRight[5]=movingLeft[5].getFlippedCopy(true, false);
        movingRight[6]=movingLeft[6].getFlippedCopy(true, false);
        movingRight[7]=movingLeft[7].getFlippedCopy(true, false);
        movingRight[8]=movingLeft[8].getFlippedCopy(true, false);
        movingRight[9]=movingLeft[9].getFlippedCopy(true, false);
        movingRight[10]=movingLeft[10].getFlippedCopy(true, false);
        movingRight[11]=movingLeft[11].getFlippedCopy(true, false);
        movingRight[12]=movingLeft[12].getFlippedCopy(true, false);
        
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
            }current.draw(x-150,y);
        }
     }
    
    ////////////////////////////////////////////////////////////
    public static GameCharacter newEnemy(int posX, int posY) throws SlickException{
        return new Alligator(posX, posY);
    }

}
