package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;

public class VentanaInicioSesion extends JFrame {
	private JPanel pNorte,pSur,pOesteCentro,pEsteCentro,pOeste;
	private JLabel lblTituloIS ,lblCorreoElectronico,lblContraseniaIs,lblRegistro;
	private JTextField txtCorreoElectronico;
	private JButton btnSalir, btnIniciarSesion, btnRegistrarse;
	private JPasswordField contraseniaIs;
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
		setExtendedState(Frame.MAXIMIZED_BOTH);
		vActual=this;
		vAnterior=va;
		
		
		pNorte = new JPanel(new GridLayout(1, 2));
		pSur = new JPanel();
		pOeste = new JPanel();
		pOesteCentro =new JPanel();
		FlowLayout flowLayout = (FlowLayout) pOesteCentro.getLayout();
		pEsteCentro = new JPanel();
		
		
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pOeste, BorderLayout.WEST);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		

		
		//Labels
		lblCorreoElectronico = new JLabel("  Correo electronico: ");
		lblTituloIS = new JLabel("     INICIAR SESION");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
		//TextField nuevos
		txtCorreoElectronico= new JTextField();
		contraseniaIs= new JPasswordField();
		
		// Tamaño del Textfield(Ancho x Alto)
				txtCorreoElectronico.setPreferredSize(new Dimension(300, 30));
				contraseniaIs.setPreferredSize(new Dimension(300, 30));
		
		// Enlazar los paneles con los label y txtField
		
			pOeste.setLayout(new BoxLayout(pOeste, BoxLayout.Y_AXIS));
			

			pOesteCentro.add(lblCorreoElectronico);
			pOesteCentro.add(txtCorreoElectronico);
			lblContraseniaIs = new JLabel("  Contrasenia: ");
			lblContraseniaIs.setFont(new Font("Tahoma", Font.PLAIN, 17));
			pOesteCentro.add(lblContraseniaIs);
			pOesteCentro.add(contraseniaIs);
			pOeste.add(pOesteCentro);

			
		//Enlazar panel este con registro
			pEsteCentro.setLayout(new BoxLayout(pEsteCentro,BoxLayout.Y_AXIS));
			lblRegistro = new JLabel("¿No tienes cuenta? Regístrate aquí");
			lblRegistro.setBorder(new EmptyBorder(0, 0, 0, 0));
			lblRegistro.setFont(new Font("Tw", Font.BOLD, 14));
			
			pEsteCentro.add(lblRegistro);
			btnRegistrarse = new JButton("                    REGÍSTRATE                   ");
			pEsteCentro.add(btnRegistrarse);
			pOeste.add(pEsteCentro);
			
		
		btnRegistrarse.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO BOTON REGISTRARSE");
			new VentanaRegistros(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		
		});
			
		//botones
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnSalir = new JButton("Atras");
		pSur.add(btnSalir);
		pSur.add(btnIniciarSesion);
		
		
		
		//cargar las colecciones
		Cine.cargarUsuarioEnLista(nomfichUsuarios);

		
		//Eventos
		btnIniciarSesion.addActionListener((e)->{
			String CorreoElectronico = txtCorreoElectronico.getText();
			String con = contraseniaIs.getText();
			//Mira si el correo electronico esta vacio
			 if(CorreoElectronico.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Inserte un Usuario","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			 //Mira si la contraseña esta vacia
			 else if (con.isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Inserte Contraseña","ERROR",JOptionPane.ERROR_MESSAGE);
				 }
			Usuario u = Cine.buscarUsuario(CorreoElectronico);
			//Compara si el correo electronico metido es igual al correo electronico que ya existe.
			 if (u == null || !CorreoElectronico.equals(u.getCorreoElectronico())) {
				JOptionPane.showMessageDialog(null, "Direccion de correo electronico no valido","ERROR",JOptionPane.ERROR_MESSAGE);
            }
			// Compara la contrasenia es igual a la contrasenia que va enlazada con el correo elctronico
			else if (CorreoElectronico.equals(u.getCorreoElectronico())) {
				if(!con.equals(u.getContrasenia())) {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta","ERROR",JOptionPane.WARNING_MESSAGE);
				}
					
				else {
					JOptionPane.showMessageDialog(null, "Bienvenido!","SESIÓN INICIADA",JOptionPane.INFORMATION_MESSAGE);
					usuario = u; //Guardamos la información del usuario que ha iniciado sesión
					carrito = new ArrayList<>(); //Inicializamos su carrito a una lista vacía (Instanciamos la lista que hace referencia al carrito)
					new VentanaHorario(vActual, u);
					vActual.setVisible(false);
					txtCorreoElectronico.setText("");
					contraseniaIs.setText("");
					logger.log(Level.INFO, "SE HA INICIADO SESION");
				}
					
			}

			
		});
			
		

		btnSalir.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
		}) ;
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("INICIO SESION");
		setVisible(true);

		}	
	
}	