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

public class VentanaOppenheimer extends JFrame{
	private JPanel pNorte, pSur, pCentro, pCentroIz, pCentroDe; 
	private JLabel lblImg, lblSetNom, lblSetCat, lblSetDur, lblSetRep, lblSetSip, lblNom, lblCat, lblDur, lblRep;
	private JButton btnA;
	private JTextArea txtSinp;
	//private JScrollPane scrollTxtArea;
	
	public VentanaOppenheimer() {
		
		//CREACIÓN PANELES
		pCentro = new JPanel (new GridLayout (1, 2));
		pCentroIz = new JPanel (new GridLayout (5, 2));
		pCentroDe = new JPanel()
;		pSur = new JPanel();
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
		lblNom = new JLabel(" Oppenheimer ");
		lblCat = new JLabel (" Acción "); // poner desde la ventana
		lblDur = new JLabel(" 3h ");
		lblRep = new JLabel (" Cillian Murphy ");
		
		
		//TEXTAREA
		txtSinp = new JTextArea(16, 58);
		txtSinp = new JTextArea("En tiempos de guerra, el brillante físico estadounidense"
				+ " Julius Robert Oppenheimer (Cillian Murphy), al frente del \"Proyecto Manhattan\", "
				+ "lidera los ensayos nucleares para construir la bomba atómica para su país. "
				+ "Impactado por su poder destructivo, Oppenheimer se cuestiona las consecuencias "
				+ "morales de su creación. Desde entonces y el resto de su vida, se opondría "
				+ "firmemente al uso de armas nucleares.");
		txtSinp.setLineWrap(true);
		txtSinp.setWrapStyleWord(true);
		txtSinp.setEditable(false);
		//scrollTxtArea = new JScrollPane(txtSinp);
		//getContentPane().add(scrollTxtArea, BorderLayout.CENTER);
		
		
		
		//IMAGEN
		pCentroDe = new JPanel();
		pCentroDe.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon imOppenheimer = new ImageIcon("src\\Imagenes\\PortadaOppenheimer.jpg");
		Image imagen = imOppenheimer.getImage();
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
			dispose();
		});
		
		
		
		//DEFINIR VENTANA
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("OPPENHEIMER");
		setVisible(true);
		
	}

	//PRUEBA DE LA VENTANA CON MAIN
	public static void main(String[] args) {
		VentanaOppenheimer VOp = new VentanaOppenheimer();	
					
	}


}