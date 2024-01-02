package domain;

public class Trabajador {
	private double horasTrabajadas;
	private double sueldo;
	private String nombreApellidosTrabajador;
	private String telefonoTrabajador;
	private String contraseniaTrabajador;
	private String dni;
	private PuestoTrabajo puesto;
	
	
	public Trabajador(double horasTrabajadas, double sueldo, String nombreApellidosTrabajador,String telefonoTrabajador, String contraseniaTrabajador,
			String dni, PuestoTrabajo puesto) {
		super();
		this.horasTrabajadas = horasTrabajadas;
		this.sueldo = sueldo;
		this.nombreApellidosTrabajador = nombreApellidosTrabajador;
		this.telefonoTrabajador = telefonoTrabajador;
		this.contraseniaTrabajador = contraseniaTrabajador;
		this.dni = dni;
		this.puesto = puesto;
	}
	
	public Trabajador (String nombreApellidos, String telefonoTrabajador, PuestoTrabajo puesto, String dni) {
		this.nombreApellidosTrabajador = nombreApellidos;
		this.telefonoTrabajador = telefonoTrabajador;
		this.puesto = puesto;
		this.dni = dni;
	}
	
	public Trabajador() {
		super();
		this.horasTrabajadas = 0;
		this.sueldo = 0;
		this.nombreApellidosTrabajador = null;
		this.contraseniaTrabajador = null;
		this.dni = null;
	}
	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
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
		return "Trabajador [horasTrabajadas=" + horasTrabajadas + ", sueldo=" + sueldo + ", nombreTrabajador=" + nombreApellidosTrabajador + ", telefonoTrabajador="+ telefonoTrabajador +", contraseñaTrabajador="
				+ contraseniaTrabajador + ", dni=" + dni + ", puesto=" + puesto + "]";
	}
}
