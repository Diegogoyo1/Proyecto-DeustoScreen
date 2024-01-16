package domain;

import java.io.Serializable;

public class Compra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1732962920848192367L;
	private Usuario usuario;
	private String hora;
	private String pelicula;
	private int sala;
	private int numEntradas;
	private String asientos;
	public Compra() {
		super();
	}
	
	public Compra(Usuario usuario, String hora, String pelicula, int sala, int numEntradas, String asientos) {
		super();
		this.usuario = usuario;
		this.hora = hora;
		this.pelicula = pelicula;
		this.sala = sala;
		this.numEntradas = numEntradas;
		this.asientos = asientos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public int getNumEntradas() {
		return numEntradas;
	}
	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}
	public String getAsientos() {
		return asientos;
	}
	public void setAsientos(String asientos) {
		this.asientos = asientos;
	}
	@Override
	public String toString() {
		return "Compra [usuario=" + usuario + ", hora=" + hora + ", pelicula=" + pelicula + ", sala=" + sala
				+ ", numEntradas=" + numEntradas + ", asientos=" + asientos + "]";
	}

	
}
