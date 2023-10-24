package Screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;



public class VentanaPrincipal extends JFrame{
	private JPanel Panel1;
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Panel1 = new JPanel();
		Panel1.setBorder(new EmptyBorder(2, 5, 5, 5));

		setContentPane(Panel1);
		
		JButton BotonPrecios = new JButton("Precios");
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		JButton btnCartelera = new JButton("Cartelera");

		Panel1.add(btnIniciarSesion);
		Panel1.add(BotonPrecios);
		Panel1.add(btnCartelera);

		
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


