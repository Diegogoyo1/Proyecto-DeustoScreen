package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import domain.Cine;
import domain.Usuario;

public class VentanaPuntos extends JFrame{
	private JPanel pSur, pNorte, pEste, pOeste ; 
	private JLabel lblUsuario, lblNumPuntos, txtUsuario, txtNumPuntos, lblImg;
	private JButton btnAniadir, btnOmitir, btnAtras;
	private JFrame vActual, vAnterior;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaPuntos(JFrame va, Usuario u,int sala, ArrayList<String> asientosSeleccionados) {
		super();
		vActual=this;
		vAnterior=va;
		
		
		//CREACIÓN PANELES
		pSur = new JPanel();
		pNorte = new JPanel();
		
		pOeste = new JPanel();
		pOeste.setLayout(new BoxLayout(pOeste, BoxLayout.Y_AXIS));
		
		pEste = new JPanel();
		pEste.setLayout(new BoxLayout(pEste, BoxLayout.Y_AXIS));
		
		
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		
		//LABELS
		lblUsuario = new JLabel(" USUARIO: ");
		lblUsuario.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblNumPuntos = new JLabel (" NÚMERO DE PUNTOS: ");
		lblNumPuntos.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblNumPuntos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblImg = new JLabel();
		
		//TEXTFIELD
		txtUsuario = new JLabel(u.getCorreoElectronico());
		txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		/*txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);*/
		
		//txtUsuario.setSize(2, 4);
		//txtUsuario.setPreferredSize(new Dimension(2, 4));
		
		txtNumPuntos = new JLabel(u.getContadorPuntos());
		txtNumPuntos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		/*txtNumPuntos.setBackground(new Color(255, 255, 255));
		txtNumPuntos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNumPuntos.setHorizontalAlignment(SwingConstants.LEFT);*/

		
		
		//ENLAZAR PANELES CON LABELS Y TEXTFIELDS
		pEste.add(lblUsuario);
		pEste.add(txtUsuario);
		pEste.add(lblNumPuntos);
		pEste.add(txtNumPuntos);
		pEste.add(Box.createVerticalStrut(30));
		pEste.setBorder(new EmptyBorder(150, 150, 150, 150 ));
		
		pOeste.add(lblImg);
		ImageIcon imEntradas = new ImageIcon("imagenes/entradas.png");
		lblImg.setIcon(imEntradas);
		
		//BOTONES
		btnAniadir = new JButton("AÑADIR");
		btnOmitir = new JButton ("OMITIR");
		btnAtras = new JButton("ATRAS");
		pSur.add(btnOmitir);
		pSur.add(btnAniadir);
		pSur.add(btnAtras);
		
		
		//EVENTOS BOTONES
		btnOmitir.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			new VentanaPago(vActual,sala,asientosSeleccionados);
			vActual.setVisible(false);
			vActual.dispose();//Este DISPOSE cerrara la ventana y nos llevara a la de PAGO directamente sin AÑADIR los puntos
			 
		});
		
		btnAniadir.addActionListener((e)-> {

			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON AÑADIR");
			new VentanaPago(vActual,sala,asientosSeleccionados);
			vActual.setVisible(false);
			vActual.dispose();//Este DISPOSE cerrara la ventana y nos llevara a la de PAGO AÑADIENDO los puntos
			 
		});
		
		btnAtras.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
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
