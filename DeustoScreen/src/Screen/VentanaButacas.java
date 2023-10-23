package Screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaButacas extends JFrame{
	private JPanel Panel1;
	
	
	
	public VentanaButacas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (100,100,600,400);
		Panel1 = new JPanel();
		Panel1.setBorder(new EmptyBorder(2,5,5,5));
		
		setContentPane(Panel1);
		
		JButton btnSiguiente = new JButton ("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JTable tablaButacas1 = new JTable();
		DefaultTableModel modeloTablaButacas1 = new DefaultTableModel();
		getContentPane().add(tablaButacas1, BorderLayout.EAST);
		
		
		
		
		JTable tablaButacas2 = new JTable();
		DefaultTableModel modeloTablaButacas2 = new DefaultTableModel();
		getContentPane().add(tablaButacas2, BorderLayout.WEST);
		
		
		Panel1.add(tablaButacas2);
		Panel1.add(tablaButacas1);
		Panel1.add(btnSiguiente);
		Panel1.add(btnAtras);
		setVisible(true);
		
		
		
		
	
}
	public static void main(String[] args) {
		VentanaButacas VB = new VentanaButacas();	
			
	
	}

	
	
	
	
	
	
	
	

}
