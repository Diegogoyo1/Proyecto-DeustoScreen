package Screen;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaSeleccionEntradas extends JFrame{
	protected JButton btnSiguiente, btnAtras;
	protected JPanel pNorte, pSur, pEste, pOeste;
	private JPanel panel;
	private JLabel lblVIP;
	private JSpinner spinVIP;
	private JLabel lblmenores;
	private JSpinner spinMenores;
	private JLabel lblEntreAños;
	private JSpinner spinEntreAños;
	private JLabel lblMayores;
	private JSpinner spinMayores;
	private JLabel lblSelecEntradas;
	
	public VentanaSeleccionEntradas() {
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel();
		pOeste = new JPanel();
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		lblSelecEntradas = new JLabel("Seleccione sus entradas");
		lblSelecEntradas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pNorte.add(lblSelecEntradas);
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
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblVIP = new JLabel("VIP");
		panel.add(lblVIP);
		
		spinVIP = new JSpinner();
		panel.add(spinVIP);
		
		lblmenores = new JLabel("Menores de 18 años");
		panel.add(lblmenores);
		
		spinMenores = new JSpinner();
		panel.add(spinMenores);
		
		lblEntreAños = new JLabel("Entre 18 y 65 años");
		panel.add(lblEntreAños);
		
		spinEntreAños = new JSpinner();
		panel.add(spinEntreAños);
		
		lblMayores = new JLabel("Mayores de 65 años");
		panel.add(lblMayores);
		
		spinMayores = new JSpinner();
		panel.add(spinMayores);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 600, 400);
		setVisible(true);
		setTitle("SELECCION ENTRADAS");
	
	}
	
	public static void main(String[] args) {
		VentanaSeleccionEntradas VSE = new  VentanaSeleccionEntradas();
		
	}

}
