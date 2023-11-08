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
import javax.swing.JTextArea;

import domain.Categoria;

public class VentanaCampeonex extends JFrame {
	private JPanel pNorte, pSur, pCentro, pCentroIz, pCentroDe; 
	private JLabel lblImg, lblSetNom, lblSetCat, lblSetDur, lblSetRep, lblSetSip, lblNom, lblCat, lblDur, lblRep;
	private JButton btnA;
	private JTextArea txtSinp;
	//private JScrollPane scrollTxtArea;
	private JFrame vActual,vAnterior;
	
	public VentanaCampeonex(JFrame va) {
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
		lblNom = new JLabel(" Campeonex ");
		lblCat = new JLabel (Categoria.COMEDIA.toString());
		lblDur = new JLabel(" 2h 4m ");
		lblRep = new JLabel (" Elisa Hipólito ");
		
		
		//TEXTAREA
		txtSinp = new JTextArea(16, 58);
		txtSinp = new JTextArea("Nuestro equipo de \"campeones\" abandona el baloncesto "
				+ "para adentrarse por error en el fascinante mundo del atletismo de la "
				+ "mano de una entrenadora novata. Entre las duras exigencias de la nueva "
				+ "disciplina y la sorprendente capacidad de la entrenadora para atraer "
				+ "todo tipo de desgracias y calamidades, todo acabará saliendo del revés.");
		txtSinp.setLineWrap(true);
		txtSinp.setWrapStyleWord(true);
		txtSinp.setEditable(false);
		//scrollTxtArea = new JScrollPane(txtSinp);
		//getContentPane().add(scrollTxtArea, BorderLayout.CENTER);
		
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
		
		//IMAGEN
		pCentroDe = new JPanel();
		pCentroDe.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon imCampeonex = new ImageIcon("src\\Imagenes\\Campeonex.jpg");
		Image imagen = imCampeonex.getImage();
		Image imagenRedimensionada = imagen.getScaledInstance(500, 700, Image.SCALE_SMOOTH);
		ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);
		lblImg = new JLabel(imagenRedimensionadaIcon);
		pCentroDe.add(lblImg);
		
		pCentro.add(pCentroDe);
		
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
		setTitle("CAMPEONEX");
		setVisible(true);
		
	}
	
}
