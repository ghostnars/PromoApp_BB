package mypackage;


import java.util.Vector;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.decor.BackgroundFactory;
import estilos.BitmapButtonField;
import estilos.ListStyleButtonField;
import estilos.Metodos;

public class CategoriaLista extends Metodos{

		BitmapButtonField bts1 , bts2 , bts3 , bts4,bts5;
		ListStyleButtonField materia1,materia2,materia3,materia4,materia5,materia6,materia7;
		ListStyleButtonField[] materias={materia1,materia2,materia3,materia4,materia5,materia6,materia7};
		Vector test = new Vector();

	
	public CategoriaLista(){
			setTitle("Categorias");
			getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.GAINSBORO, Color.SILVER,Color.SILVER,Color.GAINSBORO));
	
			Bitmap buttonRight = Bitmap.getBitmapResource( "flecha.png" );
			Bitmap button1left = Bitmap.getBitmapResource( "pizza.png" );
    		for(int i=0;i<=6;i++){
    			materias[i]= new ListStyleButtonField( button1left, "\t\nRestaurantes\n\n", buttonRight, 0 );
    			materias[i].setBackground(BackgroundFactory.createLinearGradientBackground(Color.GAINSBORO, Color.WHITE,Color.WHITE,Color.GAINSBORO)) ; 
    			materias[i].setMargin(0, 0, 3, 0);
    			materias[i].setChangeListener(this);
    			add(materias[i]);
    		}
			
		}
	 
	public void fieldChanged(Field field, int context) {
	
			if(materias[0]== field){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
				transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
				transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
				transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
				UiEngineInstance engine = Ui.getUiEngineInstance();
				engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
				openScreen(new AfiliadosLista());
			}	
			else if(materias[1]== field){
				Dialog.alert("boton 2");
			}	
			else if(materias[2]== field){
				Dialog.alert("boton 3");
			}
			else if(materias[3]== field){
				Dialog.alert("boton 4");
			}
			else if(materias[4]== field){
				Dialog.alert("boton 5");
			}	
			else if(materias[5]== field){
				Dialog.alert("boton 6");
			}	
			else if(materias[6]== field){
				Dialog.alert("boton 7");
			}
			
		}
	 

}