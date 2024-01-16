import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import domain.Compra;
import domain.Usuario;

public class CompraTest {
	private Compra c;
	private Usuario u;
	
	@Before
	public void setUp() {
		u = new Usuario("a", "a", "01-01-1970", "123", "a", "a", "0");
		c = new Compra (u, "10:00", "Oppenheimer", 1, 2, "A1,B2");
	}
	
	@Test
	public void testSetUsuario() {
		Usuario u = new Usuario("a", "a", "01-01-1970", "123", "a", "a", "0");
		c.setUsuario(u);
		assertEquals(u, c.getUsuario());
	}
	
	@Test
	public void testSetHora() {
		String hora = "10:00";
		c.setHora(hora);
		assertEquals(hora, c.getHora());
	}
	
	@Test
	public void testSetPelicula() {
		String pelicula = "Oppenheimer";
		c.setPelicula(pelicula);
		assertEquals(pelicula, c.getPelicula());
	}
	
	@Test
	public void testSetSala() {
		int sala = 1;
		c.setSala(sala);
		assertEquals(sala, c.getSala());
	}
	
	@Test
	public void testSetNumentradas() {
		int NumEntradas = 2;
		c.setNumEntradas(NumEntradas);
		assertEquals(NumEntradas, c.getNumEntradas());
	}
	
	@Test
	public void testSetAsientos() {
		String asientos = "A1,B2";
		c.setAsientos(asientos);
		assertEquals(asientos, c.getAsientos());
	}
	
	@Test
	public void testGetUsuario() {
		assertEquals(u, c.getUsuario());
	}
	
	@Test
	public void testGetHora() {
		assertEquals("10:00", c.getHora());
	}
	
	@Test
	public void testGetPelicula() {
		assertEquals("Oppenheimer", c.getPelicula());
	}
	
	@Test
	public void testGetSala() {
		assertEquals(1, c.getSala());
	}
	
	@Test 
	public void testGetNumEntradas() {
		assertEquals(2, c.getNumEntradas());
	}
	
	@Test
	public void testGetAsientos() {
		assertEquals("A1,B2", c.getAsientos());
	}
	
	@Test
	public void testToString() {
		Usuario u = new Usuario("a", "a", "01-01-1970", "123", "a", "a", "0");
		c.setUsuario(u);
		c.setHora("10:00");
		c.setPelicula("Oppenheimer");
		c.setSala(1);
		c.setNumEntradas(2);
		c.setAsientos("A1,B2");
		String expectedToString = "Compra [usuario=" + u +", hora=10:00, pelicula=Oppenheimer, sala=1, numEntradas=2, asientos=A1,B2]";
		assertEquals(expectedToString, c.toString());
	}
	
	
	
}
