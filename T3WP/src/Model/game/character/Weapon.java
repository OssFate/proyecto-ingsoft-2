/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game.character;

/**
 *
 * @author usuarios
 */
public class Weapon implements Attackable{
    private int normalDamage;
    private int specialDamage;
    
    public Weapon(){}

    public int getNormalDamage() { return normalDamage; }
    public int getSpecialDamage() { return specialDamage; }
}
