package Domain;

import java.util.ArrayList;

public class Cine extends Peliculas{
	private String nombreCine;
	private int numeroDeSalas;
	private ArrayList<Peliculas> NumeroDePeliculas;
	
	
	public Cine() {
		super();
	}


	public Cine(String nombreCine, int numeroDeSalas, ArrayList<Peliculas> numeroDePeliculas) {
		super();
		this.nombreCine = nombreCine;
		this.numeroDeSalas = numeroDeSalas;
		NumeroDePeliculas = numeroDePeliculas;
	}


	public String getNombreCine() {
		return nombreCine;
	}


	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}


	public int getNumeroDeSalas() {
		return numeroDeSalas;
	}


	public void setNumeroDeSalas(int numeroDeSalas) {
		this.numeroDeSalas = numeroDeSalas;
	}


	public ArrayList<Peliculas> getNumeroDePeliculas() {
		return NumeroDePeliculas;
	}


	public void setNumeroDePeliculas(ArrayList<Peliculas> numeroDePeliculas) {
		NumeroDePeliculas = numeroDePeliculas;
	}


	@Override
	public String toString() {
		return "Cine [nombreCine=" + nombreCine + ", numeroDeSalas=" + numeroDeSalas + ", NumeroDePeliculas="
				+ NumeroDePeliculas + "]";
	}
	
	
	
	

}
