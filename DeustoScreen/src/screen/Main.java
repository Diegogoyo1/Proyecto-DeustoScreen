package screen;

import java.util.logging.Level;


import java.util.logging.Logger;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {
		VentanaCarga va = new VentanaCarga();
		try {
			logger.log(Level.INFO, "SE INICIA EL PROGRAMA DEUSTOSCREEN");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
