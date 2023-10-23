package Domain;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Peliculas extends Actores{
	private String nombrePeli;
	private ArrayList<Actores> reparto;
	private float Duracion;
	private Date fechaEstreno;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private Categoria categoria;
	
	
	public Peliculas() {
		super();
	}


	public Peliculas(String nombrePeli, ArrayList<Actores> reparto, float duracion, Date fechaEstreno,
			SimpleDateFormat sdf, Categoria categoria) {
		super();
		this.nombrePeli = nombrePeli;
		this.reparto = reparto;
		Duracion = duracion;
		this.fechaEstreno = fechaEstreno;
		this.sdf = sdf;
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


	public float getDuracion() {
		return Duracion;
	}


	public void setDuracion(float duracion) {
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
