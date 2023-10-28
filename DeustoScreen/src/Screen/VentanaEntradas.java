package Screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;


public class VentanaEntradas extends JFrame{
	public VentanaEntradas() {
		
		
		JPanel panelNorth = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();
		
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		panelCenter.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEntradas = new JLabel("Entradas");
		JLabel lblPelicula = new JLabel("Pelicula");
		JLabel lblHorarios = new JLabel("Horarios");
		JComboBox comBoxPelicula = new JComboBox();
		JComboBox comBoxHorarios = new JComboBox();
		JButton BtnAtras = new JButton("Atrás");
		JButton BtnSiguiente = new JButton("Siguiente");
		
		panelNorth.add(lblEntradas);
		panelCenter.add(lblPelicula);
		panelCenter.add(comBoxPelicula);
		panelCenter.add(lblHorarios);
		panelCenter.add(comBoxHorarios);
		panelSouth.add(BtnSiguiente);
		panelSouth.add(BtnAtras);
		
		
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
