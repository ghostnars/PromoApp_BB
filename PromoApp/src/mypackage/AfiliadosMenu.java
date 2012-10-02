package mypackage;

import contactanos.Contactanos;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.DateField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import ofertas.Ofertas;
import noticias.Noticias;
import promociones.Promociones;
import estilos.BitmapButtonField;
import estilos.Metodos;

/** try
{
	FontFamily ffFont = FontFamily.forName("Comic Sans MS");
	ffecha = ffFont.getFont(Font.ITALIC, 13);
	fmateria = ffFont.getFont(Font.ANTIALIAS_DEFAULT, 15);
	ftitulo = ffFont.getFont(Font.ITALIC, 16); 
	fapunte = ffFont.getFont(Font.ANTIALIAS_DEFAULT, 17); 
}catch (ClassNotFoundException e){
	   System.out.println(e.getMessage());
}*/

public class AfiliadosMenu extends Metodos implements FieldChangeListener {
	BasicEditField nota;
	EditField efTitulo,efNota;	
	ObjectChoiceField ocfPrioridad;
	String choices[] = {"Alta","Media","Baja"};
	String valorinteger;
	int idMateria;
	DateField fecha;
	LabelField materia;
	private Font ffecha;
	private BitmapButtonField boton;
	private BitmapButtonField btnOfertas;
	private BitmapButtonField btnNoticias;
	private BitmapButtonField btnContact;
	private BitmapButtonField btnPromo;
    public AfiliadosMenu()
    {
    	getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.LIGHTSTEELBLUE, Color.LIGHTSTEELBLUE,Color.GAINSBORO,Color.GAINSBORO));
		
   	 try
   	 {
   	 	FontFamily ffFont = FontFamily.forName("Arial");
   	 	ffecha = ffFont.getFont(Font.ANTIALIAS_DEFAULT, 14);
   	 	
   	 }catch (ClassNotFoundException e){
   	 	   System.out.println(e.getMessage());
   	 }
    	
    	
    	
    	//valorinteger = integer;
    	//setTitle(integer);
    	Bitmap headBitmap = Bitmap.getBitmapResource( "fondomaterias.png" );
    	Bitmap logoBitmap = Bitmap.getBitmapResource( "ph.png" );
    	//Bitmap botonBitmap = Bitmap.getBitmapResource( "fondoboton.png" );
	VerticalFieldManager allContent = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | VerticalFieldManager.USE_ALL_WIDTH);
	
	LabelField nombre = new LabelField("PIZZA HUT",Field.FIELD_LEFT|LabelField.TRUNCATE_BEGINNING){
        public void paint(Graphics g){      
            g.setColor(Color.WHITE);
            super.paint(g);
       }};
	LabelField slogan = new LabelField("Las mejores pizzas bajo el techo rojo",Field.FIELD_LEFT){
        public void paint(Graphics g){      
            g.setColor(Color.WHITE);
            super.paint(g);
       }};
	LabelField local = new LabelField("Local numero 30",Field.FIELD_LEFT){
        public void paint(Graphics g){      
            g.setColor(Color.WHITE);
            super.paint(g);
       }};
	
	nombre.setMargin(6,0,3,10);
	slogan.setMargin(0,0,3,10);
	slogan.setFont(ffecha);
	local.setMargin(0,0,3,10);
	
	HorizontalFieldManager head = new HorizontalFieldManager(HorizontalFieldManager.FIELD_LEFT | HorizontalFieldManager.USE_ALL_WIDTH );
	head.setBackground(BackgroundFactory.createLinearGradientBackground(Color.STEELBLUE, Color.STEELBLUE,Color.LIGHTSTEELBLUE,Color.LIGHTSTEELBLUE));

	HorizontalFieldManager logo = new HorizontalFieldManager(HorizontalFieldManager.FIELD_LEFT );
	logo.setBackground(BackgroundFactory.createBitmapBackground(logoBitmap));
	logo.setPadding(30,30,30,30);
	logo.setMargin(5,5,7,5);
	
	VerticalFieldManager content = new VerticalFieldManager(VerticalFieldManager.FIELD_LEFT );
	content.add(nombre);
	content.add(slogan);
	content.add(local);

	head.add(logo);
	head.add(content);
	

	add(head);
	
	HorizontalFieldManager btnContentArriba = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER | VerticalFieldManager.USE_ALL_WIDTH);
	
	btnPromo = new BitmapButtonField(Bitmap.getBitmapResource("promo0.png"), Bitmap.getBitmapResource("promo1.png"),BitmapButtonField.FIELD_BOTTOM);
	btnPromo.setChangeListener(this);
	btnPromo.setMargin(23,5,5,8);
	btnContentArriba.add(btnPromo);
	
	btnOfertas = new BitmapButtonField(Bitmap.getBitmapResource("oferta0.png"), Bitmap.getBitmapResource("oferta1.png"),BitmapButtonField.FIELD_BOTTOM);
	btnOfertas.setChangeListener(this);
	btnOfertas.setMargin(23,5,5,5);
	btnContentArriba.add(btnOfertas);
	
	//----------------------------
	
	HorizontalFieldManager btnContentAbajo = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER | VerticalFieldManager.USE_ALL_WIDTH);
	
	btnNoticias = new BitmapButtonField(Bitmap.getBitmapResource("noticia0.png"), Bitmap.getBitmapResource("noticia1.png"),BitmapButtonField.FIELD_BOTTOM);
	btnNoticias.setChangeListener(this);
	btnNoticias.setMargin(0,5,5,8);
	btnContentAbajo.add(btnNoticias);
	
	btnContact = new BitmapButtonField(Bitmap.getBitmapResource("contac0.png"), Bitmap.getBitmapResource("contac1.png"),BitmapButtonField.FIELD_BOTTOM);
	btnContact.setChangeListener(this);
	btnContact.setMargin(0,5,5,5);
	btnContentAbajo.add(btnContact);
	allContent.add(btnContentArriba);
	allContent.add(btnContentAbajo);	
	add(allContent);

		
    }

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub	

		if(btnPromo== field){
			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
			transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			UiEngineInstance engine = Ui.getUiEngineInstance();
			engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			openScreen(new Promociones());
		}	
		else if(btnOfertas== field){
			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
			transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			UiEngineInstance engine = Ui.getUiEngineInstance();
			engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			openScreen(new Ofertas());
		}	
		else if(btnNoticias== field){
			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
			transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			UiEngineInstance engine = Ui.getUiEngineInstance();
			engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			openScreen(new Noticias());
		}
		else if(btnContact== field){
			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
			transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			UiEngineInstance engine = Ui.getUiEngineInstance();
			engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			openScreen(new Contactanos());
		}
		
		
	}
	public boolean onClose() {
		//force the app to quit
		 TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 200);
	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
	        UiEngineInstance engine = Ui.getUiEngineInstance();
	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new AfiliadosLista());
		return true;
	}

}

