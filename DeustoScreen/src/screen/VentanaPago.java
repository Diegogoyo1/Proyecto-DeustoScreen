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
	private JLabel  lblEntradasMenores, lblEntradasEntreanios, lblEntradasMayores;
	PanelConFondo panel;
	
	public VentanaPago(JFrame va) {
		vActual=this;
		vAnterior=va;
		
		
		
		pSur = new JPanel();
		pCentro = new JPanel(null);
		
		panel = new PanelConFondo(new ImageIcon("imagenes/ReciboPago.jpg").getImage());
		
		panel.add(pSur, BorderLayout.SOUTH);
		panel.add(pCentro, BorderLayout.CENTER);
		
		
		int espacioEntrePeneles = 150;
		pCentro.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
		btnFinalizarCompra = new JButton("Finalizar Compra");
		btnAtras = new JButton("Atras");
		//lblImagen.setBounds(200, 300, lblImagen.getWidth(), lblImagen.getHeight());
		
		
		
		btnFinalizarCompra.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Gracias por tu compra","PAGO FINALIZADO",JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
		});
		
		btnAtras.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
			
		});
		
		
		lblEntradasEntreanios = new JLabel(String.valueOf(VentanaSeleccionEntradas.getEntreanios()));
		lblEntradasEntreanios.setForeground(Color.BLACK); 
		lblEntradasEntreanios.setBounds(855,400,40,40);
		//lblImagen.add(lblEntradasEntreanios, BorderLayout.CENTER);
		
		lblEntradasMayores = new JLabel(String.valueOf(VentanaSeleccionEntradas.getMayores()));
		lblEntradasMayores.setForeground(Color.BLACK); 
		lblEntradasMayores.setBounds(855,330,40,40);
		//lblImagen.add(lblEntradasMenores, BorderLayout.CENTER);
		
		lblEntradasMenores = new JLabel(String.valueOf(VentanaSeleccionEntradas.getMenores()));
		lblEntradasMenores.setForeground(Color.BLACK); 
		lblEntradasMenores.setBounds(855,340,40,40);
		//lblImagen.add(lblEntradasMayores, BorderLayout.CENTER);
		
		
		pCentro.add(lblEntradasEntreanios);
		pCentro.add(lblEntradasMenores);
		pCentro.add(lblEntradasMayores);
		
		pSur.add(btnAtras);
		pSur.add(btnFinalizarCompra);
		pSur.setOpaque(false);
		pCentro.setOpaque(false);
		
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("FINALIZAR COMPRA");
		setContentPane(panel);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new VentanaPago(null);
	}

}