/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game.character.players;
 import Model.game.character.Character;
/**
 *
 * @author usuarios
 */
public class Colossus extends Character implements Controllable{
    private boolean isUnlocked;

    public Colossus() {
    }
    
    public boolean isUnlocked() {
        return isUnlocked;
    }
    
}
