package ofertas;

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

public class OfertasDescripcion extends Metodos implements FieldChangeListener {
		BitmapButtonField canjear;
		EmailAddressEditField correo;
		private BitmapButtonField btnFace;
		private BitmapButtonField btnTwit;
		private Font ffstyle;
		private Font ffstyle2;
		
	public  OfertasDescripcion (){
		
		 try
		 {
		 	FontFamily ffFont = FontFamily.forName("Arial");
		 	ffstyle = ffFont.getFont(Font.ITALIC, 18);
		 	ffstyle2 = ffFont.getFont(Font.ITALIC, 14);
		 }catch (ClassNotFoundException e){
		 	   System.out.println(e.getMessage());
		 }

		 getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.GAINSBORO, Color.SILVER,Color.WHITE,Color.GAINSBORO));
			
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
		
		
		btnFace = new BitmapButtonField(Bitmap.getBitmapResource("iconFace0.png"), Bitmap.getBitmapResource("iconFace1.png"),BitmapButtonField.FIELD_BOTTOM);
		btnFace.setChangeListener(this);
		btnFace.setMargin(0,5,0,100);
		
		btnTwit = new BitmapButtonField(Bitmap.getBitmapResource("iconTwit0.png"), Bitmap.getBitmapResource("iconTwit1.png"),BitmapButtonField.FIELD_BOTTOM);
		btnTwit.setChangeListener(this);
		btnTwit.setMargin(0,95,0,5);
		
		

		btncontent.add(btnFace);
		btncontent.add(btnTwit);
		
		RichTextField descripcion = new RichTextField("Banquete familiar de una pizza de un solo ingrediente masa gruesa y doble queso");
		descripcion.setMargin(10, 0, 10, 30);
		descripcion.setFont(ffstyle);
		
		VerticalFieldManager precioContent = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER );
		
		LabelField precioOferta = new LabelField("Precio Oferta: "+"$20.บบ");
		precioOferta.setMargin(5, 0, 5, 5);
		precioOferta.setFont(ffstyle);
		precioContent.add(precioOferta);
		
		LabelField precioRegular = new LabelField("Precio Normal: "+"$30.บบ");
		precioRegular.setMargin(5, 0, 5, 5);
		precioRegular.setFont(ffstyle2);
		precioContent.add(precioRegular);
		
		
		LabelField vencimiento = new LabelField("Vencimiento: "+ "22/09/12");
		vencimiento.setMargin(0, 0, 5, 5);
		vencimiento.setFont(ffstyle2);

		
		GridFieldManager grid = new GridFieldManager(4,1,0); 
		grid.setBackground(BackgroundFactory.createBitmapBackground(backBitmap));
		
        grid.add(descripcion);
        grid.add(precioContent,Field.FIELD_LEFT);
        grid.add(vencimiento);
        grid.add(btncontent);
        grid.setPadding(10, 0, 10, 10);    
        grid.setMargin(10, 5, 5, 5);
        grid.setRowPadding(20);
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
		openScreen(new Ofertas());
		return true;
	}
}	