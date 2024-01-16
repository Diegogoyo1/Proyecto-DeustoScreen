package domain;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import screen.VentanaInicioSesion;
import screen.VentanaPuntos;
import screen.VentanaSeleccionEntradas;


//Ventnana contenedora

public class Cine {
	private static List<Usuario> listaUsuarios;
	private static Map<String, Pelicula> mapaPeliculas;
	private static Map<Usuario, List<Compra>> mapaCompras;
	private static List<String> titulosPeliculas;
	private static List<Trabajador> listaTrabajadores;
	private static List<Compra> listaCompras;
	private static TreeMap<String, HashMap<Integer, ArrayList<String>>> mapaHorarios;
	public static int sala;
	private static int[][] m1;

	static {
		m1 = new int[7][12];
		listaUsuarios = new ArrayList<>();
		mapaCompras = new TreeMap<>();
		titulosPeliculas = new ArrayList<>();
		listaTrabajadores = new ArrayList<>();
		listaCompras = new ArrayList<>();
		mapaHorarios = new TreeMap<>();
		mapaPeliculas = new HashMap<>();
	}

	public static int[][] getM1() {
		return m1;
	}

	public static void setM1(int[][] m1) {
		Cine.m1 = m1;
	}

	public static void guardarMapaCompras(String nomfich) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomfich)));
			oos.writeObject(mapaCompras);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void cargarMapaCompras(String nomfich) {
		File f = new File(nomfich);
		if (f.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
				mapaCompras = (Map<Usuario, List<Compra>>) ois.readObject();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
	}
	
	public static void guardarButacasEnFichero(String nomfich) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomfich)));
			oos.writeObject(m1);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void cargarButacasDesdeFichero(String nomfich) {
		File f = new File(nomfich);
		if (f.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
				m1 = (int[][]) ois.readObject();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static TreeMap<String, HashMap<Integer, ArrayList<String>>> getMapaHorarios() {
		return mapaHorarios;
	}

	/**
	 * Metodo que carga los horarios de las peliculas del mapa
	 */
	public static void crearMapaHorarios() {
		try {
			Scanner sc = new Scanner(new FileReader("ficheros/horarios.csv"));
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				if (!mapaHorarios.containsKey(partes[0])) {
					mapaHorarios.put(partes[0], new HashMap<>());
				}
				sala = Integer.parseInt(partes[1]);
				if (!mapaHorarios.get(partes[0]).containsKey(sala)) {
					mapaHorarios.get(partes[0]).put(sala, new ArrayList<>());
				}
				String[] peliculas = partes[2].split(",");
				for (String p : peliculas) {
					mapaHorarios.get(partes[0]).get(sala).add(p);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public static List<String> getTitulosPeliculas() {
		return titulosPeliculas;
	}

	public static Map<Usuario, List<Compra>> getMapaCompras() {
		return mapaCompras;
	}


	/**
	 * 
	 * @param u
	 */
	public static void aniadirUsuario(Usuario u) {
		listaUsuarios.add(u);
	}

	

	
	/**
	 * 
	 */
	public static void ordenarListaUsuarios() {
		Comparator<Usuario> U = new Comparator<Usuario>() {
			@Override
			public int compare(Usuario o1, Usuario o2) {
				return o1.getCorreoElectronico().compareTo(o2.getCorreoElectronico());
			}
		};

		Collections.sort(listaUsuarios, U);
	}

	/**
	 * Añade las compra de un usuario al mapa Compreas
	 * 
	 * @param u Usiario de hace la compra
	 * @param e Entrada que compra en usuario
	 */
	public static void aniadirCompra(Usuario u, Compra c) {
		if (!mapaCompras.containsKey(u)) {
			mapaCompras.put(u, new ArrayList<>());
		}

		mapaCompras.get(u).add(c);
	}
	

	/**
	 * Busca los usuarios pr el correo electronico
	 * 
	 * @param CorreoElectronico
	 * @return Devuelve el usuario si se ha encontrado
	 */
	public static Usuario buscarUsuario(String CorreoElectronico) {
		boolean enc = false;
		int pos = 0;
		Usuario u = null;
		while (!enc && pos < listaUsuarios.size()) {
			u = listaUsuarios.get(pos);
			if (u.getCorreoElectronico().equals(CorreoElectronico)) {
				enc = true;
			} else {
				pos++;
			}
		}
		if (enc) {
			return u;
		} else {
			return null;
		}
	}

	/**
	 * Metodo que carga los usuarios en la lista
	 * 
	 * @param nomfich nombre del fichero Donde vamos a guardar los usuarios
	 */

	public static void cargarUsuarioEnLista(String nomfich) {
		// linea = nom;apellido;fNac;tlf;correo;contraseña;puntos
		try {
			Scanner sc = new Scanner(new FileReader(nomfich));
			String linea;
			while (sc.hasNext()) {
				linea = sc.nextLine();
				String[] partes = linea.split(";");
				String Nombre = partes[0];
				String Apellido = partes[1];
				String FechaNacimiento = partes[2];
				String tlf = partes[3];
				String CorreoElectronico = partes[4];
				String Contrasenia = partes[5];
				String ContadorPuntos = partes[6];
				Usuario u = new Usuario(Nombre, Apellido, FechaNacimiento, tlf, CorreoElectronico, Contrasenia,
						ContadorPuntos);
				if (buscarUsuario(CorreoElectronico) == null) {
					listaUsuarios.add(u);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que guarda los usuarios registrados en ficheros
	 * 
	 * @param nomfich nombre del fichero Donde vamos a guardar los usuarios
	 */
	public static void guardarUsuariosEnFichero(String nomfich) {
		try {
			PrintWriter pw = new PrintWriter(nomfich);
			// PrintWriter pw = new PrintWriter(new FileOutputStream(new
			// File(nomfich),true));
			for (Usuario u : listaUsuarios) {
				pw.println(u.getNombre() + ";" + u.getApellido() + ";" + u.getFechaNacimientoStr() + ";" + u.getTlf()
						+ ";" + u.getCorreoElectronico() + ";" + u.getContrasenia() + ";" + u.getContadorPuntos());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que vuelca todos los Usuarios del fichero a la base de datos
	 * 
	 * @param con     conexion con la base de datos
	 * @param nomFich nombre del fichero en este caso Usuarios.csv
	 */
	public static void volcado_FichCSV_Usuarios_a_BD(Connection con, String nomFich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomFich));
			String linea;
			while (sc.hasNext()) {
				linea = sc.nextLine();
				String[] partes = linea.split(";");
				String Nombre = partes[0];
				String Apellido = partes[1];
				String FechaNacimiento = partes[2];
				String tlf = partes[3];
				String CorreoElectronico = partes[4];
				String Contrasenia = partes[5];
				String ContadorPuntos = partes[6];

				Usuario u = new Usuario(Nombre, Apellido, FechaNacimiento, tlf, CorreoElectronico, Contrasenia,
						ContadorPuntos);
				BD.insertarUsuario(con, u);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// logger.log(Level.WARNING, "Ruta del fichero no encontrada");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que vuelca todos los Trabajadores del fichero a la base de datos
	 * 
	 * @param con     conexion con la base de datos
	 * @param nomFich nombre del fichero en este caso Trabajadores.csv
	 */

	public static void volcado_FichCSV_Trabajadores_a_BD(Connection con, String nomFich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomFich));
			String linea;
			while (sc.hasNext()) {
				linea = sc.nextLine();
				String[] partes = linea.split(";");
				String Dni = partes[0];
				String NombreApellidos = partes[1];
				String Telefono = partes[2];
				String Contrasenia = partes[3];
				PuestoTrabajo Puesto = PuestoTrabajo.valueOf(partes[4]);
				double Sueldo = Double.parseDouble(partes[5]);
				Trabajador t = new Trabajador(Dni, NombreApellidos, Telefono, Contrasenia, Puesto, Sueldo);
				BD.insertarTrabajador(con, t);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// logger.log(Level.WARNING, "Ruta del fichero no encontrada");
		}
	}

	public static void volcado_FichCSV_Horarios_a_BD(Connection con, String nomFich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomFich));
			String linea;
			while (sc.hasNext()) {
				linea = sc.nextLine();
				String[] partes = linea.split(";");
				String Hora = partes[0];
				int Sala = Integer.parseInt(partes[1]);
				String DiasSemana = partes[2];
				Horario h = new Horario(Hora, Sala, DiasSemana);
				BD.insertarHorario(con, h);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// logger.log(Level.WARNING, "Ruta del fichero no encontrada");
		}
	}

	public static void volcado_FichCSV_Peliculas_a_BD(Connection con, String nomFich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomFich));
			String linea;
			while (sc.hasNext()) {
				linea = sc.nextLine();
				String[] partes = linea.split(";");
				String tituloPelicula = partes[0];
				String tituloVentana = partes[1];
				String imagenCartelera = partes[2];
				String imagenPelicula = partes[3];
				String descripcion = partes[4];
				String categoria = partes[5];
				String duracion = partes[6];
				String reparto = partes[7];

				Pelicula p = new Pelicula(tituloPelicula, tituloVentana, imagenCartelera, imagenPelicula, descripcion,
						categoria, duracion, reparto);
				BD.insertarPelicula(con, p);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// logger.log(Level.WARNING, "Ruta del fichero no encontrada");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que registra a los usuarios y los guarda en el fichero
	 * 
	 * @param nomfich           nombre de l fichero
	 * @param nombre            nombre de usuario
	 * @param apellido          aoellido del usuario
	 * @param fechaNac          fecha de nacimiento del usuario
	 * @param tlf               telefono del usuario
	 * @param correoElectronico
	 * @param cont              contraseña del usuario
	 * @param contador          puntos acomulados que tiene el usuario
	 * @return devuelve true cuando estos se guardan
	 */
	public static boolean registroUsuario(String nomfichUsuarios, String nombre, String apellido, String fNac,
			String tlf, String CorreoElectronico, String contrasenia, String ContadorPuntos, JFrame frame) {
		if (isValidEmail(CorreoElectronico) && isValidContrasenia(contrasenia)
				&& buscarUsuario(CorreoElectronico) == null) {
			Usuario nuevoUsuario = new Usuario(nombre, apellido, fNac, tlf, CorreoElectronico, contrasenia,
					ContadorPuntos);
			listaUsuarios.add(nuevoUsuario);
			System.out.println(nuevoUsuario.getContadorPuntos());
			guardarUsuariosEnFichero(nomfichUsuarios);

			Connection con = BD.initBD("deustoscreen.db");
			Cine.volcado_FichCSV_Usuarios_a_BD(con, nomfichUsuarios);
			BD.cerrarBD(con);

			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Usuario ya regitrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	public static void cargarTitulosPeliculasEnLista(String nomfich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomfich));
			String linea;
			titulosPeliculas.clear();
			while (sc.hasNext()) {
				linea = sc.nextLine();
				titulosPeliculas.add(linea);
			}
			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que obtiene los titulos de las peliculas
	 * 
	 * @return Devuelve el titulo de la pelicula
	 */
	public static String[] obtenerTitulos() {
		/*
		 * String [] titulos = new String[titulosPeliculas.size()];
		 * 
		 * for(int i=0;i<titulosPeliculas.size();i++) { titulos[i] =
		 * titulosPeliculas.get(i); } return titulos;
		 */
		String[] titulos = new String[mapaPeliculas.size()];
		int i = 0;
		for (Pelicula p : mapaPeliculas.values()) {
			titulos[i] = p.getTituloPelicula();
			i++;
		}
		return titulos;
	}
	
	/*
	 * Método que actualiza el contador de puntos de todos los usuarios Llamada
	 * desde el botón FinalizarCompra
	 */
	public static void actualizarPuntosUsuarios() {
		for (Usuario u : mapaCompras.keySet()) {
			int p = mapaCompras.get(u).size();
			int pos = listaUsuarios.indexOf(u);
			listaUsuarios.get(pos).actualizarPuntos(String.valueOf(p));
		}
	}

	public static Trabajador buscarTrabajador(String inicio) {
		boolean enc = false;
		int pos = 0;
		Trabajador t = null;
		while (!enc && pos < listaTrabajadores.size()) {
			t = listaTrabajadores.get(pos);
			if ((t.getDni().equals(inicio))) {
				enc = true;
			} else {
				pos++;
			}
		}

		if (enc) {
			return t;
		} else {
			return null;
		}
	}

	public static void cargarTrabajadoresEnLista(String nomfich) {
		try {
			Scanner sc = new Scanner(new File(nomfich));
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				String dni = partes[0];
				String nombreApellidos = partes[1];
				String telefono = partes[2];
				String contrasenia = partes[3];
				PuestoTrabajo puesto = PuestoTrabajo.valueOf(partes[4]);
				double sueldo = Double.parseDouble(partes[5]);

				Trabajador t = new Trabajador(dni, nombreApellidos, telefono, contrasenia, puesto, sueldo);
				listaTrabajadores.add(t);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "[a-zA-Z0-9]{1,}@[a-z]{1,}.[a-z]{1,}";
		return Pattern.matches(emailRegex, email);
	}

	public static boolean isValidContrasenia(String contrasenia) {
		if (contrasenia.length() < 6 || !contrasenia.matches(".*[0-9].*") || !contrasenia.matches(".*[a-zA-Z].*")
				|| !contrasenia.matches(".*[!@#$%^&*()-_=+{};:,<.>/?`~].*")) {
			JOptionPane.showMessageDialog(null, "La contraseña no contiene los caracteres necesarios", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static Map<String, Pelicula> getMapaPeliculas() {
		return mapaPeliculas;
	}

	public static void crearMapaPeliculas() {
		try {
			Scanner sc = new Scanner(new FileReader("ficheros/Peliculas.csv"));
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] partes1 = linea.split(";");
				String ruta = partes1[2];
				if (!mapaPeliculas.containsKey(ruta)) {
					String tituloPelicula = partes1[0];
					String tituloVentana = partes1[1];
					String imagenCartelera = partes1[2];
					String imagenPelicula = partes1[3];
					String descripcion = partes1[4];
					String categoria = partes1[5];
					String duracion = partes1[6];
					String reparto = partes1[7];
					Pelicula p = new Pelicula(tituloPelicula, tituloVentana, imagenCartelera, imagenPelicula,
							descripcion, categoria, duracion, reparto);
					mapaPeliculas.put(ruta, p);
				}

			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static String restarPuntos() {
		Usuario u = VentanaInicioSesion.getUsuario();
		int puntosUsuario = Integer.parseInt(u.getContadorPuntos());
		int puntosRestados = puntosUsuario - VentanaPuntos.getValorSpinner();
		String puntosRestadosStr = String.valueOf(puntosRestados);
		u.setContadorPuntos(puntosRestadosStr);
		return puntosRestadosStr;
	}
	
	/**
	 * 
	 * @return puntosFinal devuelve los puntos del usuario añadiendo los puntos de la compra que esta realizando
	 */
	
	public static int getSumaPuntos() {
		Usuario u = VentanaInicioSesion.getUsuario();
		String puntosStr = u.getContadorPuntos();
		int puntos = Integer.parseInt(puntosStr);
		int precioTotal = (VentanaSeleccionEntradas.getEntreanios() * 7) + (VentanaSeleccionEntradas.getMayores() * 5)
				+ (VentanaSeleccionEntradas.getMenores() * 4);
		int puntosFinal = puntos + 10 * precioTotal;
		String numeroEnString = String.valueOf(puntosFinal);
		u.setContadorPuntos(numeroEnString);
		return puntosFinal;
	}

//	 public void actualizarPuntos(String ContadorPuntos) {
//				int puntosInt = Integer.parseInt(ContadorPuntos);
//				
//				if (getMapaCompras()!= null) {
//					puntosInt = puntosInt + value.size()*2;				}
//				
//	 }
	




	// Logger logger = java.util.logging.Logger.getLogger("logger");
	// try {
	// }catch{
	// }
	// }
}