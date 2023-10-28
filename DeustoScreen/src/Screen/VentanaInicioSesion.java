package Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Domain.Entrada;
import Domain.Usuario;

public class VentanaInicioSesion extends JFrame {
	private JPanel pNorte,pCentro,pSur,pCentroIzquierda;
	private JLabel lblTituloIS ,lblCorreoElectronico,lblContraseniaIs;
	private JTextField txtCorreoElectronico;
	private JButton btnSalir, btnIniciarSesion, btnRegistrarse;
	private JPasswordField contraseniaIs;
	
	private static Usuario usuario;
	private static List<Entrada> carrito;
	
	public static Usuario getCliente() {
		return usuario;
	}


	public static List<Entrada> getCarrito() {
		return carrito;
	}
	
	
	public VentanaInicioSesion() {
	
		
		pNorte = new JPanel(new GridLayout(1, 2));
		pCentro = new JPanel(new GridLayout(1, 2));
		pSur = new JPanel();

		pCentroIzquierda = new JPanel(new GridLayout(2, 1));
		pCentro.add(pCentroIzquierda);
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		//Labels
		lblCorreoElectronico = new JLabel("  Correo electronico: ");
		lblTituloIS = new JLabel("     INICIAR SESION");
		lblContraseniaIs = new JLabel("  Contrasenia: ");
			
		//TextField nuevos
		txtCorreoElectronico= new JTextField();
		contraseniaIs= new JPasswordField();
		
		// Enlazar los paneles con los label y txtField
		
			pCentroIzquierda.add(lblCorreoElectronico);
			pCentroIzquierda.add(txtCorreoElectronico);
			pCentroIzquierda.add(lblContraseniaIs);
			pCentroIzquierda.add(contraseniaIs);
				
			pNorte.add(lblTituloIS);
				
		//botones
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnSalir = new JButton("Salir");
		btnRegistrarse = new JButton("Registrarse");
		pSur.add(btnIniciarSesion);
		pSur.add(btnRegistrarse);
		pSur.add(btnSalir);
		
		
		//Eventos
		btnIniciarSesion.addActionListener((e)->{
			String CorreoElectronico = txtCorreoElectronico.getText();
			String con = contraseniaIs.getText();
			JOptionPane.showMessageDialog(null, "Inicio de sesion correcto","REGISTRADO",JOptionPane.INFORMATION_MESSAGE);
			VentanaEntradas ventanaEntradas = new VentanaEntradas();
			ventanaEntradas.setVisible(true);
			
		});
		


		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
			}
		});
			
		
		btnRegistrarse.addActionListener((e)->{
			VentanaRegistros ventanaRegistros = new VentanaRegistros();
			ventanaRegistros.setVisible(true);
		
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("INICIO SESION");
		setVisible(true);

		}
	
	
	
	public static void main(String[] args) {
			VentanaInicioSesion VIS = new VentanaInicioSesion();
			
		
	}
	
	
		
}	
		
		
	

	
