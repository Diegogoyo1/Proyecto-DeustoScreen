import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

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
	public void TestGetNombreActor() {
		assertEquals("Cillian Murphy", a.getNombreActor());
	} 
	
	@Test 
	public void TestGetFechaNacimientoAct() {
		assertEquals(LocalDate.of(1976, 05, 25), a.getFechaNacimientoAct());
	}

}

