package Screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaEntradas extends JFrame{
	private JTextField textField;
	public VentanaEntradas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,500, 500);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblEntradas = new JLabel("Entradas");
		panel.add(lblEntradas);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPelicula = new JLabel("Pelicula");
		panel_1.add(lblPelicula);
		
		JComboBox comBoxPelicula = new JComboBox();
		panel_1.add(comBoxPelicula);
		
		JLabel lblHorarios = new JLabel("Horarios");
		panel_1.add(lblHorarios);
		
		JComboBox comBoxHorarios = new JComboBox();
		panel_1.add(comBoxHorarios);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JButton btnSiguiente = new JButton("Siguiente");
		panel_3.add(btnSiguiente);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JButton btnCancelar = new JButton ("Cancelar");
		panel_4.add(btnCancelar);
	
		btnCancelar.addActionListener((e)->{
			dispose();
		});
		
		btnSiguiente.addActionListener((e)->{
			VentanaSeleccionEntradas VentanaSeleccionEntradas = new VentanaSeleccionEntradas();
			VentanaSeleccionEntradas.setVisible(true);
		});
		setVisible(true);
	}
	
	
	public static void main (String[] args) {
		VentanaEntradas VPt = new VentanaEntradas();
	}

}
