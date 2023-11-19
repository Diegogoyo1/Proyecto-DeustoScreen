package screen;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.awt.image.PackedColorModel;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
import java.awt.Dimension;

public class VentanaRegistros extends JFrame {
	private JPanel pNorte,pCentro,pSur,pCentroIzquierda;
	private JLabel lblNombre,lblApellido ,lblFechaNacimiento, lbltlf, lblCorreoElectronico,lblCotraseniaR,lblTituloIS; 
	private JTextField txtNombre,txtApellido,txtFechaNacimiento,txtCorreoElectronico;
	private JTextField textFieldTlf;
	private JButton btnSalir, btnIniciarSesion;
	private JPasswordField contraseniaR;
	private JFrame vActual, vAnterior;
	private static final String nomfichUsuarios = "ficheros/Usuarios.csv";
	private static Logger logger = Logger.getLogger(Main.class.getName());

	public VentanaRegistros(JFrame va) {
		super();
		vActual = this;
		vAnterior=va;
		
		
	//CREACIÓN DE PANELES Y COMPONENTES
		pNorte = new JPanel(new GridLayout(1, 2));
		pCentro = new JPanel();
		pSur = new JPanel();
		pCentro.setBorder(BorderFactory.createEmptyBorder(40, 1000, 10, 1000));

		
		
		
		
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
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCotraseniaR.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbltlf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
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
		txtCorreoElectronico.setPreferredSize(new Dimension(400,30));
		txtNombre.setPreferredSize(new Dimension(400,30));
		txtApellido.setPreferredSize(new Dimension(400,30));
		txtFechaNacimiento.setPreferredSize(new Dimension(400,30));
		textFieldTlf.setPreferredSize(new Dimension(400,30));
		contraseniaR.setPreferredSize(new Dimension(400,30));
		
		
		
		
		// Enlazar los paneles con los label y txtField
		
		pCentro.add(lblNombre);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(txtNombre);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(lblApellido);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(txtApellido);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(lblFechaNacimiento);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(txtFechaNacimiento);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(lbltlf);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(textFieldTlf);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(lblCorreoElectronico);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(txtCorreoElectronico);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(lblCotraseniaR);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(lblCotraseniaR);
		pCentro.add(Box.createVerticalStrut(30));
		pCentro.add(contraseniaR);
		pCentro.add(Box.createVerticalStrut(30));
		
		
		pNorte.add(lblTituloIS);
		
		//botones
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnSalir = new JButton("Atras");
		pSur.add(btnSalir);
		pSur.add(btnIniciarSesion);
		
	

		
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

				logger.log(Level.INFO, "SE HA CREADO UN NUEVO USUARIO");

				//crear usuario nuevo
				Usuario usuarioNuevo = new Usuario(nombre, apellido,fNac,tlf, CorreoElectronico, contrasenia, ContadorPuntos);
				System.out.println(usuarioNuevo);
				Cine.guardarUsuariosEnFichero( nomfichUsuarios);
				JOptionPane.showMessageDialog(null, "Usuario registrado con éxito","REGISTRADO",JOptionPane.INFORMATION_MESSAGE);

				new VentanaEntradas(vActual, usuarioNuevo);

				new VentanaEntradas(vActual,usuarioNuevo);

				vActual.dispose();
			}
			
			
				
				
				
			
	});
		btnSalir.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO BOTON SALIR");
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
