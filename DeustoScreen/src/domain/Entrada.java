package domain;

import java.io.Serializable;

public class Entrada implements Serializable{
	private static final long serialVersionUID = 1L;
	private int numeroDeSala;
	private int numeroDeAsiento;
	
	
	public Entrada() {
		super();
	}


	public Entrada(int numeroDeSala, int numoroDeAsiento) {
		super();
		this.numeroDeSala = numeroDeSala;
		this.numeroDeAsiento = numoroDeAsiento;
	}


	public int getNumeroDeSala() {
		return numeroDeSala;
	}


	public void setNumeroDeSala(int numeroDeSala) {
		this.numeroDeSala = numeroDeSala;
	}


	public int getNumoroDeAsiento() {
		return numeroDeAsiento;
	}


	public void setNumoroDeAsiento(int numoroDeAsiento) {
		this.numeroDeAsiento = numoroDeAsiento;
	}


	@Override
	public String toString() {
		return "Entradas [numeroDeSala=" + numeroDeSala + ", numoroDeAsiento=" + numeroDeAsiento + "]";
	}
	
	
	

}
