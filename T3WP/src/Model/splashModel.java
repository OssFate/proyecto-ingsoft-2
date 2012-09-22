package Model;

import Controller.Main;
import com.jpackages.jflashplayer.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class splashModel {

FlashPanel splash;
    
    public splashModel() {
        
        //Creating the FlashPanel with the splash flash file
        try {
            splash = new FlashPanel(new File("./Resources/login.swf"));
        } catch (JFlashLibraryLoadFailedException ex) {
            Logger.getLogger(splashModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JFlashInvalidFlashException ex) {
            Logger.getLogger(splashModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(splashModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized static splashModel getInstance()
    {
	while ( m_this == null )
	{
		m_this = new splashModel();
	}
	return m_this;
    }
    
    private static splashModel m_this;
    
}
