import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import domain.Actores;

public class ActoresTest {
	private Actores a;
	
	@Before
	public void setUp() {
		a = new Actores("Cillian Murphy", "25-05-1976");
	}
	
	@Test
	public void testSetNombreActor() {
		String actor = "Cillian Murphy";
		a.setNombreActor(actor);
		assertEquals(actor, a.getNombreActor());
	}
	
	@Test
	public void testSetFechaNacimiento() {
		
	}
	
	
	@Test
	public void TestGetNombreActor() {
		assertEquals("Cillian Murphy", a.getNombreActor());
	} 
	
	@Test 
	public void TestGetFechaNacimientoAct() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d = sdf.parse("25-05-1976");
			assertEquals(d.getTime(), a.getFechaNacimientoAct().getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

