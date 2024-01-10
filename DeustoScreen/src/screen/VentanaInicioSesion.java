package screen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import domain.Cine;
import domain.Entrada;
import domain.Usuario;


public class VentanaInicioSesion extends JFrame {
	private JPanel pSur, pEste, pOeste, pPrincipal;
	private JLabel lblTituloIS ,lblCorreoElectronico,lblContraseniaIs, lblRegistrarse;
	private JTextField txtCorreoElectronico;
	private JButton btnAtras, btnIniciarSesion, btnRegistrarse;
	private JPasswordField txtContraseniaIs;
	private JFrame vAnterior, vActual;
	private static final String nomfichUsuarios = "ficheros/Usuarios.csv";
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	private static Usuario usuario;
	private static List<Entrada> carrito;
	
	public static Usuario getUsuario() {
		return usuario;
	}
	public static List<Entrada> getCarrito() {
		return carrito;
	}
	
	
	public VentanaInicioSesion(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;

		JPanel panelContenedor = new JPanel();
		panelContenedor.setLayout(new BorderLayout());
		pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());

		pOeste = new JPanel();
		pOeste.setLayout(new BoxLayout(pOeste, BoxLayout.Y_AXIS));

		pEste = new JPanel();
		pEste.setLayout(new BoxLayout(pEste, BoxLayout.Y_AXIS));
		pSur = new JPanel();
		pSur.setLayout(new FlowLayout(FlowLayout.CENTER));

		//Labels
		lblTituloIS = new JLabel("     INICIAR SESION");

		lblCorreoElectronico = new JLabel("  Correo electronico: ");
		lblCorreoElectronico.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 17));

		lblContraseniaIs = new JLabel("  Contrasenia: ");
		lblContraseniaIs.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblContraseniaIs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRegistrarse = new JLabel("¿No tienes un usuario? Registrarse");
		lblRegistrarse.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 17));



		//TextField nuevos
		txtCorreoElectronico= new JTextField();
		txtContraseniaIs= new JPasswordField(20);

		// Tamaño del Textfield(Ancho x Alto)
		txtCorreoElectronico.setMaximumSize(new Dimension (Integer.MAX_VALUE, 20));
		txtContraseniaIs.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		//botones
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnAtras = new JButton("Atras");
		btnRegistrarse = new JButton("Registrarse");

		// Enlazar los paneles con los label, txtField y botones
		pOeste.add(lblCorreoElectronico);
		pOeste.add(txtCorreoElectronico);
		pOeste.add(lblContraseniaIs);
		pOeste.add(txtContraseniaIs);
		pOeste.add(Box.createVerticalStrut(30));
		pOeste.setBorder(new EmptyBorder(150, 150, 150, 150 ));

		pEste.add(lblRegistrarse);
		pEste.add(btnRegistrarse);
		pEste.add(Box.createVerticalStrut(30));
		pEste.setBorder(new EmptyBorder(200, 200, 200, 200 ));

		pSur.add(btnAtras);
		pSur.add(btnIniciarSesion);

		panelContenedor.add(pEste, BorderLayout.EAST);
		panelContenedor.add(pOeste, BorderLayout.WEST);
		panelContenedor.add(pSur, BorderLayout.SOUTH);

		pPrincipal.add(panelContenedor, BorderLayout.CENTER);
		getContentPane().add(pPrincipal);
		//cargar las colecciones
		Cine.cargarUsuarioEnLista(nomfichUsuarios);


		//Eventos
		btnIniciarSesion.addActionListener((e)->{
		String CorreoElectronico = txtCorreoElectronico.getText();
		String con = txtContraseniaIs.getText();
		//Mira si el correo electronico esta vacio
		 if(CorreoElectronico.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Inserte un Usuario","ERROR",JOptionPane.ERROR_MESSAGE);
				logger.log(Level.INFO, "SE HA INTENTADO ACCEDER CON USUARIO VACIO");
			}
		 //Mira si la contraseña esta vacia
		 else if (con.isEmpty()) {
				 JOptionPane.showMessageDialog(null, "Inserte Contraseña","ERROR",JOptionPane.ERROR_MESSAGE);
				 logger.log(Level.INFO, "SE HA INTENTADO ACCEDER CON CONTRASEÑA VACIA");
			 }
		Usuario u = Cine.buscarUsuario(CorreoElectronico, con);
		//Compara si el correo electronico metido es igual al correo electronico que ya existe.
		 if (u == null || !CorreoElectronico.equals(u.getCorreoElectronico())) {
			JOptionPane.showMessageDialog(null, "Direccion de correo electronico no valido","ERROR",JOptionPane.ERROR_MESSAGE);
			logger.log(Level.INFO, "SE HA INTENTADO ACCEDER CON UN CORREO NO VALIDO");
        }
		// Compara la contrasenia es igual a la contrasenia que va enlazada con el correo elctronico
		else if (CorreoElectronico.equals(u.getCorreoElectronico())) {
			if(!con.equals(u.getContrasenia())) {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta","ERROR",JOptionPane.WARNING_MESSAGE);
				logger.log(Level.INFO, "SE HA INTENTADO ACCEDER CON UNA CONTRASEÑA INCORRECTA");
			}

			else {
				JOptionPane.showMessageDialog(null, "¡Bienvenido!","SESIÓN INICIADA",JOptionPane.INFORMATION_MESSAGE);
				usuario = u; //Guardamos la información del usuario que ha iniciado sesión
				carrito = new ArrayList<>(); //Inicializamos su carrito a una lista vacía (Instanciamos la lista que hace referencia al carrito)
				new VentanaHorario(vActual, u);
				vActual.setVisible(false);
				txtCorreoElectronico.setText("");
				txtContraseniaIs.setText("");
				logger.log(Level.INFO, "SE HA INICIADO SESION");
			}

		}
		
	});


		btnAtras.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
		}) ;
			
		
		btnRegistrarse.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO BOTON REGISTRARSE");
			new VentanaRegistros(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		
		});
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("INICIO SESION");
		setVisible(true);
		}	
	
}
