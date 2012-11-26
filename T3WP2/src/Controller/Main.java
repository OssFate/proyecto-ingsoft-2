/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Game;
import org.newdawn.slick.*;

public class Main {
     public static void main(String[] args){
        AppGameContainer appgc;
        try{
            appgc = new AppGameContainer(new Game("( ͡° ͜ʖ ͡°)"));
            appgc.setDisplayMode(800, 600, false);
            appgc.setVSync(true);
            appgc.setShowFPS(false);
            appgc.start();
        } catch(SlickException e){
        }
    }
}
