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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import domain.Cine;
import domain.Usuario;

public class VentanaPuntos extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pSur, pNorte, pOeste, pEste; 
	private JLabel lblUsuario, lblNumPuntos, lblSeleccionPuntos;
	private JTextField txtUsuario, txtNumPuntos;
	private JButton btnAniadir, btnOmitir, btnAtras;
	private JFrame vActual, vAnterior;
	private JSpinner spinnerPuntos;
	public static int puntosSpinner;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	PanelConFondo panelFondo;

	
	public VentanaPuntos(JFrame va, Usuario u,int sala, ArrayList<String> asientosSeleccionados) {
		super();
		vActual=this;
		vAnterior=va;
		
		
		//CREACIÓN PANELES
		
		pSur = new JPanel();
		pNorte = new JPanel();
		pOeste = new JPanel();
		pEste = new JPanel();
		pEste.setLayout(new BoxLayout(pEste, BoxLayout.Y_AXIS));
		

		
		

		panelFondo = new PanelConFondo(new ImageIcon("imagenes/entradas.png").getImage());
		
		//SPINER DE PUNTOS
		SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.parseInt(VentanaInicioSesion.getUsuario().getContadorPuntos()), 10);
		spinnerPuntos = new JSpinner(spinnerModel);
		Dimension spinner = new Dimension(400, 40);
		spinnerPuntos.setPreferredSize(spinner);
		

		
		
		
		//BOTONES
		btnAniadir = new JButton("AÑADIR");
		btnOmitir = new JButton ("OMITIR");
		btnAtras = new JButton("ATRAS");
		
		
	
		lblSeleccionPuntos = new JLabel("Selecciones los puntos que desea aplicar: ");
		
		lblUsuario = new JLabel("  USUARIO: ", SwingConstants.CENTER);
		lblUsuario.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtUsuario = new JTextField(u.getCorreoElectronico(), SwingConstants.CENTER);
		txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtUsuario.setEditable(false);
		lblNumPuntos = new JLabel ("      NÚMERO DE PUNTOS:     ", SwingConstants.CENTER );
		lblNumPuntos.setBorder(new EmptyBorder(0, 0, 10, 20));
		lblNumPuntos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNumPuntos = new JTextField(VentanaInicioSesion.getUsuario().getContadorPuntos(), SwingConstants.CENTER);
		txtNumPuntos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtNumPuntos.setEditable(false);
		
		
		
		
		
		//EVENTOS BOTONES
		btnOmitir.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			new VentanaPago(vActual,sala,asientosSeleccionados);
			vActual.setVisible(false);
			vActual.dispose();//Este DISPOSE cerrara la ventana y nos llevara a la de PAGO directamente sin AÑADIR los puntos
			 
		});
		
		btnAniadir.addActionListener((e)-> {

			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON AÑADIR");
			Cine.restarPuntos();
			new VentanaPago(vActual,sala,asientosSeleccionados);
			vActual.setVisible(false);
			vActual.dispose();//Este DISPOSE cerrara la ventana y nos llevara a la de PAGO AÑADIENDO los puntos
			 
		});
		
		btnAtras.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		spinnerPuntos.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				puntosSpinner = (int) spinnerPuntos.getValue();
			}
		});
		
		pEste.add(lblUsuario);
		pEste.add(txtUsuario);
		pEste.add(lblNumPuntos);
		pEste.add(txtNumPuntos);
		pEste.add(lblSeleccionPuntos);
		pEste.add(spinnerPuntos);
		pEste.add(Box.createVerticalStrut(30));
		pEste.setBorder(new EmptyBorder(200, 200, 550, 200 ));
		
		
		pSur.add(btnAtras);
		pSur.add(btnOmitir);
		pSur.add(btnAniadir);
		
		
		pOeste.setOpaque(false);
		pEste.setOpaque(false);
		pNorte.setOpaque(false);
		pSur.setOpaque(false);
		
		panelFondo.add(pOeste, BorderLayout.WEST);
		panelFondo.add(pEste, BorderLayout.EAST);
		panelFondo.add(pSur, BorderLayout.SOUTH);
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setContentPane(panelFondo);
		setTitle("PUNTOS");
		setVisible(true);
	
	}
	
//	public static int getValorSpinner() {
//		int valorSpinner = spinnerPuntos.getValue();
//		System.out.println(valorSpinner);
//		return valorSpinner;
//	}
	
//	public static String aplicarPuntos() {
//		
//	}
	
	
}
