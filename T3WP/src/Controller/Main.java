package Controller;

import View.mainInterface;

public class Main {
    
    // singleton design pattern + lazy initialization
    public synchronized static Main getInstance()
    {
	while ( m_this == null )
	{
		m_this = new Main();
	}
	return m_this;
    }

    public Main() {
        
        mInterface = new mainInterface();
        
    }
    
    public void run()
    {
	mInterface.init();
	mInterface.setTitle( "T3WP" );
	mInterface.setSize( 1280 , 720 );
	mInterface.setVisible( true );
    }
    
    public void exit()
    {
        System.exit( 0 );
    }
    
    public static void main( String[] args ){
        Main.getInstance().run();
    }

    public mainInterface getmInterface() {
        return mInterface;
    }
    
    private static Main m_this;
    
    private mainInterface mInterface;
}
