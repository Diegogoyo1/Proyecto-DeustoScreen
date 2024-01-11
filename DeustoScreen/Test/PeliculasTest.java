import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Actores;
import domain.Categoria;
import domain.Pelicula;

public class PeliculasTest { 
	private Pelicula p;
	
	@Before
	public void setUp() {
		 p = new Pelicula("Oppenheimer", new ArrayList<Actores>(), "3h", "21-07-2023", Categoria.ACCIÓN);

	}
	
	
	@Test
	public void testSetNombre() {
		String nombre = "Oppenheimer";
		p.setNombrePeli(nombre);
		assertEquals(nombre, p.getNombrePeli());
	}
	
	@Test
	public void testSetReparto() {
		
	}
	
	@Test
	public void testSetDuracion() {
		String duracion = "3h";
		p.setDuracion(duracion);
		assertEquals(duracion, p.getDuracion());
	}
	
	@Test
	public void testSetFechaEstreno() {
		
	}
	
	@Test
	public void testSetCategoria() {
		Categoria categoria = Categoria.ACCIÓN;
		p.setCategoria(categoria);
		assertEquals(categoria, p.getCategoria());
	}
	
	@Test
	public void testGetNombrePeli() {
		assertEquals("Oppenheimer", p.getNombrePeli());
		
	}
	
	@Test
	public void testGetReparto() {
		List<String> actores = Arrays.asList();
		assertEquals(actores, p.getReparto());
		
	}
	
	@Test
	public void testGetDuracion() {
		assertEquals("3h", p.getDuracion());
		
	}
	
	@Test 
	public void testGetFechaEstreno() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d = sdf.parse("21-07-2023");
			assertEquals(d.getTime(), p.getFechaEstreno().getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetCategoria() {
		assertEquals(Categoria.ACCIÓN, p.getCategoria());
	}

}
