/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.character.players;

import Model.character.GameCharacter;
import org.newdawn.slick.SlickException;

/**
 *
 * @author usuarios
 */
public class Balanced extends GameCharacter implements Controllable{
    public Balanced(double health) throws SlickException {
        super(health);
    }
}
