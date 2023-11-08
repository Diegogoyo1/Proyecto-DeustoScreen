package screen;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaPago extends JFrame {
	private JButton btnFinalizarCompra, btnAtras;
	private JPanel pNorte, pSur, pEste, pOeste;
	private JFrame vActual, vAnterior;
	
	
	public VentanaPago(JFrame va) {
		vActual=this;
		vAnterior=va;
		
		
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
			JOptionPane.showMessageDialog(null, "Gracias por tu compra","PAGO FINALIZADO",JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
		});
		
		btnAtras.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
			
		});
		
		pSur.add(btnAtras);
		pSur.add(btnFinalizarCompra);
		
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("FINALIZAR COMPRA");
		setVisible(true);
		
	}
	

}
