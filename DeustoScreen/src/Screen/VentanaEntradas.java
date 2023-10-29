package Screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;


public class VentanaEntradas extends JFrame{
	protected JPanel panelNorth, panelEast, panelWest, panelCenter, panelSouth;
	protected JButton BtnAtras, BtnSiguiente;
	private JLabel lblEntradas, lblPelicula, lblHorarios;
	
	public VentanaEntradas() {
		
		//Creacion de Paneles
		 panelNorth = new JPanel();
		 panelEast = new JPanel();
		 panelWest = new JPanel();
		 panelCenter = new JPanel();
		 panelSouth = new JPanel();
		 
		//Añadimos localizacion a paneles y columnas
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		panelCenter.setLayout(new GridLayout(0, 2, 0, 0));
		
		//Creacion de Labels, ComboBox y Botones
		lblEntradas = new JLabel("Entradas");
		lblPelicula = new JLabel("Pelicula");
		lblHorarios = new JLabel("Horarios");
		JComboBox comBoxPelicula = new JComboBox();
		JComboBox comBoxHorarios = new JComboBox();
		BtnAtras = new JButton("Atrás");
		BtnSiguiente = new JButton("Siguiente");
		
		
		//Añadimos todo lo anterior a paneles
		panelNorth.add(lblEntradas);
		panelCenter.add(lblPelicula);
		panelCenter.add(comBoxPelicula);
		panelCenter.add(lblHorarios);
		panelCenter.add(comBoxHorarios);
		panelSouth.add(BtnSiguiente);
		panelSouth.add(BtnAtras);
		
		//ActionListener de los botones
		BtnAtras.addActionListener((e)->{
			dispose();
		});
		
		BtnSiguiente.addActionListener((e)->{
			VentanaSeleccionEntradas ventanaSeleccionEntradas = new VentanaSeleccionEntradas();
			ventanaSeleccionEntradas.setVisible(true);
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300,500, 500);
		setTitle("ENTRADAS");
		setVisible(true);
	}
	
	
	public static void main (String[] args) {
		VentanaEntradas VPt = new VentanaEntradas();
	}

}
