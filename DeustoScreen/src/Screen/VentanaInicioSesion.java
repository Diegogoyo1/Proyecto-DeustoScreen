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
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame {
	private JPanel pNorte,pCentro,pSur,pCentroIzquierda,pCentroDerecha;
	private JLabel lblNombre,lblApellido ,lblFechaNacimiento, lbltlf, lblCorreoElectronico;
	private JTextField txtNombre,txtApellido,txtFechaNacimiento,txttlf, txtCorreoElectronico;
	//private JFrame vActual;
	private JButton btnSalir, BtnIniciarSesion;

	public VentanaInicioSesion() {
		super();
		//vActual = this;
		setBounds(200, 300, 600, 400);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		/*CREACIÓN DE PANELES Y COMPONENTES*/
		pNorte = new JPanel(new GridLayout(1, 2));
		pCentro = new JPanel(new GridLayout(1, 2));
		pSur = new JPanel();

		pCentroIzquierda = new JPanel(new GridLayout(2, 2));
		pCentroDerecha = new JPanel(new GridLayout(4, 2));
		pCentro.add(pCentroIzquierda);
		pCentro.add(pCentroDerecha);
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		//Labels
		lblNombre= new JLabel("Nombre: ");
		lblApellido= new JLabel("Apellido");
		lblFechaNacimiento = new JLabel("fecha de nacimiento");
		lbltlf = new JLabel(" Tlf");
		lblCorreoElectronico = new JLabel("Correo electronico");
		
		//TextField
		txtNombre = new JTextField();
		txtApellido= new JTextField();
		txtFechaNacimiento= new JTextField();
		txtCorreoElectronico= new JTextField();
		
		// Enlazar los paneles con los labely txtField
		
		pCentroIzquierda.add(lblNombre);
		pCentroIzquierda.add(txtNombre);
		pCentroIzquierda.add(lblApellido);
		pCentroIzquierda.add(txtApellido);
		pCentroIzquierda.add(lblFechaNacimiento);
		pCentroIzquierda.add(txtFechaNacimiento);
		pCentroIzquierda.add(lbltlf);
		//pCentroIzquierda.add(txttlf);
		pCentroIzquierda.add(lblCorreoElectronico);
		pCentroIzquierda.add(txtCorreoElectronico);
		
		//botones
		BtnIniciarSesion = new JButton("INICIAR SESIÓN");
		btnSalir = new JButton("SALIR");
		pSur.add(BtnIniciarSesion);
		pSur.add(btnSalir);
	
		setVisible(true);
	}
	
	//Eventos
	

	public static void main(String[] args) {
		VentanaInicioSesion VIS = new VentanaInicioSesion();
		
	}

}
