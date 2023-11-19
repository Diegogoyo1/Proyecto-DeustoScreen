package screen;

import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import domain.Usuario;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class VentanaSeleccionEntradas extends JFrame{
	private JButton btnSiguiente, btnAtras;
	private JPanel pCentro, pNorte, pSur, pEste, pOeste;;
	private JLabel lblmenores, lblEntreAños, lblMayores, lblSelecEntradas;
	private JSpinner spinMenores, spinEntreAños, spinMayores;
	private JFrame vActual, vAnterior;
	
	private static int totalEntradas, menores, entreanios, mayores;
	
	public static int getTotalEntradas() {
		return totalEntradas;
	}
	
	public static int getMenores() {
		return menores;
	}
	
	public static int getEntreanios() {
		return entreanios;
	}
	
	public static int getMayores() {
		return mayores;
	}


	

	public VentanaSeleccionEntradas(JFrame va,Usuario u) {

		super();
		totalEntradas = 0;
		vActual=this;
		vAnterior=va;
		
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
		pCentro.setBorder(BorderFactory.createEmptyBorder(40, 1000, 10, 1000));
	
		
		
		//Creacion de Labels, Spinners y Botones
		SpinnerModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		SpinnerModel spinnerModel3 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		SpinnerModel spinnerModel4 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		lblSelecEntradas = new JLabel("Seleccione sus entradas");
		pNorte.add(lblSelecEntradas);
		
		lblmenores = new JLabel("Menores de 18 años");
		lblmenores.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinMenores = new JSpinner(spinnerModel2);
		Dimension spinner = new Dimension(400, 40);
		spinMenores.setPreferredSize(spinner);
		
		lblEntreAños = new JLabel("Entre 18 y 65 años");
		lblEntreAños.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinEntreAños = new JSpinner(spinnerModel3);
		spinEntreAños.setPreferredSize(spinner);
		
		lblMayores = new JLabel("Mayores de 65 años");
		lblMayores.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinMayores = new JSpinner(spinnerModel4);
		spinMayores.setPreferredSize(spinner);
		
		btnSiguiente = new JButton("Siguiente");
		btnAtras = new JButton("Atras");

		//Cambiamos tamaño del texto del panel sur
		lblSelecEntradas.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		//Añadimos  Labels, Spinners y Botones a paneles
		pNorte.add(lblSelecEntradas);
		pCentro.add(Box.createVerticalStrut(50));
		pCentro.add(lblmenores);
		
		pCentro.add(spinMenores);
		pCentro.add(Box.createVerticalStrut(50));
		pCentro.add(lblEntreAños);

		pCentro.add(spinEntreAños);
		pCentro.add(Box.createVerticalStrut(50));
		pCentro.add(lblMayores);
		pCentro.add(spinMayores);
		pCentro.add(Box.createVerticalStrut(50));
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
		
		//ActionListener de los botones
		btnSiguiente.addActionListener((e)->{
			menores = (int) spinMenores.getValue();
			entreanios= (int) spinEntreAños.getValue();
			mayores = (int) spinMayores.getValue();
			if (menores > 0 || entreanios > 0 || mayores > 0) {
				totalEntradas = menores + mayores + entreanios;
				vActual.setVisible(false);
				vActual.dispose();


				new VentanaButacas (vActual,u);

			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una entrada","ERROR",JOptionPane.WARNING_MESSAGE);
			}

		});
		
		btnAtras.addActionListener((e)-> {
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 600, 400);
		setVisible(true);
		setTitle("SELECCION ENTRADAS");
		
		
	
	}





	

}
