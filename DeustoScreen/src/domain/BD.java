package domain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	/**
	 * Metodo que crea las tablas de la Base de Datos
	 * @param con Conexion de la base de datos
	 * @throws SQLException Excepcion si no se actualiza la tabla en la base de datos
	 */
	public static void crearTabla (Connection con) throws SQLException{
		String sqlUsuario = "CREATE TABLE IF NOT EXISTS Usuario (Nombre String, Apellido String,FechaNacimiento String, Teléfono String,CorreoElectronico String,Contrasenia String,ContadorPuntos String )";
		String sqlPeliculas = "CREATE TABLE IF NOT EXISTS Peliculas (titulo String, Reparto String,Duracion String, FechaDeEstreno String, Categoria String )";
		String sqlActorres = "CREATE TABLE IF NOT EXISTS Actores(nombre String , FechaNacimiento String )";
		String sqlHorarios = "CREATE TABLE IF NOT EXISTS Horarios()";
		String sqlTrabajador = "CREATE TABLE IF NOT EXISTS Trabajador(NombreApellidosTrabajor String, Dni String, CotraseniaTrabajador String, TelefonoTrabajador String, Puesto PuestoTrabajo, HorasTrabajadas double, Sueldo double)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sqlUsuario);
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
				String sql = String.format("INSERT INTO USUARIO VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s')", 
						usuario.getNombre(), usuario.getApellido(), usuario.getTlf(),usuario.getCorreoElectronico(),usuario.getContrasenia(),usuario.getContadorPuntos());
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
		String sql = String.format("SELECT * FROM USUARIO WHERE CorreoElectronico = '%s'", CorreoElectronico);
		Usuario usuario= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellidos");
				String fNac = rs.getString("fechaNacimiento");
				String tlf = rs.getString("Teléfono");
				String CorreoEle = rs.getString("CorreoElectronico");
				String contrasenia = rs.getString("Contraseña");
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
			String sql = String.format("INSERT INTO TRABAJADOR VALUES('%s','%s','%s','%s','%s','%,.2f','%,.2f')",
					trabajador.getNombreApellidosTrabajador(), trabajador.getDni(), trabajador.getContraseniaTrabajador(), trabajador.getTelefonoTrabajador(), trabajador.getPuesto(), trabajador.getHorasTrabajadas(), trabajador.getSueldo());
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
		String sql = String.format("SELECT * FROM TRABAJADOR WHERE Dni = '%s'", dni);
		Trabajador trabajador = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				String nombreApellidosTrabajador = rs.getString("NombreApellidos");
				String dniTra = rs.getString("Dni");
				String contraseniaTrabajador = rs.getString("Contraseña");
				String telefonoTrabajador = rs.getString("Telefono");
				String puesto = rs.getString("Puesto");
				String horasTrabajadas = rs.getString("HorasTrabajadas");
				String sueldo = rs.getString("Sueldo");	
			}
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				String horasTrabajadas = rs.getString("HorasTrabajadas");
				String sueldo = rs.getString("Sueldo");
				String nombreApellidosTrabajador = rs.getString("nombreApellidosTrabajador");
				String telefonoTrabajador = rs.getString("telefonoTrabajador");
				String contraseniaTrabajador = rs.getString("contraseniaTrabajador");
				String dni = rs.getString("dni");
				String puesto = rs.getString("Puesto");
				Trabajador trabajador = new Trabajador(horasTrabajadas, sueldo, nombreApellidosTrabajador, telefonoTrabajador, contraseniaTrabajador, dni, puesto);
				lt.add(trabajador);					
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lt;
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
