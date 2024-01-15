package domain;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
public class BD {
/**
 * Metodo que inicializa la base de datos
 * @param nombreBD
 * @return devuelve la conexion de la base de datos
 */
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void borrarTabla(Connection con) throws SQLException{
		String sqlUsuario = "DROP TABLE IF EXISTS Usuario";
		String sqlPeliculas = "DROP TABLE IF EXISTS Peliculas";
		String sqlHorarios = "DROP TABLE IF EXISTS Horarios";
		String sqlTrabajador = "DROP TABLE IF EXISTS Trabajador";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sqlUsuario);
			st.executeUpdate(sqlPeliculas);
			st.executeUpdate(sqlHorarios);
			st.executeUpdate(sqlTrabajador);
			st.close();
		} catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * Metodo que crea las tablas de la Base de Datos
	 * @param con Conexion de la base de datos
	 * @throws SQLException Excepcion si no se actualiza la tabla en la base de datos
	 */
	public static void crearTabla (Connection con) throws SQLException{
		String sqlUsuario = "CREATE TABLE IF NOT EXISTS Usuario (Nombre String, Apellido String,FechaNacimiento String, Telefono String,CorreoElectronico String,Contrasenia String,ContadorPuntos String )";
		String sqlPeliculas = "CREATE TABLE IF NOT EXISTS Peliculas (TituloPelicula String, TituloVentana String, ImagenCartelera String, ImagenPelicula String, Descripcion String, Categoria String, Duracion String, Reparto String)";
		String sqlHorarios = "CREATE TABLE IF NOT EXISTS Horarios(Hora String, Sala int, DiasSemana String)";
		String sqlTrabajador = "CREATE TABLE IF NOT EXISTS Trabajador(Dni String, NombreApellidos String, Telefono String,  Contrasenia String, Puesto String, Sueldo double)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sqlUsuario);
			st.executeUpdate(sqlPeliculas);
			st.executeUpdate(sqlHorarios);
			st.executeUpdate(sqlTrabajador);
			st.close();
		} catch (SQLException e) {
			throw e;
		}
	}
	/**
	 * Inserta usuario en la base de datos
	 * @param con Conexion de la base de datos
	 * @param usuario Usuario que queremos insertar en la base de datos
	 */
		public static void insertarUsuario(Connection con, Usuario usuario){
			if(buscarUsario(con,usuario.getCorreoElectronico())==null){
				String sql = String.format("INSERT INTO Usuario VALUES('%s','%s','%s','%s','%s','%s','%s')", 
						usuario.getNombre(), usuario.getApellido(), usuario.getFechaNacimientoStr(), usuario.getTlf(), usuario.getCorreoElectronico(),usuario.getContrasenia(),usuario.getContadorPuntos());
				try {
					Statement st = con.createStatement();
					st.executeUpdate(sql);
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		/**
		 * Busca usuario mediante el valor de correo electronico
		 * @param con Conexion de la base de datos
		 * @param CorreoElectronico correo electronico con el cual vamos a buscar el usuario
		 * @return devuelve el usuario que ha buscado en la base de datos
		 */
	public static Usuario buscarUsario(Connection con, String CorreoElectronico) {
		String sql = String.format("SELECT * FROM Usuario WHERE CorreoElectronico = '%s'", CorreoElectronico);
		Usuario usuario= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellido");
				String fNac = rs.getString("fechaNacimiento");
				String tlf = rs.getString("Telefono");
				String CorreoEle = rs.getString("CorreoElectronico");
				String contrasenia = rs.getString("Contrasenia");
				String ContadorPuntos = rs.getString("ContadorPuntos");
				usuario = new Usuario(nombre, apellido, fNac, tlf, CorreoEle, contrasenia, ContadorPuntos);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	/**
	 * Metodo que obtiene la lista de usuarios 
	 * @param con Conexion de la base de datos
	 */
	public static List<Usuario> obtenerListaUsario(Connection con){
		String sql = "SELECT * FROM Usuario";
		List<Usuario> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String tlf = rs.getString("Teléfono");
				String fNac = rs.getString("fechaNacimineto");
				String correoElectronico = rs.getString("CorreoElectronico");
				String contrasenia = rs.getString("Contrasenia");
				String puntosAcumulados = rs.getString("PuntosAcumulados");
				Usuario usuario = new Usuario(nombre, apellidos,fNac,tlf,correoElectronico,contrasenia,puntosAcumulados);
				l.add(usuario);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	/**
	 * Inserta trabajador en la base de datos
	 * @param con Conexion de la base de datos
	 * @param trabajador Trabajador que queremos insertar en la base de datos
	 */
	public static void insertarTrabajador (Connection con, Trabajador trabajador) {
		if(buscarTrabajador(con, trabajador.getDni()) == null) {
			String sql = String.format("INSERT INTO Trabajador VALUES('%s','%s','%s','%s','%s','%.2f')",
					trabajador.getDni(),trabajador.getNombreApellidosTrabajador(), trabajador.getTelefonoTrabajador(), trabajador.getContraseniaTrabajador(), trabajador.getPuesto(), trabajador.getSueldo());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	/**
	 * Busca trabajador mediante el valor del dni
	 * @param con Conexion de la base de datos
	 * @param Dni dni con el cual vamos a buscar el trabajador
	 * @return devuelve el trabajador que ha buscado en la base de datos
	 */
	public static Trabajador buscarTrabajador(Connection con, String dni) {
		String sql = String.format("SELECT * FROM Trabajador WHERE Dni = '%s'", dni);
		Trabajador trabajador = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				String dniTra = rs.getString("Dni");
				String nombreApellidosTrabajador = rs.getString("NombreApellidos");
				String contraseniaTrabajador = rs.getString("Contrasenia");
				String telefonoTrabajador = rs.getString("Telefono");
				PuestoTrabajo puesto = PuestoTrabajo.valueOf(rs.getString("Puesto"));
				double sueldo = Double.parseDouble(rs.getString("Sueldo"));	
				trabajador = new Trabajador (dniTra, nombreApellidosTrabajador, contraseniaTrabajador, telefonoTrabajador, puesto, sueldo);

			}
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trabajador;
		
	}
	
	
	/**
	 * Metodo que obtiene la lista de trabajadores 
	 * @param con Conexion de la base de datos
	 */
	
	public static List<Trabajador> obtenerListaTrabajador (Connection con){
		String sql = "SELECT * FROM Trabajador";
		List<Trabajador> lt = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String dni = rs.getString("Dni");
				String nombreApellidosTrabajador = rs.getString("NombreApellidos");
				String telefonoTrabajador = rs.getString("Telefono");
				String contraseniaTrabajador = rs.getString("Contrasenia");
				PuestoTrabajo puesto = PuestoTrabajo.valueOf(rs.getString("Puesto"));
				double sueldo = rs.getDouble("Sueldo");
				Trabajador trabajador = new Trabajador(dni, nombreApellidosTrabajador, telefonoTrabajador, contraseniaTrabajador,  puesto, sueldo);
				lt.add(trabajador);					
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lt;
	}
	
	public static TreeMap<String, HashMap<Integer, ArrayList<String>>> obtenerListaHorarios (Connection con){
		String sql = "SELECT * FROM Horarios";
		TreeMap<String, HashMap<Integer, ArrayList<String>>> th = new TreeMap<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				/*String dni = rs.getString("Dni");
				String nombreApellidosTrabajador = rs.getString("NombreApellidosTrabajador");
				String telefonoTrabajador = rs.getString("TelefonoTrabajador");
				String contraseniaTrabajador = rs.getString("ContraseniaTrabajador");
				PuestoTrabajo puesto = PuestoTrabajo.valueOf(rs.getString("Puesto"));
				double sueldo = rs.getDouble("Sueldo");
				Trabajador trabajador = new Trabajador(dni, nombreApellidosTrabajador, telefonoTrabajador, contraseniaTrabajador,  puesto, sueldo);*/
				//th.add(horario);					
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return th;
	}
	
	public static void insertarPelicula (Connection con, Pelicula pelicula) {
		if(buscarTrabajador(con, pelicula.getTituloPelicula()) == null) {
			String sql = String.format("INSERT INTO Peliculas VALUES('%s','%s','%s','%s','%s','%s','%s','%s')",
					pelicula.getTituloPelicula(), pelicula.getTituloVentana(), pelicula.getImagenCartelera(), pelicula.getImagenPelicula(), pelicula.getDescripcion(), pelicula.getCategoria(), pelicula.getDuracion(), pelicula.getReparto());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Pelicula buscarPelicula(Connection con, String tituloPelicula) {
		String sql = String.format("SELECT * FROM Peliculas WHERE TituloPelicula = '%s'", tituloPelicula);
		Pelicula pelicula= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				String tituloPeliculaTP = rs.getString("TituloPelicula");
				String tituloVentana = rs.getString("TituloVentana");
				String imagenCartelera = rs.getString("ImagenCartelera");
				String imagenPelicula = rs.getString("ImagenPelicula");
				String descripcion = rs.getString("Descripcion");
				Categoria categoria = Categoria.valueOf(rs.getString("Categoria"));
				String duracion = rs.getString("Duracion");
				String reparto = rs.getString("Reparto");
				pelicula = new Pelicula(tituloPeliculaTP, tituloVentana, imagenCartelera, imagenPelicula, descripcion, categoria, duracion, reparto);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pelicula;
	}
	
	
	
	public static List<Pelicula> obtenerListaPeliculas(Connection con){
		String sql = "SELECT * FROM Peliculas";
		List<Pelicula> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String tituloPeliculaTP = rs.getString("TituloPelicula");
				String tituloVentana = rs.getString("TituloVentana");
				String imagenCartelera = rs.getString("ImagenCartelera");
				String imagenPelicula = rs.getString("ImagenPelicula");
				String descripcion = rs.getString("Descripcion");
				Categoria categoria = Categoria.valueOf(rs.getString("Categoria"));
				String duracion = rs.getString("Duracion");
				String reparto = rs.getString("Reparto");
				Pelicula pelicula = new Pelicula(tituloPeliculaTP, tituloVentana, imagenCartelera, imagenPelicula, descripcion, categoria, duracion, reparto);
				l.add(pelicula);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	
	public static void insertarHorario (Connection con, Horario horario) {
		if(buscarTrabajador(con, horario.getHora()) == null) {
			String sql = String.format("INSERT INTO Horarios VALUES('%s','%d','%s')",
					horario.getHora(), horario.getSala(), horario.getDiasSemana());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Horario buscarHorario(Connection con, String hora) {
		String sql = String.format("SELECT * FROM Horarios WHERE Hora = '%s'", hora);
		Horario horario= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				String horaH = rs.getString("Hora");
				int sala = rs.getInt("Sala");
				String diasSemana = rs.getString("DiasSemana");
				horario = new Horario(horaH, sala, diasSemana);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horario;
	}
	
	
	
	public static List<Horario> obtenerListaHorario(Connection con){
		String sql = "SELECT * FROM Horarios";
		List<Horario> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String hora = rs.getString("Hora");
				int sala = rs.getInt("Sala");
				String diasSemana = rs.getString("DiasSemana");
				Horario horario = new Horario(hora, sala,diasSemana);
				l.add(horario);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	
	/**
	 * Metodo que cierra la base de datos
	 * @param con Conexion de labase de datos
	 */
	public static void cerrarBD(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
	
}
