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
	private JPanel pSur, pCentro, pNorte;
	private JFrame vActual, vAnterior;
	private JLabel  lblTitulo,lblNumPrec, lblEntradasMenores, lblEntradasEntreanios, lblEntradasMayores, lblTotal, lblRecibo, lblGracias,
					lblAsteriscos1, lblAsteriscos2, lblAsteriscos3, lblAsteriscos4, lblAsteriscos5;
	
	public VentanaPago(JFrame va) {
		vActual=this;
		vAnterior=va;
		
		
		 
		
		//PANELES
		pSur = new JPanel();
		pCentro = new JPanel(null);
		pNorte = new JPanel();

		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pNorte, BorderLayout.NORTH);

		int espacioEntrePeneles = 150;
		pCentro.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
		
		//BOTONES
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
		
		
		
		//LABELS
		lblTitulo = new JLabel("RESUMEN PAGO");
		
		lblNumPrec = new JLabel("TIPO                    nº               Pr.");
		lblNumPrec.setFont(new Font( "Arial", Font.PLAIN, 25));
		lblNumPrec.setBounds(700, 50, 500, 500);
		
		lblAsteriscos1 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos1.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos1.setBounds(700, -50, 500, 500);
		
		lblAsteriscos2 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos2.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos2.setBounds(700, 25, 500, 500);
		
		lblAsteriscos3 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos3.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos3.setBounds(700, 230, 500, 500);
		
		lblAsteriscos4 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos4.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos4.setBounds(700, 330, 500, 500);
		
		lblAsteriscos5 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos5.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos5.setBounds(700, 425, 500, 500);
		
		lblRecibo = new JLabel("RECIBO");
		lblRecibo.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblRecibo.setBounds(835,-13,500,500);
		
		lblGracias = new JLabel("¡GRACIAS!");
		lblGracias.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGracias.setBounds(835, 375, 500, 500);
		
		
		lblEntradasMenores = new JLabel("Junior                   " + String.valueOf(VentanaSeleccionEntradas.getMenores()) + "                " + String.valueOf(VentanaSeleccionEntradas.getMenores()*4));
		lblEntradasMenores.setForeground(Color.BLACK);
		lblEntradasMenores.setFont(new Font( "Arial", Font.PLAIN, 25));
		lblEntradasMenores.setBounds(700,100,500,500);
		
		lblEntradasEntreanios = new JLabel("Adulto                   " + String.valueOf(VentanaSeleccionEntradas.getEntreanios()) + "                " + String.valueOf(VentanaSeleccionEntradas.getEntreanios()*7));
		lblEntradasEntreanios.setForeground(Color.BLACK);
		lblEntradasEntreanios.setFont(new Font( "Arial", Font.PLAIN, 25));
		lblEntradasEntreanios.setBounds(700,150,500,500);
		
		lblEntradasMayores = new JLabel("Senior                   " + String.valueOf(VentanaSeleccionEntradas.getMayores()) + "                " + String.valueOf(VentanaSeleccionEntradas.getMayores()*5));
		lblEntradasMayores.setForeground(Color.BLACK); 
		lblEntradasMayores.setFont(new Font( "Arial", Font.PLAIN, 25));
		lblEntradasMayores.setBounds(700,200,500,500);
		
		
		
		lblTotal = new JLabel("TOTAL                                    " 
					+  String.valueOf((VentanaSeleccionEntradas.getEntreanios()*7) 
					+ (VentanaSeleccionEntradas.getMayores()*5) 
					+ (VentanaSeleccionEntradas.getMenores()*4) ) );
		lblTotal.setFont(new Font( "Arial", Font.PLAIN, 25));
		lblTotal.setBounds(700,260,500,500);
		
		

		
		
		pCentro.add(lblEntradasEntreanios);
		pCentro.add(lblEntradasMenores);
		pCentro.add(lblEntradasMayores);
		pCentro.add(lblAsteriscos1);
		pCentro.add(lblAsteriscos2);
		pCentro.add(lblAsteriscos3);
		pCentro.add(lblAsteriscos4);
		pCentro.add(lblAsteriscos5);
		pCentro.add(lblRecibo);
		pCentro.add(lblGracias);
		pCentro.add(lblTotal);
		pCentro.add(lblNumPrec);
		
		
		pSur.add(btnAtras);
		pSur.add(btnFinalizarCompra);
		pNorte.add(lblTitulo);
		
		
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
	public static void main(String[] args) {
		new VentanaPago(null);
	}

}