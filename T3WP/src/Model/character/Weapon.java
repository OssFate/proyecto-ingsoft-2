/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.character;
/**
 *
 * @author usuarios
 */
public class Weapon implements Attackable{
    private int normalDamage;
    private int specialDamage;
    private int range;
    
    public Weapon(){}

    public int getNormalDamage() { return normalDamage; }
    public int getSpecialDamage() { return specialDamage; }
    public int getRange() { return range; }
}
