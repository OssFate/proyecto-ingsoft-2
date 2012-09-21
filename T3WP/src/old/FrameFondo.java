/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class FrameFondo extends JFrame{
    private final Panel p = new Panel();
    public FrameFondo(){ 
        super("t3wp");
        setContentPane(p);
    }
    public void setImage(String nombreimagen){ p.setImage(nombreimagen); }
    public void setImage(Image imagennueva){ p.setImage(imagennueva); }
}
