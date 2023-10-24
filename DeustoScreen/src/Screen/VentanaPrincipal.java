package Screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;



public class VentanaPrincipal extends JFrame{
	private JPanel PanelNorte, PanelCentro;
	private JButton BotonPrecios, btnIniciarSesion,btnCartelera;;
	
	public VentanaPrincipal() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		PanelNorte = new JPanel();
		PanelCentro = new JPanel();
		getContentPane().add(PanelNorte, BorderLayout.NORTH);
		getContentPane().add(PanelCentro,BorderLayout.CENTER);
		
				
		BotonPrecios = new JButton("Precios");
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnCartelera = new JButton("Cartelera");
		
		//Imagen
		 ImageIcon logo = new ImageIcon(" 23.54.19_90281ec4.gif"); 
	     JLabel gifLabelLogo = new JLabel(logo);

		PanelNorte.add(btnIniciarSesion);
		PanelNorte.add(BotonPrecios);
		PanelNorte.add(btnCartelera);
		PanelCentro.add(gifLabelLogo);

		
		//Eventos Botones
		
		BotonPrecios.addActionListener((e)->{
			VentanaPrecios ventanaPrecios = new VentanaPrecios();
			ventanaPrecios.setVisible(true);
		});
		
		btnIniciarSesion.addActionListener((e)->{
			VentanaPregunta1 ventanaPregunta1 = new VentanaPregunta1();
			ventanaPregunta1.setVisible(true);
		});
		
		btnCartelera.addActionListener((e)->{
			VentanaCartelera ventanaCartelera = new VentanaCartelera();
			ventanaCartelera.setVisible(true);
		});
		
		setVisible(true);
	}
	
	// Prueba con main
	public static void main(String[] args) {
		VentanaPrincipal VP = new VentanaPrincipal();	
			
	
	}

}


