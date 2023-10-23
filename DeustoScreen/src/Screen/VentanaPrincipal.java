package Screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
		BotonPrecios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnCartelera = new JButton("Cartelera");
		btnCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		Panel1.add(btnIniciarSesion);
		Panel1.add(BotonPrecios);
		Panel1.add(btnCartelera);

		setVisible(true);
	}
	
	// Prueba con main
	public static void main(String[] args) {
		VentanaPrincipal VP = new VentanaPrincipal();	
			
	
	}

}


