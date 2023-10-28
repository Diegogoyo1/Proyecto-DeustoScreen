package Screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.image.PackedColorModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class VentanaRegistros extends JFrame {
	private JPanel pNorte,pCentro,pSur,pCentroIzquierda;
	private JLabel lblNombre,lblApellido ,lblFechaNacimiento, lbltlf, lblCorreoElectronico,lblContraseniaIs,lblCotraseniaR,lblTituloIS;
	private JTextField txtNombre,txtApellido,txtFechaNacimiento,txtCorreoElectronico;
	private JTextField textFieldTlf;
	private JFrame vActual;
	private JButton btnSalir, btnIniciarSesion;
	
	private JPasswordField contraseniaR;

	public VentanaRegistros() {
		super();
		vActual = this;
		
		
	//CREACIÓN DE PANELES Y COMPONENTES
		pNorte = new JPanel(new GridLayout(1, 2));
		pCentro = new JPanel(new GridLayout(1, 2));
		pSur = new JPanel();

		pCentroIzquierda = new JPanel(new GridLayout(6, 1));
		pCentro.add(pCentroIzquierda);
		
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		//Labels
		lblNombre= new JLabel("  Nombre: ");
		lblApellido= new JLabel("  Apellido");
		lblFechaNacimiento = new JLabel("  Fecha de nacimiento");
		lbltlf = new JLabel(" Tlf");
		lblCorreoElectronico = new JLabel("  Correo electronico");
		lblTituloIS = new JLabel("     REGISTRARSE");
		lblCotraseniaR = new JLabel("  Contrasenia");
		
		
		//TextField nuevos
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellido= new JTextField();
		txtFechaNacimiento= new JTextField();
		textFieldTlf = new JTextField();
		txtCorreoElectronico= new JTextField();
		contraseniaR= new JPasswordField();
		
		// Enlazar los paneles con los label y txtField
		
		pCentroIzquierda.add(lblNombre);
		pCentroIzquierda.add(txtNombre);
		pCentroIzquierda.add(lblApellido);
		pCentroIzquierda.add(txtApellido);
		pCentroIzquierda.add(lblFechaNacimiento);
		pCentroIzquierda.add(txtFechaNacimiento);
		pCentroIzquierda.add(lbltlf);
		pCentroIzquierda.add(textFieldTlf);
		pCentroIzquierda.add(lblCorreoElectronico);
		pCentroIzquierda.add(txtCorreoElectronico);
		pCentroIzquierda.add(lblCotraseniaR);
		pCentroIzquierda.add(lblCotraseniaR);
		pCentroIzquierda.add(contraseniaR);
		
		pNorte.add(lblTituloIS);
		
		//botones
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnSalir = new JButton("Salir");
		pSur.add(btnIniciarSesion);
		pSur.add(btnSalir);
	
		
		//eventos botones 
		btnIniciarSesion.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Usuario registrado con éxito","REGISTRADO",JOptionPane.INFORMATION_MESSAGE);
			VentanaEntradas ventanaEntradas = new VentanaEntradas();
			ventanaEntradas.setVisible(true);
		
		});
		btnSalir.addActionListener((e)->{
			dispose();
			
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 600, 400);
		setTitle("REGISTRO");
		setVisible(true);
	}
	

	public static void main(String[] args) {
		VentanaRegistros VR = new VentanaRegistros();
		
	}

}
