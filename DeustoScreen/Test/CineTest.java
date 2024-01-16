

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Cine;
import domain.Compra;
import domain.Usuario;

public class CineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetM1() {
		assertNotNull(Cine.getM1());
	}

	@Test
	public void testSetM1() {
		Cine.setM1(null);
		assertNull(Cine.getM1());
	}

	@Test
	public void testGuardarMapaCompras() {
		Cine.guardarMapaCompras("ficheros/prueba.dat");
		File f = new File("ficheros/prueba.dat");
		assertTrue(f.exists());
	}

	@Test
	public void testCargarMapaCompras() {
		Cine.cargarMapaCompras("ficheros/prueba.dat");
		assertNotNull(Cine.getMapaCompras());
	}

	@Test
	public void testGuardarButacasEnFichero() {
		Cine.guardarButacasEnFichero("ficheros/prueba.csv");
		File f = new File("ficheros/prueba.csv");
		assertTrue(f.exists());
	}

	@Test
	public void testCargarButacasDesdeFichero() {
		Cine.cargarButacasDesdeFichero("ficheros/ButacasSala1_14_1_2024_1-16_00.dat");
		assertNotNull(Cine.getM1());
	}

	@Test
	public void testGetMapaHorarios() {
		assertNotNull(Cine.getMapaHorarios());
	}

	@Test
	public void testCrearMapaHorarios() {
		Cine.crearMapaHorarios();
		assertNotNull(Cine.getMapaHorarios());
		
	}

	@Test
	public void testGetListaUsuarios() {
		assertNotNull(Cine.getListaUsuarios());
	}

	@Test
	public void testGetTitulosPeliculas() {
		assertNotNull(Cine.getTitulosPeliculas());
	}

	@Test
	public void testGetMapaCompras() {
		assertNotNull(Cine.getMapaCompras());
	}

	@Test
	public void testAniadirUsuario() {
		int tam = Cine.getListaUsuarios().size();
		Cine.aniadirUsuario(new Usuario("A", "A", "10-10-2000", "123456789", "A@A.com", "Aa-20", "0"));
		int tam2 = Cine.getListaUsuarios().size();
		assertTrue(tam+1==tam2);
	}

	@Test
	public void testOrdenarListaUsuarios() {
		Cine.cargarUsuarioEnLista("ficheros/Usuarios.csv");
		Cine.ordenarListaUsuarios();
		assertTrue(Cine.getListaUsuarios().get(0).getCorreoElectronico().compareTo(Cine.getListaUsuarios().get(1).getCorreoElectronico())<0);
	}

	@Test
	public void testAniadirCompra() {
		int tam = Cine.getMapaCompras().size();
		Cine.aniadirCompra(new Usuario("A", "A", "10-10-2000", "123456789", "A@A.com", "Aa-20", "0"), new Compra(new Usuario("A", "A", "10-10-2000", "123456789", "A@A.com", "Aa-20", "0"), "10:00", "Oppenheimer", 1, 4, "A1,B2"));
		int tam2 = Cine.getMapaCompras().size();
		assertTrue(tam+1==tam2);
	}


	@Test
	public void testBuscarUsuario() {
		Cine.aniadirUsuario(new Usuario("A", "A", "10-10-2000", "123456789", "A@A.com", "Aa-20", "0"));
		Usuario u = Cine.buscarUsuario("A@A.com");
		assertNotNull(u);
		u = Cine.buscarUsuario("");
		assertNull(u);
		
	}

	@Test
	public void testCargarUsuarioEnLista() {
		Cine.cargarUsuarioEnLista("ficheros/Usuarios.csv");
		assertNotNull(Cine.getListaUsuarios());
	}

	@Test
	public void testGuardarUsuariosEnFichero() {
	
	}

	
	@Test
	public void testRegistroUsuario() {
		assertFalse(Cine.registroUsuario("ficheros/Usuarios.csv","B", "B", "10-10-2000", "123456789", "B@B.com", "Aa-20", "0",null));
	}


	@Test
	public void testObtenerTitulos() {
	}

	@Test
	public void testActualizarPuntosUsuarios() {
	}

	@Test
	public void testBuscarTrabajador() {
	}

	@Test
	public void testCargarTrabajadoresEnLista() {
	}

	@Test
	public void testIsValidEmail() {
	}

	@Test
	public void testIsValidContrasenia() {
		
	}

	@Test
	public void testGetMapaPeliculas() {
	}

	@Test
	public void testCrearMapaPeliculas() {
	}

	@Test
	public void testGetSumaPuntos() {
		
	}

}
