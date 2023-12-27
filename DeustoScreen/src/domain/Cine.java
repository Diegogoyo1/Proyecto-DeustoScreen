package domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
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
	private static Map<Usuario, List<Entrada>> compras;
	private static List<String> titulosPeliculas;
	private static Usuario u;
	private static TreeMap<String, HashMap<Integer, ArrayList<String>>> mapaHorarios ;
	
	static {
		entradas = new ArrayList<>();
		usuarios = new ArrayList<>();
		compras = new TreeMap<>();
		titulosPeliculas =new ArrayList<>();
		//u = new Usuario();
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
				int sala = Integer.parseInt(partes[1]);
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

	public static Map<Usuario, List<Entrada>> getCompras() {
		return compras;
	}

	public static ArrayList<Entrada> getEntradas() {
		return (ArrayList<Entrada>) entradas;
	}
	public static void aniadirEntrada(Entrada Entrada) {
		entradas.add(Entrada);
	}
	
	public static void imprimirEntrada() {
		for(Entrada e: entradas) {
			System.out.println(e);
		}
	}
	
	public static void aniadirUsuario(Usuario u) {
		usuarios.add(u);
	}
	
	public static void imprimirUsuario() {
		for(Usuario u: usuarios) {
			System.out.println(u);
		}
	}
	public static void aniadirPelicula(Peliculas e) {
		Pelicula.add(e);
	}
	
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
			if(!compras.containsKey(u)) { 
				compras.put(u, new ArrayList<>());
			}
			compras.get(u).add(e); 
		}
			
		/**
		 * Método que imprime por consola las compras de todos los Usuarios
		 */
		public static void imprimirCompras() {
			//Recorremos las claves del mapa
			for(Usuario u: compras.keySet()) {
				System.out.println(u);
				//Por cada cliente, obtenemos su lista de Articulos comprados
				List<Entrada> l = compras.get(u);
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
			List<Entrada> l = compras.get(u);
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
		 * @param nomfich 
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
		 * @param nomfich
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
			 for(Usuario u : compras.keySet()) {
				 int p = compras.get(u).size();
				 int pos = usuarios.indexOf(u);
				 usuarios.get(pos).actualizarPuntos(String.valueOf(p));
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