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
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblEntradas = new JLabel("Entradas");
		panel.add(lblEntradas);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPelicula = new JLabel("Pelicula");
		panel_5.add(lblPelicula);
		
		JComboBox comBoxPelicula = new JComboBox();
		panel_5.add(comBoxPelicula);
		
		JLabel lblHorarios = new JLabel("Horarios");
		panel_5.add(lblHorarios);
		
		JComboBox comBoxHorarios = new JComboBox();
		panel_5.add(comBoxHorarios);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblJunior = new JLabel("Junior");
		panel_6.add(lblJunior);
		
		JButton btnJuniorMenos = new JButton("-");
		panel_6.add(btnJuniorMenos);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(10);
		
		JButton btnJuniorMas = new JButton("+");
		panel_6.add(btnJuniorMas);
		
		JLabel lbl = new JLabel("New label");
		panel_6.add(lbl);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_4.add(btnNewButton_1);
	}

}
