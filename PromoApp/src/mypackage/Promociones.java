package mypackage;

import java.util.Vector;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.decor.BackgroundFactory;
import estilos.ListStyleButtonField;
import estilos.Metodos;

public class Promociones extends Metodos implements FieldChangeListener {
	BasicEditField nota;
	EditField efTitulo;	
	Vector idApunte = new Vector();
	Vector Prioridad = new Vector();
	Config path = new Config();
	Config statement = new Config();
	int idMateria;
	Vector bb = new Vector();
	Vector Codigo = new Vector();
	String val;
	String mensaje;
	Bitmap tagBitmap;
	String direccion;
	private Font ffecha;
	Vector integer= new Vector();
    public Promociones()
    {  
    	setTitle("Promociones");
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.GAINSBORO, Color.SILVER,Color.SILVER,Color.GAINSBORO));

	 try
	 {
	 	FontFamily ffFont = FontFamily.forName("Arial");
	 	ffecha = ffFont.getFont(Font.ANTIALIAS_DEFAULT, 5);
	 	
	 }catch (ClassNotFoundException e){
	 	   System.out.println(e.getMessage());
	 }
		Bitmap buttonRight = Bitmap.getBitmapResource( "flecha.png" );
		Bitmap button1left = Bitmap.getBitmapResource( "pizza.png" );
		
				for(int i=0;i<=10;i++){
					String nombre = "PIZZA HUT";
					String promo =" pizzas gratis";
				bb.addElement(new ListStyleButtonField( button1left, "\n"+nombre+"\n"+i+promo+"\n\n", buttonRight, 0 ));
				((Field) bb.elementAt(i)).setBackground(BackgroundFactory.createLinearGradientBackground(Color.GAINSBORO, Color.WHITE,Color.WHITE,Color.GAINSBORO)) ; 
				((Field) bb.elementAt(i)).setChangeListener(this);
				((Field) bb.elementAt(i)).setMargin(0, 0, 3, 0);
				add((Field)bb.elementAt(i));
				

				}

             //si el SELECT de notas no retorna nada muestra un error en pantalla
          
    	
}
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		for(int j=0;j<=bb.size()-1;j++){
			if( bb.elementAt(j)== field ){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
				transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
				transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
				transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
				UiEngineInstance engine = Ui.getUiEngineInstance();
				engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			//openScreen(new notaModificar(idMateria,(String) idApunte.elementAt(j)));
				openScreen(new PromoDescripcion());
				
			}
		}
	}
	
	public boolean onClose() {
		//fuerza la app a cerrar o envia a la page que se desee con tranciciones y direccion
		 TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 500);
	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
	        UiEngineInstance engine = Ui.getUiEngineInstance();
	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new AfiliadosMenu());
		return true;
	}

}
