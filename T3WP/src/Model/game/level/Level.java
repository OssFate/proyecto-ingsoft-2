/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game.level;

import Model.game.character.Character;

/**
 *
 * @author usuarios
 */
public class Level {
    Map map;
    Tower tower;
    Character[] c;
    Character[] enemies;
    Item[] items;
    // Time time;

    public Level() {
    }
    
    public void createEnemy(){}
    public void destroyEnemy(){}
}