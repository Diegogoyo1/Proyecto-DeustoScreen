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
		
		JScrollPane scrollPane = new JScrollPane();
		Panel1.add(scrollPane);
		Panel1.add(btnIniciarSesion);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 2));
		Panel1.add(panel2);
		getContentPane().add(panel2, BorderLayout.SOUTH);
		
		JButton btnCartelera = new JButton("Cartelera");
		Panel1.add(btnCartelera);
		Panel1.add(BotonPrecios);
	}
	
	// Prueba con main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}


