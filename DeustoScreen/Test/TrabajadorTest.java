import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import domain.PuestoTrabajo;
import domain.Trabajador;

public class TrabajadorTest {
	private Trabajador t;

	@Before
	public void setUp() {
		t = new Trabajador("79117182B", "Nicolás Presa", "670296434", "79117182B", PuestoTrabajo.JEFE, 3000.00 );
	}
	
	@Test
	public void testSetDni() {
		String dni = "79117182B";
		t.setDni(dni);
		assertEquals(dni, t.getDni());
	}
	
	@Test
	public void testSetNombreApellidos() {
		String nombreApellidos = "Nicolás Presa";
		t.setNombreApellidosTrabajador(nombreApellidos);
		assertEquals(nombreApellidos, t.getNombreApellidosTrabajador());
	}
	
	@Test
	public void testSetTelefono() {
		String telefono = "670296434";
		t.setTelefonoTrabajador(telefono);
		assertEquals(telefono, t.getTelefonoTrabajador());
	}
	
	@Test
	public void testSetContrasenia() {
		String contrasenia = "79117182B";
		t.setContraseniaTrabajador(contrasenia);
		assertEquals(contrasenia, t.getContraseniaTrabajador());
	}
	
	@Test
	public void testSetPuestoTrabajo() {
		PuestoTrabajo puestoTrabajo = PuestoTrabajo.JEFE;
		t.setPuesto(puestoTrabajo);
		assertEquals(puestoTrabajo, t.getPuesto());
	}
	
	@Test
	public void testSetSueldo() {
		double sueldo = 3000.00;
		t.setSueldo(sueldo);
		assertTrue(sueldo - t.getSueldo()==0);
	}
	
	@Test
	public void testGetDni() {
		assertEquals("79117182B", t.getDni());
	}
	
	@Test 
	public void testGetNombreApellidos() {
		assertEquals("Nicolás Presa", t.getNombreApellidosTrabajador());
	}
	
	@Test
	public void testeGetTelefono() {
		assertEquals("670296434", t.getTelefonoTrabajador());
	}
	
	@Test
	public void testGetContrasenia() {
		assertEquals("79117182B", t.getContraseniaTrabajador());
	}
	
	@Test
	public void testGetPuestoTrabajo() {
		assertEquals(PuestoTrabajo.JEFE, t.getPuesto());
	}
	
	@Test
	public void testGetSueldo() {
		assertTrue(3000.00-t.getSueldo()==0);
	}
	
	@Test
	public void testToString() {
		t.setDni("79117182B");
		t.setNombreApellidosTrabajador("Nicolás Presa");
		t.setTelefonoTrabajador("670296434");
		t.setContraseniaTrabajador("79117182B");
		t.setPuesto(PuestoTrabajo.JEFE);
		t.setSueldo(3000.00);
		String expectedToString = "Trabajador [dni=79117182B, nombreApellidos=Nicolás Presa, telefono=670296434, contrasenia=79117182B, puesto=" + PuestoTrabajo.JEFE + ", sueldo=" + 3000.00 + "]";
		assertEquals(expectedToString, t.toString());
	}

}
