package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import estilos.BitmapButtonField;
import estilos.Metodos;

public class Registro extends Metodos implements FieldChangeListener {
		BitmapButtonField boton;
		BasicEditField nombre,apellido;
		EmailAddressEditField correo;

		
	public  Registro (){
		

		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.GAINSBORO, Color.SILVER,Color.WHITE,Color.WHITE));
		
		LabelField titulo = new LabelField ("REGISTRO");
		titulo.setMargin(20, 0, 0, 120);
        //fondo.add(titulo);
		add(titulo);
		
        HorizontalFieldManager allContent = new HorizontalFieldManager(HorizontalFieldManager.USE_ALL_WIDTH);
        VerticalFieldManager contentEtiquetas = new VerticalFieldManager(VerticalFieldManager.FIELD_RIGHT);
        VerticalFieldManager contentInput = new VerticalFieldManager(VerticalFieldManager.FIELD_LEFT);
        
        
        LabelField lblnombre = new LabelField ("Nombre:");
        lblnombre.setMargin(20, 0, 0, 28);
        
        Bitmap bordes = Bitmap.getBitmapResource("rounded-border1.png");
        VerticalFieldManager vfmNombre = new VerticalFieldManager(VerticalFieldManager.FIELD_RIGHT);
        vfmNombre.setBorder(BorderFactory.createBitmapBorder(new XYEdges(10,10,10,10), bordes));
        vfmNombre.setMargin(10, 0, 0, 0);
        nombre = new BasicEditField("", "", 50, EditField.NO_NEWLINE);
        //nombre.setFont(getFont());
        //nombre.setBackground( BackgroundFactory.createSolidTransparentBackground( Color.WHITE, 50 ) );
        
        vfmNombre.add(nombre);
        contentEtiquetas.add(lblnombre);
        contentInput.add(vfmNombre); 
        
        //---------------------apellido--------------------------
        
        LabelField lblapellido = new LabelField ("Apellido:");
        lblapellido.setMargin(30, 0, 0, 28);
        
        
        VerticalFieldManager vfmApellido = new VerticalFieldManager(VerticalFieldManager.FIELD_RIGHT);
        vfmApellido.setBorder(BorderFactory.createBitmapBorder(new XYEdges(10,10,10,10), bordes));
        vfmApellido.setMargin(10, 0, 0, 0);
        apellido = new BasicEditField("", "", 50, EditField.NO_NEWLINE);
        //nombre.setFont(getFont());
        //nombre.setBackground( BackgroundFactory.createSolidTransparentBackground( Color.WHITE, 50 ) );
        
        vfmApellido.add(apellido);
        contentEtiquetas.add(lblapellido);
        contentInput.add(vfmApellido); 
        
        //---------------------correo--------------------------
        
        LabelField lblcorreo = new LabelField ("  Correo:");
        lblcorreo.setMargin(30, 0, 0, 28);
        
        
        VerticalFieldManager vfmCorreo = new VerticalFieldManager(VerticalFieldManager.FIELD_RIGHT);
        vfmCorreo.setBorder(BorderFactory.createBitmapBorder(new XYEdges(10,10,10,10), bordes));
        vfmCorreo.setMargin(10, 0, 0, 0);
        correo = new EmailAddressEditField("", "", 50);
        //nombre.setFont(getFont());
        //nombre.setBackground( BackgroundFactory.createSolidTransparentBackground( Color.WHITE, 50 ) );
        
        vfmCorreo.add(correo);
        contentEtiquetas.add(lblcorreo);
        contentInput.add(vfmCorreo); 
        
         //---------------------acceder--------------------------
        
        boton = new BitmapButtonField(Bitmap.getBitmapResource("acceder0.png"), Bitmap.getBitmapResource("acceder1.png"),BitmapButtonField.FIELD_BOTTOM);
		boton.setChangeListener(this);
		boton.setMargin(5,0,0,0);
		contentInput.add(boton);

       contentEtiquetas.setMargin(0, 0, 0, 0);
       contentInput.setMargin(0, 0, 0, 10); 
       contentInput.setPadding(0, 30, 0, 10); 
       
       allContent.add(contentEtiquetas);
       allContent.add(contentInput); 
      
       add(allContent);


		
	}
	
	

	public void fieldChanged(Field field, int context) {
	if ( boton == field){

           
		}
	}	
} 