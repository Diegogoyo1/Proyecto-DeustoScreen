package Screen;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaSeleccionEntradas extends JFrame{
	protected JButton btnSiguiente, btnAtras;
	protected JPanel pNorte, pSur, pEste, pOeste;
	
	public VentanaSeleccionEntradas() {
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel();
		pOeste = new JPanel();
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste, BorderLayout.EAST);
		getContentPane().add(pOeste, BorderLayout.WEST);
		
		
		btnSiguiente = new JButton("Siguiente");
		btnAtras = new JButton("Atras");
		
		
		btnSiguiente.addActionListener((e)->{
			VentanaButacas ventanaButacas = new VentanaButacas();
			ventanaButacas.setVisible(true);
		});
		
		btnAtras.addActionListener((e)-> {
			dispose();
		});
		
		
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
		
		
		
		
		
		
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 300, 600, 400);
		setVisible(true);
		setTitle("SELECCION ENTRADAS");
	
	}
	
	public static void main(String[] args) {
		VentanaSeleccionEntradas VSE = new  VentanaSeleccionEntradas();
		
	}

}
