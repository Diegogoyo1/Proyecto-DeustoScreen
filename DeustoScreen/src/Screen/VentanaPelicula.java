package Screen;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPelicula extends JFrame{
	private JPanel pSur, pCentro, pCebtroIz, pCentroDe; 
	private JLabel lblPeli, lblSip, lblDur, lblCategoria;
	private JButton btnOk, btnCancel;
	private JTextField txtPeli, txtSip, txtDur, txtCategoria;
	
	public VentanaPelicula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (100,100,380,400);
		
		//CREACIÓN PANELES
		pCentro = new JPanel (new GridLayout (1, 2));
		pSur = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		//LABELS
		lblPeli = new JLabel(" nombre pelicula ");
		lblSip = new JLabel (" SIPNOSIS: ");
		lblDur = new JLabel(" DURACIÓN ");
		lblCategoria = new JLabel (" CATEGORÍA: ");
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main1(String[] args) {
		VentanaPelicula VP = new VentanaPelicula();
	
}
	
}
