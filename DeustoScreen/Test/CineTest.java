import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import domain.Cine;
import domain.Entrada;
import domain.Usuario;

import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;

	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.TreeMap;

	import org.junit.Before;
	import org.junit.Test;

	public class CineTest {

	    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	    @Before
	    public void setUpStreams() {
	        System.setOut(new PrintStream(outContent));
	        System.setErr(new PrintStream(errContent));
	    }

	    /*@Test
	    public void testAniadirEntrada() {
	        Cine.crearMapaHorarios();  // Asegúrate de que el mapa de horarios esté inicializado
	        Entrada entrada = new Entrada("Pelicula1", "Sala1", "Horario1");
	        Cine.aniadirEntrada(entrada);
	        assertTrue(Cine.getEntradas().contains(entrada));
	    }*/

	   /* @Test
	    public void testImprimirEntrada() {
	        Cine.crearMapaHorarios();  // Asegúrate de que el mapa de horarios esté inicializado
	        Entrada entrada = new Entrada("Pelicula1", "Sala1", "Horario1");
	        Cine.aniadirEntrada(entrada);
	        Cine.imprimirEntrada();
	        assertTrue(outContent.toString().contains(entrada.toString()));
	    }*/

	    @Test
	    public void testAniadirUsuario() {
	        Usuario usuario = new Usuario("Nombre", "Apellido", "FechaNacimiento", "Telefono", "CorreoElectronico", "Contrasenia", "ContadorPuntos");
	        Cine.aniadirUsuario(usuario);
	        assertTrue(Cine.getListaUsuarios().contains(usuario));
	    }

	    @Test
	    public void testImprimirUsuario() {
	        Usuario usuario = new Usuario("Nombre", "Apellido", "FechaNacimiento", "Telefono", "CorreoElectronico", "Contrasenia", "ContadorPuntos");
	        Cine.aniadirUsuario(usuario);
	        Cine.imprimirUsuario();
	        assertTrue(outContent.toString().contains(usuario.toString()));
	    }

	   /* @Test
	    public void testAniadirCompra() {
	        Usuario usuario = new Usuario("Nombre", "Apellido", "FechaNacimiento", "Telefono", "CorreoElectronico", "Contrasenia", "ContadorPuntos");
	        Entrada entrada = new Entrada("Pelicula1", "Sala1", "Horario1");
	        Cine.aniadirCompra(usuario, entrada);
	        assertTrue(Cine.getMapaCompras().containsKey(usuario));
	        assertTrue(Cine.getMapaCompras().get(usuario).contains(entrada));
	    }*/

	    /*@Test
	    public void testImprimirCompras() {
	        Usuario usuario = new Usuario("Nombre", "Apellido", "FechaNacimiento", "Telefono", "CorreoElectronico", "Contrasenia", "ContadorPuntos");
	        Entrada entrada = new Entrada("Pelicula1", "Sala1", "Horario1");
	        Cine.aniadirCompra(usuario, entrada);
	        Cine.imprimirCompras();
	        assertTrue(outContent.toString().contains(usuario.toString()));
	        assertTrue(outContent.toString().contains(entrada.toString()));
	    }*/

	    @Test
	    public void testBuscarUsuario() {
	        Usuario usuario = new Usuario("Nombre", "Apellido", "FechaNacimiento", "Telefono", "CorreoElectronico", "Contrasenia", "ContadorPuntos");
	        Cine.aniadirUsuario(usuario);
	        assertEquals(usuario, Cine.buscarUsuario("CorreoElectronico", "Contrasenia"));
	    }
	    
	}