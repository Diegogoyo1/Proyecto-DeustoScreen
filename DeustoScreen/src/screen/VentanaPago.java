package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaPago extends JFrame {
	private JButton btnFinalizarCompra, btnAtras;
	private JPanel pSur, pCentro;
	private JFrame vActual, vAnterior;
	private JLabel lblImagen, lblEntradasMenores, lblEntradasEntreanios, lblEntradasMayores;

	
	public VentanaPago(JFrame va) {
		vActual=this;
		vAnterior=va;
		
		
		
		pSur = new JPanel();
		pCentro = new JPanel();
		
	
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		
		int espacioEntrePeneles = 150;
		pCentro.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
		btnFinalizarCompra = new JButton("Finalizar Compra");
		btnAtras = new JButton("Atras");
		ImageIcon imRecibo = new ImageIcon("imagenes/ReciboPago.jpg");
		lblImagen = new JLabel(imRecibo);
		lblImagen.setOpaque(false);
		lblImagen.setPreferredSize(new Dimension(imRecibo.getIconWidth(), imRecibo.getIconHeight()));
		lblImagen.setPreferredSize(new Dimension(356, 550));
		lblEntradasEntreanios = new JLabel(String.valueOf(VentanaSeleccionEntradas.getEntreanios()));
		lblEntradasMayores = new JLabel(String.valueOf(VentanaSeleccionEntradas.getMenores()));
		lblEntradasMenores = new JLabel(String.valueOf(VentanaSeleccionEntradas.getMayores()));
		
		btnFinalizarCompra.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Gracias por tu compra","PAGO FINALIZADO",JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
		});
		
		btnAtras.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
			
		});
		
		
		
		lblEntradasEntreanios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntradasEntreanios.setVerticalAlignment(SwingConstants.CENTER);
		lblEntradasEntreanios.setForeground(Color.BLACK); 
		
		lblImagen.add(lblEntradasEntreanios, BorderLayout.CENTER);
		
		lblEntradasMenores.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntradasMenores.setVerticalAlignment(SwingConstants.TOP);
		lblEntradasMenores.setForeground(Color.BLACK); 
		
		lblImagen.add(lblEntradasMenores, BorderLayout.CENTER);
		
		lblEntradasMayores.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntradasMayores.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEntradasMayores.setForeground(Color.BLACK); 
		
		lblImagen.add(lblEntradasMayores, BorderLayout.CENTER);
		
		pCentro.add(lblImagen);
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
	/*public static void main(String[] args) {
		new VentanaPago(null);
	}*/

}
