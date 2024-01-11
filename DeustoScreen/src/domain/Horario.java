package domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Horario {
	private String hora;
	private int sala;
	private String diasSemana;
	
	
	
	public Horario(String hora, int sala, String diasSemana) {
		super();
		this.hora = hora;
		this.sala = sala;
		this.diasSemana = diasSemana;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public int getSala() {
		return sala;
	}



	public void setSala(int sala) {
		this.sala = sala;
	}



	public String getDiasSemana() {
		return diasSemana;
	}



	public void setLunes(String diasSemana) {
		this.diasSemana = diasSemana;
	}



	


	@Override
	public String toString() {
		return "Horario [hora=" + hora + ", sala=" + sala + ", diasSemana=" + diasSemana + "]";
	}
	
	
	
	
}
