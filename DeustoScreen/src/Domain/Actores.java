package Domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Actores {
	private String nombreActor;
	private Date fechaNacimientoAct;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public Actores() {
		super();
	}

	public Actores(String nombreActor, Date fechaNacimientoAct, SimpleDateFormat sdf) {
		super();
		this.nombreActor = nombreActor;
		this.fechaNacimientoAct = fechaNacimientoAct;
		this.sdf = sdf;
	}

	public String getNombreActor() {
		return nombreActor;
	}

	public void setNombreActor(String nombreActor) {
		this.nombreActor = nombreActor;
	}

	public Date getFechaNacimientoAct() {
		return fechaNacimientoAct;
	}

	public void setFechaNacimientoAct(Date fechaNacimientoAct) {
		this.fechaNacimientoAct = fechaNacimientoAct;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	@Override
	public String toString() {
		return "Actores [nombreActor=" + nombreActor + ", fechaNacimientoAct=" + fechaNacimientoAct + ", sdf=" + sdf
				+ "]";
	}
	
	
	
	
	

	

}
