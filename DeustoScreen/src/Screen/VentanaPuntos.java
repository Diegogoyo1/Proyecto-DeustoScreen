package Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaPuntos extends JFrame{
	private JPanel pSur, pCentro, pCentroArribaIz, pCentroArribaDe, pCentroAbajoIz, pCentroAbajoDe;
	private JLabel lblUsuario, lblNumPuntos;
	private JButton btnAniadir, btnOmitir;
	private JTextField txtUsuario, txtNumPuntos;
	
	public VentanaPuntos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (100,100,380,400);
		
		//CREACIÓN PANELES
		pCentro = new JPanel (new GridLayout (2, 2));
		pSur = new JPanel();
		
		pCentroArribaIz = new JPanel();
		pCentroArribaDe = new JPanel();
		pCentroAbajoIz = new JPanel ();
		pCentroAbajoDe = new JPanel ();
		
		pCentro.add(pCentroArribaIz);
		pCentro.add(pCentroArribaDe);
		pCentro.add(pCentroAbajoIz);
		pCentro.add(pCentroAbajoDe);
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		
		//LABELS
		lblUsuario = new JLabel(" USUARIO ");
		lblNumPuntos = new JLabel (" NÚMERO DE PUNTOS: ");
		
		//TEXTFIELD
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtNumPuntos = new JTextField();
		
		//ENLAZAR PANELES CON LABELS Y TEXTFIELDS
		pCentroArribaIz.add(lblUsuario);
		pCentroArribaDe.add(txtUsuario);
		pCentroAbajoIz.add(lblNumPuntos);
		pCentroAbajoDe.add(txtNumPuntos);
		
		
		//BOTONES
		btnAniadir = new JButton("AÑADIR");
		btnOmitir = new JButton ("OMITIR");
		pSur.add(btnAniadir);
		pSur.add(btnOmitir);
		
		
		//EVENTOS BOTONES
		btnOmitir.addActionListener((e)->{
			System.exit(0);
		});
		setVisible(true);
		
		//btnAniadir
	
	}
	
	public static void main (String[] args) {
		VentanaPuntos VPt = new VentanaPuntos();
	}

}
