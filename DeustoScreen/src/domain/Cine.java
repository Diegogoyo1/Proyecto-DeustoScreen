package domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Logger;

import javax.swing.undo.UndoableEditSupport;

import screen.VentanaSeleccionEntradas;

import java.text.SimpleDateFormat;


//Ventnana contenedora

public class Cine{
	private static List<Entrada> Entradas = new ArrayList<>();
	private static List<Usuario> Usuarios = new ArrayList<>();
	private static List<Peliculas> Pelicula = new ArrayList<>();
	private static Map<Usuario, List<Entrada>> compras = new TreeMap<>();
	private static List<String> titulosPeliculas =new ArrayList<>();
	
	public static List<Usuario> getListaUsuarios(){
		return Usuarios;
	}
	
	public static List<String> getTitulosPeliculas() {
		return titulosPeliculas;
	}

	public static Map<Usuario, List<Entrada>> getCompras() {
		return compras;
	}

	public static ArrayList<Entrada> getEntradas() {
		return (ArrayList<Entrada>) Entradas;
	}
	public static void aniadirEntrada(Entrada Entrada) {
		Entradas.add(Entrada);
	}
	
	public static void imprimirEntrada() {
		for(Entrada e: Entradas) {
			System.out.println(e);
		}
	}
	
	public static void aniadirUsuario(Usuario u) {
		Usuarios.add(u);
	}
	
	public static void imprimirUsuario() {
		for(Usuario u: Usuarios) {
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
		
		Collections.sort(Usuarios, U);
		}
		
		public static void aniadirCompra(Usuario u, Entrada e) {
			if(!compras.containsKey(u)) { 
				compras.put(u, new ArrayList<>());
			}
			compras.get(u).add(e); 
		}
			
		//Método que imprime por consola las compras de todos los Usuarios
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
		public static void imprimirComprasUsuario(Usuario u) {
			List<Entrada> l = compras.get(u);
			for(Entrada a: l) {
				System.out.println(a);
			}
		}
		
		public static Usuario buscarUsuario(String CorreoElectronico) {
			boolean enc = false;
			int pos = 0;
			Usuario u = null;
			while(!enc && pos<Usuarios.size()) {
				u =Usuarios.get(pos);
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
						Usuarios.add(u);
						}
					}
					sc.close();
				}catch (FileNotFoundException e) {
				 
			 }
	
		}
		public static void guardarUsuariosEnFichero(String nomfich) {
			try {
				PrintWriter pw = new PrintWriter(nomfich);
				for(Usuario u : Usuarios) {
					pw.println(u.getNombre()+";"+u.getApellido()+";"+u.getFechaNacimientoStr()+";"+u.getTlf() +";"
							+u.getCorreoElectronico()+";"+u.getContrasenia()+ ";" + u.getContadorPuntos());
				}
				pw.flush();
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public static void cargarPeliculasEnLista(String nomfich) {
			try {
				Scanner sc =  new Scanner(new FileReader(nomfich));
				String linea;
				while(sc.hasNext()) {
					linea = sc.nextLine();
					titulosPeliculas.add(linea);
				}
				sc.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public static String [] obtenerTitulos() {
			String [] titulos = new String[titulosPeliculas.size()];
			
			for(int i=0;i<titulosPeliculas.size();i++) {
				titulos[i] = titulosPeliculas.get(i);
			}
			return titulos;
		}
		
		
		
		 public static List<Peliculas> obtenerListaPeliculas() {
		        return Pelicula;
		    }

		public static int getSumaPuntos() {
			int puntos = Integer.parseInt(Usuario.getContadorPuntos());
			int puntosFinal = puntos +10;
	        String numeroEnString = String.valueOf(puntosFinal);
			Usuario.setContadorPuntos(numeroEnString);
			return puntosFinal;
		}
		
		
			
			
		
		
		
		//Logger logger = java.util.logging.Logger.getLogger("logger");
		//try {
		//}catch{
		//}
		//}
}