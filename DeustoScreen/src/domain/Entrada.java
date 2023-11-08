package domain;

public class Entrada {
	private int numeroDeSala;
	private int numoroDeAsiento;
	
	
	public Entrada() {
		super();
	}


	public Entrada(int numeroDeSala, int numoroDeAsiento) {
		super();
		this.numeroDeSala = numeroDeSala;
		this.numoroDeAsiento = numoroDeAsiento;
	}


	public int getNumeroDeSala() {
		return numeroDeSala;
	}


	public void setNumeroDeSala(int numeroDeSala) {
		this.numeroDeSala = numeroDeSala;
	}


	public int getNumoroDeAsiento() {
		return numoroDeAsiento;
	}


	public void setNumoroDeAsiento(int numoroDeAsiento) {
		this.numoroDeAsiento = numoroDeAsiento;
	}


	@Override
	public String toString() {
		return "Entradas [numeroDeSala=" + numeroDeSala + ", numoroDeAsiento=" + numoroDeAsiento + "]";
	}
	
	
	

}
