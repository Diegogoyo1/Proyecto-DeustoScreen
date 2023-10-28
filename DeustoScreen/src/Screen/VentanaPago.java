package Screen;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPago extends JFrame {
	protected JButton btnFinalizarCompra, btnAtras;
	protected JPanel pNorte, pSur, pEste, pOeste;
	
	public VentanaPago() {
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel();
		pOeste = new JPanel();
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste, BorderLayout.EAST);
		getContentPane().add(pOeste, BorderLayout.WEST);
		
		btnFinalizarCompra = new JButton("Finalizar Compra");
		btnAtras = new JButton("Atras");
		
		
		btnFinalizarCompra.addActionListener((e)->{
			
		});
		
		btnAtras.addActionListener((e)->{
			dispose();
		});
		
		pSur.add(btnAtras);
		pSur.add(btnFinalizarCompra);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("FINALIZAR COMPRA");
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		VentanaPago VP = new VentanaPago();
	}
	

}
