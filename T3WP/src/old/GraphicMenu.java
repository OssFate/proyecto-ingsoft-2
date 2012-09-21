/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author German
 */
public class GraphicMenu {
    private static final int BUTTON_HEIGHT = 30;
    private static final int BUTTON_WIDTH = 200;
    private GraphicButton[] buttons = new GraphicButton[4];
    private String title;
    private Font font = new Font("Charlemagne STD",Font.BOLD,28);
    private FontMetrics fm;
    private static final int XCOORD = 150;
    private static final int[] YCOORD = {(500/6),(500/3),(500/2),((500*2)/3),((500*5)/6)};
    
    public GraphicMenu(String t){
        
        title = t;
        buttons[0]=GraphicButton.getButton("Iniciar Juego", XCOORD, YCOORD[1]-30, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttons[1]=GraphicButton.getButton("Cambiar Jugador", XCOORD, YCOORD[2]-30, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttons[2]=GraphicButton.getButton("Salir", XCOORD, YCOORD[4]-30, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttons[3]=GraphicButton.getButton("Opciones", XCOORD, YCOORD[3]-30, BUTTON_WIDTH, BUTTON_HEIGHT);
    }
    public void PrintButton(Graphics g){
        
        g.setFont(font);
        fm = g.getFontMetrics(font);
        g.setColor(Color.WHITE);
        int x = (500-fm.stringWidth(title))/2;
        int y = YCOORD[0]-fm.getHeight();
        g.drawString(title, x, y);
        for(int i=0;i<buttons.length;i++){
            if(!(buttons[i]==null))
                buttons[i].drawButton(g);
        }
    }
    
    public void ButtonPressed(int x, int y){
        for(int i=0; i<buttons.length;i++){
            if(buttons[i].pressed(x, y)){
                if(i==2) System.exit(0);
            }   
        }    
    }
    
    public void buttonReleased(int x, int y){
        for(int i=0;i<buttons.length;i++){
            buttons[i].released(x, y);
        }
    }
}
