package screen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;

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
	
	
	
	


	public VentanaCartelera(JFrame va) {
		super();
		vActual=this;
		vAnterior = va;
		
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new  JPanel();
		pOeste = new JPanel();
		pCentro = new JPanel();
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste, BorderLayout.EAST);
		getContentPane().add(pOeste, BorderLayout.WEST);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		int espacioEntrePeneles = 200;
		pCentro.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
		scrollVentana = new JScrollPane();
		getContentPane().add(scrollVentana, BorderLayout.EAST);
		
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
			
		});
		
		
		
		btnOppenheimer = new JButton("Oppenhaimer");
		ImageIcon imOppenheimer = new ImageIcon("src/imagenes/Oppenheimer.jpg");
		btnOppenheimer.setIcon(imOppenheimer);
		btnOppenheimer.setPreferredSize(new Dimension(imOppenheimer.getIconWidth(), imOppenheimer.getIconHeight()));
		btnOppenheimer.setPreferredSize(new Dimension(250, 445));
		btnOppenheimer.addActionListener((e)->{
			new VentanaOppenheimer(vActual);
			vActual.setVisible(false);
			vActual.dispose();
			
			
		});
		
		
		btnBarbie = new JButton("Barbie");
		ImageIcon imBarbie = new ImageIcon("src/imagenes/Barbie.jpg");
		btnBarbie.setIcon(imBarbie);
		btnBarbie.setPreferredSize(new Dimension(imBarbie.getIconWidth(), imBarbie.getIconHeight()));
		btnBarbie.setPreferredSize(new Dimension(250, 445));
		btnBarbie.addActionListener((e)->{
			//new VentanaBarbie(vActual);
			String texto = "Barbie (Margot Robbie) lleva una vida ideal en \r\n"
					+ "Barbieland, allí todo es perfecto, con chupi fiestas llenas \r\n"
					+ "de música y color, y todos los días son el mejor día. Claro \r\n"
					+ "que Barbie se hace algunas preguntas, cuestiones bastante \r\n"
					+ "incómodas que no encajan con el mundo idílico en el que ella \r\n"
					+ "y las demás Barbies viven. Cuando Barbie se dé cuenta de que \r\n"
					+ "es capaz de apoyar los talones en el suelo, y tener los pies \r\n"
					+ "planos, decidirá calzarse unos zapatos sin tacones y viajar \r\n"
					+ "hasta el mundo real.";
			new VentanaBarbie(vActual, texto, "src\\Imagenes\\PortadaBarbie.jpg", "BARBIE","Barbie", Categoria.COMEDIA.toString(), "1h 54m", "Margot Robie");
			vActual.setVisible(false);
			vActual.dispose();
			
			
		});
		
		
		btnSawX = new JButton("Saw X");
		ImageIcon imSawX = new ImageIcon("src/imagenes/SawX.jpg");
		btnSawX.setIcon(imSawX);
		btnSawX.setPreferredSize(new Dimension(imSawX.getIconWidth(), imSawX.getIconHeight()));
		btnSawX.setPreferredSize(new Dimension(250, 445));
		btnSawX.addActionListener((e)->{
			new VentanaSawX(vActual);
			vActual.setVisible(false);
			vActual.dispose();
			
		});
		
		
		btnCampeonex = new JButton("Campeonex");
		ImageIcon imCampeonex = new ImageIcon("src/imagenes/Campeonex.jpg");
		btnCampeonex.setIcon(imCampeonex);
		btnCampeonex.setPreferredSize(new Dimension(imCampeonex.getIconWidth(), imCampeonex.getIconHeight()));
		btnCampeonex.setPreferredSize(new Dimension(250, 445));
		btnCampeonex.addActionListener((e)->{
			new VentanaCampeonex(vActual);
			vActual.setVisible(false);
			vActual.dispose();
			
		});
		
		
		btnTrolls3 = new JButton("Trolls 3");
		ImageIcon imTrolls3 = new ImageIcon("src/imagenes/Trolls3.jpg");
		btnTrolls3.setIcon(imTrolls3);
		btnTrolls3.setPreferredSize(new Dimension(imTrolls3.getIconWidth(), imTrolls3.getIconHeight()));
		btnTrolls3.setPreferredSize(new Dimension(250, 445));
		btnTrolls3.addActionListener((e)->{
			new VentanaTrolls3(vActual);
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
		
		
		
		
		
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("PELICULAS");
		//setContentPane(va);
		setVisible(true);
		
		
		
	}
	
	


}
