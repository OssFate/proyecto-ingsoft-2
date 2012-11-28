/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author Alex
 */
public class Create extends BasicGameState{
    File user;
    PrintWriter pw;
    int current;
    int x, y;
    Image bg;
    String nameUser = "default";
    UnicodeFont ufont;
    
    Create(int state) { }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bg = new Image("res/create.png");
        user = new File("src/res/" + nameUser + ".txt");
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bg.draw(0,0);
        g.setColor(Color.black);
        g.drawString(nameUser, 295, 275);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        x = Mouse.getX();
        y = Mouse.getY();
        
        if(!nameUser.equals("") && (input.isKeyPressed(Input.KEY_ENTER) ||
                (input.isMouseButtonDown(0)) &&
                (x > 330 && x < 530) &&(y > 45 && y < 90))){
            /*try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(user));
                pw.write(nameUser);
                pw.write("\n");
                pw.write(0);
                pw.close();
                bw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
            }*/sbg.enterState(3);
        }
        if(input.isKeyPressed(Input.KEY_ESCAPE) || input.isMouseButtonDown(0)
                && (x > 550 && x < 750) && (y > 45 && y < 90)) sbg.enterState(0);
    }
    
    public int getID() { return 2; }
    
    public void keyPressed(int key, char c){
        if(key != -1) nameUser += c;
        if(key == Input.KEY_BACK || key == Input.KEY_DELETE)
            nameUser = nameUser.substring(0, nameUser.length()-2);
    }
}
