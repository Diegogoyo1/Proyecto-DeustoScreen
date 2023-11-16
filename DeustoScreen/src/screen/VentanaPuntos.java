package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
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

import domain.Usuario;

public class VentanaPuntos extends JFrame{
	private JPanel pSur, pCentro, pNorte; 
	private JLabel lblUsuario, lblNumPuntos, txtUsuario, txtNumPuntos;
	private JButton btnAniadir, btnOmitir;
	private JFrame vActual, vAnterior;
	
	public VentanaPuntos(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		
		
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
		txtUsuario = new JLabel(Usuario.getCorreoElectronico());
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		
		//txtUsuario.setSize(2, 4);
		//txtUsuario.setPreferredSize(new Dimension(2, 4));
		txtNumPuntos = new JLabel ();
		txtNumPuntos = new JLabel();

		
		
		//ENLAZAR PANELES CON LABELS Y TEXTFIELDS
		pCentro.add(lblUsuario);
		pCentro.add(txtUsuario);
		pCentro.add(lblNumPuntos);
		pCentro.add(txtNumPuntos);
		
		
		//BOTONES
		btnAniadir = new JButton("AÑADIR");
		btnOmitir = new JButton ("OMITIR");
		pSur.add(btnOmitir);
		pSur.add(btnAniadir);
		
		
		//EVENTOS BOTONES
		btnOmitir.addActionListener((e)->{
			new VentanaPago(vActual);
			vActual.setVisible(false);
			vActual.dispose();//Este DISPOSE cerrara la ventana y nos llevara a la de PAGO directamente sin AÑADIR los puntos
			 
		});
		
		btnAniadir.addActionListener((e)-> {
			new VentanaPago(vActual);
			vActual.setVisible(false);
			vActual.dispose();//Este DISPOSE cerrara la ventana y nos llevara a la de PAGO AÑADIENDO los puntos
			 
		});
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("PUNTOS");
		setVisible(true);
	
	}
	
}
