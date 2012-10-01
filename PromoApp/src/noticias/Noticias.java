package noticias;

import java.util.Vector;

import mypackage.AfiliadosMenu;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.decor.BackgroundFactory;
import estilos.ListStyleButtonField;
import estilos.Metodos;

public class Noticias extends Metodos implements FieldChangeListener {
	BasicEditField nota;
	EditField efTitulo;	
	int idMateria;
	Vector bb = new Vector();
	Vector Codigo = new Vector();
	String val;
	String mensaje;
	Bitmap tagBitmap;
	String direccion;

	Vector integer= new Vector();
    public Noticias()
    {  
    	setTitle("Noticias");
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.SILVER, Color.BLACK,Color.BLACK,Color.SILVER));

		Bitmap buttonRight = Bitmap.getBitmapResource( "next.png" );
		Bitmap button1left = Bitmap.getBitmapResource( "nph.png" );
		
				for(int i=0;i<=10;i++){
					String nombre = "PIZZA HUT";
					String noticia ="Cambiamos de logo";
					String fecha ="55/09/12";
				bb.addElement(new ListStyleButtonField( button1left,"\n"+nombre+"\n"+noticia+i+"\n"+fecha+"\n\n", buttonRight, 0 ));
				((Field) bb.elementAt(i)).setBackground(BackgroundFactory.createLinearGradientBackground(Color.STEELBLUE, Color.LIGHTSTEELBLUE,Color.STEELBLUE,Color.LIGHTSTEELBLUE)) ; 
				((Field) bb.elementAt(i)).setChangeListener(this);
				((Field) bb.elementAt(i)).setMargin(0, 0, 2, 0);
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
				openScreen(new NoticiasDescripcion());
				
			}
		}
	}
	
	public boolean onClose() {
		//fuerza la app a cerrar o envia a la page que se desee con tranciciones y direccion
		 TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
	        UiEngineInstance engine = Ui.getUiEngineInstance();
	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new AfiliadosMenu());
		return true;
	}

}
