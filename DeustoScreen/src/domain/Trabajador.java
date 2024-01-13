package domain;

public class Trabajador {
	private String dni;
	private String nombreApellidosTrabajador;
	private String telefonoTrabajador;
	private String contraseniaTrabajador;
	private PuestoTrabajo puesto;
	private double sueldo;
	
	
	
	public Trabajador(String dni, String nombreApellidosTrabajador,String telefonoTrabajador, String contraseniaTrabajador, PuestoTrabajo puesto, double sueldo) {
		super();
		this.dni = dni;
		this.nombreApellidosTrabajador = nombreApellidosTrabajador;
		this.telefonoTrabajador = telefonoTrabajador;
		this.contraseniaTrabajador = contraseniaTrabajador;
		this.puesto = puesto;
		this.sueldo = sueldo;
	}
	
	public double getSueldo() {
	return sueldo;
	}

	public void setSueldo(double sueldo) {
	this.sueldo = sueldo;
	}

	public PuestoTrabajo getPuesto() {
	return puesto;
	}

	public void setPuesto(PuestoTrabajo puesto) {
	this.puesto = puesto;
	}
	public String getNombreApellidosTrabajador() {
		return nombreApellidosTrabajador;
	}

	public void setNombreApellidosTrabajador(String nombreTrabajador) {
		this.nombreApellidosTrabajador = nombreTrabajador;
	}
	
	public String getTelefonoTrabajador() {
		return telefonoTrabajador;
	}
	
	public void setTelefonoTrabajador(String telefonoTrabajador) {
		this.telefonoTrabajador = telefonoTrabajador;
	}

	public String getContraseniaTrabajador() {
		return contraseniaTrabajador;
	}

	public void setContraseniaTrabajador(String contraseniaTrabajador) {
		this.contraseniaTrabajador = contraseniaTrabajador;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Trabajador [dni=" + dni + ", nombreApellidos=" + nombreApellidosTrabajador + ", telefono="+ telefonoTrabajador +", contrasenia="
				+ contraseniaTrabajador + ", puesto=" + puesto + ", sueldo=" + sueldo + "]";
	}
}
