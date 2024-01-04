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
		VentanaCarga va = new VentanaCarga();
		try {
			logger.log(Level.INFO, "SE INICIA EL PROGRAMA DEUSTOSCREEN");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING, "NO SE HA PODIDO CARAGAR LA VENTANA CARGA");
		}
		
		Connection con = BD.initBD("deustoscreen.db");
		try {
			BD.crearTabla(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Cine.volcado_FichCSV_Usuarios_a_BD(con, "ficheros/Usuario.csv");
		Cine.volcado_FichCSV_Trabajadores_a_BD(con, "ficheros/Trabajadores.csv");
		
		BD.cerrarBD(con);

		
	Properties properties = new Properties();
	try {
		properties.load(new FileReader("conf/config.properties"));
		String nombreBD = properties.getProperty("nombreBD");
		String nombreAplicacion = properties.getProperty("nombreAplicacion");
		String fechaCreacion = properties.getProperty("fechaCreacion");
	} catch (FileNotFoundException e1) {
		logger.log(Level.WARNING, "NO SE HA ENCONTRADO LA RUTA DEL FICHERO");
	} catch (IOException e2) {
		logger.log(Level.WARNING, "SE HA INTERRUMPIDO LA OPERACIÓN DE CARGA DEL FICHERO PROPERTIES");	
		
	}
}
}