package mypackage;

import java.util.Vector;

import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import estilos.BitmapButtonField;
import estilos.Metodos;

public class notaLista extends Metodos implements FieldChangeListener {
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
    public notaLista(int id_materia)
    {  
	 getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK, Color.BLACK,Color.BLACK,Color.BLACK));
	 idMateria = id_materia;
	 Bitmap elementoBitmap = Bitmap.getBitmapResource("fondomaterias.png");
	 try
	 {
	 	FontFamily ffFont = FontFamily.forName("Arial");
	 	ffecha = ffFont.getFont(Font.ANTIALIAS_DEFAULT, 13);
	 	
	 }catch (ClassNotFoundException e){
	 	   System.out.println(e.getMessage());
	 }

				tagBitmap = Bitmap.getBitmapResource(direccion);

				bb.addElement(new BitmapButtonField(Bitmap.getBitmapResource(direccion), Bitmap.getBitmapResource("barraboton2.png"), BitmapButtonField.FIELD_LEFT | BitmapButtonField.FIELD_VCENTER));
				((Field) bb.elementAt(i)).setChangeListener(this);
				((Field) bb.elementAt(i)).setMargin(0, 0, 0, 0);
				LabelField fech = new LabelField(r.getString(3)){
                    public void paint(Graphics g){      
                        g.setColor(Color.WHITE);
                        super.paint(g);
                   }};;
                   fech.setFont(ffecha);
                   fech.setMargin(0,0,0,5);
				//ASIGNA TEXTO AL EL ELEMENTO DE LISTA
				LabelField titulo = new LabelField(r.getString(0)){
                    public void paint(Graphics g){      
                        g.setColor(Color.WHITE);
                        super.paint(g);
                   }};;
                   titulo.setMargin(0,0,0,5);
				

				
				idApunte.addElement(""+r.getInteger(1));
				//CREAR ELEMENTO DE LISTA
				HorizontalFieldManager elementolista = new HorizontalFieldManager(Field.USE_ALL_WIDTH | Field.FIELD_VCENTER);
				elementolista.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,1,0,0), elementoBitmap));
				VerticalFieldManager elemento = new VerticalFieldManager(Field.USE_ALL_WIDTH | Field.FIELD_VCENTER);
				//elementolista.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,0,0,5), tagBitmap));
				//AGREGAR A PANTALLA CADA ELEMENTO		
				elementolista.setMargin(3,3,3,3);
				elementolista.add((Field)bb.elementAt(i));
				
				//elementolista.add(bfTag);
				elemento.add(titulo);
				elemento.add(fech);
				elementolista.add(elemento);
				add(elementolista);		
				

             //si el SELECT de notas no retorna nada muestra un error en pantalla
          
    	
}
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		for(int j=0;j<=bb.size()-1;j++){
			if( bb.elementAt(j)== field ){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
				transition.setIntAttribute(TransitionContext.ATTR_DURATION, 500);
				transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
				transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
				UiEngineInstance engine = Ui.getUiEngineInstance();
				engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			openScreen(new notaModificar(idMateria,(String) idApunte.elementAt(j)));
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
		openScreen(new CategoriaLista());
		return true;
	}

}
