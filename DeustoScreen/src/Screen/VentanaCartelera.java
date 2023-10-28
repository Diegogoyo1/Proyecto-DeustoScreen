package Screen;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
		int espacioEntrePeneles1 = 200;
		pCentro.setBorder(new EmptyBorder(espacioEntrePeneles1,espacioEntrePeneles1,espacioEntrePeneles1,espacioEntrePeneles1));
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e)->{
			dispose();
			
		});
		
		
		
		btnOppenheimer = new JButton("Oppenhaimer");
		btnOppenheimer.setPreferredSize(new Dimension(250, 350));
		btnOppenheimer.addActionListener((e)->{
			VentanaOppenheimer ventanaOppenheimer = new VentanaOppenheimer();
			ventanaOppenheimer.setVisible(true);
			
		});
		
		
		btnBarbie = new JButton("Barbie");
		btnBarbie.setPreferredSize(new Dimension(250, 350));
		btnBarbie.addActionListener((e)->{
			VentanaBarbie ventanaBarbie = new VentanaBarbie();
			ventanaBarbie.setVisible(true);
			
			
		});
		
		
		btnSawX = new JButton("Saw X");
		btnSawX.setPreferredSize(new Dimension(250, 350));
		btnSawX.addActionListener((e)->{
			VentanaSawX ventanaSawX = new VentanaSawX();
			ventanaSawX.setVisible(true);
			
		});
		
		
		btnCampeonex = new JButton("Campeonex");
		btnCampeonex.setPreferredSize(new Dimension(250, 350));
		btnCampeonex.addActionListener((e)->{
			VentanaCampeonex ventanaCampeonex = new VentanaCampeonex();
			ventanaCampeonex.setVisible(true);
			
		});
		
		
		btnTrolls3 = new JButton("Trolls 3");
		btnTrolls3.setPreferredSize(new Dimension(250, 350));
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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("PELICULAS");
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		VentanaCartelera VPs = new VentanaCartelera();
	}

}
