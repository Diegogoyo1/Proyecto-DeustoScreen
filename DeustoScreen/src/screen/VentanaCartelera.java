package screen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import domain.Categoria;

public class VentanaCartelera extends JFrame {
	private JPanel pNorte, pSur, pEste, pOeste, pCentro;
	private JButton btnAtras,btnOppenheimer, btnBarbie, btnSawX, btnCampeonex, btnTrolls3;
	private JLabel lblPeliculas;
	private JScrollPane scrollVentana;
	private JFrame vAnterior, vActual;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	PanelConFondo panel;
	

	public VentanaCartelera(JFrame va) {
		super();
		vActual=this;
		vAnterior = va;
		
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new  JPanel();
		pOeste = new JPanel();
		pCentro = new JPanel();
		
		
		
		
		panel = new PanelConFondo(new ImageIcon("imagenes/FondoCartelera.jpg").getImage());
		
		panel.add(pNorte, BorderLayout.NORTH);
		panel.add(pSur, BorderLayout.SOUTH);
		panel.add(pEste, BorderLayout.EAST);
		panel.add(pOeste, BorderLayout.WEST);
		panel.add(pCentro, BorderLayout.CENTER);
		int espacioEntrePeneles = 200;
		pCentro.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
//		scrollVentana = new JScrollPane();
//		getContentPane().add(scrollVentana, BorderLayout.EAST);
		
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
			
		});
		
		
		
		btnOppenheimer = new JButton("Oppenhaimer");
		ImageIcon imOppenheimer = new ImageIcon("imagenes/Oppenheimer.jpg");
		btnOppenheimer.setIcon(imOppenheimer);
		btnOppenheimer.setPreferredSize(new Dimension(imOppenheimer.getIconWidth(), imOppenheimer.getIconHeight()));
		btnOppenheimer.setPreferredSize(new Dimension(250, 445));
		String textoOp ="En tiempos de guerra, el brillante físico estadounidense"
				+ " Julius Robert Oppenheimer (Cillian Murphy), al frente del \"Proyecto Manhattan\", "
				+ "lidera los ensayos nucleares para construir la bomba atómica para su país. "
				+ "Impactado por su poder destructivo, Oppenheimer se cuestiona las consecuencias "
				+ "morales de su creación. Desde entonces y el resto de su vida, se opondría "
				+ "firmemente al uso de armas nucleares.";
		btnOppenheimer.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON OPPENHAIMER");
			new VentanaPelicula(vActual, textoOp, "imagenes/PortadaOppenheimer.jpg", "OPPENHEIMER", "Oppenheimer", Categoria.ACCIÓN.toString(), "3h", "Cillian Murphy");
			vActual.setVisible(false);
			vActual.dispose();
			
			
		});
		
		
		btnBarbie = new JButton("Barbie");
		ImageIcon imBarbie = new ImageIcon("imagenes/Barbie.jpg");
		btnBarbie.setIcon(imBarbie);
		btnBarbie.setPreferredSize(new Dimension(imBarbie.getIconWidth(), imBarbie.getIconHeight()));
		btnBarbie.setPreferredSize(new Dimension(250, 445));
		btnBarbie.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON BARBIE");
			//new VentanaBarbie(vActual);
			String textoBa = "Barbie (Margot Robbie) lleva una vida ideal en \r\n"
					+ "Barbieland, allí todo es perfecto, con chupi fiestas llenas \r\n"
					+ "de música y color, y todos los días son el mejor día. Claro \r\n"
					+ "que Barbie se hace algunas preguntas, cuestiones bastante \r\n"
					+ "incómodas que no encajan con el mundo idílico en el que ella \r\n"
					+ "y las demás Barbies viven. Cuando Barbie se dé cuenta de que \r\n"
					+ "es capaz de apoyar los talones en el suelo, y tener los pies \r\n"
					+ "planos, decidirá calzarse unos zapatos sin tacones y viajar \r\n"
					+ "hasta el mundo real.";
			new VentanaPelicula(vActual, textoBa, "imagenes/PortadaBarbie.jpg", "BARBIE","Barbie", Categoria.COMEDIA.toString(), "1h 54m", "Margot Robie");
			vActual.setVisible(false);
			vActual.dispose();
			
			
		});
		
		
		btnSawX = new JButton("Saw X");
		ImageIcon imSawX = new ImageIcon("imagenes/SawX.jpg");
		btnSawX.setIcon(imSawX);
		btnSawX.setPreferredSize(new Dimension(imSawX.getIconWidth(), imSawX.getIconHeight()));
		btnSawX.setPreferredSize(new Dimension(250, 445));
		btnSawX.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON SAW X");
			String textoSX = "Situada entre los acontecimientos sucedidos en "
					+ "SAW y SAW II, John, desesperado y enfermo, viaja a México "
					+ "para someterse a un tratamiento experimental y muy arriesgado "
					+ "con la esperanza de curar su cáncer mortal. Sin embargo, toda la "
					+ "operación resulta ser un fraude para engañar a aquellos más "
					+ "vulnerables. Lleno de rabia y con un nuevo y escabroso propósito, "
					+ "John retomará su trabajo como asesino en serie y dará a probar su "
					+ "propia medicina a los embaucadores. Bajo la atenta mirada de Jigsaw, "
					+ "los jóvenes se enfrentaran a las trampas más ingeniosas, mortales y "
					+ "tortuosas en un visceral y despiadado juego";
			new VentanaPelicula(vActual, textoSX, "imagenes/SawX.jpg", " SAW X", "Saw X", Categoria.TERROR.toString(), "1h 58m", "Tobin Bell");
			vActual.setVisible(false);
			vActual.dispose();
			
		});
		
		
		btnCampeonex = new JButton("Campeonex");
		ImageIcon imCampeonex = new ImageIcon("imagenes/Campeonex.jpg");
		btnCampeonex.setIcon(imCampeonex);
		btnCampeonex.setPreferredSize(new Dimension(imCampeonex.getIconWidth(), imCampeonex.getIconHeight()));
		btnCampeonex.setPreferredSize(new Dimension(250, 445));
		btnCampeonex.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON CAMPEONEX");
			String textoCa = "Nuestro equipo de \"campeones\" abandona el baloncesto "
					+ "para adentrarse por error en el fascinante mundo del atletismo de la "
					+ "mano de una entrenadora novata. Entre las duras exigencias de la nueva "
					+ "disciplina y la sorprendente capacidad de la entrenadora para atraer "
					+ "todo tipo de desgracias y calamidades, todo acabará saliendo del revés.";
			new VentanaPelicula(vActual, textoCa, "imagenes/Campeonex.jpg", "CAMPEONEX", "Campeonex", Categoria.COMEDIA.toString(), "2h 4m", "Elisa Hipólito");
			vActual.setVisible(false);
			vActual.dispose();
			
		});
		
		
		btnTrolls3 = new JButton("Trolls 3");
		ImageIcon imTrolls3 = new ImageIcon("imagenes/Trolls3.jpg");
		btnTrolls3.setIcon(imTrolls3);
		btnTrolls3.setPreferredSize(new Dimension(imTrolls3.getIconWidth(), imTrolls3.getIconHeight()));
		btnTrolls3.setPreferredSize(new Dimension(250, 445));
		btnTrolls3.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON TROLLS 3");
			String textoTr = "Poppy y Branch son oficialmente, por fin, pareja. "
					+ " A medida que se relacionan, Poppy descubre que Branch "
					+ "tiene un pasado secreto. Una vez formó parte de su fenómeno boyband "
					+ "favorito, BroZone, con sus cuatro hermanos: Floyd, John Dory, "
					+ "Spruce y Clay. BroZone se disolvió cuando Branch era todavía un bebé, "
					+ "al igual que la familia, y Branch no ha vuelto a ver a sus hermanos "
					+ "desde entonces. Pero cuando Floyd, el hermano de Branch, es secuestrado "
					+ "por sus talentos musicales por un par de nefastos villanos estrellas del "
					+ "pop, Velvet y Veneer, Branch y Poppy se embarcan en un angustioso y "
					+ "emotivo viaje para reunir a los otros hermanos y rescatar a Floyd de un "
					+ "destino aún peor que la oscuridad de la cultura pop.";
			new VentanaPelicula(vActual, textoTr, "imagenes/PortadaTrolls3.jpg", "TROLLS3", "Trolls 3", Categoria.ANIMACIÓN.toString(), "1h 31m", "Justin Timberlake");
			vActual.setVisible(false);
			vActual.dispose();
			
		});
		
		
		lblPeliculas = new JLabel("PELICULAS");
		
		
		pSur.add(btnAtras);
		pNorte.add(lblPeliculas);
		pCentro.add(btnOppenheimer);
		pCentro.add(btnBarbie);
		pCentro.add(btnSawX);
		pCentro.add(btnCampeonex);
		pCentro.add(btnTrolls3);
		pCentro.setOpaque(false);
		pSur.setOpaque(false);
		pNorte.setOpaque(false);
		
		
		
		
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("PELICULAS");
		setContentPane(panel);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new VentanaCartelera(null);
	}


}
