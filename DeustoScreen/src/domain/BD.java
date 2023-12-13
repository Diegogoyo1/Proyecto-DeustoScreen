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
 * 
 * @param nombreBD
 * @return
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


	public static void crearTabla (Connection conn) throws SQLException{
		String sqlUsuario = "CREATE TABLE IF NOT EXISTS Usuario (Nombre String, Apellido String,FechaNacimiento String, Teléfono String,CorreoElectronico String,Contrasenia String,ContadorPuntos String )";
		String sqlPeliculas = "CREATE TABLE IF NOT EXISTS Peliculas (titulo String, Reparto String,Duracion String, FechaDeEstreno String,Categoria String )";
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sqlUsuario);
			st.close();

		} catch (SQLException e) {
			throw e;
		}
	}

		public static void insertarUsuario(Connection con, Usuario usuario){

			if(buscarUsario(con,usuario.getCorreoElectronico())==null){
				String sql = String.format("INSERT INTO USUARIO VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s')", usuario.getNombre(), usuario.getApellido(), usuario.getTlf(),
						usuario.getCorreoElectronico(),usuario.getContrasenia(),usuario.getContadorPuntos());
				try {
					Statement st = con.createStatement();
					st.executeUpdate(sql);
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


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
				String contrasenia = rs.getString("Contraseña");
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

	
	public static void cerrarBD(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
