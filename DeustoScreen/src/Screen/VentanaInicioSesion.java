package Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
	private JButton btnSalir, BtnIniciarSesion;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		
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
		BtnIniciarSesion = new JButton("INICIAR SESION");
		btnSalir = new JButton("SALIR");
		pSur.add(BtnIniciarSesion);
		pSur.add(btnSalir);
		
		//Eventos
		BtnIniciarSesion.addActionListener((e)->{
			String CorreoElectronico = txtCorreoElectronico.getText();
			String con = contraseniaIs.getText();
			JOptionPane.showMessageDialog(null, "Usuario registrado con éxito","REGISTRADO",JOptionPane.INFORMATION_MESSAGE);
			VentanaEntradas ventanaEntradas = new VentanaEntradas();
			
			
		});
		


		btnSalir.addActionListener((e)->{
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			dispose();
		});
		setVisible(true);

		}
	
	
	
	public static void main(String[] args) {
			VentanaInicioSesion VIS = new VentanaInicioSesion();
			
		
	}
	
	
		
}	
		
		
	

	
