package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import domain.Usuario;

public class VentanaPuntos extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pSur, pNorte, pIzq, pDe ; 
	private JLabel lblUsuario, lblNumPuntos, lblImg; 
	private JTextField txtUsuario, txtNumPuntos;
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
		pIzq = new JPanel();
		pDe = new JPanel();

		//pOeste = new JPanel();
		//pOeste.setLayout(new BoxLayout(pOeste, BoxLayout.Y_AXIS));
		//pEste = new JPanel();
		//pEste.setLayout(new BoxLayout(pEste, BoxLayout.Y_AXIS));
		
		
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pIzq, BorderLayout.WEST);
		getContentPane().add(pDe, BorderLayout.EAST);
		
		
		
		
		//BOTONES
		btnAniadir = new JButton("AÑADIR");
		btnOmitir = new JButton ("OMITIR");
		btnAtras = new JButton("ATRAS");
		pSur.add(btnOmitir);
		pSur.add(btnAniadir);
		pSur.add(btnAtras);
		
		
		lblImg = new JLabel(new ImageIcon ("imagenes/entradas.png"));
		lblImg.setPreferredSize(new Dimension(700,700));
		pIzq.add(lblImg);
		


		
		lblUsuario = new JLabel("  USUARIO: ", SwingConstants.CENTER);
		lblUsuario.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtUsuario = new JTextField(u.getCorreoElectronico(), SwingConstants.CENTER);
		txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtUsuario.setEditable(false);
		lblNumPuntos = new JLabel ("      NÚMERO DE PUNTOS:     ", SwingConstants.CENTER );
		lblNumPuntos.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblNumPuntos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNumPuntos = new JTextField(u.getContadorPuntos(), SwingConstants.CENTER);
		txtNumPuntos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtNumPuntos.setEditable(false);
		
		pDe.add(lblUsuario);
		pDe.add(txtUsuario);
		pDe.add(lblNumPuntos);
		pDe.add(txtNumPuntos);
		pDe.add(Box.createVerticalStrut(60));
		pDe.setBorder(new EmptyBorder(50,150,150,150));

		
		
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
		this.getContentPane().setBackground(Color.WHITE);
		setTitle("PUNTOS");
		setVisible(true);
	
	}
	
	
}
