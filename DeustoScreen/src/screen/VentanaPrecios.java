package screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VentanaPrecios  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JFrame vAnterior, vActual;
	protected JPanel PanelNorth, PanelCentral, PanelCentIzq, panel;
	protected JButton btnAtras;
	protected JLabel lblPrecios, lblMenores, lblPreciosMenores_1, lblEntreAnios, lblPreciosEntre_1, lblMayores, lblPrecioMayores_1;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaPrecios(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		
		//CREACION PANELES
		PanelNorth = new JPanel();
		PanelCentral = new JPanel();
		PanelCentIzq = new JPanel();
		panel = new JPanel();
		
		//CREACION BOTON ATRAS
		btnAtras = new JButton("Atrás");
		
		//CRACION LABELS
		lblPrecios = new JLabel("PRECIOS", SwingConstants.CENTER);
		lblMenores = new JLabel("Menores de 18 años:" ,SwingConstants.CENTER);
		lblPreciosMenores_1 = new JLabel("4€", SwingConstants.CENTER);
		lblEntreAnios = new JLabel("Entre 18 y 65 años:", SwingConstants.CENTER);
		lblPreciosEntre_1 = new JLabel("7€", SwingConstants.CENTER);
		lblMayores = new JLabel("Mayores de 65 años:", SwingConstants.CENTER);
		lblPrecioMayores_1 = new JLabel("5€", SwingConstants.CENTER);
		
		
		//AÑADIR EDITAR PANELES
		getContentPane().add(PanelNorth, BorderLayout.NORTH);
		getContentPane().add(PanelCentral, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		PanelCentral.add(PanelCentIzq);
		PanelCentIzq.setLayout(new GridLayout(0, 2, 0, 50));
		
		//AÑADIR A LOS PANELES BOTON, LABELS
		PanelNorth.add(lblPrecios);
		PanelCentIzq.add(lblMenores);
		PanelCentIzq.add(lblPreciosMenores_1);
		PanelCentIzq.add(lblEntreAnios);
		PanelCentIzq.add(lblPreciosEntre_1);
		PanelCentIzq.add(lblMayores);
		PanelCentIzq.add(lblPrecioMayores_1);
		panel.add(btnAtras);
		
		//CAMBIAR EL TAMAÑO DE LA FUENTE
		lblPrecios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMenores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEntreAnios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreciosMenores_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEntreAnios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreciosEntre_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMayores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrecioMayores_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PanelCentral.setBorder(BorderFactory.createEmptyBorder(200, 100, 40, 100));
		
		//CAMBIAR ALINEACION AL CENTRO
		lblPreciosMenores_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreciosEntre_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioMayores_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		//AÑADIR ACTINLISTENER BOTON ATRAS
		btnAtras.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("PRECIOS");
		setVisible(true);
		
	}
	
}
