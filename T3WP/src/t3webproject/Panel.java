/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package t3webproject;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class Panel extends JPanel {
    private Image imagen;
    public Panel(){ imagen=null; }
    public Panel(String nombreimagen) {
        if(nombreimagen!=null) 
            imagen=new ImageIcon(getClass().getResource(nombreimagen)).getImage();
    }
    public Panel(Image img){
        if(img!=null) imagen=img;
    }

    public void setImage(String nombreimagen) {
        if(nombreimagen!=null)
            imagen=new ImageIcon(getClass().getResource(nombreimagen)).getImage();
        else imagen=null;
        repaint();
    }
    public void setImage(Image nuevaimagen){
        if(nuevaimagen!=null) imagen=nuevaimagen;
        else imagen=null;
        repaint();
    }

    @Override
    public void paint(Graphics g){
        if(imagen!=null){
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        }
        else setOpaque(true);
        super.paint(g);
    }
}
