/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.character.GameCharacter;
import Model.character.Observer;
import Model.character.enemies.*;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState implements Observable{
    
    int score = 0;
    float currentSpeed = 0;
    Sound sound;
    float bgX = 0;
    float bgY = 0;
    GameCharacter gameChar;
    double health;
    float xMouse = 100;
    float yMouse = 250;
    int[] duration = {200};
    boolean quit = false;
    boolean playSound=false;
    Image bg;
    Image pause;
    Animation anim;
    
    //////////////////////////////
    ArrayList<Observer> Observers;
    boolean changed;
    ArrayList<GameCharacter> enemyList;
    
    public Play(int state) { }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        
        
        bg = new Image("res/bgFixed.jpg");
        pause = new Image("res/pause.png");
        sound = new Sound("res/1.wav");
        
        ///////////////////////////////////////
        changed = false;
        Observers = new ArrayList<Observer>();

	enemyList = new ArrayList<GameCharacter>();
	///////////////////////////////////////
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bg.draw(bgX, bgY);
        g.drawString("Score: "+score, 700, 20);
        
	for (GameCharacter b : enemyList) {
            b.draw(gc);
	}
        
        gameChar.drawHealth(g);
        gameChar.draw(gc);
        if(quit == true){
            pause.draw(200,200);
            if(quit == false){
                g.clear();
            }
        }
        //////////////////////////////////////////////
	if (changed){
            notifyObservers(g);
        }
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        
        if(!playSound){
            sound.play();
            playSound=true;
        }
                
        Input input = gc.getInput();
        gameChar.setIdle(true);
        gameChar.setAttacking(false);
        
        if(input.isKeyDown(Input.KEY_ESCAPE)) {
            quit = true;
        }
        
        if(quit == true){
            //if(input.isKeyDown(Input.KEY_DOWN) && bgY > -222 && !gameChar.getAttacking()) bgY += delta * gameChar.getSpeed();
            //if(input.isKeyDown(Input.KEY_UP) && bgY < 170 && !gameChar.getAttacking()) bgY -= delta *  gameChar.getSpeed();
            gameChar.setIdle(true);
            
            if(input.isKeyDown(Input.KEY_R)) {
                quit = false;
            }
            if(input.isKeyDown(Input.KEY_M)){
                quit = false;
                bgX = 0;
                bgY = 0;
                score = 0;
                Observers.clear();
                enemyList.clear();
                playSound = false;
                sound.stop();
                sbg.enterState(0);
            }
            if(input.isKeyDown(Input.KEY_Q)) {
                System.exit(0);
            }
        }
        
        if(!quit){
        if (input.isKeyDown(Input.KEY_Z) || input.isMouseButtonDown(0)){
            gameChar.setIdle(false);
            gameChar.setAttacking(true);
        }
        
        if(((input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) && !gameChar.getAttacking())
                && bgX < -10){
            bgX += delta *gameChar.getSpeed();
            gameChar.setFacingRight(false);
            gameChar.setIdle(false);
        }
        if((input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) && !gameChar.getAttacking())
        { 
            bgX -= delta * gameChar.getSpeed();
            if(bgX < -1616) {
                bgX = -125;
            }
            gameChar.setFacingRight(true);
            gameChar.setIdle(false);
        }
        
        if ((input.isKeyPressed(Input.KEY_Z) || input.isMousePressed(0)) && quit==false) {
                gameChar.getSound().play();
            }
        
        ///////////////////////////////////////////////////////////////
	
        //System.out.println(colision());
        if(colision()){
            setChanged(true);
        }

	if((Math.random()*250) < 1){
            enemyList.add(Rat.newEnemy(900, 360));
            enemyList.get(enemyList.size() - 1).setIdle(false);
            enemyList.get(enemyList.size() - 1).setFacingRight(false);
            addObserver(enemyList.get(enemyList.size() - 1));
	}
        if((Math.random()*250) < 1){
            enemyList.add(Rabbit.newEnemy(900, 370));
            enemyList.get(enemyList.size() - 1).setIdle(false);
            enemyList.get(enemyList.size() - 1).setFacingRight(false);
            addObserver(enemyList.get(enemyList.size() - 1));
	}
        if((Math.random()*400) < 1){
            enemyList.add(Mongoose.newEnemy(900, 360));
            enemyList.get(enemyList.size() - 1).setIdle(false);
            enemyList.get(enemyList.size() - 1).setFacingRight(false);
            addObserver(enemyList.get(enemyList.size() - 1));
	}
        if((Math.random()*400) < 1){
            enemyList.add(Pig.newEnemy(900, 320));
            enemyList.get(enemyList.size() - 1).setIdle(false);
            enemyList.get(enemyList.size() - 1).setFacingRight(false);
            addObserver(enemyList.get(enemyList.size() - 1));
	}
        if((Math.random()*1000) < 1){
            enemyList.add(Alligator.newEnemy(900, 140));
            enemyList.get(enemyList.size() - 1).setIdle(false);
            enemyList.get(enemyList.size() - 1).setFacingRight(false);
            addObserver(enemyList.get(enemyList.size() - 1));
	}
        
        for (GameCharacter b : enemyList) {
            
            if(gameChar.getIdle() || gameChar.getAttacking()) {
                currentSpeed = 0;
            }
            else{
                currentSpeed = gameChar.getSpeed();
                if(!gameChar.getFacing()) {
                    currentSpeed *= -1;
                }
            }
            b.move(delta,currentSpeed);
        }
        
        for(int i = 0; i < enemyList.size(); i++){
            if(enemyList.get(i).isDestroy()){
                Observers.remove(Observers.indexOf(enemyList.get(i)));
                enemyList.remove(i);
                score++;
            }
        }
    }
    }
    @Override
    public int getID(){ return 3; }
    
    public void setGameChar(GameCharacter g){
        gameChar=g;
        addObserver(gameChar);
    }
    
    //////////////////////////////////////////
    @Override
    public void addObserver(Observer o) {
        Observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = Observers.indexOf(o);
        if (i >= 0){
            Observers.remove(i);
        }
    }

    @Override
    public void notifyObservers(Graphics g) {
       for(int i = 0; i < Observers.size(); i++){
           Observer observer = Observers.get(i);
           observer.update(gameChar.getAttacking());
       }
       setChanged(false);
    }

    private void setChanged(boolean b) {
        this.changed = b;
    }

    
    private boolean colision() {
        for(int j = 1; j < Observers.size(); j++){
                if(Observers.get(0).getBox().colide(Observers.get(j).getBox())){
                    Observers.get(0).setColide(true);
		    Observers.get(j).setColide(true);
                    return true;
                }
                Observers.get(0).setColide(false);
		Observers.get(j).setColide(false);
            }
        
        return false;
    }
}
