/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author German
 */
public class GamePanel extends JPanel implements Runnable {
    private static final int PW = 500;
    private static final int PH = 500;
    private Graphics dbg;
    private Image dbimage = null;
    private Image bground = new ImageIcon(getClass().getResource("bg.jpg")).getImage();
    
    private Thread animator;
    private volatile boolean running = false;
    
    private volatile boolean gameOver = false;
    
    private Font font;
    private FontMetrics metrics;
    
    private GraphicMenu menuTest = new GraphicMenu("Pending Title");
    
    //proximamente
    public GamePanel()
    {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(PW,PH));
        
        setFocusable(true);
        requestFocus();
        readyForTermination();
        
        //crear componentes del juego
        //..
        
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e)
            {testPress(e.getX(),e.getY());}

            @Override
            public void mouseReleased(MouseEvent e) {
                mRelease(e.getX(), e.getY());
            }

            
            
        });
        
        font = new Font("ComicSans", Font.BOLD, 15);
        metrics = this.getFontMetrics(font);
    }
    @Override
    public void addNotify()
    /* Espera a que el GamePanel se agregue
     a un jframe o japplet*/
    {
        super.addNotify();
        startGame();
    }
    
    private void startGame()
    //Inicializar y lanzar el thread
    {
        if(animator == null || !running)
        {
            animator = new Thread(this);
            animator.start();
        }
    }
    
    public void stopGame()
    {
        running = false;
    }
    
    public void run()
    // update, render, sleep repetidamente
    {
        running = true;
        while(running)
        {
            gameUpdate();
            gameRender();
            paintScreen();
            
            try{
                Thread.sleep(5);
            }catch(InterruptedException ex){System.out.println("Excepcion "+ ex.getMessage());}
        }System.exit(0); // cerrar el JFrame/JApplet cierra el thread
    }
    public void gameUpdate()
    {
        if(!gameOver); //update al estado del juego
    }
    public void gameRender()
    //dibuja el frame actual al buffer de imagenes
    {
        if(dbimage==null){
            dbimage = createImage(PW,PH);
            if(dbimage==null){
                System.out.println("dbimage es null");
                return;
            }
            else
                dbg = dbimage.getGraphics();
        }
        //limpiar el fondo
        dbg.setColor(Color.white);
        dbg.fillRect(0, 0, PW, PH);
        dbg.drawImage(bground, 0, 0, PW, PW, this);
        
        //Dibujar elementos
        menuTest.PrintButton(dbg);
        //..
        
        if(gameOver)
            gameOverMessage(dbg);
        
    }
    
    private void gameOverMessage(Graphics g)
    //centra el mensaje de game over
    {
        g.setColor(Color.red);
        g.setFont(font);
        String msg = "Testing Stuff";
        int x =(PW - metrics.stringWidth(msg))/2;
        int y =(PH - metrics.getHeight())/2;
        g.drawString(msg, x, y);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(dbimage != null)
            g.drawImage(dbimage, 0, 0, null);
    }
    
    private void readyForTermination(){
        addKeyListener( new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();
                if((keyCode == KeyEvent.VK_ESCAPE)||(keyCode == KeyEvent.VK_Q)||(keyCode == KeyEvent.VK_END)
                        ||(keyCode == KeyEvent.VK_C) && e.isControlDown())
                {
                    running = false;
                }
            }
        });
    }
    private void testPress(int x, int y)
    {
        //¿es (x,y) importante en el juego?
        menuTest.ButtonPressed(x, y);
    }
    private void mRelease(int x, int y){
        menuTest.buttonReleased(x, y);
    }
    
    private void paintScreen()
    //render desde el buffer de imagen hacia la pantalla
    {
        Graphics g;
        try {
            g = this.getGraphics( );  // get the panel's graphic context
            if ((g != null) && (dbimage != null))
                g.drawImage(dbimage, 0, 0, null);
            Toolkit.getDefaultToolkit( ).sync( );  // sync the display on some systems
            g.dispose( );
        }
        catch (Exception e)
            { System.out.println("Graphics context error: " + e);  }
     } // end of paintScreen( )
}