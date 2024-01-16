package screen;
import java.awt.BorderLayout; 
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnFinalizarCompra, btnAtras;
	private JPanel pSur, pCentro, pNorte,pEntradas,pRecibo;
	private JFrame vActual, vAnterior;
	private JLabel  lblDescuento,lblPagoFinal, lblEntradasMenores, lblEntradasEntreanios, lblEntradasMayores, lblTotal, lblRecibo,
					lblAsteriscos1, lblAsteriscos2, lblAsteriscos3, lblAsteriscos4, lblAsteriscos5;
	private JLabel  lblSala, lblHora, lblAsientos, lblPelicula, lblNumEntradas, lblEntradas,
					lblAsteriscos6;
	private JLabel lblTitulo;	
	private static Logger logger = Logger.getLogger(Main.class.getName());



	private String asientos;

	public VentanaPago(JFrame va, int sala, ArrayList<String> asientosSeleccionados) {
		vActual=this;
		vAnterior=va;
		
		
		 
		
		//PANELES
		pSur = new JPanel();
		pCentro = new JPanel(new GridLayout(1,2));
		pNorte = new JPanel();
		pEntradas = new JPanel();
		pRecibo = new JPanel();

		pEntradas = new JPanel();
		pRecibo = new JPanel();



		asientos = "";
		for(String a: asientosSeleccionados) {
			asientos = asientos+a+" ";
		}
		
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		
		lblTitulo = new JLabel("RESUMEN PAGO");
		pNorte.add(lblTitulo);
		
		int espacioEntrePeneles = 150;
		pEntradas.setBorder( new EmptyBorder(espacioEntrePeneles, espacioEntrePeneles, espacioEntrePeneles, espacioEntrePeneles));
		
		//BOTONES
		btnFinalizarCompra = new JButton("Finalizar Compra");
		btnAtras = new JButton("Atras");		


		btnFinalizarCompra.addActionListener((e)->{


			logger.log(Level.INFO, "SE HA FINALIZADO LA COMPRA");	
			JOptionPane.showMessageDialog(null, "Gracias por tu compra", "PAGO FINALIZADO",
						JOptionPane.INFORMATION_MESSAGE);
				
				Compra c = new Compra(VentanaInicioSesion.getUsuario(),
						String.valueOf(VentanaEntradas.getComboHorarios().split("-")[1]),
						String.valueOf(VentanaEntradas.getComboTitulos()), sala,
						VentanaSeleccionEntradas.getTotalEntradas(), asientos);
				if (!Cine.getMapaCompras().containsKey(VentanaInicioSesion.getUsuario())) {
					Cine.getMapaCompras().put(VentanaInicioSesion.getUsuario(), new ArrayList<>());
				}
				Usuario u = VentanaInicioSesion.getUsuario();
				Cine.getMapaCompras().get(u).add(c);
				Cine.getSumaPuntos();
				Cine.guardarMapaCompras("ficheros/Compras.dat");
				Cine.guardarUsuariosEnFichero("ficheros/Usuarios.csv");
				setVisible(false);


			});

		btnAtras.addActionListener((e)->{
			logger.log(Level.INFO, "Se ha pulsado boton atras");
			vActual.dispose();
			vAnterior.setVisible(true);

		});

		lblAsteriscos1 = new JLabel("***************************************************");
		lblAsteriscos1.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos2 =new JLabel("***************************************************");
		lblAsteriscos2.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblPelicula = new JLabel("Pelicula:   "  + String.valueOf(VentanaEntradas.getComboTitulos()));
		lblPelicula.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblHora = new JLabel("Hora:   " + String.valueOf(VentanaEntradas.getComboHorarios().split("-")[1]));
		lblHora.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblNumEntradas = new JLabel("Nº Entradas:   " + String.valueOf(VentanaSeleccionEntradas.getTotalEntradas()));
		lblNumEntradas.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblSala = new JLabel("Sala: "   + sala);
		lblSala.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsientos = new JLabel("Asientos: " + asientos );
		lblAsientos.setFont(new Font("Arial", Font.PLAIN,20));

		pEntradas.add(lblAsteriscos1);
		pEntradas.add(lblEntradas);
		pEntradas.add(lblAsteriscos2);
		pEntradas.add(lblPelicula);
		pEntradas.add(lblHora);
		pEntradas.add(lblNumEntradas);
		pEntradas.add(lblSala);
		pEntradas.add(lblAsientos);
		pEntradas.add(Box.createVerticalStrut(60));

		pEntradas.setBorder(new EmptyBorder(150,150,150,150));

		pEntradas.setBorder(new EmptyBorder(150,300,300,300));


		pCentro.add(pEntradas);

		lblAsteriscos3 = new JLabel("***************************************************");
		lblAsteriscos3.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblRecibo = new JLabel("RECIBO");
		lblRecibo.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos4 =new JLabel("***************************************************");
		lblAsteriscos4.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblEntradasMenores = new JLabel("Junior:   "  + String.valueOf(VentanaSeleccionEntradas.getMenores()) +"          "+ String.valueOf(VentanaSeleccionEntradas.getMenores()*4));
		lblEntradasMenores.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblEntradasEntreanios = new JLabel("Adulto:   " + String.valueOf(VentanaSeleccionEntradas.getEntreanios())+"          " + String.valueOf(VentanaSeleccionEntradas.getEntreanios()*7));
		lblEntradasEntreanios.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblEntradasMayores = new JLabel("Senior:   " + String.valueOf(VentanaSeleccionEntradas.getMayores()) + "          "+String.valueOf(VentanaSeleccionEntradas.getMayores()*5));
		lblEntradasMayores.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos5 = new JLabel("***************************************************");
		lblAsteriscos5.setFont(new Font( "Arial", Font.PLAIN, 20));
		int total = (VentanaSeleccionEntradas.getMenores()*4)  + (VentanaSeleccionEntradas.getEntreanios()*7) + (VentanaSeleccionEntradas.getMayores()*5);
		lblTotal = new JLabel("TOTAL:  " + String.valueOf(total));

		lblTitulo.setFont(new Font( "Arial", Font.PLAIN, 20));

		lblTotal.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblAsteriscos6 = new JLabel("***************************************************");
		lblAsteriscos6.setFont(new Font( "Arial", Font.PLAIN, 20));
		double descuento = VentanaPuntos.puntosSpinner * 0.01/2;
		lblDescuento = new JLabel("Descuento: "  + String.valueOf(descuento));
		lblDescuento.setFont(new Font( "Arial", Font.PLAIN, 20));
		lblPagoFinal = new JLabel("Pago Final: "   + String.valueOf(total - descuento));
		lblPagoFinal.setFont(new Font( "Arial", Font.PLAIN, 20));


		pRecibo.add(lblAsteriscos3);
		pRecibo.add(lblRecibo);
		pRecibo.add(lblAsteriscos4);
		pRecibo.add(lblEntradasMenores);
		pRecibo.add(lblEntradasEntreanios);
		pRecibo.add(lblEntradasMayores);
		

		pRecibo.add(lblAsteriscos5);
		pRecibo.add(lblTotal);
		pRecibo.add(lblAsteriscos6);
		pRecibo.add(lblDescuento);
		pRecibo.add(lblPagoFinal);
		pRecibo.add(Box.createVerticalStrut(60));
		pRecibo.setBorder(new EmptyBorder(150,300,300,300));


		pCentro.add(pRecibo);

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

