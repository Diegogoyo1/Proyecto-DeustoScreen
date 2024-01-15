package screen;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import domain.Cine;
import domain.Compra;
import domain.Usuario;


public class VentanaPago extends JFrame {
	private JButton btnFinalizarCompra, btnAtras;
	private JPanel pSur, pCentro, pNorte, pEste, pOeste;
	private JFrame vActual, vAnterior;
	private JLabel lblTituloRecibo, lblNumPrec, lblEntradasMenores, lblEntradasEntreanios, lblEntradasMayores, lblTotal,
			lblRecibo, lblGracias, lblAsteriscos1, lblAsteriscos2, lblAsteriscos3, lblAsteriscos4, lblAsteriscos5;
	private JLabel lblSala, lblHora, lblAsientos, lblPelicula, lblNumEntradas, lblEntradas, lblAsteriscos6,
			lblAsteriscos7, lblAsteriscos8;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	private String asientos;
	
	/**
	 * 
	 * @return puntosFinal devuelve los puntos del usuario añadiendo los puntos de la compra que esta realizando
	 */
	
	public static int getSumaPuntos() {
		Usuario u = VentanaInicioSesion.getUsuario();
		String puntosStr = u.getContadorPuntos();
		int puntos = Integer.parseInt(puntosStr);
		int precioTotal = (VentanaSeleccionEntradas.getEntreanios() * 7) + (VentanaSeleccionEntradas.getMayores() * 5)
				+ (VentanaSeleccionEntradas.getMenores() * 4);
		int puntosFinal = puntos + 10 * precioTotal;
		String numeroEnString = String.valueOf(puntosFinal);
		u.setContadorPuntos(numeroEnString);
		return puntosFinal;
	}
	/**
	 * metodo que imprime las compas de los usuarios por pantalla
	 * 
	 * @param u
	 */
	public static void imprimirComprasUsuario(Usuario u) {
		List<Compra> l = Cine.getMapaCompras().get(u);
		for (Compra a : l) {
			System.out.println(a);
		}
	}
	
	public VentanaPago(JFrame va, int sala, ArrayList<String> asientosSeleccionados) {
		vActual = this;
		vAnterior = va;

		// PANELES
		pSur = new JPanel();
		pCentro = new JPanel(null);
		pNorte = new JPanel();

		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pNorte, BorderLayout.NORTH);

		int espacioEntrePeneles = 150;
		pCentro.setBorder(
				new EmptyBorder(espacioEntrePeneles, espacioEntrePeneles, espacioEntrePeneles, espacioEntrePeneles));

		// LABELS(resumen Pago)
		lblTituloRecibo = new JLabel("RESUMEN PAGO");

		lblNumPrec = new JLabel("TIPO                    nº               Pr.");
		lblNumPrec.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNumPrec.setBounds(1100, 50, 500, 500);

		lblAsteriscos1 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsteriscos1.setBounds(1100, -50, 500, 500);

		lblAsteriscos2 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsteriscos2.setBounds(1100, 25, 500, 500);

		lblAsteriscos3 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsteriscos3.setBounds(1100, 230, 500, 500);

		lblAsteriscos4 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsteriscos4.setBounds(1100, 330, 500, 500);

		lblAsteriscos5 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsteriscos5.setBounds(1100, 425, 500, 500);

		lblRecibo = new JLabel("RECIBO");
		lblRecibo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRecibo.setBounds(1235, -13, 500, 500);

		lblGracias = new JLabel("¡GRACIAS!");
		lblGracias.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGracias.setBounds(1235, 375, 500, 500);

		lblEntradasMenores = new JLabel(
				"Junior                   " + String.valueOf(VentanaSeleccionEntradas.getMenores()) + "                "
						+ String.valueOf(VentanaSeleccionEntradas.getMenores() * 4));
		lblEntradasMenores.setForeground(Color.BLACK);
		lblEntradasMenores.setFont(new Font("Arial", Font.PLAIN, 25));
		lblEntradasMenores.setBounds(1100, 100, 500, 500);

		lblEntradasEntreanios = new JLabel(
				"Adulto                   " + String.valueOf(VentanaSeleccionEntradas.getEntreanios())
						+ "                " + String.valueOf(VentanaSeleccionEntradas.getEntreanios() * 7));
		lblEntradasEntreanios.setForeground(Color.BLACK);
		lblEntradasEntreanios.setFont(new Font("Arial", Font.PLAIN, 25));
		lblEntradasEntreanios.setBounds(1100, 150, 500, 500);

