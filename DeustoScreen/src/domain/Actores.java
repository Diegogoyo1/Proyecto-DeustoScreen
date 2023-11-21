package domain;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Actores {
	private String nombreActor;
	private Date fechaNacimientoAct;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public Actores() {
		super();
	}
	
	public Actores(String nombreActor, String fechaNacimientoAct) {
		super();
		this.nombreActor = nombreActor;
		try {
			this.fechaNacimientoAct = sdf.parse(fechaNacimientoAct);
		} catch (ParseException e) {
			this. fechaNacimientoAct= new Date(0);
		}
	}

	
	public Actores(String nombreActor, Date fechaNacimientoAct) {
		super();
		this.nombreActor = nombreActor;
		this.fechaNacimientoAct = fechaNacimientoAct;
	}

	

	public String getNombreActor() {
		return nombreActor;
	}

	public void setNombreActor(String nombreActor) {
		this.nombreActor = nombreActor;
	}

	public Date getFechaNacimientoAct() {
		return (Date) fechaNacimientoAct;
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
		return "Actores [nombreActor=" + nombreActor + ", fechaNacimientoAct=" + fechaNacimientoAct 
				+ "]";
	}
	
	
	
	
	

	

}
