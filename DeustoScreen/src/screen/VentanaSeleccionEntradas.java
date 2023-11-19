package screen;

import java.awt.BorderLayout;



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
		pCentro.setLayout(new GridLayout(0, 2, 0, 0));
	
		
		
		//Creacion de Labels, Spinners y Botones
		SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		SpinnerModel spinnerModel2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		SpinnerModel spinnerModel3 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		SpinnerModel spinnerModel4 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		lblSelecEntradas = new JLabel("Seleccione sus entradas");
		lblmenores = new JLabel("Menores de 18 años");
		lblEntreAños = new JLabel("Entre 18 y 65 años");
		lblMayores = new JLabel("Mayores de 65 años");
		spinMenores = new JSpinner(spinnerModel2);
		spinEntreAños = new JSpinner(spinnerModel3);
		spinMayores = new JSpinner(spinnerModel4);
		btnSiguiente = new JButton("Siguiente");
		btnAtras = new JButton("Atras");

		//Cambiamos tamaño del texto del panel sur
		lblSelecEntradas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		//Añadimos  Labels, Spinners y Botones a paneles
		pNorte.add(lblSelecEntradas);
		pCentro.add(lblmenores);
		pCentro.add(spinMenores);
		pCentro.add(lblEntreAños);
		pCentro.add(spinEntreAños);
		pCentro.add(lblMayores);
		pCentro.add(spinMayores);
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
