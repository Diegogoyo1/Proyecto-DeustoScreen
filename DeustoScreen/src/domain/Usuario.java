package domain;

import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JPasswordField;

public class Usuario {
	private String nombre;
	private String apellido;
	private Date FechaNacimiento;
	private String tlf;
	private static String CorreoElectronico;
	private static String Contrasenia;
	private static String ContadorPuntos;
	private static final String nomfichUsuarios = "src/ficheros/Usuarios.csv";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	
	//Contructor
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String apellido, Date FechaNacimiento, String tlf,
			String correoElectronico, String contrasenia, String ContadorPuntos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.FechaNacimiento = FechaNacimiento;
		this.tlf = tlf;
		this.CorreoElectronico = correoElectronico;
		this.Contrasenia= contrasenia;
		this.ContadorPuntos = ContadorPuntos;
	}
	
	public Usuario(String nombre, String apellido, String FechaNacimiento, String tlf,
			String correoElectronico, String contrasenia, String ContadorPuntos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		try {
			this.FechaNacimiento = sdf.parse(FechaNacimiento);
		} catch (ParseException e) {
			this.FechaNacimiento = new Date(0);
		}
		
		
		this.tlf = tlf;
		this.CorreoElectronico = correoElectronico;
		this.Contrasenia= contrasenia;
		this.ContadorPuntos = ContadorPuntos;
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


	public Date getFechanacimiento() {
		return FechaNacimiento;
	}
	public String getFechaNacimientoStr() {
		return sdf.format(FechaNacimiento);
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

	public static String getCorreoElectronico() {
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
	
	public static void cargarPuntosDeFichero(String nomfich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomfich));
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String [] partes = linea.split(";");
				ContadorPuntos = partes[6];
				}
				sc.close();
			}catch (FileNotFoundException e) {
			 
		 }

	}
	
	public static  String getContadorPuntos() {
		return ContadorPuntos;
	}

	public static void setContadorPuntos(String contadorPuntos) {
		ContadorPuntos = contadorPuntos;
	}

	
	
	
	
	
	
	// toString
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", fechanacimiento=" + FechaNacimiento + ", sdf="
				+ sdf + ", tlf=" + tlf + ", CorreoElectronico=" + CorreoElectronico + "contrasenia: " + Contrasenia+ "Puntos:"+ ContadorPuntos+ "]";
	}
	
	


}
