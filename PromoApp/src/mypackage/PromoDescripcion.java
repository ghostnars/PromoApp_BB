package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;

import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import estilos.BitmapButtonField;
import estilos.ListStyleButtonField;
import estilos.Metodos;

public class PromoDescripcion extends Metodos implements FieldChangeListener {
		BitmapButtonField boton;
		BasicEditField nombre,apellido;
		EmailAddressEditField correo;
		LabelField asd;
		
	public  PromoDescripcion (){
		

		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.GAINSBORO, Color.SILVER,Color.WHITE,Color.WHITE));
		
		Bitmap logoBitmap = Bitmap.getBitmapResource( "imgPromo.jpg" );
		
		HorizontalFieldManager imgPromo = new HorizontalFieldManager(HorizontalFieldManager.FIELD_LEFT );
		imgPromo.setBackground(BackgroundFactory.createBitmapBackground(logoBitmap));
		imgPromo.setPadding(66,155,66,155);
		imgPromo.setMargin(5,5,7,5);
		add(imgPromo);
		
		
		
		
		
		LabelField titulo = new LabelField ("REGISTRO");
		titulo.setMargin(20, 0, 0, 120);
		add(titulo);
		

		
	}
	
	

	public void fieldChanged(Field field, int context) {
	if ( boton == field){
		TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
		transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
		transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
		transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
		UiEngineInstance engine = Ui.getUiEngineInstance();
		engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new PromoDescripcion());
           
		}
	}	
} 