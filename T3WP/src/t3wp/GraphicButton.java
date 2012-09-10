/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package t3wp;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author German
 */
public class GraphicButton {
    private int height;
    private int width;
    private int x;
    private int y;
    private String buttonText;
    private Color buttonColor = Color.lightGray;
    private Color textColor = Color.BLUE;
    private Font font;
    private FontMetrics fm;
    
    private GraphicButton(String bt,int xcoord,int ycoord,int w,int h){
        x=xcoord;
        y=ycoord;
        width=w;
        height=h;
        buttonText=bt;
        font = new Font("Trajan Pro", Font.BOLD, 14);
    }
    
    public static GraphicButton getButton(String bt,int xcoord,int ycoord,int w,int h){
        return new GraphicButton(bt,xcoord,ycoord,w,h);
    }
    
    public void drawButton(Graphics g){
        
        g.setFont(font);
        fm = g.getFontMetrics(font);
        int xcoord = (x+(width/2))-(fm.stringWidth(buttonText)/2);
        int ycoord = (y+(height-2))-(fm.getHeight()/2);
        g.setColor(buttonColor);
        g.fillOval(x, y, width, height);
        //g.fillRect(x, y, width, height);
        g.setColor(textColor);
        g.drawOval(x, y, width, height);
        g.drawOval(x, y, width-1, height-1);
        //g.drawRect(x, y, width, height);
        g.drawString(buttonText, xcoord, ycoord);
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public boolean pressed(int xcoord, int ycoord){
        if(pointInButton(xcoord,ycoord)){
            buttonColor = Color.white;
            textColor = Color.BLACK;
            return true;
        }
        return false;
    }
    
    public void released(int xcoord, int ycoord){
        if(pointInButton(xcoord,ycoord)){
            buttonColor = Color.lightGray;
            textColor = Color.BLUE;
        }
    }
    
    public boolean pointInButton(int xcoord, int ycoord){
        if(xcoord >= x && xcoord <= x+width && ycoord >= y && ycoord <= y+height) return true;
        return false;
    }
    
    /*public void passed(int xcoord, int ycoord){
        if (xcoord >= x && xcoord <= x+width && ycoord >= y && ycoord <= y+height){
            buttonColor = Color.CYAN;
            textColor = Color.BLACK;
        }
        else{
            buttonColor = Color.GRAY;
            textColor = Color.WHITE;
        }
    }*/
    
}
