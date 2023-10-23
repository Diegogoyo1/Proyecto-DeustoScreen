package Screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.image.PackedColorModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class VentanaInicioSesion extends JFrame {
	private JPanel pNorte,pCentro,pSur,pCentroIzquierda,pCentroDerecha;
	private JLabel lblNombre,lblApellido ,lblFechaNacimiento, lbltlf, lblCorreoElectronico,lblContrasenia,lblTituloIS;
	private JTextField txtNombre,txtApellido,txtFechaNacimiento,txttlf ,txtCorreoElectronico;
	private JFrame vActual;
	private JButton btnSalir, BtnIniciarSesion;
	private JTextField textField;
	private JPasswordField contrasenia;

	public VentanaInicioSesion() {
		super();
		vActual = this;
		setBounds(200, 300, 600, 400);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		/*CREACIÓN DE PANELES Y COMPONENTES*/
		pNorte = new JPanel(new GridLayout(1, 2));
		pCentro = new JPanel(new GridLayout(1, 2));
		pSur = new JPanel();

		pCentroIzquierda = new JPanel(new GridLayout(5, 1));
		pCentroDerecha = new JPanel(new GridLayout(4, 2));
		pCentro.add(pCentroIzquierda);
		pCentro.add(pCentroDerecha);
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		//Labels
		lblNombre= new JLabel("  Nombre: ");
		lblApellido= new JLabel("  Apellido");
		lblFechaNacimiento = new JLabel("  Fecha de nacimiento");
		lbltlf = new JLabel(" Tlf");
		lblCorreoElectronico = new JLabel("  Correo electronico");
		lblTituloIS = new JLabel("     Iniciar Sesion");
		lblContrasenia = new JLabel("  COntrasenia");
		
		//TextField
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellido= new JTextField();
		txtFechaNacimiento= new JTextField();
		txtCorreoElectronico= new JTextField();
		
		
		// Enlazar los paneles con los label y txtField
		
		pCentroIzquierda.add(lblNombre);
		pCentroIzquierda.add(txtNombre);
		pCentroIzquierda.add(lblApellido);
		pCentroIzquierda.add(txtApellido);
		pCentroIzquierda.add(lblFechaNacimiento);
		pCentroIzquierda.add(txtFechaNacimiento);
		pCentroIzquierda.add(lbltlf);
		
		pNorte.add(lblTituloIS);
		
		
		textField = new JTextField();
		pCentroIzquierda.add(textField);
		textField.setColumns(10);
		pCentroIzquierda.add(lblCorreoElectronico);
		pCentroIzquierda.add(txtCorreoElectronico);
		
		//botones
		BtnIniciarSesion = new JButton("INICIAR SESIÓN");
		btnSalir = new JButton("SALIR");
		pSur.add(BtnIniciarSesion);
		pSur.add(btnSalir);
	
		
	//eventos botones 
		BtnIniciarSesion.addActionListener((e)->{
			VentanaEntradas ventanaEntradas = new VentanaEntradas();
			ventanaEntradas.setVisible(true);
		
		});
		btnSalir.addActionListener((e)->{
			System.exit(0);
		});
		setVisible(true);
	}
	

	public static void main(String[] args) {
		VentanaInicioSesion VIS = new VentanaInicioSesion();
		
	}

}
