package screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.awt.image.PackedColorModel;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.Cine;
import domain.Usuario;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Color;

public class VentanaRegistros extends JFrame {
	private JPanel pNorte,pCentro,pSur,pCentroIzquierda;
	private JLabel lblNombre,lblApellido ,lblFechaNacimiento, lbltlf, lblCorreoElectronico,lblCotraseniaR,lblTituloIS; 
	private JTextField txtNombre,txtApellido,txtFechaNacimiento,txtCorreoElectronico;
	private JTextField textFieldTlf;
	private JButton btnSalir, btnIniciarSesion;
	private JPasswordField contraseniaR;
	private JFrame vActual, vAnterior;
	private static final String nomfichUsuarios = "ficheros/Usuarios.csv";


	public VentanaRegistros(JFrame va) {
		super();
		vActual = this;
		vAnterior=va;
		
		
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
		lblNombre= new JLabel("  Nombre ");
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
			String nombre = txtNombre.getText();
			String apellido = txtApellido.getText();
			String fNac = txtFechaNacimiento.getText();
			String tlf = textFieldTlf.getText();
			String CorreoElectronico = txtCorreoElectronico.getText();
			String contrasenia = contraseniaR.getText();
			String ContadorPuntos = "0";
			
			// Verificar si existe el usuario
			//Usuario usuarioExstente = Cine.buscarUsuario(CorreoElectronico);
			if (Cine.buscarUsuario(CorreoElectronico)!= null) {
			JOptionPane.showMessageDialog(null, "Usuario ya existe","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else {
				//crear usuario nuevo
				Usuario usuarioNuevo = new Usuario(nombre, apellido,fNac,tlf, CorreoElectronico, contrasenia, ContadorPuntos);
				Cine.aniadirUsuario(usuarioNuevo);
				Cine.guardarUsuariosEnFichero( nomfichUsuarios);
				JOptionPane.showMessageDialog(null, "Usuario registrado con éxito","REGISTRADO",JOptionPane.INFORMATION_MESSAGE);
				new VentanaEntradas(vActual);
				vActual.dispose();
			}
			
			
				
				
				
			
	});
		btnSalir.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
			
		});
		
				
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600,300, 600, 400);
		setTitle("REGISTRO");
		setVisible(true);
	}
	
	
}
