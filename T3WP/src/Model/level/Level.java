/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.level;

import Model.character.GameCharacter;

/**
 *
 * @author usuarios
 */
public class Level {
    Map map;
    Tower tower;
    GameCharacter[] c;
    GameCharacter[] enemies;
    Item[] items;
    // Time time;

    public Level() {
    }
    
    public void createEnemy(){}
    public void destroyEnemy(){}
}
