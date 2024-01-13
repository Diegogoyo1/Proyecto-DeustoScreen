package domain;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Pelicula {
	private String id;
	private String tituloPelicula;
	private String tituloVentana;
	private String imagenCartelera;
	private String imagenPelicula;
	private String descripcion;
	private Categoria categoria;
	private String duracion;
	private String reparto;
	
	public Pelicula(String id, String tituloPelicula, String tituloVentana, String imagenCartelera, String imagenPelicula,
			String descripcion, Categoria categoria, String duracion, String reparto) {
		super();
		this.id = id;
		this.tituloPelicula = tituloPelicula;
		this.tituloVentana = tituloVentana;
		this.imagenCartelera = imagenCartelera;
		this.imagenPelicula = imagenPelicula;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.duracion = duracion;
		this.reparto = reparto;
		
		
	}
	
	public Pelicula (String tituloPelicula, String tituloVentana, String imagenCartelera, String imagenPelicula,
			String descripcion, String categoria, String duracion, String reparto) {
		super();
		this.tituloPelicula = tituloPelicula;
		this.tituloVentana = tituloVentana;
		this.imagenCartelera = imagenCartelera;
		this.imagenPelicula = imagenPelicula;
		this.descripcion = descripcion;
		this.categoria = Categoria.valueOf(categoria);
		this.duracion = duracion;
		this.reparto = reparto;
	}

	public  String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public void setTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
	}

	public String getTituloVentana() {
		return tituloVentana;
	}

	public void setTituloVentana(String tituloVentana) {
		this.tituloVentana = tituloVentana;
	}

	public String getImagenCartelera() {
		return imagenCartelera;
	}

	public void setImagenCartelera(String imagenCartelera) {
		this.imagenCartelera = imagenCartelera;
	}

	public String getImagenPelicula() {
		return imagenPelicula;
	}

	public void setImagenPelicula(String imagenPelicula) {
		this.imagenPelicula = imagenPelicula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ",tituloPelicula=" + tituloPelicula + ", tituloVentana=" + tituloVentana + ", imagenCartelera="
				+ imagenCartelera + ", imagenPelicula=" + imagenPelicula + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", duracion=" + duracion + ", reparto=" + reparto + "]";
	}
	
	
	
}