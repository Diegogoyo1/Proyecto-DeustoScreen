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
			Date d = sdf.parse("01-001-1970");
			assertEquals(d.getTime(), u.getFechaNacimiento().getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
