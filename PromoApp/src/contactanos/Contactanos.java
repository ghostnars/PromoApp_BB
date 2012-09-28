package contactanos;

import java.util.Vector;

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
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import estilos.BitmapButtonField;
import estilos.Metodos;


public class Contactanos extends Metodos implements FieldChangeListener {
	BasicEditField nota;
	EditField efTitulo;	
	int idcategoria;
	Vector bb = new Vector();
	Vector Codigo = new Vector();
	String val;
	String mensaje;
	Bitmap tagBitmap;
	String direccion;
	Vector integer= new Vector();
	BitmapButtonField btnlogo;
	BitmapButtonField materia1,materia2,materia3,materia4,materia5,materia6,materia7;
	BitmapButtonField[] materias={materia1,materia2,materia3,materia4,materia5,materia6,materia7};
	Vector test = new Vector();
	private LabelField contact;
	private LabelField tipoContact;
	private Font ffstyle;
	private Font ffstyle2;
	private LabelField numeroTel;

public Contactanos(){
		setTitle("Contactanos");
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.GAINSBORO, Color.GAINSBORO,Color.GAINSBORO,Color.GAINSBORO));
		 try
		 {
		 	FontFamily ffFont = FontFamily.forName("Arial");
		 	ffstyle = ffFont.getFont(Font.BOLD, 16);
		 	ffstyle2 = ffFont.getFont(Font.ITALIC, 14);
		 }catch (ClassNotFoundException e){
		 	   System.out.println(e.getMessage());
		 }
		 
		 Bitmap logoBitmap = Bitmap.getBitmapResource( "ph.png" );
		 VerticalFieldManager img = new VerticalFieldManager(Field.FIELD_HCENTER);
		 img.setBackground(BackgroundFactory.createBitmapBackground(logoBitmap));
		 add(img);
		 
		 VerticalFieldManager telefono = new VerticalFieldManager(Field.USE_ALL_WIDTH);
		 telefono.setBackground(BackgroundFactory.createLinearGradientBackground(Color.SILVER, Color.SILVER,Color.SILVER,Color.SILVER));
			
			//AGREGAR A PANTALLA CADA ELEMENTO
			
		 numeroTel = new LabelField("Telefono: " + "2296-2276");
		 telefono.add(numeroTel);
		 telefono.setMargin(5, 5, 10, 5);
		 telefono.setPadding(10, 0, 10, 15);
		add(telefono);
			
		for(int i=0;i<=3;i++){
			
			  //CREAR BOTON "FLECHA" CON HOOVER PARA CADA LISTA ESTA LLEVA LA ACCION PARA PASAR SCREEN
		materias[i] = new BitmapButtonField(Bitmap.getBitmapResource("arrow0.png"), Bitmap.getBitmapResource("arrow1.png"), BitmapButtonField.FIELD_LEFT);
			
		contact = new LabelField("Facebook");
		contact.setFont(ffstyle);
		tipoContact = new LabelField("\t"+"www.facebook.com/PizzaHut");
		tipoContact.setFont(ffstyle2);

			//CREAR ELEMENTO DE LISTA
	    	//Bitmap elementoBitmap = Bitmap.getBitmapResource("fondomaterias.png");
			VerticalFieldManager elementolista = new VerticalFieldManager(Field.USE_ALL_WIDTH);
			elementolista.setBackground(BackgroundFactory.createLinearGradientBackground(Color.SILVER, Color.SILVER,Color.SILVER,Color.SILVER));
			
			//AGREGAR A PANTALLA CADA ELEMENTO
			
			elementolista.add(materias[i]);
			elementolista.add(contact);
			elementolista.add(tipoContact);
			elementolista.setMargin(0, 5, 0, 5);
			elementolista.setPadding(10, 0, 10, 15);
			add(elementolista);
			
		}
		
	}
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub

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
