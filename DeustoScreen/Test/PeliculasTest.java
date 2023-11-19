import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import domain.Actores;
import domain.Categoria;
import domain.Peliculas;

public class PeliculasTest { 
	Peliculas p = new Peliculas("Oppenheimer", new ArrayList<Actores>(), "3h", "21-07-2023", Categoria.ACCIÓN);
	
	@Test
	public void TestGetNombrePeli() {
		assertEquals("Oppenheimer", p.getNombrePeli());
		
	}
	
	@Test
	public void TestGetReparto() {
		List<String> actores = Arrays.asList("Cillian Murphy", "Emily Blunt", "Matt Damon","Robert Downey Jr.");
		assertEquals(actores, p.getReparto());
		
	}
	
	@Test
	public void TestGetDuracion() {
		assertEquals("3h", p.getDuracion());
		
	}
	
	@Test
	public void TestGetFechaEstreno() {
		assertEquals(LocalDate.of(2023, 07, 21), p.getFechaEstreno());
		
	}
	
	@Test
	public void TestGetCategoria() {
		assertEquals(Categoria.ACCIÓN, p.getCategoria());
	}

}
