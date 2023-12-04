import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Usuario;

public class UsuarioTest {
	private Usuario u;
	
	@Before
	public void setUp() {
		u = new Usuario("a", "a", "01-01-1970", "123", "a", "a", "0");
	}
	 
	@After
	public void tearDown() {
		u = null;
	}
	
//	@Test
//	public void testUsuario() {
//		u = new Usuario();
//		assertEquals(null, u.getNombre());
//		assertEquals(null, u.getApellido());
//		assertEquals(null, u.getFechaNacimiento());
//		assertEquals(null, u.getTlf());
//		assertEquals(null, u.getCorreoElectronico());
//		assertEquals(null, u.getContrasenia());
//		assertEquals(null, u.getContadorPuntos());
//	}
	
	@Test
	public void testSetNombre() {
		String nombre = "a";
		u.setNombre(nombre);
		assertEquals(nombre, u.getNombre());
	}
	
	@Test
	public void testSetApellido() {
		String apellido = "a";
		u.setApellido(apellido);
		assertEquals(apellido, u.getApellido());
	}
	
	@Test
	public void testSetFechaNacimiento() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date fechaNac = sdf.parse("01-01-1970");
			u.setFechaNacimiento(fechaNac);
			assertEquals(fechaNac, u.getFechaNacimiento());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testSetTlf() {
		String tlf = "123";
		u.setTlf(tlf);
		assertEquals(tlf, u.getTlf());
	}
	
	@Test
	public void testSetCorreoElectronico() {
		String ce = "a";
		u.setCorreoElectronico(ce);
		assertEquals(ce, u.getCorreoElectronico());
	}
	
	@Test
	public void testSetContrasenia() {
		String contrasenia = "a";
		u.setContrasenia(contrasenia);
		assertEquals(contrasenia, u.getContrasenia());
	}
	
	@Test
	public void testSetContadorPuntos() {
		String cp = "0";
		u.setContadorPuntos(cp);
		assertEquals(cp, u.getContadorPuntos());
	}
	
	@Test
	public void TestGetNombre() {
		assertEquals("a", u.getNombre());
	}
	
	@Test
	public void TestGetApellido() {
		assertEquals("a", u.getApellido());
	}
	
	@Test 
	public void TestGetFechaNacimiento() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d = sdf.parse("01-01-1970");
			assertEquals(d.getTime(), u.getFechaNacimiento().getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetFechaNacimientoStr() {
		assertEquals("01-01-1970", u.getFechaNacimientoStr());
	}
		
	
	@Test
	public void TestGetTlf() {
		assertEquals("123", u.getTlf());
	}
	
	@Test 
	public void TestGetCorreoElectronico() {
		assertEquals("a", u.getCorreoElectronico());
	}
	
	@Test
	public void TestGetContrasenia() {
		assertEquals("a", u.getContrasenia());
	}
	
	@Test 
	public void TestGetContadorPuntos() {
		assertEquals("0", u.getContadorPuntos());
	}
	
	@Test
	public void testToString() {
		u.setNombre("a");
		u.setApellido("a");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date fechaNac = sdf.parse("01-01-1970");
			u.setFechaNacimiento(fechaNac);
			assertEquals(fechaNac.getTime(), u.getFechaNacimiento().getTime());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		u.setTlf("123");
		u.setCorreoElectronico("a");
		u.setContrasenia("a");
		u.setContadorPuntos("0");
		String expectedToString = "Usuario [nombre=a, apellido=a, fechanacimiento=01-01-1970, tlf=123, correoElectronico=a, contraseña: a, Puntos:0]";
		assertEquals(expectedToString, u.toString());
	}
}
