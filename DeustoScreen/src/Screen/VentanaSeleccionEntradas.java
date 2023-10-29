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
	private JButton btnSiguiente, btnAtras;
	private JPanel pCentro, pNorte, pSur, pEste, pOeste;;
	private JLabel lblVIP, lblmenores, lblEntreAños, lblMayores, lblSelecEntradas;
	private JSpinner spinVIP, spinMenores, spinEntreAños, spinMayores;
	
	
	public VentanaSeleccionEntradas() {
		
		//Crecion de los Paneles
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel();
		pOeste = new JPanel();
		pCentro = new JPanel();
		
		//Añadimos localizacion a paneles y columnas
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste, BorderLayout.EAST);
		getContentPane().add(pOeste, BorderLayout.WEST);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		pCentro.setLayout(new GridLayout(0, 2, 0, 0));
	
		
		
		//Creacion de Labels, Spinners y Botones
		lblSelecEntradas = new JLabel("Seleccione sus entradas");
		lblVIP = new JLabel("VIP");
		lblmenores = new JLabel("Menores de 18 años");
		lblEntreAños = new JLabel("Entre 18 y 65 años");
		lblMayores = new JLabel("Mayores de 65 años");
		spinVIP = new JSpinner();
		spinMenores = new JSpinner();
		spinEntreAños = new JSpinner();
		spinMayores = new JSpinner();
		btnSiguiente = new JButton("Siguiente");
		btnAtras = new JButton("Atras");

		//Cambiamos tamaño del texto del panel sur
		lblSelecEntradas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		//Añadimos  Labels, Spinners y Botones a paneles
		pNorte.add(lblSelecEntradas);
		pCentro.add(lblVIP);
		pCentro.add(lblmenores);
		pCentro.add(lblEntreAños);
		pCentro.add(lblMayores);
		pCentro.add(spinVIP);
		pCentro.add(spinMenores);
		pCentro.add(spinEntreAños);
		pCentro.add(spinMayores);
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
		
		//ActionListener de los botones
		btnSiguiente.addActionListener((e)->{
			VentanaButacas ventanaButacas = new VentanaButacas();
			ventanaButacas.setVisible(true);
		});
		
		btnAtras.addActionListener((e)-> {
			dispose();
		});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 600, 400);
		setVisible(true);
		setTitle("SELECCION ENTRADAS");
	
	}
	
	public static void main(String[] args) {
		VentanaSeleccionEntradas VSE = new  VentanaSeleccionEntradas();
		
	}

}
