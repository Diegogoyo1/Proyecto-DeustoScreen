package domain;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Peliculas extends Actores{
	private String nombrePeli;
	private ArrayList<Actores> reparto;
	private String Duracion;
	private Date fechaEstreno;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private Categoria categoria;
	
	
	public Peliculas() {
		super();
	}

	public Peliculas(String nombrePeli, ArrayList<Actores> reparto, String duracion, String fechaEstreno, Categoria categoria) {
		super();
		this.nombrePeli = nombrePeli;
		this.reparto = reparto;
		this.Duracion = duracion;
		try {
			this.fechaEstreno = (Date) sdf.parse(fechaEstreno);
		} catch (ParseException e) {
			this. fechaEstreno= new Date(0);
		}
		this.categoria = categoria;
	}

	public Peliculas(String nombrePeli, ArrayList<Actores> reparto, String duracion, Date fechaEstreno, Categoria categoria) {
		super();
		this.nombrePeli = nombrePeli;
		this.reparto = reparto;
		Duracion = duracion;
		this.fechaEstreno = (Date) fechaEstreno;
		this.categoria = categoria;
	}


	public String getNombrePeli() {
		return nombrePeli;
	}


	public void setNombrePeli(String nombrePeli) {
		this.nombrePeli = nombrePeli;
	}


	public ArrayList<Actores> getReparto() {
		return reparto;
	}


	public void setReparto(ArrayList<Actores> reparto) {
		this.reparto = reparto;
	}


	public  String getDuracion() {
		return Duracion;
	}


	public void setDuracion(String duracion) {
		Duracion = duracion;
	}


	public Date getFechaEstreno() {
		return fechaEstreno;
	}


	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}


	public SimpleDateFormat getSdf() {
		return sdf;
	}


	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Peliculas [nombrePeli=" + nombrePeli + ", reparto=" + reparto + ", Duracion=" + Duracion
				+ ", fechaEstreno=" + fechaEstreno + ", sdf=" + sdf + ", categoria=" + categoria + "]";
	}
	
	
	
	
	
	
	
	
	

}
