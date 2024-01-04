package domain;

import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileReader;
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



//Ventnana contenedora

public class Cine{
	private static List<Entrada> entradas;
	private static List<Usuario> usuarios; 
	private static List<Peliculas> Pelicula;
	private static Map<Usuario, List<Entrada>> mapaCompras;
	private static List<String> titulosPeliculas;
	private static List<Trabajador> listaTrabajadores;
	private static Usuario u;
	private static TreeMap<String, HashMap<Integer, ArrayList<String>>> mapaHorarios ;
	public static int sala;
	
	
	static {
		entradas = new ArrayList<>();
		usuarios = new ArrayList<>();
		mapaCompras = new TreeMap<>();
		titulosPeliculas =new ArrayList<>();
		listaTrabajadores = new ArrayList<>();
		mapaHorarios = new TreeMap<>();
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
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String [] partes = linea.split(";");
				if(!mapaHorarios.containsKey(partes[0])) {
					mapaHorarios.put(partes[0], new HashMap<>());
				}
				sala = Integer.parseInt(partes[1]);
				if(!mapaHorarios.get(partes[0]).containsKey(sala)){
					mapaHorarios.get(partes[0]).put(sala, new ArrayList<>());
				}
				String [] peliculas = partes[2].split(",");
				for(String p: peliculas) {
					mapaHorarios.get(partes[0]).get(sala).add(p);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static List<Usuario> getListaUsuarios(){
		return usuarios;
	}
	
	public static List<String> getTitulosPeliculas() {
		return titulosPeliculas;
	}


	public static Map<Usuario, List<Entrada>> getMapaCompras() {
		return mapaCompras;
	}

	public static ArrayList<Entrada> getEntradas() {
		return (ArrayList<Entrada>) entradas;
	}
	/**
	 * 
	 * @param Entrada
	 */
	public static void aniadirEntrada(Entrada Entrada) {
		entradas.add(Entrada);
	}
	/**
	 * 
	 */
	public static void imprimirEntrada() {
		for(Entrada e: entradas) {
			System.out.println(e);
		}
	}
	/**
	 * 
	 * @param u
	 */
	public static void aniadirUsuario(Usuario u) {
		usuarios.add(u);
	}
	/**
	 * 
	 */
	public static void imprimirUsuario() {
		for(Usuario u: usuarios) {
			System.out.println(u);
		}
	}
	/**
	 * 
	 * @param e
	 */
	public static void aniadirPelicula(Peliculas e) {
		Pelicula.add(e);
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
		
		Collections.sort(usuarios, U);
		}
	
	

		/**
		 * Añade las compra de un usuario al mapa Compreas
		 * @param u Usiario de hace la compra
		 * @param e Entrada que compra en usuario
		 */
		public static void aniadirCompra(Usuario u, Entrada e) {
			if(!mapaCompras.containsKey(u)) { 
				mapaCompras.put(u, new ArrayList<>());
			}

			mapaCompras.get(u).add(e); 
		}
			
		/**
		 * Método que imprime por consola las compras de todos los Usuarios
		 */
		public static void imprimirCompras() {
			//Recorremos las claves del mapa
			for(Usuario u: mapaCompras.keySet()) {
				System.out.println(u);
				//Por cada cliente, obtenemos su lista de Articulos comprados
				List<Entrada> l = mapaCompras.get(u);
				//Recorremos los artículos comprados
				for(Entrada a: l) {
					System.out.println(a);
				}
				System.out.println("************************************************************************");
			}
		}
		/**
		 * metodo que imprime las compas de los usuarios por pantalla
		 * @param u
		 */
		public static void imprimirComprasUsuario(Usuario u) {
			List<Entrada> l = mapaCompras.get(u);
			for(Entrada a: l) {
				System.out.println(a);
			}
		}
		/**
		 * Busca los usuarios pr el correo electronico
		 * @param CorreoElectronico
		 * @return Devuelve el usuario si se ha encontrado
		 */
		public static Usuario buscarUsuario(String CorreoElectronico) {
			boolean enc = false;
			int pos = 0;
			Usuario u = null;
			while(!enc && pos<usuarios.size()) {
				u =usuarios.get(pos);
				if(u.getCorreoElectronico().equals(CorreoElectronico)) {
					enc = true;
				}else {
					pos++;
				}
			}
			if(enc) {
				return u;
			}else{
				return null;
			}
		}
		/**
		 * Metodo que carga los usuarios en la lista 
		 * @param nomfich nombre del fichero Donde vamos a guardar los usuarios
		 */
		 
		public static void cargarUsuarioEnLista(String nomfich) {
			//linea = nom;apellido;fNac;tlf;correo;contraseña;puntos
			try {
				Scanner sc = new Scanner(new FileReader(nomfich));
				String linea;
				while(sc.hasNext()) {
					linea = sc.nextLine();
					String [] partes = linea.split(";");
					String Nombre = partes[0];
					String Apellido = partes[1];
					String FechaNacimiento = partes[2];
					String tlf = partes[3];
					String CorreoElectronico = partes[4];
					String Contrasenia = partes[5];
					String ContadorPuntos = partes[6];
					Usuario u = new Usuario(Nombre,Apellido,FechaNacimiento,tlf,CorreoElectronico,Contrasenia,ContadorPuntos);
					if(buscarUsuario(CorreoElectronico)== null) {
						usuarios.add(u);
						}
					}
					sc.close();
				}catch (FileNotFoundException e) {
				 
			 }
	
		}
		/**
		 * Metodo que guarda los usuarios registrados en ficheros
		 * @param nomfich nombre del fichero Donde vamos a guardar los usuarios
		 */
		public static void guardarUsuariosEnFichero(String nomfich) {
			try {
				PrintWriter pw =new PrintWriter (nomfich);
				//PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfich),true));
				for(Usuario u : usuarios) {
					pw.println(u.getNombre()+";"+u.getApellido()+";"+u.getFechaNacimientoStr()+";"+u.getTlf() +";"
							+u.getCorreoElectronico()+";"+u.getContrasenia()+ ";" + u.getContadorPuntos());
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
		 * @param con conexion con la base de datos
		 * @param nomFich nombre del fichero en este caso Usuarios.csv
		 */
		public static void volcado_FichCSV_Usuarios_a_BD(Connection con,String nomFich) {
			try {
				Scanner sc = new Scanner(new FileReader(nomFich));
				String linea;
				while(sc.hasNext()) {
					linea = sc.nextLine();
					String []partes = linea.split(";");
					String Nombre = partes[0];
					String Apellido = partes[1];
					String FechaNacimiento = partes[2];
					String tlf = partes[3];
					String CorreoElectronico = partes[4];
					String Contrasenia = partes[5];
					String ContadorPuntos = partes[6];	

					Usuario u = new Usuario(Nombre, Apellido, FechaNacimiento, tlf, CorreoElectronico, Contrasenia, ContadorPuntos);
					BD.insertarUsuario(con, u);
				}
				sc.close();
			}catch (FileNotFoundException e) {
				//logger.log(Level.WARNING, "Ruta del fichero no encontrada");
			}
		}

		
		/**
		 * Metodo que vuelca todos los Trabajadores del fichero a la base de datos
		 * 
		 * @param con conexion con la base de datos
		 * @param nomFich nombre del fichero en este caso Trabajadores.csv
		 */
		
		public static void volcado_FichCSV_Trabajadores_a_BD(Connection con, String nomFich) {
			try {
				Scanner sc = new Scanner(new FileReader(nomFich));
				String linea;
				while (sc.hasNext()) {
					linea = sc.nextLine();
					String []partes = linea.split(";");
					String NombreApellidos = partes[2];
					String Dni = partes[5];
					String Contrasenia = partes[4];
					String Telefono = partes[3];
					String Puesto = partes[6];
					String HorasTrabajadas = partes[0];
					String Sueldo = partes[1];
					
					Trabajador t = new Trabajador(HorasTrabajadas, Sueldo, NombreApellidos, Telefono, Contrasenia, Dni, Puesto);
					BD.insertarTrabajador(con, t);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//logger.log(Level.WARNING, "Ruta del fichero no encontrada");
			}
		}
		

		/**
		 * Metodo que registra a los usuarios y los guarda en el fichero
		 * 
		 * @param nomfich nombre de l fichero
		 * @param nombre nombre de usuario
		 * @param apellido aoellido del usuario
		 * @param fechaNac fecha de nacimiento del usuario
		 * @param tlf telefono del usuario
		 * @param correoElectronico
		 * @param cont contraseña del usuario
		 * @param contador puntos acomulados que tiene el usuario
		 * @return devuelve true cuando estos se guardan
		 */
		public static boolean registroUsuario(String nomfich, String nombre, String apellido, String fechaNac,
				String tlf, String correoElectronico, String cont, String contador) {
			
			Usuario u = new Usuario(nombre, apellido, fechaNac, tlf, correoElectronico, cont, contador);
			usuarios.add(u);
			guardarUsuariosEnFichero(nomfich);
			return true;
		}
		
		/**
		 * Metodo que carga las peliculas en una lista.
		 * @param nomfich
		 */
		public static void cargarPeliculasEnLista(String nomfich) {
			try {
				Scanner sc =  new Scanner(new FileReader(nomfich));
				String linea;
				titulosPeliculas.clear();
				while(sc.hasNext()) {
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
		 * @return Devuelve el titulo de la pelicula
		 */
		public static String [] obtenerTitulos() {
			String [] titulos = new String[titulosPeliculas.size()];
			
			for(int i=0;i<titulosPeliculas.size();i++) {
				titulos[i] = titulosPeliculas.get(i);
			}
			return titulos;
		}
		
		
		/**
		 * Metodo que Obtiene la lista de peliculas
		 * @return Devuelve la lista de peliculas
		 */
		 public static List<Peliculas> obtenerListaPeliculas() {
		        return Pelicula;
		 }
		 
		 /*Método que actualiza el contador de puntos de todos los usuarios
		  * Llamada desde el botón FinalizarCompra*/
		 public static void actualizarPuntosUsuarios() {
			 for(Usuario u : mapaCompras.keySet()) {
				 int p = mapaCompras.get(u).size();
				 int pos = usuarios.indexOf(u);
				 usuarios.get(pos).actualizarPuntos(String.valueOf(p));
			 }
		 }
		 
		 public static Trabajador buscarTrabajador (String inicio) {
			 boolean enc = false;
				int pos = 0;
				Trabajador t = null;
				while(!enc && pos<listaTrabajadores.size()) {
					t=listaTrabajadores.get(pos);
					if((t.getDni().equals(inicio))) {
						enc = true;
					}else {
						pos++;
					}
				}
				
				if(enc) {
					return t;
				}else {
					return null;
				}
		 }
		 
		 public static void cargarTrabajadoresEnLista(String nomfich) {
			 try {
					Scanner sc = new Scanner(new File(nomfich));
					while(sc.hasNextLine()) {
						String linea = sc.nextLine();
						String[]partes = linea.split(";");
						String nombreApellidos = partes[0];
						String telefono = partes[1];
						PuestoTrabajo puesto = PuestoTrabajo.valueOf(partes[2]);
						String dni = partes[3];
						Trabajador t = new Trabajador(nombreApellidos, telefono, puesto, dni );
						listaTrabajadores.add(t);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		 }

	 /*public void actualizarPuntos(String ContadorPuntos) {
				int puntosInt = Integer.parseInt(ContadorPuntos);
				
				if (getCompras()!= null) {
					puntosInt = puntosInt + value.size()*2;				}
				
	 }
	public static int getSumaPuntos() {
			String puntosStr = Usuario.getContadorPuntos();
			int puntos = Integer.parseInt(puntosStr);
			int numeroEntradas = Entradas.size();
			int puntosFinal = puntos +10*numeroEntradas;
	        String numeroEnString = String.valueOf(puntosFinal);
			Usuario.setContadorPuntos(numeroEnString);
			return puntosFinal;
		}*/
		
		
			
			
		
		
		
		//Logger logger = java.util.logging.Logger.getLogger("logger");
		//try {
		//}catch{
		//}
		//}
}