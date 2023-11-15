package screen;

import java.awt.BorderLayout;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class VentanaSeleccionEntradas extends JFrame{
	private JButton btnSiguiente, btnAtras;
	private JPanel pCentro, pNorte, pSur, pEste, pOeste;;
	private JLabel lblVIP, lblmenores, lblEntreAños, lblMayores, lblSelecEntradas;
	private JSpinner spinVIP, spinMenores, spinEntreAños, spinMayores;
	private JFrame vActual, vAnterior;
	
	private static int totalEntradas;
	
	public static int getTotalEntradas() {
		return totalEntradas;
	}

	public VentanaSeleccionEntradas(JFrame va) {
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
		lblVIP = new JLabel("VIP");
		lblmenores = new JLabel("Menores de 18 años");
		lblEntreAños = new JLabel("Entre 18 y 65 años");
		lblMayores = new JLabel("Mayores de 65 años");
		spinVIP = new JSpinner(spinnerModel);
		spinMenores = new JSpinner(spinnerModel2);
		spinEntreAños = new JSpinner(spinnerModel3);
		spinMayores = new JSpinner(spinnerModel4);
		btnSiguiente = new JButton("Siguiente");
		btnAtras = new JButton("Atras");

		//Cambiamos tamaño del texto del panel sur
		lblSelecEntradas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		//Añadimos  Labels, Spinners y Botones a paneles
		pNorte.add(lblSelecEntradas);
		pCentro.add(lblVIP);
		pCentro.add(spinVIP);
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
			int vip = (int) spinVIP.getValue();
			int menores = (int) spinMenores.getValue();
			int entreaños= (int) spinEntreAños.getValue();
			int mayores = (int) spinMayores.getValue();
			if (vip > 0 || menores > 0 || entreaños > 0 || mayores > 0) {
				totalEntradas = vip + menores + mayores + entreaños;
				vActual.setVisible(false);
				vActual.dispose();
				new VentanaButacas (vActual);
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
