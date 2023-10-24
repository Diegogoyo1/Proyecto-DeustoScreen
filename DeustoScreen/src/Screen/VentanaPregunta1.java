package Screen;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPregunta1 extends JFrame {
	private JPanel PanelNorte ,PanelSur;
	private JButton  BotonSi,BotonNo;
	private JLabel lblPregunta;
	
	public VentanaPregunta1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 200);

		PanelSur = new JPanel();
		PanelNorte = new JPanel();
		getContentPane().add(PanelSur, BorderLayout.SOUTH);
		getContentPane().add(PanelNorte,BorderLayout.NORTH);
		
		BotonSi= new JButton("si");
		BotonNo = new JButton("no");
		
		lblPregunta = new JLabel("Estas ya registrado??");
		
		PanelSur.add(BotonSi);
		PanelSur.add(BotonNo);
		
		PanelNorte.add(lblPregunta);
		
		BotonSi.addActionListener((e)->{
			VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
			
			
		});
		
		BotonNo.addActionListener((e)->{
			VentanaRegistros ventanaRegistros =  new VentanaRegistros();
			
		});
		
		setVisible(true);
	}
	public static void main(String[] args) {
		VentanaPregunta1 Vp = new VentanaPregunta1();
		
	}
}
