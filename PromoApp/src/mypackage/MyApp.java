package mypackage;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;

/**
 * This class extends the UiApplication class, providing a
 * graphical user interface.
 */
public class MyApp extends UiApplication
{
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
	//Instancias de Config,java Clase que contiene los parametros SQL y la version de la base de datos

	static MainScreen splashScreen = null, homeScreen = null, homeScreen1 = null;
	static int	g_nScreenWidth = 0, g_nScreenHeight = 0;
	
	
    public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        MyApp theApp = new MyApp();       
        theApp.enterEventDispatcher(); 
    }
    /**
     * Creates a new MyApp object
     */
    public MyApp()
    {               
    	
    //Al iniciar la aplicacion comienza creando la base de datos y las tablas

    	
    	g_nScreenWidth =  Display.getHeight();
        g_nScreenHeight = Display.getWidth();
        // Push a screen onto the UI stack for rendering.
        splashScreen = new SplashScreen();
        pushScreen( splashScreen );
        // Push a screen onto the UI stack for rendering.
    }    
}
