package Screen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPelicula extends JFrame{
	private JPanel pNorte, pSur, pCentro, pCentroIz, pCentroDe; 
	private JLabel lblPeli, lblSip, lblDur, lblCategoria;
	private JButton btnOk, btnCancel;
	private JTextField txtPeli, txtSip, txtDur, txtCategoria;
	
	public VentanaPelicula() {
		
		//CREACIÓN PANELES
		pCentro = new JPanel (new GridLayout (1, 2));
		pCentroIz = new JPanel (new GridLayout (4,2));
		pCentroDe = new JPanel();
		pSur = new JPanel();
		pNorte = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		
		pCentro.add(pCentroIz);
		pCentro.add(pCentroDe);
		
		//LABELS
		lblPeli = new JLabel(" NOMBRE: ");
		lblSip = new JLabel (" SINOPSIS: ");
		lblDur = new JLabel(" DURACIÓN: ");
		lblCategoria = new JLabel (" CATEGORÍA: ");
		
		//TEXTFIELD
		txtPeli = new JTextField();
		txtSip = new JTextField();
		txtDur = new JTextField();
		txtCategoria = new JTextField();
		
		//ENLAZER PANELES CON LABELS Y TEXTFIELDS
		pCentroIz.add(lblPeli);
		pCentroIz.add(txtPeli);
		pCentroIz.add(lblSip);
		pCentroIz.add(txtSip);
		pCentroIz.add(lblDur);
		pCentroIz.add(txtDur);
		pCentroIz.add(lblCategoria);
		pCentroIz.add(txtCategoria);
		//pCentroDe.add("IMAGEN") --> añadir la imagen
		
		//BOTONES
		btnOk = new JButton("OK");
		btnCancel = new JButton("CANCELAR");
		pSur.add(btnOk);
		pSur.add(btnCancel);
		
		//EVENTOS BOTONES
		//sin terminar
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCancel.addActionListener((e) -> {
			dispose();
		});
		setVisible(true);
		
		
		//DEFINIR VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (100,100,380,400);
		setVisible(true);
		
	}
	//PRUEBA DE LA VENTANA CON MAIN
	public static void main(String[] args) {
		VentanaPelicula VP = new VentanaPelicula();	
					
	}


}