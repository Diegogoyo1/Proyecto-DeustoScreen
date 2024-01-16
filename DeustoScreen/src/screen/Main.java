package screen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;


import java.util.logging.Logger;

import domain.BD;
import domain.Cine;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		VentanaCarga va = new VentanaCarga();
		Properties properties = new Properties();
		String nombreBD,nombreU,nombreT,nombreH,nombreP;
		try {
			properties.load(new FileReader("conf/config.properties"));
			nombreBD = properties.getProperty("nombreBD");
			nombreU = properties.getProperty("nombreFUsuarios");
			nombreT  = properties.getProperty("nombreFTrabajadores");
			nombreH = properties.getProperty("nombreFHorarios");
			nombreP = properties.getProperty("nombreFPeliculas");
		} catch (FileNotFoundException e1) {
			logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO");
			nombreBD = "Datos/deustoscreen.db";
			nombreU = "ficheros/Usuarios.csv";
			nombreT = "ficheros/Trabajadores.csv";
		    nombreH =  "ficheros/Horarios.csv";
		    nombreP = "ficheros/Peliculas.csv";
		} catch (IOException e2) {
			logger.log(Level.WARNING, "SE HA INTERRUMPIDO LA OPERACIÓN DE CARGA DEL FICHERO PROPERTIES");	
			nombreBD = "Datos/deustoscreen.db";
			nombreU = "ficheros/Usuarios.csv";
			nombreT = "ficheros/Trabajadores.csv";
		    nombreH =  "ficheros/Horarios.csv";
		    nombreP = "ficheros/Peliculas.csv";
			
		}
		
		try {
			logger.log(Level.INFO, "SE INICIA EL PROGRAMA DEUSTOSCREEN");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING, "NO SE HA PODIDO CARGAR LA VENTANA CARGA");
		}
		
		Connection con = BD.initBD(nombreBD);
		try {
			BD.borrarTabla(con);
			BD.crearTabla(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Cine.volcado_FichCSV_Usuarios_a_BD(con, nombreU);
		Cine.volcado_FichCSV_Trabajadores_a_BD(con, nombreT);
		Cine.volcado_FichCSV_Horarios_a_BD(con,nombreH);
		Cine.volcado_FichCSV_Peliculas_a_BD(con, nombreP);
		BD.cerrarBD(con);
		Cine.crearMapaPeliculas();
		 
	
	}
}