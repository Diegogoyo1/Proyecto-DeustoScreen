package Screen;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaCartelera extends JFrame {
	protected JPanel pNorte, pSur, pEste, pOeste, pCentro;
	protected JButton btnAtras,btnOppenheimer, btnBarbie, btnSawX, btnCampeonex, btnTrolls3;
	protected JLabel lblPeliculas;
	
	
	public VentanaCartelera() {
		
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
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e)->{
			dispose();
			
		});
		
		
		
		btnOppenheimer = new JButton("Oppenhaimer");
		ImageIcon imOppenheimer = new ImageIcon("src\\Imagenes\\Oppenheimer.jpg");
		btnOppenheimer.setIcon(imOppenheimer);
		btnOppenheimer.setPreferredSize(new Dimension(imOppenheimer.getIconWidth(), imOppenheimer.getIconHeight()));
		btnOppenheimer.setPreferredSize(new Dimension(250, 445));
		btnOppenheimer.addActionListener((e)->{
			VentanaOppenheimer ventanaOppenheimer = new VentanaOppenheimer();
			ventanaOppenheimer.setVisible(true);
			
		});
		
		
		btnBarbie = new JButton("Barbie");
		ImageIcon imBarbie = new ImageIcon("src\\Imagenes\\Barbie.jpg");
		btnBarbie.setIcon(imBarbie);
		btnBarbie.setPreferredSize(new Dimension(imBarbie.getIconWidth(), imBarbie.getIconHeight()));
		btnBarbie.setPreferredSize(new Dimension(250, 445));
		btnBarbie.addActionListener((e)->{
			VentanaBarbie ventanaBarbie = new VentanaBarbie();
			ventanaBarbie.setVisible(true);
			
			
		});
		
		
		btnSawX = new JButton("Saw X");
		ImageIcon imSawX = new ImageIcon("src\\Imagenes\\SawX.jpg");
		btnSawX.setIcon(imSawX);
		btnSawX.setPreferredSize(new Dimension(imSawX.getIconWidth(), imSawX.getIconHeight()));
		btnSawX.setPreferredSize(new Dimension(250, 445));
		btnSawX.addActionListener((e)->{
			VentanaSawX ventanaSawX = new VentanaSawX();
			ventanaSawX.setVisible(true);
			
		});
		
		
		btnCampeonex = new JButton("Campeonex");
		ImageIcon imCampeonex = new ImageIcon("src\\Imagenes\\Campeonex.jpg");
		btnCampeonex.setIcon(imCampeonex);
		btnCampeonex.setPreferredSize(new Dimension(imCampeonex.getIconWidth(), imCampeonex.getIconHeight()));
		btnCampeonex.setPreferredSize(new Dimension(250, 445));
		btnCampeonex.addActionListener((e)->{
			VentanaCampeonex ventanaCampeonex = new VentanaCampeonex();
			ventanaCampeonex.setVisible(true);
			
		});
		
		
		btnTrolls3 = new JButton("Trolls 3");
		ImageIcon imTrolls3 = new ImageIcon("src\\Imagenes\\Trolls3.jpg");
		btnTrolls3.setIcon(imTrolls3);
		btnTrolls3.setPreferredSize(new Dimension(imTrolls3.getIconWidth(), imTrolls3.getIconHeight()));
		btnTrolls3.setPreferredSize(new Dimension(250, 445));
		btnTrolls3.addActionListener((e)->{
			VentanaTrolls3 ventanaTrolls3 = new VentanaTrolls3();
			ventanaTrolls3.setVisible(true);
			
		});
		
		
		lblPeliculas = new JLabel("PELICULAS");
		
		
		
		
		
		
		
		pSur.add(btnAtras);
		pNorte.add(lblPeliculas);
		pCentro.add(btnOppenheimer);
		pCentro.add(btnBarbie);
		pCentro.add(btnSawX);
		pCentro.add(btnCampeonex);
		pCentro.add(btnTrolls3);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("PELICULAS");
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		VentanaCartelera VPs = new VentanaCartelera();
	}

}
