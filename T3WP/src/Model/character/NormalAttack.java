/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.character;

/**
 *
 * @author usuarios
 */
public abstract class NormalAttack implements Attackable{
    private int enemyDamage;
    private int towerDamage;
    
    public abstract void attack();
}
