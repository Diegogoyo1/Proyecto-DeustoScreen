package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
	private static final String nomfichUsuarios = "Ficheros/Usuarios.csv";

	
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
		
		// Tamaño del ComboBox(Ancho x Alto)
				txtCorreoElectronico.setPreferredSize(new Dimension(10,5));
				contraseniaIs.setPreferredSize(new Dimension(10,5));
		
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
		
		//cargar las colecciones
		Cine.cargarUsuarioEnLista(nomfichUsuarios);

		
		//Eventos
		btnIniciarSesion.addActionListener((e)->{
			String CorreoElectronico = txtCorreoElectronico.getText();
			String con = contraseniaIs.getText();
			Usuario u = Cine.buscarUsuario(CorreoElectronico);
			if(u == null) {
				JOptionPane.showMessageDialog(null, "Para poder iniciar sesión tienes que estar registrado","ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
				if(u.getContrasenia().equals(con)) {
					JOptionPane.showMessageDialog(null, "Bienvenido!","SESIÓN INICIADA",JOptionPane.INFORMATION_MESSAGE);
					usuario = u; //Guardamos la información del usuario que ha iniciado sesión
					carrito = new ArrayList<>(); //Inicializamos su carrito a una lista vacía (Instanciamos la lista que hace referencia al carrito)
					new VentanaEntradas(vActual);
					vActual.setVisible(false);
					txtCorreoElectronico.setText("");
					contraseniaIs.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta","ERROR",JOptionPane.WARNING_MESSAGE);
					new VentanaEntradas(vActual);
				}
			}
			
		});
			
		

		btnSalir.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
		}) ;
			
				
			
			
		
		btnRegistrarse.addActionListener((e)->{
			new VentanaRegistros(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("INICIO SESION");
		setVisible(true);

		}
	
	
	
		
}	
		
		
	

	
