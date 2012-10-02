package database;
public class Config {
	private String version = "0.0.9.sqlite";
	private String path;
	private String Createusuario;
	private String Selectusuario;
	private String Deletetableusuario;
	private String Insertusuario;
	//Direccion + la version de la base de datos
	public String Path(){
		path = "file:///SDCard/Databases/PROMO/PromoDB_"+version;
		return path;
	}
	//CREATE
	public String CreateUsuario(){
		Createusuario = "CREATE TABLE IF NOT EXISTS USUARIO(id_user INTEGER UNIQUE, nombre TEXT, apellido TEXT, correo TEXT)";
		return Createusuario;
	}
	
	public String InsertUsuario(){
		Insertusuario = "INSERT INTO USUARIO(id_user,nombre,apellido,correo)VALUES(";
		return Insertusuario;
	}
	
	public String SelectUsuario(){
		Selectusuario = "SELECT nombre FROM USUARIO WHERE id_user = 1";
		return Selectusuario;
	}
	
	public String DeleteTableUsuario(){
		Deletetableusuario = "DELETE FROM APUNTE";
		return Deletetableusuario;
	}
}
