package promociones;

import mypackage.AfiliadosMenu;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import estilos.BitmapButtonField;
import estilos.Metodos;

public class PromoDescripcion extends Metodos implements FieldChangeListener {
		BitmapButtonField canjear;
		EmailAddressEditField correo;
		private BitmapButtonField btnFace;
		private BitmapButtonField btnTwit;
		private Font ffstyle;
		private BitmapButtonField btnCanjear;
		
	public  PromoDescripcion (){
		
		 try
		 {
		 	FontFamily ffFont = FontFamily.forName("Arial");
		 	ffstyle = ffFont.getFont(Font.ANTIALIAS_DEFAULT, 15);
		 	
		 }catch (ClassNotFoundException e){
		 	   System.out.println(e.getMessage());
		 }

		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.LIGHTSTEELBLUE, Color.LIGHTSTEELBLUE,Color.GAINSBORO,Color.GAINSBORO));
		
		Bitmap logoBitmap = Bitmap.getBitmapResource( "imgPromo.jpg" );
		Bitmap backBitmap = Bitmap.getBitmapResource( "dbackground.png" );
		
		HorizontalFieldManager imgPromo = new HorizontalFieldManager(HorizontalFieldManager.FIELD_LEFT );
		imgPromo.setBackground(BackgroundFactory.createBitmapBackground(logoBitmap));
		imgPromo.setPadding(66,155,66,155);
		imgPromo.setMargin(5,5,7,5);
		add(imgPromo);

		LabelField titulo = new LabelField ("Descripcion:");
		titulo.setMargin(10, 0, 0, 20);
		add(titulo);
		
		HorizontalFieldManager btncontent = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER );
		
		btnCanjear = new BitmapButtonField(Bitmap.getBitmapResource("canjear1.png"), Bitmap.getBitmapResource("canjear0.png"),BitmapButtonField.FIELD_BOTTOM);
		btnCanjear.setChangeListener(this);
		btnCanjear.setMargin(0,5,0,40);
		
		btnFace = new BitmapButtonField(Bitmap.getBitmapResource("iconFace0.png"), Bitmap.getBitmapResource("iconFace1.png"),BitmapButtonField.FIELD_BOTTOM);
		btnFace.setChangeListener(this);
		btnFace.setMargin(0,5,0,5);
		
		btnTwit = new BitmapButtonField(Bitmap.getBitmapResource("iconTwit0.png"), Bitmap.getBitmapResource("iconTwit1.png"),BitmapButtonField.FIELD_BOTTOM);
		btnTwit.setChangeListener(this);
		btnTwit.setMargin(0,5,0,5);
		
		
		btncontent.add(btnCanjear);
		btncontent.add(btnFace);
		btncontent.add(btnTwit);
		
		RichTextField descripcion = new RichTextField("Dos piezas al presentar y utiliar este cupon tiene derecho a canjear");
		descripcion.setMargin(10, 0, 10, 30);
		
		LabelField disponibilidad = new LabelField("Promociones disponibles:  2", Field.FIELD_LEFT);
		disponibilidad.setFont(ffstyle);
		
		GridFieldManager grid = new GridFieldManager(3,1,0); 
		grid.setBackground(BackgroundFactory.createLinearGradientBackground(Color.LIGHTSTEELBLUE, Color.LIGHTSTEELBLUE,Color.GAINSBORO,Color.GAINSBORO));
		
        grid.add(descripcion);
        grid.add(btncontent);
        grid.add(disponibilidad, Field.FIELD_LEFT);
        grid.setPadding(10, 0, 10, 10);    
        grid.setMargin(10, 5, 5, 5);
        grid.setRowPadding(20);
        add(grid);
		
	}
	
	

	public void fieldChanged(Field field, int context) {
	if ( btnCanjear == field){
	/*TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
		transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
		transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
		transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
		UiEngineInstance engine = Ui.getUiEngineInstance();
		engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new Promociones());*/
			Dialog.alert("canjeado exitosamente");
           
		}
	if ( btnFace == field){
	/*TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
		transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
		transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
		transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
		UiEngineInstance engine = Ui.getUiEngineInstance();
		engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new Promociones());*/
			Dialog.alert("Compartir");
           
		}
	if ( btnTwit == field){
	/*TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
		transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
		transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
		transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
		UiEngineInstance engine = Ui.getUiEngineInstance();
		engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new Promociones());*/
			Dialog.alert("Twittear");
           
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
		openScreen(new Promociones());
		return true;
	}
} 