package domain;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JPasswordField;

public class Usuario {
	private String nombre;
	private String apellido;
	private Date FechaNacimiento;
	private String tlf;
	private String CorreoElectronico;
	private String Contrasenia;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	
	//Contructor
	
	public Usuario() {
		super();
	}
	
	
	public Usuario(String nombre, String apellido, String FechaNacimiento, String tlf,
			String correoElectronico, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		
		try {
			this.FechaNacimiento = (Date) sdf.parse(FechaNacimiento);
		} catch (ParseException e) {
			this.FechaNacimiento = new Date(0);
		}
		this.tlf = tlf;
		this.CorreoElectronico = correoElectronico;
		this.Contrasenia= contrasenia;
	}
	
	public Usuario(String nombre, String apellido, Date FechaNacimiento, String tlf,
			String correoElectronico, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.FechaNacimiento = FechaNacimiento;
		this.tlf = tlf;
		this.CorreoElectronico = correoElectronico;
		this.Contrasenia= contrasenia;
	}

	//getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFehanacimiento() {
		return FechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.FechaNacimiento = fechaNacimiento;
	}


	public  String getTlf() {
		return tlf;
	}


	public void setTlf(String tlf) {
		this.tlf = tlf;
	}


	public String getCorreoElectronico() {
		return CorreoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}
	
	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}


	// toString
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", fechanacimiento=" + FechaNacimiento + ", sdf="
				+ sdf + ", tlf=" + tlf + ", CorreoElectronico=" + CorreoElectronico + "contrasenia: " + Contrasenia+"]";
	}
	
	


}
