package Domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Usuario {
	private String nombre;
	private String apellido;
	private Date fechanacimiento;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private int tlf;
	private String CorreoElectronico;
	private String Contrasenia;
	
	
	//Contructor
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String apellido, Date fehanacimiento, SimpleDateFormat sdf, int tlf,
			String correoElectronico, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.sdf = sdf;
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
		return fechanacimiento;
	}


	public void setFehanacimiento(Date fehanacimiento) {
		this.fechanacimiento = fehanacimiento;
	}


	public SimpleDateFormat getSdf() {
		return sdf;
	}


	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}


	public int getTlf() {
		return tlf;
	}


	public void setTlf(int tlf) {
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
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", fechanacimiento=" + fechanacimiento + ", sdf="
				+ sdf + ", tlf=" + tlf + ", CorreoElectronico=" + CorreoElectronico + "contrasenia: " + Contrasenia+"]";
	}
	
	


}
