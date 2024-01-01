package domain;

public class Entrada {
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
