package mypackage;

import database.Config;
import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import estilos.Utils;

public class SplashScreen extends MainScreen {
	String var = "vacio";
	Config path = new Config();
	Config statement = new Config();
    public SplashScreen() {
        super(SplashScreen.USE_ALL_HEIGHT | SplashScreen.NO_VERTICAL_SCROLL);
        setTitle((LabelField)null) ; // hide screen title

       
        BitmapField bmp = new BitmapField(Utils.getFitBitmapImage("splashscreen.png",320, 240),
        		BitmapField.FIELD_HCENTER | BitmapField.FIELD_VCENTER);  
        
        HorizontalFieldManager rowHolder = new HorizontalFieldManager(NO_HORIZONTAL_SCROLL | NO_VERTICAL_SCROLL|
                Field.FIELD_HCENTER | USE_ALL_HEIGHT );
        rowHolder.add(bmp);
        add(rowHolder);
        /*
         * Se hace el SELECT en splashscreen para poder ver si existen materias ya guardadas
         * en base de datos y elige que pantalla se va a abrir,
         * si hay datos abre materiaLista.java y si no hay nada en la base
         * lo abre login el cual utiliza el webservice para llenar la lista de materias
         *
         */
        
  	try{

  		
        	URI uri = URI.create(path.Path());
        	Database sqliteDB = DatabaseFactory.open(uri);
        	
            Statement se = sqliteDB.createStatement("SELECT nombre FROM USUARIO WHERE id_user = 1");
                se.prepare();
          		//Dialog.alert("entro");
                //c tipo Cursor que devuelve un arreglo de registros Statement se = sqliteDB.createStatement(statement.SelectUsuario());
                Cursor c = se.getCursor();
                	
                Row r;
                
                int i = 0;
                //mientras c se mueva a la siguiente fila entra e incrementa i + 1
                while(c.next()) 
                {
                    r = c.getRow();
               
                  i++;
                    }
                    sqliteDB.close();
            		//si i no incremento en nada var toma el valor de uno
                    if (i==0)
                    {
                    	var = "no";
                		
                    }
                    if (i==1)
                    {
                    	var = "si";
                		
                    }
                   
            }catch (Exception e){
            e.printStackTrace();
           // Dialog.alert("que ondas ahii "+e.getMessage());
            }

        // wait then open new screen
        
        MyApp.homeScreen = new Registro();
        MyApp.homeScreen1 = new CategoriaLista();
        UiApplication.getUiApplication().invokeLater(new Runnable() {
        	
            public void run() {
            	//si var es igual a uno dirige a homescreen1 que en este caso es login
            	if(var.equals("no")){
            	UiApplication.getUiApplication().pushScreen(MyApp.homeScreen);
                UiApplication.getUiApplication().popScreen(MyApp.splashScreen);
                //si var no trae uno entonces es porque trae datos que "la base de datos ha sido creada"
                //y apunta a materia lista.
            	}
            	if(var.equals("si")){
            	UiApplication.getUiApplication().pushScreen(MyApp.homeScreen1);
                UiApplication.getUiApplication().popScreen(MyApp.splashScreen);	
            	}
                
            }
            //tiempo de duracion del splashscreen y repeticion en falso
        }, 1500, false);
    }
}
