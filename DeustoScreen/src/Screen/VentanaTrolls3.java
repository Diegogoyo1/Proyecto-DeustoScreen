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

public class VentanaTrolls3 extends JFrame {
	private JPanel pNorte, pSur, pCentro, pCentroIz, pCentroDe; 
	private JLabel lblImg, lblSetNom, lblSetCat, lblSetDur, lblSetRep, lblSetSip, lblNom, lblCat, lblDur, lblRep;
	private JButton btnA;
	private JTextArea txtSinp;
	//private JScrollPane scrollTxtArea;
	private JFrame vActual, vAnterior;
	
	public VentanaTrolls3(JFrame va) {
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
		lblNom = new JLabel(" Trolls 3: Todos Juntos ");
		lblCat = new JLabel (Categoria.ANIMACIÓN.toString());
		lblDur = new JLabel(" 1h 31m ");
		lblRep = new JLabel (" Justin Timberlake ");
		
		
		//TEXTAREA
		txtSinp = new JTextArea(16, 58);
		txtSinp = new JTextArea("Poppy y Branch son oficialmente, por fin, pareja. "
				+ " A medida que se relacionan, Poppy descubre que Branch "
				+ "tiene un pasado secreto. Una vez formó parte de su fenómeno boyband "
				+ "favorito, BroZone, con sus cuatro hermanos: Floyd, John Dory, "
				+ "Spruce y Clay. BroZone se disolvió cuando Branch era todavía un bebé, "
				+ "al igual que la familia, y Branch no ha vuelto a ver a sus hermanos "
				+ "desde entonces. Pero cuando Floyd, el hermano de Branch, es secuestrado "
				+ "por sus talentos musicales por un par de nefastos villanos estrellas del "
				+ "pop, Velvet y Veneer, Branch y Poppy se embarcan en un angustioso y "
				+ "emotivo viaje para reunir a los otros hermanos y rescatar a Floyd de un "
				+ "destino aún peor que la oscuridad de la cultura pop.");
		txtSinp.setLineWrap(true);
		txtSinp.setWrapStyleWord(true);
		txtSinp.setEditable(false);
		//scrollTxtArea = new JScrollPane(txtSinp);
		//getContentPane().add(scrollTxtArea, BorderLayout.CENTER);
		
		//IMAGEN
		pCentroDe = new JPanel();
		pCentroDe.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon imTrolls = new ImageIcon("src\\Imagenes\\PortadaTrolls.jpg");
		Image imagen = imTrolls.getImage();
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
		setTitle("TROLLS 3: Todos Juntos");
		setVisible(true);
		
	}
	
	
}
