package Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaPuntos extends JFrame{
	private JPanel pSur, pCentro, pNorte; 
	private JLabel lblUsuario, lblNumPuntos;
	private JButton btnAniadir, btnOmitir;
	private JTextField txtUsuario, txtNumPuntos;
	
	public VentanaPuntos() {
		
		
		//CREACIÓN PANELES
		pCentro = new JPanel (new GridLayout (2, 2));
		pSur = new JPanel();
		pNorte = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		
		//LABELS
		lblUsuario = new JLabel(" USUARIO ");
		lblNumPuntos = new JLabel (" NÚMERO DE PUNTOS: ");
		
		//TEXTFIELD
		txtUsuario = new JTextField(5);
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtNumPuntos = new JTextField(10);
		
		//ENLAZAR PANELES CON LABELS Y TEXTFIELDS
		pCentro.add(lblUsuario);
		pCentro.add(txtUsuario);
		pCentro.add(lblNumPuntos);
		pCentro.add(txtNumPuntos);
		
		
		//BOTONES
		btnAniadir = new JButton("Añadir");
		btnOmitir = new JButton ("Omitir");
		pSur.add(btnOmitir);
		pSur.add(btnAniadir);
		
		
		//EVENTOS BOTONES
		btnOmitir.addActionListener((e)->{
			dispose(); //Este DISPOSE cerrara la ventana y nos llevara a la de PAGO directamente sin AÑADIR los puntos
			VentanaPago ventanaPago = new VentanaPago();
			ventanaPago.setVisible(true);
			 
		});
		
		btnAniadir.addActionListener((e)-> {
			dispose();//Este DISPOSE cerrara la ventana y nos llevara a la de PAGO AÑADIENDO los puntos
			VentanaPago ventanaPago = new VentanaPago();
			ventanaPago.setVisible(true);
			 
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("PUNTOS");
		setVisible(true);
	
	}
	
	public static void main (String[] args) {
		VentanaPuntos VPt = new VentanaPuntos();
	}

}
