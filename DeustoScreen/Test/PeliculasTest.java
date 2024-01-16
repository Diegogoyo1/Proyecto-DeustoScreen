import static org.junit.Assert.assertEquals; 
import org.junit.Before;
import org.junit.Test;

import domain.Categoria;
import domain.Pelicula;

public class PeliculasTest { 
	private Pelicula p;
	


	@Before
	public void setUp() {
		 p = new Pelicula("Oppenheimer",  "OPPENHEIMER","imagenes/Oppenheimer.jpg" , "imagenes/PortadaOppenheimer.jpg",
				 "En tiempos de guerra, el brillante fisico estadounidense...", Categoria.ACCION, "3h", "Cillian Murphy");

	}
	
	
	
	@Test
	public void testSetTituloPelicula() {
		String tituloPelicula = "Oppenheimer";
		p.setTituloPelicula(tituloPelicula);
		assertEquals(tituloPelicula, p.getTituloPelicula());
	}
	
	@Test 
	public void testSetTituloVentana() {
		String tituloVentana = "OPPENHEIMER";
		p.setTituloVentana(tituloVentana);
		assertEquals(tituloVentana, p.getTituloVentana());
	}
	
	@Test
	public void testSetImagenCartelera() {
		String imagenCartelera = "imagenes/Oppenheimer.jpg";
		p.setImagenCartelera(imagenCartelera);
		assertEquals(imagenCartelera, p.getImagenCartelera());
	}
	@Test 
	public void testSetImagenPelicula() {
		String imagenPelicula = "imagenes/PortadaOppenheimer.jpg";
		p.setImagenPelicula(imagenPelicula);
		assertEquals(imagenPelicula, p.getImagenPelicula());
	}
	
	@Test
	public void testSetDescripcion() {
		String descripcion = "En tiempos de guerra, el brillante fisico estadounidense...";
		p.setDescripcion(descripcion);
		assertEquals(descripcion, p.getDescripcion());
	}
	
	@Test
	public void testSetCategoria() {
		Categoria categoria = Categoria.ACCION;
		p.setCategoria(categoria);
		assertEquals(categoria, p.getCategoria());
	}
	
	@Test
	public void testSetDuracion() {
		String duracion = "3h";
		p.setDuracion(duracion);
		assertEquals(duracion, p.getDuracion());
	}
	
	@Test
	public void testSetReparto() {
		String reparto = "Cillian Murphy";
		p.setReparto(reparto);
		assertEquals(reparto, p.getReparto());
	}
	
	@Test
	public void testGetTituloPelicula() {
		assertEquals("Oppenheimer", p.getTituloPelicula());
		
	}
	
	@Test
	public void testGetTituloVentana() {
		assertEquals("OPPENHEIMER", p.getTituloVentana());
	}
	
	@Test
	public void testGetImagenCartelera() {
		assertEquals("imagenes/Oppenheimer.jpg", p.getImagenCartelera());
	}
	
	@Test
	public void testGetImagenPelicula() {
		assertEquals("imagenes/PortadaOppenheimer.jpg", p.getImagenPelicula());
	}
	
	@Test
	public void testGetDescripcion() {
		assertEquals("En tiempos de guerra, el brillante fisico estadounidense...", p.getDescripcion());
	}
	
	@Test
	public void testGetCategoria() {
		assertEquals(Categoria.ACCION, p.getCategoria());
	}
	
	@Test
	public void testGetDuracion() {
		assertEquals("3h", p.getDuracion());
	}
	
	@Test
	public void testGetReparto() {
		assertEquals("Cillian Murphy", p.getReparto());
	}
	
	@Test
	public void testToString() {
		p.setTituloPelicula("Oppenheimer");
		p.setTituloVentana("OPPENHEIMER");
		p.setImagenCartelera("imagenes/Oppenheimer.jpg");
		p.setImagenPelicula("imagenes/PortadaOppenheimer.jpg");
		p.setDescripcion("En tiempos de guerra, el brillante fisico estadounidense...");
		p.setCategoria(Categoria.ACCION);
		p.setDuracion("3h");
		p.setReparto("Cillian Murphy");
		String expectedToString = "Pelicula [id=1,tituloPelicula=Oppenheimer, tituloVentana=OPPENHEIMER, imagenCartelera=imagenes/Oppenheimer.jpg, imagenPelicula=imagenes/PortadaOppenheimer.jpg, descripcion=En tiempos de guerra, el brillante fisico estadounidense..., categoria=" + Categoria.ACCION + ", duracion=3h, reparto=Cillian Murphy]";		
		assertEquals(expectedToString, p.toString());
	}
	
	
	
	
	/*@Test
	public void testGetReparto() {
		List<String> actores = Arrays.asList();
		assertEquals(actores, p.getReparto());
	}*/

}
