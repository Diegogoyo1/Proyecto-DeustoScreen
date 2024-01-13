import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
		
		LocalDate ld = LocalDate.of(1970, 1, 1);
		u.setFechaNacimiento(ld);
		assertEquals(ld, u.getFechaNacimiento());
	
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
		Date d = new Date(0);
		assertEquals(sdf.format(d), sdf.format(u.getFechaNacimiento()));
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
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		LocalDate ld = LocalDate.of(1970, 1, 1);
		u.setFechaNacimiento(ld);
		assertEquals(0,ld.compareTo(u.getFechaNacimiento()));
		
		u.setTlf("123");
		u.setCorreoElectronico("a");
		u.setContrasenia("a");
		u.setContadorPuntos("0");
		String expectedToString = "Usuario [nombre=a, apellido=a, fechanacimiento=01-01-1970, tlf=123, correoElectronico=a, contraseña: a, Puntos:0]";
		assertEquals(expectedToString, u.toString());
	}
	
	@Test
	public void testEquals() throws ParseException {
			Usuario u1 = new Usuario("a", "a", "01-01-1970", "123", "a", "a", "0");
			Usuario u2 = new Usuario("a", "a", "01-01-1970", "123", "b", "a", "0");
			assertFalse(u.equals(u2));
			assertTrue(u.equals(u1));
			assertFalse(u.equals(null));
			assertTrue(u.equals(u));
	}
	
	@Test
	public void testHashCode() {
		assertNotEquals(-1, u.hashCode());
	}
	
	@Test
	public void testCompareTo() {
		
		assertEquals(0, u.compareTo(u));
		

	}
	@Test
	public void testActualizarPuntos(){
		int p = Integer.parseInt(u.getContadorPuntos());
		u.actualizarPuntos("3");
		assertEquals(p+3, Integer.parseInt(u.getContadorPuntos()));
	}
	
}
