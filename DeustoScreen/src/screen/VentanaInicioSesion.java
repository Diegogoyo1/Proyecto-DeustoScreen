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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.Cine;
import domain.Entrada;
import domain.Usuario;

public class VentanaInicioSesion extends JFrame {
	private JPanel pNorte,pCentro,pSur,pCentroIzquierda;
	private JLabel lblTituloIS ,lblCorreoElectronico,lblContraseniaIs;
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
		vActual=this;
		vAnterior=va;
	
		
		pNorte = new JPanel(new GridLayout(1, 2));
		pCentro = new JPanel();
		pSur = new JPanel();
		pCentro.setBorder(BorderFactory.createEmptyBorder(40, 1000, 10, 1000));
		
		
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		//Labels
		lblCorreoElectronico = new JLabel("  Correo electronico: ");
		lblTituloIS = new JLabel("     INICIAR SESION");
		lblContraseniaIs = new JLabel("  Contrasenia: ");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContraseniaIs.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
		//TextField nuevos
		txtCorreoElectronico= new JTextField();
		contraseniaIs= new JPasswordField();
		
		// Tamaño del Textfield(Ancho x Alto)
				txtCorreoElectronico.setPreferredSize(new Dimension(400,30));
				contraseniaIs.setPreferredSize(new Dimension(400,30));
		
		// Enlazar los paneles con los label y txtField
		
			pCentro.add(lblCorreoElectronico);
			pCentro.add(Box.createVerticalStrut(50));
			pCentro.add(txtCorreoElectronico);
			pCentro.add(lblContraseniaIs);
			pCentro.add(Box.createVerticalStrut(50));
			pCentro.add(contraseniaIs);
			
				
			pNorte.add(lblTituloIS);
				
		//botones
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnSalir = new JButton("Atras");
		btnRegistrarse = new JButton("Registrarse");
		pSur.add(btnSalir);
		pSur.add(btnIniciarSesion);
		pSur.add(btnRegistrarse);
		
		
		//cargar las colecciones
		Cine.cargarUsuarioEnLista(nomfichUsuarios);

		
		//Eventos
		btnIniciarSesion.addActionListener((e)->{
			String CorreoElectronico = txtCorreoElectronico.getText();
			String con = contraseniaIs.getText();
			 if(CorreoElectronico.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Inserte un Usuario","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			 else if (con.isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Inserte Contraseña","ERROR",JOptionPane.ERROR_MESSAGE);
				 }
			Usuario u = Cine.buscarUsuario(CorreoElectronico);
			
			 if (!CorreoElectronico.equals(u.getCorreoElectronico())) {
				JOptionPane.showMessageDialog(null, "Direccion de correo electronico no valido","ERROR",JOptionPane.ERROR_MESSAGE);
            }
			
			else if (CorreoElectronico.equals(u.getCorreoElectronico())) {
				if(!con.equals(u.getContrasenia())) {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta","ERROR",JOptionPane.WARNING_MESSAGE);
				}
					
				else {
					JOptionPane.showMessageDialog(null, "Bienvenido!","SESIÓN INICIADA",JOptionPane.INFORMATION_MESSAGE);
					usuario = u; //Guardamos la información del usuario que ha iniciado sesión
					carrito = new ArrayList<>(); //Inicializamos su carrito a una lista vacía (Instanciamos la lista que hace referencia al carrito)
					new VentanaEntradas(vActual,u);
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
