/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package t3wp;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author German
 */
public class GameWindow extends JFrame {
    private GamePanel thegame;
    
    public GameWindow(){
        
        thegame = new GamePanel();
        add(thegame);
        setTitle("T3WP");
        setVisible(true);
        thegame.setVisible(true);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
    }
}
