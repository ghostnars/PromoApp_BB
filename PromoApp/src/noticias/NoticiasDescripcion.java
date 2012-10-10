package noticias;

import ofertas.Ofertas;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.DateField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import estilos.BitmapButtonField;
import estilos.Metodos;

public class NoticiasDescripcion extends Metodos implements FieldChangeListener {
		BitmapButtonField canjear;
		EmailAddressEditField correo;
		private BitmapButtonField btnFace;
		private BitmapButtonField btnTwit;
		private Font ffstyle;
		private Font ffstyle2;
		
	public  NoticiasDescripcion (){
		
		 try
		 {
		 	FontFamily ffFont = FontFamily.forName("Arial");
		 	ffstyle = ffFont.getFont(Font.ANTIALIAS_STANDARD, 16);
		 	ffstyle2 = ffFont.getFont(Font.ITALIC, 13);
		 }catch (ClassNotFoundException e){
		 	   System.out.println(e.getMessage());
		 }

		// getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.LIGHTSTEELBLUE, Color.LIGHTSTEELBLUE,Color.GAINSBORO,Color.GAINSBORO));
		 getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK, Color.BLACK,Color.BLACK,Color.BLACK));	
		Bitmap logoBitmap = Bitmap.getBitmapResource( "changeLogo.jpg" );
		Bitmap backBitmap = Bitmap.getBitmapResource( "dbackground.png" );
		
		HorizontalFieldManager imgPromo = new HorizontalFieldManager(HorizontalFieldManager.FIELD_LEFT );
		imgPromo.setBackground(BackgroundFactory.createBitmapBackground(logoBitmap));
		imgPromo.setPadding(66,155,66,155);
		imgPromo.setMargin(5,5,0,5);
		add(imgPromo);

		LabelField titulo = new LabelField ("Descripcion:");
		//titulo.setMargin(10, 0, 0, 20);
		//add(titulo);
		
	HorizontalFieldManager btncontent = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER );
		
		
		btnFace = new BitmapButtonField(Bitmap.getBitmapResource("iconFace0.png"), Bitmap.getBitmapResource("iconFace1.png"),BitmapButtonField.FIELD_BOTTOM);
		btnFace.setChangeListener(this);
		btnFace.setMargin(0,5,0,100);
		
		btnTwit = new BitmapButtonField(Bitmap.getBitmapResource("iconTwit0.png"), Bitmap.getBitmapResource("iconTwit1.png"),BitmapButtonField.FIELD_BOTTOM);
		btnTwit.setChangeListener(this);
		btnTwit.setMargin(0,113,0,5);
		
		

		btncontent.add(btnFace);
		btncontent.add(btnTwit);
		
		LabelField tituloNoticia = new LabelField("CAMBIAMOS DE LOGO");
		tituloNoticia.setMargin(5, 0, 5, 5);
		tituloNoticia.setFont(ffstyle);
		
		RichTextField contenido = new RichTextField("Desde ahora cambiamos de logo y ahora somos 'las mejores pizzas bajo el techo azul'");
		contenido.setMargin(10, 0, 10, 30);
		contenido.setFont(ffstyle);
	
		
		LabelField fecha = new LabelField("Fecha de publicacion: "+ "22/09/12");
		fecha.setMargin(0, 0, 5, 5);
		fecha.setFont(ffstyle2);

		
		GridFieldManager grid = new GridFieldManager(5,1,0); 
		grid.setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("numbergradeG.png"))) ; 
		grid.add(titulo);
        grid.add(tituloNoticia);
        grid.add(contenido,Field.FIELD_LEFT);
        grid.add(fecha);
        grid.add(btncontent);
        grid.setPadding(10, 0, 10, 10);    
        grid.setMargin(5, 5, 5, 5);
        grid.setRowPadding(15);
        add(grid);
		
	}
	
	

	public void fieldChanged(Field field, int context) {

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
		openScreen(new Noticias());
		return true;
	}
}	