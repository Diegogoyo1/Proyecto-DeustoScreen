package screen;

import java.awt.BorderLayout; 
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Cine;
import domain.Pelicula;

public class VentanaCartelera extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pNorte, pSur, pEste, pOeste, pCentro;
	private JButton btnAtras;
	private JLabel lblPeliculas;
	private JFrame vAnterior, vActual;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	PanelConFondo panel;

	public VentanaCartelera(JFrame va) {
		super();
		
		vActual = this;
		vAnterior = va;

		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel();
		pOeste = new JPanel();
		pCentro = new JPanel();

		panel = new PanelConFondo(new ImageIcon("imagenes/FondoCartelera.jpg").getImage());

		panel.add(pNorte, BorderLayout.NORTH);
		panel.add(pSur, BorderLayout.SOUTH);
		panel.add(pEste, BorderLayout.EAST);
		panel.add(pOeste, BorderLayout.WEST);
		panel.add(pCentro, BorderLayout.CENTER);
		int espacioEntrePeneles = 200;
		pCentro.setBorder(
				new EmptyBorder(espacioEntrePeneles, espacioEntrePeneles, espacioEntrePeneles, espacioEntrePeneles));

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);

		});

		for(String ruta: Cine.getMapaPeliculas().keySet()) {
			Pelicula p = Cine.getMapaPeliculas().get(ruta);
			JButton btn = new JButton(p.getTituloPelicula());
			ImageIcon im = new ImageIcon(p.getImagenCartelera());
			btn.setIcon(im);
			btn.setPreferredSize(new Dimension(im.getIconWidth(), im.getIconHeight()));
			btn.setPreferredSize(new Dimension(250, 445));
			btn.addActionListener((e) -> {
				logger.log(Level.INFO, "SE HA CLICKADO EL BOTON "+ p.getTituloPelicula());
				String textoTr = p.getDescripcion();
				new VentanaPelicula(vActual, textoTr, p.getImagenPelicula(), p.getTituloVentana(), p.getTituloPelicula(),
						p.getCategoria().toString(), p.getDuracion(), p.getReparto());
				vActual.setVisible(false);
				vActual.dispose();

			});
			pCentro.add(btn);
		}

		lblPeliculas = new JLabel("PELICULAS");

		pSur.add(btnAtras);
		pNorte.add(lblPeliculas);
		pCentro.setOpaque(false);
		pSur.setOpaque(false);
		pNorte.setOpaque(false);

		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
				.getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
				.getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("PELICULAS");
		setContentPane(panel);
		setVisible(true);

	}
}
