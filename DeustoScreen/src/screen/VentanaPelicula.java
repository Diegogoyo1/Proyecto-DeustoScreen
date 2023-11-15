package screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import domain.Categoria;

public class VentanaPelicula extends JFrame {
	private JPanel pNorte, pSur, pCentro, pCentroIz, pCentroDe; 
	private JLabel lblImg, lblSetNom, lblSetCat, lblSetDur, lblSetRep, lblSetSip, lblNom, lblCat, lblDur, lblRep;
	private JButton btnA;
	private JTextArea txtSinp;
	private JFrame vActual, vAnterior;
	private JScrollPane scrollTxtArea;
	
	public VentanaPelicula(JFrame va,String ta,String im, String ti, String ln, String lc, String ld, String lr) {
		super();
		vActual=this;
		vAnterior=va;
		
		//CREACIÓN PANELES
		pCentro = new JPanel (new GridLayout (1, 2));
		pCentroIz = new JPanel (new GridLayout (5, 2));
		pCentroDe = new JPanel();
		pSur = new JPanel();
		pNorte = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		
		pCentro.add(pCentroIz);
		pCentro.add(pCentroDe);
		
		//LABELS
		lblSetNom = new JLabel(" NOMBRE: ");
		lblSetCat = new JLabel (" CATEGORÍA: ");
		lblSetDur = new JLabel(" DURACIÓN: ");
		lblSetRep = new JLabel (" REPARTO: ");
		lblSetSip = new JLabel (" SINOPSIS: ");
		lblNom = new JLabel(ln);
		lblCat = new JLabel (lc); 
		lblDur = new JLabel(ld);
		lblRep = new JLabel (lr);
		
		
		//TEXTAREA
		txtSinp = new JTextArea(16, 58);
		txtSinp = new JTextArea(ta);
		txtSinp.setLineWrap(true);
		txtSinp.setWrapStyleWord(true);
		txtSinp.setEditable(false);
		/*scrollTxtArea = new JScrollPane(txtSinp);
		getContentPane().add(scrollTxtArea, BorderLayout.CENTER);*/
		
		//IMAGEN
		pCentroDe = new JPanel();
		pCentroDe.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon imBarbie = new ImageIcon(im);
		Image imagen = imBarbie.getImage();
		Image imagenRedimensionada = imagen.getScaledInstance(500, 700, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);
		lblImg = new JLabel(imagenRedimensionadaIcon);
		pCentroDe.add(lblImg);
		
		pCentro.add(pCentroDe);
		
		//ENLAZER PANELES CON LABELS Y TEXTFIELDS
		pCentroIz.add(lblSetNom);
		pCentroIz.add(lblNom);
		pCentroIz.add(lblSetCat);
		pCentroIz.add(lblCat);
		pCentroIz.add(lblSetDur);
		pCentroIz.add(lblDur);
		pCentroIz.add(lblSetCat);
		pCentroIz.add(lblCat);
		pCentroIz.add(lblSetRep);
		pCentroIz.add(lblRep);
		pCentroIz.add(lblSetSip);
		pCentroIz.add(txtSinp);
		
		
		//BOTONES
		btnA = new JButton("ATRÁS");
		pSur.add(btnA);
		
		
		//EVENTOS BOTONES
		btnA.addActionListener((e) -> {
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		
		
		//DEFINIR VENTANA
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		//setTitle("BARBIE");
		setTitle(ti);
		setVisible(true);
		
	}	
						
	
}
