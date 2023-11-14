package screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VentanaPrecios  extends JFrame{
	protected JFrame vAnterior, vActual;
	
	public VentanaPrecios(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		
		//Creacion de Paneles
		JPanel PanelNorth = new JPanel();
		JPanel PanelCentral = new JPanel();
		JPanel PanelCentIzq = new JPanel();
		JPanel panel = new JPanel();
		
		//Creacion de boton de atras
		JButton btnAtras = new JButton("Atrás");
		
		//Creacion de Labels
		JLabel lblPrecios = new JLabel("PRECIOS", SwingConstants.CENTER);
		JLabel lblVIP = new JLabel("VIP:", SwingConstants.CENTER);
		JLabel lblPreciosVIP_1 = new JLabel("10€", SwingConstants.CENTER);
		JLabel lblMenores = new JLabel("Menores de 18 años:" ,SwingConstants.CENTER);
		JLabel lblPreciosMenores_1 = new JLabel("4€", SwingConstants.CENTER);
		JLabel lblEntreAños = new JLabel("Entre 18 y 65 años:", SwingConstants.CENTER);
		JLabel lblPreciosEntre_1 = new JLabel("7€", SwingConstants.CENTER);
		JLabel lblMayores = new JLabel("Mayores de 65 años:", SwingConstants.CENTER);
		JLabel lblPrecioMayores_1 = new JLabel("5€", SwingConstants.CENTER);
		
		
		//Añadir y editar Panels 
		getContentPane().add(PanelNorth, BorderLayout.NORTH);
		getContentPane().add(PanelCentral, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		PanelCentral.add(PanelCentIzq);
		PanelCentIzq.setLayout(new GridLayout(0, 2, 0, 50));
		
		//Añadir a los paneles boton los lbl y boton 
		PanelNorth.add(lblPrecios);
		PanelCentIzq.add(lblVIP);
		PanelCentIzq.add(lblPreciosVIP_1);
		PanelCentIzq.add(lblMenores);
		PanelCentIzq.add(lblPreciosMenores_1);
		PanelCentIzq.add(lblEntreAños);
		PanelCentIzq.add(lblPreciosEntre_1);
		PanelCentIzq.add(lblMayores);
		PanelCentIzq.add(lblPrecioMayores_1);
		panel.add(btnAtras);
		
		//Cambiar el tamaño de la fuente
		lblPrecios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVIP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreciosVIP_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMenores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEntreAños.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreciosMenores_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEntreAños.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreciosEntre_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMayores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrecioMayores_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PanelCentral.setBorder(BorderFactory.createEmptyBorder(200, 100, 40, 100));
		
		//Cambiar la alineacion de al centro
		lblPreciosVIP_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreciosMenores_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreciosEntre_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioMayores_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Añadir actionListener para Boton atras
		btnAtras.addActionListener((e)->{
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
