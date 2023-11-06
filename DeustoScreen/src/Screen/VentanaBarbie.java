package Screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Domain.Categoria;

public class VentanaBarbie extends JFrame {
	private JPanel pNorte, pSur, pCentro, pCentroIz, pCentroDe; 
	private JLabel lblImg, lblSetNom, lblSetCat, lblSetDur, lblSetRep, lblSetSip, lblNom, lblCat, lblDur, lblRep;
	private JButton btnA;
	private JTextArea txtSinp;
	private JFrame vActual, vAnterior;
	//private JScrollPane scrollTxtArea;
	
	public VentanaBarbie(JFrame va) {
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
		lblNom = new JLabel(" Barbie ");
		lblCat = new JLabel (Categoria.COMEDIA.toString()); 
		lblDur = new JLabel(" 1h 54m ");
		lblRep = new JLabel (" Margot Robbie ");
		
		
		//TEXTAREA
		txtSinp = new JTextArea(16, 58);
		txtSinp = new JTextArea("Barbie (Margot Robbie) lleva una vida ideal en "
				+ "Barbieland, allí todo es perfecto, con chupi fiestas llenas "
				+ "de música y color, y todos los días son el mejor día. Claro "
				+ "que Barbie se hace algunas preguntas, cuestiones bastante "
				+ "incómodas que no encajan con el mundo idílico en el que ella "
				+ "y las demás Barbies viven. Cuando Barbie se dé cuenta de que "
				+ "es capaz de apoyar los talones en el suelo, y tener los pies "
				+ "planos, decidirá calzarse unos zapatos sin tacones y viajar "
				+ "hasta el mundo real.");
		txtSinp.setLineWrap(true);
		txtSinp.setWrapStyleWord(true);
		txtSinp.setEditable(false);
		//scrollTxtArea = new JScrollPane(txtSinp);
		//getContentPane().add(scrollTxtArea, BorderLayout.CENTER);
		
		//IMAGEN
		pCentroDe = new JPanel();
		pCentroDe.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon imBarbie = new ImageIcon("src\\Imagenes\\PortadaBarbie.jpg");
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("BARBIE");
		setVisible(true);
		
	}	
						
	
}