		lblEntradasMayores = new JLabel(
				"Senior                   " + String.valueOf(VentanaSeleccionEntradas.getMayores()) + "                "
						+ String.valueOf(VentanaSeleccionEntradas.getMayores() * 5));
		lblEntradasMayores.setForeground(Color.BLACK);
		lblEntradasMayores.setFont(new Font("Arial", Font.PLAIN, 25));
		lblEntradasMayores.setBounds(1100, 200, 500, 500);

		lblTotal = new JLabel("TOTAL                                    "
				+ String.valueOf((VentanaSeleccionEntradas.getEntreanios() * 7)
						+ (VentanaSeleccionEntradas.getMayores() * 5) + (VentanaSeleccionEntradas.getMenores() * 4)));
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTotal.setBounds(1100, 260, 500, 500);

		// LABEL (resumen entradas)
		lblAsteriscos6 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos6.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsteriscos6.setBounds(300, -50, 500, 500);

		lblAsteriscos7 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos7.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsteriscos7.setBounds(300, 25, 500, 500);

		lblAsteriscos8 = new JLabel("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		lblAsteriscos8.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsteriscos8.setBounds(300, 425, 500, 500);

		lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setForeground(Color.BLACK);
		lblEntradas.setFont(new Font("Arial", Font.PLAIN, 25));
		lblEntradas.setBounds(400, -13, 500, 500);

		lblPelicula = new JLabel("Pelicula                     " + String.valueOf(VentanaEntradas.getComboTitulos()));
		lblPelicula.setForeground(Color.BLACK);
		lblPelicula.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPelicula.setBounds(300, 100, 500, 500);

		lblSala = new JLabel("Sala                                         " + sala);
		lblSala.setForeground(Color.BLACK);
		lblSala.setFont(new Font("Arial", Font.PLAIN, 25));
		lblSala.setBounds(300, 250, 500, 500);

		asientos = "";
		for (String a : asientosSeleccionados) {
			asientos = asientos + a + " ";
		}
		lblAsientos = new JLabel("Asientos                  " + asientos);
		lblAsientos.setForeground(Color.BLACK);
		lblAsientos.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAsientos.setBounds(300, 300, 500, 500);

		lblHora = new JLabel("Hora                                  "
				+ String.valueOf(VentanaEntradas.getComboHorarios().split("-")[1]));
		lblHora.setForeground(Color.BLACK);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 25));
		lblHora.setBounds(300, 150, 500, 500);

		lblNumEntradas = new JLabel(
				"Num Entradas                          " + String.valueOf(VentanaSeleccionEntradas.getTotalEntradas()));
		lblNumEntradas.setForeground(Color.BLACK);
		lblNumEntradas.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNumEntradas.setBounds(300, 200, 500, 500);

		// BOTONES
		btnFinalizarCompra = new JButton("Finalizar Compra");
		btnAtras = new JButton("Atras");

		btnFinalizarCompra.addActionListener((e) -> {
			JOptionPane.showMessageDialog(null, "Gracias por tu compra", "PAGO FINALIZADO",
					JOptionPane.INFORMATION_MESSAGE);
			logger.log(Level.INFO, "SE HA FINALIZADO LA COMPRA");

			Compra c = new Compra(VentanaInicioSesion.getUsuario(),
					String.valueOf(VentanaEntradas.getComboHorarios().split("-")[1]),
					String.valueOf(VentanaEntradas.getComboTitulos()), sala,
					VentanaSeleccionEntradas.getTotalEntradas(), asientos);
			if (!Cine.getMapaCompras().containsKey(VentanaInicioSesion.getUsuario())) {
				Cine.getMapaCompras().put(VentanaInicioSesion.getUsuario(), new ArrayList<>());
			}
			Usuario u = VentanaInicioSesion.getUsuario();
			Cine.getMapaCompras().get(u).add(c);
			Cine.guardarMapaCompras("ficheros/Compras.dat");
			u.setContadorPuntos(String.valueOf(VentanaPago.getSumaPuntos()));
			setVisible(false);
		});

		btnAtras.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA CLICKADO BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);

		});

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

		pCentro.add(lblAsteriscos6);
		pCentro.add(lblAsteriscos7);
		pCentro.add(lblAsteriscos8);
		pCentro.add(lblEntradas);
		pCentro.add(lblSala);
		pCentro.add(lblAsientos);
		pCentro.add(lblHora);
		pCentro.add(lblPelicula);
		pCentro.add(lblNumEntradas);

		pSur.add(btnAtras);
		pSur.add(btnFinalizarCompra);
		pNorte.add(lblTituloRecibo);

		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
				.getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
				.getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 380, 400);
		setTitle("FINALIZAR COMPRA");
		setVisible(true);

	}

	public static void main(String[] args) {
		new VentanaPago(null, 1, new ArrayList<>());
	}

}