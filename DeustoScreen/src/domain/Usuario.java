package domain;

import java.util.Objects;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario implements Comparable<Usuario> {
	private String nombre;
	private String apellido;
	private LocalDate FechaNacimiento;
	private String tlf;
	private String CorreoElectronico;
	private String Contrasenia;
	private String ContadorPuntos;
	@SuppressWarnings("unused")
	private static final String nomfichUsuarios = "src/ficheros/Usuarios.csv";

	//private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	// Contructor

	public Usuario(String nombre, String apellido, String FechaNacimiento, String tlf, String correoElectronico,
			String contrasenia, String ContadorPuntos)  {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.FechaNacimiento = LocalDate.parse(FechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		this.tlf = tlf;
		this.CorreoElectronico = correoElectronico;
		this.Contrasenia = contrasenia;
		this.ContadorPuntos = ContadorPuntos;

	}
	
	

	/*public Usuario() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.FechaNacimiento = new Date(0);

		this.tlf = "";
		this.CorreoElectronico = "";
		this.Contrasenia = "";
		this.ContadorPuntos = "";
	}*/

	/*public Usuario() {
		super();
		
	}*/

	

	// getters y setters
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

	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}

	public String getFechaNacimientoStr() {
		return FechaNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.FechaNacimiento = fechaNacimiento;
	}

	public String getTlf() {
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

	public String getContadorPuntos() {
		return ContadorPuntos;
	}

	public void setContadorPuntos(String contadorPuntos) {
		ContadorPuntos = contadorPuntos;
	}

	public void actualizarPuntos(String puntos){
		int p = Integer.parseInt(ContadorPuntos) + Integer.parseInt(puntos);
		ContadorPuntos = String.valueOf(p);
	}

	// toString
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", fechanacimiento=" + getFechaNacimientoStr()
				+ ", tlf=" + tlf + ", correoElectronico=" + CorreoElectronico + ", contraseña: " + Contrasenia
				+ ", Puntos:" + ContadorPuntos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CorreoElectronico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(CorreoElectronico, other.CorreoElectronico);
	}

	@Override
	public int compareTo(Usuario o) {
		return this.CorreoElectronico.compareTo(o.CorreoElectronico);
	}

}
