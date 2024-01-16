import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import domain.Horario;

public class HorarioTest {
	private Horario h;
	
	@Before
	public void setUp() {
		h = new Horario ("10:00", 1, "lunes,martes,miercoles,jueves,viernes,sabado,domingo");
	}
	
	@Test 
	public void testSetHora() {
		String hora = "10:00";
		h.setHora(hora);
		assertEquals(hora, h.getHora());
	}
	
	@Test
	public void testSetSala() {
		int sala = 1;
		h.setSala(sala);
		assertEquals(sala, h.getSala());
	}
	
	@Test
	public void testSetDiasSemana() {
		String diasSemana = "lunes,martes,miercoles,jueves,viernes,sabado,domingo";
		h.setDiasSemana(diasSemana);
		assertEquals(diasSemana, h.getDiasSemana());
	}
	
	@Test
	public void testGetHora() {
		assertEquals("10:00", h.getHora());
	}
	
	@Test
	public void testGetSala() {
		assertEquals(1, h.getSala());
	}
	
	@Test
	public void testGetDiasSemana() {
		assertEquals("lunes,martes,miercoles,jueves,viernes,sabado,domingo", h.getDiasSemana());
	}
	
	@Test
	public void testToString() {
		h.setHora("10:00");
		h.setSala(1);
		h.setDiasSemana("lunes,martes,miercoles,jueves,viernes,sabado,domingo");
		String expectedToString = "Horario [hora=10:00, sala=1, diasSemana=lunes,martes,miercoles,jueves,viernes,sabado,domingo]";
		assertEquals(expectedToString, h.toString());
	}
	
}
