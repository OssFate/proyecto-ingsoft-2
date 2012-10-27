package View;

import Controller.Main;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class mainInterface extends JFrame{

    private mainCanvas canvas;
    
    public mainInterface() throws HeadlessException {
        
        setSize(1280, 720);
        
        addCanvas();
        
        // give App a chance to do clean up before exiting
	setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        
        addWindowListener( new WindowAdapter()
	{
            /**
            * Invoked when the user attempts to close the window
            * from the window's system menu.
            */
            @Override
            public void windowClosing( WindowEvent e )
            {
                // now main knows the user wants to exit the app:
		// if the document has been modified and not saved,
		// then ask the user what to do, etc.
		Main.getInstance().exit();
            }
	} );
        
    }
    
    
    private void addCanvas()
    {
        canvas = new mainCanvas();

	add( canvas, BorderLayout.CENTER );
    }

    public void init() {
        assert canvas != null;
        
        //canvas.init();
    }
}
