/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game.character;

/**
 *
 * @author usuarios
 */
public class Character {
    private int life;
    private boolean isEnemy;
    // ImageIcon sprite;
    private Weapon[] weapons;
    
    public Character(){}

    public int getLife() { return life; }
    public Weapon[] getWeapons() { return weapons; }
    public boolean isEnemy() { return isEnemy; }
}
